package com.example.bluetoothexample

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.bluetoothexample.databinding.ActivityMainBinding
import com.journeyapps.barcodescanner.CaptureActivity
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import java.io.IOException
import java.io.OutputStream
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val tag: String = "MainActivity"
    private val btModuleUuid: UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
    private val requestEnableBt = 1
    private val requestBluetoothConnectPermission = 2
    private val requestFineLocationPermission = 3
    private lateinit var mBtAdapter: BluetoothAdapter
    private lateinit var btSocket: BluetoothSocket
    private var selectDevice: BluetoothDevice? = null
    private lateinit var myConnectionBT: ConnectedThread
    private var mNameDevices: ArrayList<String> = arrayListOf()
    private lateinit var deviceAdapter: ArrayAdapter<String>

    private val barcodeLauncher = registerForActivityResult(ScanContract()) {
        if (it.contents != null) {
            showToast("Reader: " + it.contents)
            myConnectionBT.writeln(it.contents)
        } else {
            showToast("Error in reader")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestBluetoothConnectPermission()
        requestLocationPermission()

        deviceAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, mNameDevices)
        deviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        binding.idsSpinner.adapter = deviceAdapter

        binding.searchBtn.setOnClickListener {
            selectedDevices()
        }

        binding.connectBtn.setOnClickListener {
            connectBtDevice()
        }

        binding.disconnectBtn.setOnClickListener {
            try {
                btSocket.close()
            } catch (e: IOException) {
                showToast("Error disconnecting..: ${e.message}")
            }
            finish()
        }

        binding.led1OnBtn.setOnClickListener {
            myConnectionBT.writeln("ENCENDER")
        }

        binding.led1OffBtn.setOnClickListener {
            myConnectionBT.writeln("APAGAR")
        }

        binding.readerBtn.setOnClickListener {
            scan()
        }
    }

    private var someActivityResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == requestEnableBt) {
                Log.d(tag, "ACTIVITY REGISTER")
            }
        }

    private fun selectedDevices() {
        mBtAdapter = BluetoothAdapter.getDefaultAdapter()
        if (!mBtAdapter.isEnabled) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) return
            someActivityResultLauncher.launch(enableBtIntent)
        }

        binding.idsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View,
                i: Int,
                l: Long
            ) {
                selectDevice = getBluetoothDeviceByName(mNameDevices[i])
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {
                selectDevice = null
            }
        }
        val pairedDevices = mBtAdapter.bondedDevices
        if (pairedDevices.isNotEmpty()) {
            for (device in pairedDevices)
                mNameDevices.add(device.name)
            deviceAdapter.notifyDataSetChanged()
        } else showToast("No one device connected")
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            requestFineLocationPermission
        )
    }

    private fun requestBluetoothConnectPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.BLUETOOTH_CONNECT),
            requestBluetoothConnectPermission
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == requestBluetoothConnectPermission) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Log.d(tag, "BLUETOOTH_CONNECT successful")
            else Log.d(tag, "BLUETOOTH_CONNECT denied")
        }
    }

    private fun getBluetoothDeviceByName(name: String): BluetoothDevice {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.BLUETOOTH_CONNECT
            ) != PackageManager.PERMISSION_GRANTED
        ) Log.d(tag, "---->>>>> ActivityCompat.checkSelfPermission")
        val pairedDevices = mBtAdapter.bondedDevices
        for (pairedDevice in pairedDevices)
            if (pairedDevice.name.equals(name))
                return pairedDevice
        return pairedDevices.first()
    }

    private fun connectBtDevice() {
        if (selectDevice == null) {
            showToast("Select a device to connect")
            return
        }
        try {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT)
                != PackageManager.PERMISSION_GRANTED
            ) return
            btSocket = selectDevice!!.createRfcommSocketToServiceRecord(btModuleUuid)
            btSocket.connect()
            myConnectionBT = ConnectedThread(btSocket, this)
            myConnectionBT.start()
            showToast("Connection successful")
        } catch (e: IOException) {
            showToast("Error to connect with device: ${e.message}")
        }
    }

    private class ConnectedThread(socket: BluetoothSocket, private val context: Context) :
        Thread() {
        private var mmOutputStream: OutputStream?

        init {
            var tmpOut: OutputStream? = null
            try {
                tmpOut = socket.outputStream
            } catch (e: IOException) {
                Toast.makeText(
                    context,
                    "Error to create data buffer: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
            mmOutputStream = tmpOut
        }

        fun write(input: String) {
            try {
                for (c in input) mmOutputStream?.write(c.code)
            } catch (e: IOException) {
                Toast.makeText(
                    context,
                    "Error to write in mmOutStream: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        fun writeln(input: String) {
            write(input + "\n")
        }
    }

    private fun showToast(msg: String) {
        runOnUiThread {
            Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
        }
    }

    private fun scan(){
        val options = ScanOptions()
        options.setDesiredBarcodeFormats(ScanOptions.ALL_CODE_TYPES)
        options.setPrompt("Scan a bar code!")
        options.setCameraId(0)
        options.setOrientationLocked(false)
        options.setBeepEnabled(true)
        options.captureActivity = CaptureActivityPortrait::class.java
        options.setBarcodeImageEnabled(false)
        barcodeLauncher.launch(options)
    }

}
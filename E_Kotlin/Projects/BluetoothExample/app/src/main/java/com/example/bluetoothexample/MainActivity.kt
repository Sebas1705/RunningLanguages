package com.example.bluetoothexample

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.bluetoothexample.databinding.ActivityMainBinding
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.UUID
import java.util.zip.CheckedOutputStream

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG: String = "MainActivity"
    private val BT_MODULE_UUID: UUID = UUID.fromString("")
    private val REQUEST_ENABLE_BT = 1
    private val REQUEST_BLUETOOTH_CONNECT_PERMISION = 2
    private val REQUEST_FINE_LOCATION_PERMISION = 3
    private lateinit var mBtAdapter: BluetoothAdapter
    private lateinit var btSocket: BluetoothSocket
    private lateinit var selectDevice: BluetoothDevice
    private lateinit var myConectionBT: ConnectedThread
    private var mNameDevices: ArrayList<String> = arrayListOf()
    private lateinit var deviceAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestBluetoothConnectPermision()
        requestLocationPermision()

        deviceAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, mNameDevices)
        deviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        binding.idsSpinner.adapter = deviceAdapter

        binding.searchBtn.setOnClickListener {

        }

        binding.connectBtn.setOnClickListener {

        }

        binding.disconnectBtn.setOnClickListener {

        }

        binding.led1OnBtn.setOnClickListener {

        }

        binding.led1OffBtn.setOnClickListener {

        }

        binding.led2OnBtn.setOnClickListener {

        }

        binding.led2OffBtn.setOnClickListener {

        }
    }

    private class ConnectedThread(private val socket: BluetoothSocket, context: Context) :
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
                    Toast.LENGTH_SHORT
                ).show()
            }
            mmOutputStream = tmpOut
        }
        fun write(input: Char){
            try{
                mmOutputStream.write(input.toByte())
            }
        }
    }

    fun showToast(msg: String) {
        runOnUiThread {
            Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
        }
    }
}
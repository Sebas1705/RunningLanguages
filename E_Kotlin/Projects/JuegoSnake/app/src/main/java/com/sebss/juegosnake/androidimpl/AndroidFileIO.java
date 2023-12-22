package com.sebss.juegosnake.androidimpl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import android.content.res.AssetManager;
import android.os.Environment;
import com.sebss.juegosnake.FileIO;

public class AndroidFileIO implements FileIO {
    AssetManager assets;
    String rutaAlmacenamientoExterno;

    public AndroidFileIO(AssetManager assets) {
        this.assets = assets;
        this.rutaAlmacenamientoExterno = Environment
                .getExternalStorageDirectory().getAbsolutePath()
                + File.separator;
    }

    @Override
    public InputStream leerAsset(String nombreArchivo) throws IOException {
        return assets.open(nombreArchivo);
    }

    @Override
    public InputStream leerArchivo(String nombreArchivo) throws IOException {
        return Files.newInputStream(Paths.get(rutaAlmacenamientoExterno + nombreArchivo));
    }

    @Override
    public OutputStream escribirArchivo(String nombreArchivo) throws IOException {
        return Files.newOutputStream(Paths.get(rutaAlmacenamientoExterno + nombreArchivo));
    }

}


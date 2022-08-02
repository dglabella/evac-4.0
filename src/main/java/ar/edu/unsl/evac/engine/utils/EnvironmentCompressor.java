package ar.edu.unsl.evac.engine.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;

public class EnvironmentCompressor implements Compressible {

    @Override
    public byte[] compress(byte[] data) throws IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflater = new DeflaterOutputStream(outputStream);

        deflater.write(data);
        deflater.close();

        return outputStream.toByteArray();
    }

    @Override
    public byte[] uncompress(byte[] data) throws IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        InflaterOutputStream inflater = new InflaterOutputStream(outputStream);

        inflater.write(data);
        inflater.close();

        return outputStream.toByteArray();
    }
}

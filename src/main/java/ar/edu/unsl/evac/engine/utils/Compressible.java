package ar.edu.unsl.evac.engine.utils;

import java.io.IOException;

public interface Compressible {

    byte[] compress(byte[] data) throws IOException;

    byte[] uncompress(byte[] data) throws IOException;
}

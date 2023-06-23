package org.apache.commons.imaging.performance;

import org.apache.commons.imaging.formats.jpeg.JpegReadTest;
import org.apache.commons.imaging.formats.pcx.PcxReadTest;
import org.apache.commons.imaging.formats.png.ConvertPngToGifTest;
import org.apache.commons.imaging.formats.tiff.*;
import org.apache.commons.imaging.formats.xbm.XbmReadTest;
import org.apache.commons.imaging.formats.xpm.XpmReadTest;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.io.IOException;

@State(Scope.Benchmark)
public class ImagingBenchmark {
    private final JpegReadTest jpegReadTest = new JpegReadTest();

    private final PcxReadTest pcxReadTest = new PcxReadTest();

    private final ConvertPngToGifTest convertPngToGifTest = new ConvertPngToGifTest();

    private final TiffCcittTest tiffCcittTest = new TiffCcittTest();

    private final TiffFloatingPointReadTest tiffFloatingPointReadTest = new TiffFloatingPointReadTest();

    private final TiffLzwTest tiffLzwTest = new TiffLzwTest();

    private final TiffReadTest tiffReadTest = new TiffReadTest();

    private final XbmReadTest xbmReadTest = new XbmReadTest();

    private XpmReadTest xpmReadTest;


    @Benchmark
    public void pcxReadTestImagesBench() {
        try {
            pcxReadTest.test();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    public void convertPngToGifTestBench() {
        try {
            convertPngToGifTest.test();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    public void tiffCcittTestImagesBench() {
        tiffCcittTest.testAll5x2Images();

    }

    @Benchmark
    public void tiffCcittTestCompressionsBench() {
        try {
            tiffCcittTest.testAll5x2Compressions();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    public void tiffFloatingPointReadTestBench() {
        try {
            tiffFloatingPointReadTest.test();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    public void tiffReadTestBench() {
        try {
            tiffReadTest.test();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    public void tiffReadReadDirectoryTestBench() {
        try {
            tiffReadTest.testReadDirectories();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    public void tiffLzwTestMediumBench() {
        try {
            tiffLzwTest.testMedium();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    public void tiffLzwTestTiffImageDataBench() {
        try {
            tiffLzwTest.testTiffImageData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    public void tiffLzwTestTrivialBench() {
        try {
            tiffLzwTest.testTrivial();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    public void xbmReadTestBench() {
        try {
            xbmReadTest.test();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    public void xpmReadTestBench() {
        try {
            xpmReadTest.test();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

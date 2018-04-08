package common;

import org.junit.jupiter.api.Assertions;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class TestResourceContext {

    private InputStream in;
    private ByteArrayOutputStream outputByteStream;
    private PrintStream out;
    private String inputFileName;
    private String expectedOutputFileName;

    public TestResourceContext(String inputFileName, String expectedOutputFileName) throws FileNotFoundException {
        this.inputFileName = inputFileName;
        this.expectedOutputFileName = expectedOutputFileName;
        // init in
        ClassLoader classLoader = getClass().getClassLoader();
        File input = new File(classLoader.getResource(inputFileName).getFile());
        in = new FileInputStream(input);
        // init out
        outputByteStream = new ByteArrayOutputStream();
        out = new PrintStream(outputByteStream);
    }

    public InputStream getIn() {
        return in;
    }

    public PrintStream getOut() {
        return out;
    }

    public void assertExpectedOutputFileEqualsToOut() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File expectedOutputFile = new File(classLoader.getResource(expectedOutputFileName).getFile());
        String expectedString = new String(Files.readAllBytes(Paths.get(expectedOutputFile.getAbsolutePath())));
        Assertions.assertEquals(expectedString, outputByteStream.toString());
    }

    public void teardown() throws IOException {
        in.close();
    }
}

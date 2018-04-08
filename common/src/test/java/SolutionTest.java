import common.TestResourceContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

class SolutionTest {

    @Test
    public void InMemoryTest() {
        // Arrange
        String inputStr = "a" + System.lineSeparator()
                + "ab" + System.lineSeparator()
                + "abc" + System.lineSeparator();
        String expectedOutputStr = "a" + System.lineSeparator()
                + "ba" + System.lineSeparator()
                + "cba";
        InputStream inputStream = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outputByteStream = new ByteArrayOutputStream();
        PrintStream outputStream = new PrintStream(outputByteStream);
        Solution.setInOut(inputStream, outputStream);

        // Act
        Solution.main(null);

        // Assert
        String outputStr = outputByteStream.toString();
        Assertions.assertEquals(expectedOutputStr, outputStr);
    }

    @Test
    public void ResourcesTest() throws IOException {
        TestResourceContext context = new TestResourceContext("input01.txt", "output01.txt");
        try {

            // Arrange
            Solution.setInOut(context.getIn(), context.getOut());

            // Act
            Solution.main(null);

            // Assert
            context.assertExpectedOutputFileEqualsToOut();
        } finally {
            context.teardown();
        }
    }
}

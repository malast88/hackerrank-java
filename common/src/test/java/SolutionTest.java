import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
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
                + "cba" + System.lineSeparator();
        InputStream inputStream = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outputByteStream = new ByteArrayOutputStream();
        PrintStream outputStream = new PrintStream(outputByteStream);
        Solution.setInOut(inputStream, outputStream);

        // Act
        Solution.main(null);

        // Assert
        String outputStr = new String(outputByteStream.toByteArray());
        Assertions.assertEquals(expectedOutputStr, outputStr);
    }
}

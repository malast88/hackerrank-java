import common.TestResourceContext;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class JavaStringTokensTest {

    @Test
    public void ResourcesTest01() throws IOException {
        TestResourceContext context = new TestResourceContext("01_input.txt", "01_output.txt");
        try {

            // Arrange
            JavaStringTokens.setInOut(context.getIn(), context.getOut());

            // Act
            JavaStringTokens.main(null);

            // Assert
            context.assertExpectedOutputFileEqualsToOut();
        } finally {
            context.teardown();
        }
    }

    @Test
    public void ResourcesTest02() throws IOException {
        TestResourceContext context = new TestResourceContext("02_input.txt", "02_output.txt");
        try {

            // Arrange
            JavaStringTokens.setInOut(context.getIn(), context.getOut());

            // Act
            JavaStringTokens.main(null);

            // Assert
            context.assertExpectedOutputFileEqualsToOut();
        } finally {
            context.teardown();
        }
    }

    @Test
    public void ResourcesTest03() throws IOException {
        TestResourceContext context = new TestResourceContext("03_input.txt", "03_output.txt");
        try {

            // Arrange
            JavaStringTokens.setInOut(context.getIn(), context.getOut());

            // Act
            JavaStringTokens.main(null);

            // Assert
            context.assertExpectedOutputFileEqualsToOut();
        } finally {
            context.teardown();
        }
    }
}

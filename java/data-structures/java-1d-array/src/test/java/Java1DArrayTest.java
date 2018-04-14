import common.TestResourceContext;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class Java1DArrayTest {

    @Test
    public void ResourcesTest01() throws IOException {
        TestResourceContext context = new TestResourceContext("01_input.txt", "01_output.txt");
        try {

            // Arrange
            Java1DArray.setInOut(context.getIn(), context.getOut());

            // Act
            Java1DArray.main(null);

            // Assert
            context.assertExpectedOutputFileEqualsToOut();
        } finally {
            context.teardown();
        }
    }
}

import common.TestResourceContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CanYouAccessTest {

    @Test
    public void ResourcesTest01() throws Exception {
        TestResourceContext context = new TestResourceContext("01_input.txt", "01_output.txt");
        try {

            // Arrange
            CanYouAccess.setInOut(context.getIn(), context.getOut());

            // Act
            CanYouAccess.main(null);

            // Assert
            context.assertExpectedOutputFileEqualsToOut();
        } finally {
            context.teardown();
        }
    }
}

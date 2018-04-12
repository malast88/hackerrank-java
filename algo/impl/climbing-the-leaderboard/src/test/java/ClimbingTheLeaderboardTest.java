import common.TestResourceContext;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ClimbingTheLeaderboardTest {

    @Test
    public void ResourcesTest() throws IOException {
        TestResourceContext context = new TestResourceContext("01_input.txt", "01_output.txt");
        try {

            // Arrange
            ClimbingTheLeaderboard.setInOut(context.getIn(), context.getOut());

            // Act
            ClimbingTheLeaderboard.main(null);

            // Assert
            context.assertExpectedOutputFileEqualsToOut();
        } finally {
            context.teardown();
        }
    }
}

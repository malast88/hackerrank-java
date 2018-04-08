import common.TestResourceContext;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ClimbingTheLeaderboardTest {

    @Test
    public void ResourcesTest() throws IOException {
        TestResourceContext context = new TestResourceContext("input01.txt", "output01.txt");
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

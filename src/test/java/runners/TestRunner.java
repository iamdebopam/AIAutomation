package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {
                "src/test/java/features/homePage.feature",
                "src/test/java/features/jeansCart.feature",
                "src/test/java/features/poloCart.feature"
        },
        glue = {"stepDefinitions","hooks"},
        plugin = {"pretty"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    // Disable parallel execution to run features sequentially in the order above
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

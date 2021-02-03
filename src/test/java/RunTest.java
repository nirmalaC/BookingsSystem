import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue={"stepDefinitions"},
        monochrome = true,
        plugin = { "pretty", "html:target/ui-cucumber-reports" },
        tags = {"@ApiTests , @FeatureAutomationTest"}
)
public class RunTest {
}

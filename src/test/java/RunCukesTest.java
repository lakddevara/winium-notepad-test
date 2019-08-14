import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {".\\src\\test\\java\\features"},
        plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber.json"},
        tags = {"@test"},
        glue={"steps"},
//		dryRun = true,
        monochrome = true
)
public class RunCukesTest{

}

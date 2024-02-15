package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/reports/cucumber.json"
        },
        tags = "@BlogDoAgi",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = false,
        stepNotifications = true,
        features = "src/test/resources",
        glue = "steps"
)
public class runner {
}

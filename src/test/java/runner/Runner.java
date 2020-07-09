package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Run the scenarios specified by tags
       // tags = {""},

        // Define the features files location
        features = {"src/test/resources/features"},

        // Define the steps files location
        glue = {"stepDefinitions"},

        // Skip undefined steps from execution
        strict = true,

        // Readable format of the console output from Cucumber
        monochrome = true,

        // Code snippets will be created using camelcase
        snippets = CucumberOptions.SnippetType.CAMELCASE,

        // Plugins
        plugin = {"pretty"}
)
public class Runner {
}

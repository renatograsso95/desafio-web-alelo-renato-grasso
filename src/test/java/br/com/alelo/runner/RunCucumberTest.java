package br.com.alelo.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/feature/",
        glue = "br.com.alelo",
        tags = "@correios",
        plugin = { "pretty", "html:evidencias/report-html" },
        monochrome = false,
        snippets = SnippetType.CAMELCASE,
        dryRun = false,
        strict = true
)
public class RunCucumberTest {

}
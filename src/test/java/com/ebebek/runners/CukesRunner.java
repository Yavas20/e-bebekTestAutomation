package com.ebebek.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {//"pretty",
                "json:target/cucumber.json",
                "junit:target/junit/junit-report.xml",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"},
        features = "src/test/resources/features",
        glue = "com/ebebek/step_definitions",
        dryRun = false,
        tags = "@task2",
        publish = true



)
public class CukesRunner {
}

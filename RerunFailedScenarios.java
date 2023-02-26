package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.utilities.ReportUtilities;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)

@CucumberOptions(features="@target\\failedScenarios.txt", 

glue="org.step", dryRun = false, monochrome = true, strict = false, snippets = SnippetType.CAMELCASE, tags = {"@smoke"},

plugin = { "pretty", "html:src\\test\\resources\\Reports", "json:src\\test\\resources\\Reports\\jReport.json",
		
"junit:src\\test\\resources\\Reports\\jUReport.xml","rerun:target\\failedScenarios.txt"} )

public class RerunFailedScenarios {
		
		@AfterClass
		
		public static void jvmReportGeneration() {
			
			ReportUtilities.generateJvmReports(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\jReport.json");

		}
		

	

}

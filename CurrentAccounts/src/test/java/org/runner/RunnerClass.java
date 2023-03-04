package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.report.ReportUtility;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions (features="C:\\Users\\HP\\eclipse-workspace\\New folder\\CurrentAccounts\\src\\test\\resources", 

glue = "org.stepdefinition", dryRun = false, monochrome = true, strict = false, //tags = {"@smoke"},

plugin = { "pretty", "html:\\Users\\HP\\eclipse-workspace\\New folder\\CurrentAccounts\\ReportFile", 
		
		"json:C:\\Users\\HP\\eclipse-workspace\\New folder\\CurrentAccounts\\ReportFile\\jReport.json",
		
"junit:\\Users\\HP\\eclipse-workspace\\New folder\\CurrentAccounts\\ReportFile\\jUnitReport.xml"}) //"rerun:target\\failedScenarios.txt"})

public class RunnerClass {
	
@AfterClass
	
	public static void jvmReportGeneration() {
		
		//ReportUtility.generateJvmReports(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\jReport.json");
	
	ReportUtility.generateJvmReports("\\Users\\HP\\eclipse-workspace\\New folder\\CurrentAccounts\\ReportFile\\jReport.json");

	}

}

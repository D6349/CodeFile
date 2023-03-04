package org.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class ReportUtility {
	
	public static void generateJvmReports(String jsonFilePath) {

	      File f = new File("\\Users\\HP\\eclipse-workspace\\New folder\\CurrentAccounts\\ReportFile\\jvmReport");
	     
	      Configuration c = new Configuration(f, "Current Accounts Page");
	      
	      c.addClassifications("browser", "Chrome");
	      
	      List<String> li = new ArrayList<String>();
	      li.add(jsonFilePath);
	      
	      ReportBuilder r = new ReportBuilder(li, c);
	      
	      r.generateReports();
	      
		}

}

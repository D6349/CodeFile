package org.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class ReportUtilities {
	
	public static void generateJvmReports(String jsonFilePath) {

      File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\JvmReports");
      
      Configuration c = new Configuration(f, "LedgersLoginPage");
      
      c.addClassifications("browser", "Chrome");
      
      List<String> li = new ArrayList<String>();
      li.add(jsonFilePath);
      
      ReportBuilder r = new ReportBuilder(li, c);
      
      r.generateReports();
      
	}

	

}

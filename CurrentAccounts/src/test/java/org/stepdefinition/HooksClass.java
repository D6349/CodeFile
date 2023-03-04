package org.stepdefinition;

import java.io.IOException;

import org.base.BaseClass;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.core.api.Scenario;
import io.cucumber.core.event.Status;
import io.cucumber.java.After;

public class HooksClass extends BaseClass{

	
@Before
public void beforeScenario() throws IOException {

//.out.println("Execution Starts....");
//launchMutipleBrowser(readingProperty("browser"));
//launchUrl(readingProperty("url"));
}

@After
private static void afterScenario(Scenario s) throws IOException {


	if (s.isFailed()) {
		

		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
		s.embed(screenshot, "img/png");	
		
		
		
	}else {
		
		String name = s.getName();
		takeSnap(name);
	
		
		
	}
	

}
}

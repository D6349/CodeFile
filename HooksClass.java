package org.step;


import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.utilities.BaseClass;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass extends BaseClass{
	
	@Before
	
	public void BrowserLaunch() {
		
		

	}
	
	@After
	
	public void afterScenerio(Scenario s) throws IOException {
		
		
			if (s.isFailed()) {
				

				final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				
				s.embed(screenshot, "img/png");	
				
			} else {
				
				String sName = s.getName();
				takeSnap(sName);	

			}

		
		}
		
		



	
	

}

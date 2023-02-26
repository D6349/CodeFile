package org.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import gherkin.ast.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriverWait wait;

	public static void launchBrowser(String browser) {

		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	public static void loadUrl(String url) {

		driver.get(url);

	}

	public static String readingProperty(String propertyName) throws IOException {

		FileReader f = new FileReader("config.properties");

		Properties p = new Properties();

		p.load(f);

		String propertyValue = p.getProperty(propertyName);

		return propertyValue;

	}

	public static void enterText(WebElement s, String m) {

		s.sendKeys(m);

	}

	public static void elementClick(WebElement e) {

		e.click();
	}
	
	public static void implicityWait(long l) {

		driver.manage().timeouts().implicitlyWait(l, TimeUnit.SECONDS);
	}
	
	public static void sleepThread(int l) throws InterruptedException {

		Thread.sleep(l);
	}
	
	public static void selectbyIndex(WebElement e, int i) {

		Select s = new Select(e);
		
		s.selectByIndex(i);
	}
	
	public static void selectbyValue(WebElement e, String v) {

		Select s = new Select(e);
		
		s.selectByValue(v);
	}
	
	public static void selectbyText(WebElement e, String v) {

		Select s = new Select(e);
		
		s.selectByVisibleText(v);
	}
	
	
	public static void takeSnap(String scenarioName) throws IOException {
		

		TakesScreenshot tS = (TakesScreenshot) driver;
		
		File src = tS.getScreenshotAs(OutputType.FILE);
		
		File des = new File("C:\\Users\\HP\\eclipse-workspace\\TestMaven\\ScreenShot\\" + scenarioName + ".jpg");
		
		FileUtils.copyFile(src, des);
	
		
		}
	
	
	
}

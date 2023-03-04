package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	

	public static WebDriver driver;

	public static void launchBrowser() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	public static void launchMutipleBrowser(String browser) {

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
	
	public static String readingProperty(String propertyName) throws IOException {

		FileReader f = new FileReader("config.properties");

		Properties p = new Properties();

		p.load(f);

		String propertyValue = p.getProperty(propertyName);

		return propertyValue;

	}


	public static void launchUrl(String url) {

		driver.get(url);

	}

	public static void maximizeBrowser() {

		driver.manage().window().maximize();

	}

	public static void enterText(WebElement w, String s) {

		w.sendKeys(s);

	}

	public static void clickBtn(WebElement w1) {

		w1.click();

	}

	public static void selectbyValue(WebElement wE, String sS) {

		Select s = new Select(wE);
		s.selectByValue(sS);

	}

	public static void selectbyValueText(WebElement wE1, String sS1) {

		Select s = new Select(wE1);
		s.selectByVisibleText(sS1);

	}

	public static void selectbyValueIndex(WebElement wE2, int i) {

		Select s = new Select(wE2);
		s.selectByIndex(i);

	}

	public static void javaScrpitSendKeys(WebElement webRef, String text) {

		JavascriptExecutor j = (JavascriptExecutor) driver;

		j.executeScript("arguments[0].setAttribute('value','" + text + "')", webRef);

	}

	public static void javaScrpitAttribute(WebElement webRef1) {

		JavascriptExecutor j = (JavascriptExecutor) driver;

		Object ref = j.executeScript("return arguments[0].getAttribute('value')", webRef1);

		System.out.println(ref);

	}

	public static void javaScrpitScroll(WebElement webRef1) {

		JavascriptExecutor j = (JavascriptExecutor) driver;

		j.executeScript("arguments[0].scrollIntoView()", webRef1);

	}

	public static void getAttribute(WebElement webRef1) {

		String tA = webRef1.getAttribute("value");

		System.out.println(tA);

	}

	public static void javaScripClick(WebElement webClk) {

		JavascriptExecutor j = (JavascriptExecutor) driver;

		j.executeScript("arguments[0].click()", webClk);

	}

	public static void getText(WebElement webRef1) {

		String tA = webRef1.getText();

		System.out.println(tA);

	}

	public static void ThreadSleep(int it) throws InterruptedException {

		Thread.sleep(it);

	}

	public static void actionClassMouse(WebElement it) {

		Actions a = new Actions(driver);
		a.moveToElement(it).perform();

	}

	public static void actionRightClk(WebElement wC) {

		Actions a = new Actions(driver);
		a.contextClick(wC).perform();
	}

	public static void actionDoubleClk(WebElement wD) {

		Actions a = new Actions(driver);
		a.doubleClick(wD).perform();
	}

	public static void actionSendKeys(WebElement wT, String wS) {

		Actions a = new Actions(driver);
		a.sendKeys(wT, wS).perform();

	}

	public static void actionKeyUp(WebElement wK, String wS) {

		Actions a = new Actions(driver);
		a.keyUp(wK, wS).perform();

	}

	public static void actionKeyDown(WebElement wD, String sD) {

		Actions a = new Actions(driver);
		a.keyDown(wD, sD).perform();

	}

	public static void alertAccept() {

		Alert a = driver.switchTo().alert();

		a.accept();
	}

	public static void alertDismiss() {

		Alert a = driver.switchTo().alert();

		a.dismiss();
	}

	public static void alertSendKeys(String sA) {

		Alert a = driver.switchTo().alert();

		a.sendKeys(sA);
	}
	
	public static void alertText() {

		Alert a = driver.switchTo().alert();

		String tS = a.getText();
		
		System.out.println(tS);
	}

	

	
	public static void robotClassTab() throws AWTException {

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

	}

	public static void robotClassEnter() throws AWTException {

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ENTER);

	}

	public static void printValue(WebElement wT) {

		String text = wT.getText();

		System.out.println(text);

	}

	public static void frames(WebElement ss1) {

		driver.switchTo().frame(ss1);

	}

	public static void closeBrowser() {

		driver.close();

	}

	public static void quitBrowser() {

		driver.quit();

	}


	public static void takeSnap(String scenarioName) throws IOException {
		

		/*TakesScreenshot tS = (TakesScreenshot) driver;
		
		File fi = new File(target);
		
		File src = tS.getScreenshotAs(OutputType.FILE);
		
		File des = new File( fi + ".jpg");
		
		FileUtils.copyFile(src, des);*/
		
		// File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	        /*//Copy the file to a location and use try catch block to handle exception
	        try {
	            FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\New folder\\CurrentAccounts\\Screenshot\\img.jpg"));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	*/
		 
      TakesScreenshot tS = (TakesScreenshot) driver;
		
		File src = tS.getScreenshotAs(OutputType.FILE);
		
		File des = new File("C:\\Users\\HP\\eclipse-workspace\\New folder\\CurrentAccounts\\Screenshot\\" + scenarioName + ".jpg");
		
		FileUtils.copyFile(src, des);
		
		}
	
	public static void windowsHandling(int id) {
		
		String parentWindow = driver.getWindowHandle();
		
		Set<String> allWindows = driver.getWindowHandles();
		
		List<String> listingWindowsId= new ArrayList<String>();
		
		listingWindowsId.addAll(allWindows);
		
		driver.switchTo().window(listingWindowsId.get(id));

		
	}

	public static void chromeOptions() {
		
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--start-maximized");
	    options.addArguments("Zoom 80%");
	   
	}


}




package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	

	public static WebDriver driver;

	public static void launchBrowser() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

	}

	public static void launchUrl(String url) {

		driver.get(url);

	}

	public static void maximizeBrowser() {

		driver.manage().window().maximize();

	}

	public static void sendKeys(WebElement w, String s) {

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

	public static void javaScrpitsCroll(WebElement webRef1) {

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

	public static void close() {

		driver.close();

	}

	public static void quit() {

		driver.quit();

	}

	public static String excelread(int rowNo, int cellNo) throws IOException {

		File f = new File("C:\\Users\\D\\eclipse-workspace\\MavenProject2\\HotelExcel\\BookingDetails.xlsx");

		FileInputStream fF = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fF);

		Sheet s = w.getSheet("Booking");

		Row r = s.getRow(rowNo);

		Cell c = r.getCell(cellNo);

		String sCV = c.getStringCellValue();

		int cT = c.getCellType();

		String text = "";

		if (cT == 1) {

			text = c.getStringCellValue();
			
		} else if (DateUtil.isCellDateFormatted(c)) {

			Date d = c.getDateCellValue();

			SimpleDateFormat sD = new SimpleDateFormat("dd MMM YYYY");

			text = sD.format(d);

		} else {

			double dD = c.getNumericCellValue();

			long l = (long) dD;

			text = String.valueOf(l);
		}

		return sCV;

	}

	public static String write(int r1, int c1, String s) throws IOException {

		File f = new File("C:\\Users\\D\\eclipse-workspace\\MavenProject2\\HotelExcel\\newData.xlsx");

		Workbook wB = new XSSFWorkbook();

		Sheet cS = wB.createSheet("Details");

		Row cR = cS.createRow(r1);

		Cell cC = cR.createCell(c1);

		cC.setCellValue(s);

		FileOutputStream fOS = new FileOutputStream(f);

		wB.write(fOS);

		String text = cC.getStringCellValue();

		return text;

	}


}

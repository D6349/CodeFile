package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdditionalBase {
	
	public static WebDriver driver;

	public void intializateBrowser(String browser) {

		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		} else if (browser.equals("edge")) {

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();

		} else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

	}

	public static void intilizateUrl(String u) {

		driver.get(u);

	}

	public static String readingProperty(String propertyName) throws IOException {

		FileReader f = new FileReader("Config.properties");

		Properties p = new Properties();

		p.load(f);

		String pP = p.getProperty(propertyName);

		return pP;

	}

	public static void enterText(WebElement wc, String txt) {
		wc.sendKeys(txt);

	}

	public static void clickBtn(WebElement w1) {

		w1.click();

	}

	public void selectbyValue(WebElement wE, String sS) {

		Select s = new Select(wE);
		s.selectByValue(sS);

	}

	public void selectbyValueText(WebElement wE1, String sS1) {

		Select s = new Select(wE1);
		s.selectByVisibleText(sS1);

	}

	public static void selectbyValueIndex(WebElement wE2, int i) {

		Select s = new Select(wE2);
		s.selectByIndex(i);

	}

	public static void getAttribute(WebElement webRef1) {

		String tA = webRef1.getAttribute("value");

		System.out.println(tA);

	}

	public static void javaScrpitSendKeys(WebElement webRef, String text) {

		JavascriptExecutor j = (JavascriptExecutor) driver;

		j.executeScript("arguments[0].setAttribute('value','" + text + "')", webRef);

	}
	
	public static void javaScrpitClick(WebElement webRef1) {

		JavascriptExecutor j = (JavascriptExecutor) driver;

		j.executeScript("arguments[0].click()", webRef1);

	}

	public static void javaScrpitAttribute(WebElement webRef1) {

		JavascriptExecutor j = (JavascriptExecutor) driver;

		Object ref = j.executeScript("return arguments[0].getAttribute('value')", webRef1);

		System.out.println(ref);

	}
	
	public static String excelread(String pT, String sS, int rowNo, int cellNo) throws IOException {

		File f = new File(pT);

		FileInputStream fF = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fF);

		Sheet s = w.getSheet(sS);

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

	public static String write(String pT, String sS, int r1, int c1, String s) throws IOException {

		File f = new File(pT);

		Workbook wB = new XSSFWorkbook();

		Sheet cS = wB.createSheet(sS);

		Row cR = cS.createRow(r1);

		Cell cC = cR.createCell(c1);

		cC.setCellValue(s);

		FileOutputStream fOS = new FileOutputStream(f);

		wB.write(fOS);

		String text = cC.getStringCellValue();

		return text;

	}
	
	public static void update(String pT, String sS, int r1, int c1, String s) throws IOException {

		File f = new File(pT);
		
		FileInputStream fF = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fF);

		Sheet s1 = w.getSheet(sS);

		Row cR = s1.getRow(r1);

		Cell cC = cR.createCell(c1);

		cC.setCellValue(s);

		FileOutputStream fOS = new FileOutputStream(f);

		w.write(fOS);
		
	}

	


}

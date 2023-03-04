package org.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoSite {
	

	public static void main(String[] args) throws InterruptedException {

		//System.setProperty("webdriver.chromedriver.driver",
				//"C:\\Users\\HP\\eclipse-workspace\\SeleniumPro\\DriverLib\\chromedriver_win32.zip");//
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://epiccrm.app/#/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/input[1]"))
				.sendKeys("deena.dayalanh@indiafilings.com");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/input[2]")).sendKeys("India@123");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/button[4]")).click();
		//driver.findElement(By.xpath("//button[@data-state='crm']")).click();
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement cL = driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[2]/div/div/div/div/div/div/div/div/div[3]/div[1]/a/img"));
		js.executeScript("arguments[0].click()", cL);
		//WebElement devClk = driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[2]/div/div/div/div/div/div/div/div/div[3]/div[4]/a/img"));
		//js.executeScript("arguments[0].click()", devClk);
		//driver.findElement(By.xpath("//span[text()='APIs']")).click();
		driver.findElement(By.xpath("//span[text()='Platforms']")).click();
		driver.findElement(By.xpath("//span[text()='EQL Fintech']")).click();
		driver.findElement(By.xpath("//span[text()='Payment Gateway']")).click();
		//List<WebElement> tables = driver.findElements(By.xpath("//div[@id='kt_header_mobile']"));
		List<WebElement> tables = driver.findElements(By.tagName("table"));
		System.out.println("Number of Tables" + tables.size());	
		//Thread.sleep(7000);
		/*String parenW = driver.getWindowHandle();
		//System.out.println(parenW);
		Set<String> allWin = driver.getWindowHandles();
		List<String> win = new ArrayList<String>();
		//System.out.println(win.addAll(allWin));
		driver.switchTo().window(win.get(0));*/
		//Thread.sleep(7000);
		WebElement table = driver.findElement(By.xpath("//div[@id='business_metrics']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);
			List<WebElement> headings = row.findElements(By.tagName("th"));
			for (int j = 0; j < headings.size(); j++) {

				WebElement heading = headings.get(j);
				System.out.println(heading.getText());
			}
			List<WebElement> datas = row.findElements(By.tagName("td"));
			for (int j = 0; j < datas.size(); j++) {

				WebElement data = datas.get(j);
				System.out.println(data.getText());
			}

		}
	}

}

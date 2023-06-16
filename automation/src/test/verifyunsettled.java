package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifyunsettled {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		driver.get("https://ops.dev.toucanus.net/");
		Thread.sleep(500);
		driver.findElement(By.name("f1")).sendKeys("nagaraju");
		driver.findElement(By.name("f2")).sendKeys("Password@123");
		driver.findElement(By.name("login1")).click();
		Thread.sleep(500);

		//FileInputStream file = new FileInputStream("/home/nagaraju/newtranfolder/postran.xlsx");
		FileInputStream file = new FileInputStream("/home/nagaraju/newtranfolder/trantest.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet s = wb.getSheet("sheet1");
		int row = s.getLastRowNum();
		int coloumn = s.getRow(0).getLastCellNum();
		System.out.println(row);

		for (int rownum = 1; rownum <= row; rownum++) {
			XSSFRow currentrow = s.getRow(rownum);
			int terminalno = (int) currentrow.getCell(2).getNumericCellValue();
			String terminal = String.valueOf(terminalno);
			String rrnno = currentrow.getCell(8).getStringCellValue();
			String unsettled = rrnno;

			driver.findElement(By.cssSelector("[id='smenu']")).click();
			driver.findElement(By.cssSelector("[id='ter']")).click();
			Thread.sleep(500);
			driver.findElement(By.cssSelector("[name='tNumber']")).clear();
			driver.findElement(By.cssSelector("[name='tNumber']")).sendKeys(terminal);
			Thread.sleep(500);
			driver.findElement(By.cssSelector("[id='searchBtn']")).click();
			Thread.sleep(500);
			driver.findElement(By.cssSelector("[id='inqBtn']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[text()=' Transactions ']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[text()='Unsettlement Txn']")).click();
			Thread.sleep(500);

			driver.findElement(By.xpath("//*[text()=" + unsettled + "]")).isDisplayed();
			if (true) {
				currentrow.createCell(9).setCellValue("Yes");
				FileOutputStream out = new FileOutputStream(new File("/home/nagaraju/newtranfolder/trantest.xlsx"));
				wb.write(out);
				Thread.sleep(500);
			} else {
				currentrow.createCell(9).setCellValue("no");
				FileOutputStream out = new FileOutputStream(new File("/home/nagaraju/newtranfolder/trantest.xlsx"));
				wb.write(out);
				Thread.sleep(500);
			}

			Thread.sleep(200);

		}

	}

}

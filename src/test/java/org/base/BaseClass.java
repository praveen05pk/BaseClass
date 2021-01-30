package org.base;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.JSpinner.DateEditor;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	static public WebDriver driver;
	static public Actions a;
	static public Robot r;
	static public Alert al;
	static public JavascriptExecutor js;
	static public Select s;

	public static void getdriver(String browser) {

		WebDriverManager.chromedriver().setup();

		if (browser == "chrome") {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		}
		if (browser == "firefox") {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		if (browser == "ie") {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
	}

	public static void implictyWait(int time) {

		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static void loadUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void fill(WebElement element, String data) {

		element.sendKeys(data);
	}

	public static void click(WebElement element) {

		element.click();
	}

	public static String getTextData(WebElement element) {
		String text = element.getText();
		return text;
	}

	public static String getAttributeValue(WebElement element) {
		String value = element.getAttribute("value");
		return value;
	}

	public static void closeWin() {
		driver.close();
	}

	public static void quitBroWser() {
		driver.quit();
	}

	public static void moveElement(WebElement element) {
		a = new Actions(driver);
		a.moveToElement(element).perform();

	}

	public static void dragDrop(WebElement source, WebElement target) {
		a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

	public static void rightClick(WebElement element) {
		a = new Actions(driver);
		a.contextClick(element).perform();
	}

	public static void doubleClck(WebElement element) {
		a = new Actions(driver);
		a.doubleClick(element).perform();
	}

	public static void downArrow(int value) throws AWTException {
		r = new Robot();

		for (int i = 0; i < value; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
	}

	public static void pressEnter() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void pressCntlA() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
	}

	public static void acceptAlert() {
		al = driver.switchTo().alert();
		al.accept();
	}

	public static void dismissAlert() {
		al = driver.switchTo().alert();
		al.dismiss();
	}

	public static void getAlertText() {
		al = driver.switchTo().alert();
		al.getText();
	}

	public static void sendAlertText(String value) {
		al = driver.switchTo().alert();
		al.sendKeys(value);
	}

	public static void scrollUp(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public static void scrollDown(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void jsSetValue(WebElement element, String data) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','data')", element);
	}

	public static void jsGetValue(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].getAttribute('value')", element);
	}

	public static void jsClick(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].click()", element);
	}

	public static void screenshot(String path) throws IOException {

		TakesScreenshot s = (TakesScreenshot) driver;
		File screenshot = s.getScreenshotAs(OutputType.FILE);

		File f = new File(path);
		FileUtils.copyFile(screenshot, f);
	}

	public static void back() {
		driver.navigate().back();
	}

	public static void forward() {
		driver.navigate().forward();
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void toUrl(String Url) {
		driver.navigate().to(Url);
	}

	public static void enabled(WebElement element) {
		boolean txt = element.isEnabled();
		System.out.println(txt);
	}

	public static void dispalyed(WebElement element) {
		boolean txt = element.isDisplayed();
		System.out.println(txt);
	}

	public static void selected(WebElement element) {
		boolean txt = element.isSelected();
		System.out.println(txt);
	}

	public static void selectIndex(WebElement element, int index) {
		s = new Select(element);
		s.selectByIndex(index);

	}

	public static void selectVisibleText(WebElement element, String text) {
		s = new Select(element);
		s.selectByVisibleText(text);

	}

	public static void selectValue(WebElement element, String value) {
		s = new Select(element);
		s.selectByValue(value);

	}

	public static void deselectValue(WebElement element, String value) {
		s = new Select(element);
		s.deselectByValue(value);

	}

	public static void deselectIndex(WebElement element, int index) {
		s = new Select(element);
		s.deselectByIndex(index);

	}

	public static void deselectVisibleText(WebElement element, String text) {
		s = new Select(element);
		s.deselectByVisibleText(text);

	}

	public static void deselect(WebElement element) {
		s = new Select(element);
		s.deselectAll();

	}

	public static void windowHandling(int index) {

		Set<String> windows = driver.getWindowHandles();

		ArrayList l = new ArrayList();

		l.get(index);

	}

	public static String excelRead(String excelpath, String sheetname, int rowNo, int cellNo) throws IOException {

		File f = new File(excelpath);

		FileInputStream stream = new FileInputStream(f);

		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(sheetname);

		Row row = sheet.getRow(rowNo);

		Cell cell = row.getCell(cellNo);

		int cellType = cell.getCellType();

		String value = "";

		if (cellType == 1) {

			value = cell.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(cell)) {

			Date dateCellValue = cell.getDateCellValue();

			SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");

			value = dateformat.format(dateCellValue);

		}
		else {
			double numericCellValue = cell.getNumericCellValue();

			long l = (long) numericCellValue;

			value = String.valueOf(l);
		}
		return value;
	}

	public static void excelWrite(String excelPath, String sheetName, int rowNo, int cellNo, String value)
			throws IOException {

		File f = new File(excelPath);

		FileInputStream Inputstream = new FileInputStream(f);

		Workbook workbook = new XSSFWorkbook(Inputstream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(value);

		FileOutputStream Outputstream = new FileOutputStream(f);
		workbook.write(Outputstream);

	}

	public static void excelCreate(String excelPath, String sheetName, int rowNo, int cellNo, String value)
			throws IOException {

		File f = new File(excelPath);

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(value);

		FileOutputStream Outputstream = new FileOutputStream(f);
		workbook.write(Outputstream);

	}

	public static String webTable(String tagname, int index) {

		WebElement table = driver.findElement(By.tagName(tagname));
		WebElement row = table.findElement(By.tagName("tr"));
		// java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
		// String text = rows.get(index).getText();
		java.util.List<WebElement> cell = row.findElements(By.tagName("td"));
		String text = cell.get(index).getText();
		return text;

	}

	public static void enterFrameByIdorName(String idOrString) {

		driver.switchTo().frame(idOrString);

	}

}

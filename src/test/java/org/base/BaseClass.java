package org.base;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
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

	public static void waits(int time) {

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

	public static void getData(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	public static void getValue(WebElement element) {
		String value = element.getAttribute("value");
		System.out.println(value);
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
	
	
	public static void selectIndex(WebElement element, int a) {
			s= new Select(element);
			s.selectByIndex(a);

	}
	
	public static void selectVisibleText(WebElement element, String text) {
		s= new Select(element);
		s.selectByVisibleText(text);

	}
	public static void selectValue(WebElement element, String value) {
		s= new Select(element);
		s.selectByValue(value);	
	
	}
	
	public static void deselectValue(WebElement element, String value) {
		s= new Select(element);
		s.deselectByValue(value);	
	
	}
	
	public static void deselectIndex(WebElement element, int index) {
		s= new Select(element);
		s.deselectByIndex(index);	
	
	}
	
	public static void deselectVisibleText(WebElement element, String text) {
		s= new Select(element);
		s.deselectByVisibleText(text);
	
	}
	
	public static void deselect(WebElement element) {
		s= new Select(element);
		s.deselectAll();
		
	
	}
	
	public static void windowHandling(int index) {
		
		Set<String> windows = driver.getWindowHandles();
		
		ArrayList l = new ArrayList();
		
		l.get(index);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}	
	
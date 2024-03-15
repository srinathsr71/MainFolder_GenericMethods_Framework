package com.operationmethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericMethods {

	public static WebDriver driver;
	public static WebElement element;

	public void navigateToUrl(String url) {
		try {
			// driver.navigate().to(url);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.open(arguments[0])", url);
		} catch (Exception e) {
			// Handle any exceptions that might occur during navigation
			e.printStackTrace(); // For logging
		}
	}

	public String getTitlePage() {
		return driver.getTitle();
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	// sending text to one web element use this method
	public void sendKeysToElement(WebElement element,CharSequence... keys) {
		element.sendKeys(keys);
	}

	public void geturl(String url) {
		driver.get(url);
	}

	// sending text to more than one web element use this method
	public void sendKeysToElements(Map<WebElement, CharSequence> elementTextMap) {
		try {
			for (Map.Entry<WebElement, CharSequence> entry : elementTextMap.entrySet()) {
				WebElement element = entry.getKey();
				CharSequence keys = entry.getValue();
				element.sendKeys(keys);
			}
		} catch (Exception e) {
			e.printStackTrace(); // For logging
		}
	}

	public String getElementText(WebElement element) {
		return element.getText();
	}

	public String getElementAttribute(WebElement element,String attributeName) {
		return element.getAttribute(attributeName);
	}

	public boolean isElementPresent() {
		try {
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void scrollToElement(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void selectDropdownByVisibleText(WebElement element,String visibleText) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(visibleText);
	}

	public void selectDropDownByValue(WebElement element,String value) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}

	public void selectDropDownByIndex(WebElement element,int index) {
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
	}

	// validation methods of elements in selenium
	public boolean isElementDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (ElementNotInteractableException e) {
			return false;
		}
	}

	public boolean isElementEnabled(WebElement element) {
		try {
			element.isEnabled();
			return true;
		} catch (ElementNotInteractableException e) {
			return false;
		}
	}

	public boolean isElementSelected(WebElement element) {
		try {
			element.isSelected();
			return true;
		} catch (ElementNotInteractableException e) {
			return false;
		}
	}

	public void clearAndSendKeysToElement(Map<WebElement, CharSequence> elementTextMap) {
		try {
			for (Map.Entry<WebElement, CharSequence> entry : elementTextMap.entrySet()) {
				WebElement element = entry.getKey();
				CharSequence keys = entry.getValue();
				element.clear();
				element.sendKeys(keys);
			}
		} catch (Exception e) {
			e.printStackTrace(); // For logging
		}
	}

	public int getNumberOfElements(List<WebElement> ele) {
		return ele.size();
	}

	public void deselectAllOptions(WebElement element) {
		Select dropdown = new Select(element);
		dropdown.deselectAll();
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void clickAndHold(WebElement element) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).build().perform();
	}

	public void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public void doubleClickElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}

	public void contextClickElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	public void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).build().perform();
	}

	public void keyDownAndType(WebElement element,Keys key, CharSequence... keys) {
		Actions actions = new Actions(driver);
		actions.keyDown(element, key).sendKeys(keys).keyUp(element, key).build().perform();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void sendKeysToAlert(String keys) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(keys);
	}

	public String getElementTagName(WebElement element) {
		return element.getTagName();
	}

	public String getElementCssValue(WebElement element,String propertyName) {
		return element.getCssValue(propertyName);
	}

	public int getTotalNumberOfWindows() {
		try {
			return driver.getWindowHandles().size();
		} catch (Exception e) {
			e.printStackTrace(); // For logging
			return 0; // Return 0 if there's an exception
		}
	}

	public boolean switchToWindowAtIndex(int index) {
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> handlesList = new ArrayList<>(windowHandles);
			if (index >= 0 && index < handlesList.size()) {
				driver.switchTo().window(handlesList.get(index));
				return true;
			} else {
				System.out.println("Window index out of bounds");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();// For logging
			return false;
		}
	}

	public void maximizeWindow() {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace(); // For logging
		}
	}

	public void minimizeWindow() {
		try {
			driver.manage().window().minimize(); // Move window out of screen
		} catch (Exception e) {
			e.printStackTrace(); // For logging
		}
	}

	public void enterFullscreenMode() {
		try {
			driver.manage().window().fullscreen();
		} catch (Exception e) {
			e.printStackTrace(); // For logging
		}
	}

	public boolean switchToWindowHandle(String windowHandle) {
		try {
			driver.switchTo().window(windowHandle);
			return true;
		} catch (NoSuchWindowException e) {
			System.out.println("Window with handle '" + windowHandle + "' not found.");
			return false;
		} catch (Exception e) {
			e.printStackTrace(); // For logging other exceptions
			return false;
		}
	}

	public boolean switchToFrameByIndex(int index) {
		try {
			driver.switchTo().frame(index);
			return true;
		} catch (NoSuchFrameException e) {
			System.out.println("Frame with index '" + index + "' not found.");
			return false;
		}
	}

	public boolean switchToFrameByNameOrId(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
			return true;
		} catch (NoSuchFrameException e) {
			System.out.println("Frame with name or ID '" + nameOrId + "' not found.");
			return false;
		}
	}

	public boolean switchToFrameByElement(WebElement element) {
		try {
			driver.switchTo().frame(element);
			return true;
		} catch (NoSuchFrameException e) {
			System.out.println("Frame with element '" + element + "' not found.");
			return false;
		}
	}

	public void takeScreenshot(String fileName) {
		try {
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(fileName));
		} catch (Exception e) {
			e.printStackTrace(); // For logging other exceptions
		}
	}

	// 45
	public void openNewTabAndSwitchToIt() {
		try {
			// Open a new tab using JavaScript
			((JavascriptExecutor) driver).executeScript("window.open()");

			// Switch to the newly opened tab
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> handlesList = new ArrayList<>(windowHandles);
			String newTabHandle = handlesList.get(handlesList.size() - 1);
			driver.switchTo().window(newTabHandle);
		} catch (Exception e) {
			e.printStackTrace(); // For logging
		}
	}

	public void openNewWindowAndSwitchToIt() {
		try {
			// Open a new window using JavaScript
			((JavascriptExecutor) driver).executeScript("window.open()");

			// Switch to the newly opened window
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> handlesList = new ArrayList<>(windowHandles);
			String newWindowHandle = handlesList.get(handlesList.size() - 1);
			driver.switchTo().window(newWindowHandle);
		} catch (Exception e) {
			e.printStackTrace(); // For logging
		}
	}

	public void switchToOriginalWindow(String originalWindowHandle) {
		try {
			driver.switchTo().window(originalWindowHandle);
		} catch (Exception e) {
			e.printStackTrace(); // For logging
		}
	}

	public List<String> getAllOptions(WebElement element) {
		List<String> optionsList = new ArrayList<>();
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement option : options) {
				optionsList.add(option.getText());
			}
		} catch (Exception e) {
			e.printStackTrace(); // For logging
		}
		return optionsList;
	}

	public String getFirstSelectedOption(WebElement element) {
		String firstSelectedOption = null;
		try {
			Select select = new Select(element);
			WebElement selectedOption = select.getFirstSelectedOption();
			firstSelectedOption = selectedOption.getText();
		} catch (Exception e) {
			e.printStackTrace(); // For logging
		}
		return firstSelectedOption;
	}

	public List<String> getAllSelectedOptions(WebElement element) {
		List<String> selectedOptionsList = new ArrayList<>();
		try {
			Select select = new Select(element);
			List<WebElement> selectedOptions = select.getAllSelectedOptions();
			for (WebElement option : selectedOptions) {
				selectedOptionsList.add(option.getText());
			}
		} catch (Exception e) {
			e.printStackTrace(); // For logging
		}
		return selectedOptionsList;
	}
	// above 50 methods

	private static String filepath;

	public static void setFilepath(String filepath) {
		GenericMethods.filepath = filepath;
	}

	public String getProperty(String key) {
		try {
			FileInputStream fileInputStream = new FileInputStream(filepath);
			Properties properties = new Properties();
			properties.load(fileInputStream);
			String value = properties.getProperty(key);

			// Close the FileInputStream
			fileInputStream.close();

			return value;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String readExcelData(String sheetName, int rowNum, int cellNum, String fileloc)
			throws EncryptedDocumentException, IOException {

		// Initialize FileInputStream and Workbook objects
		try (FileInputStream fileInputStream = new FileInputStream(fileloc);
				Workbook workbook = WorkbookFactory.create(fileInputStream)) {

			// Get the sheet by name
			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				throw new IllegalArgumentException("Sheet not found: " + sheetName);
			}

			// Get the row
			Row row = sheet.getRow(rowNum);
			if (row == null) {
				throw new IllegalArgumentException("Row not found: " + rowNum);
			}

			// Get the cell
			Cell cell = row.getCell(cellNum);
			if (cell == null) {
				throw new IllegalArgumentException("Cell not found: " + cellNum);
			}

			// Retrieve the cell value as a string
			return cell.getStringCellValue();
		}
	}

	public void openBrowser() throws IOException {
		if (getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Unsupported browser: ");
		}
	}
	
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	
	
	public void explicitWaitToEnterData(WebDriver driver ,WebElement element,String data) throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(getProperty(data));
	}
	
}

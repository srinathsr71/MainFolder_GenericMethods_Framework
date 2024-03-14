package com.operationmethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.io.FileUtils;
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
import org.openqa.selenium.support.ui.Select;

public class GenericStaticMethods {

	  public static WebDriver driver;	  
	  public static WebElement element;
	  public static void navigateToUrl(String url) {
	    try {
	      JavascriptExecutor js = (JavascriptExecutor)driver;
	      js.executeScript("window.open(arguments[0])", new Object[] { url });
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	  }
	  
	  public static String getTitlePage() {
	    return driver.getTitle();
	  }
	  
	  public static void clickElement() {
	    element.click();
	  }
	  
	  public static void sendKeysToElement(CharSequence... keys) {
	    element.sendKeys(keys);
	  }
	  
	  public static void geturl(String url) {
	    driver.get(url);
	  }
	  
	  public static void sendKeysToElements(Map<WebElement, CharSequence> elementTextMap) {
	    try {
	      for (Map.Entry<WebElement, CharSequence> entry : elementTextMap.entrySet()) {
	        WebElement element = entry.getKey();
	        CharSequence keys = entry.getValue();
	        element.sendKeys(new CharSequence[] { keys });
	      } 
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	  }
	  
	  public static String getElementText() {
	    return element.getText();
	  }
	  
	  public static String getElementAttribute(String attributeName) {
	    return element.getAttribute(attributeName);
	  }
	  
	  public static boolean isElementPresent() {
	    try {
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    } 
	  }
	  
	  public static void scrollToElement(WebDriver driver, WebElement element) {
	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", new Object[] { element });
	  }
	  
	  public static void selectDropdownByVisibleText(String visibleText) {
	    Select dropdown = new Select(element);
	    dropdown.selectByVisibleText(visibleText);
	  }
	  
	  public static void selectDropDownByValue(String value) {
	    Select dropdown = new Select(element);
	    dropdown.selectByValue(value);
	  }
	  
	  public static void selectDropDownByIndex(int index) {
	    Select dropdown = new Select(element);
	    dropdown.selectByIndex(index);
	  }
	  
	  public static boolean isElementDisplayed() {
	    try {
	      element.isDisplayed();
	      return true;
	    } catch (ElementNotInteractableException e) {
	      return false;
	    } 
	  }
	  
	  public static boolean isElementEnabled() {
	    try {
	      element.isEnabled();
	      return true;
	    } catch (ElementNotInteractableException e) {
	      return false;
	    } 
	  }
	  
	  public static boolean isElementSelected() {
	    try {
	      element.isSelected();
	      return true;
	    } catch (ElementNotInteractableException e) {
	      return false;
	    } 
	  }
	  
	  public static void clearAndSendKeysToElement(Map<WebElement, CharSequence> elementTextMap) {
	    try {
	      for (Map.Entry<WebElement, CharSequence> entry : elementTextMap.entrySet()) {
	        WebElement element = entry.getKey();
	        CharSequence keys = entry.getValue();
	        element.clear();
	        element.sendKeys(new CharSequence[] { keys });
	      } 
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	  }
	  
	  public static int getNumberOfElements(List<WebElement> ele) {
	    return ele.size();
	  }
	  
	  public static void deselectAllOptions() {
	    Select dropdown = new Select(element);
	    dropdown.deselectAll();
	  }
	  
	  public static void switchToDefaultContent() {
	    driver.switchTo().defaultContent();
	  }
	  
	  public static void switchToFrame() {
	    driver.switchTo().frame(element);
	  }
	  
	  public static void clickAndHold() {
	    Actions actions = new Actions(driver);
	    actions.clickAndHold(element).build().perform();
	  }
	  
	  public static void moveToElement() {
	    Actions actions = new Actions(driver);
	    actions.moveToElement(element).build().perform();
	  }
	  
	  public static void doubleClickElement() {
	    Actions actions = new Actions(driver);
	    actions.doubleClick(element).build().perform();
	  }
	  
	  public static void contextClickElement() {
	    Actions actions = new Actions(driver);
	    actions.contextClick(element).build().perform();
	  }
	  
	  public static void dragAndDrop(WebElement source, WebElement target) {
	    Actions actions = new Actions(driver);
	    actions.dragAndDrop(source, target).build().perform();
	  }
	  
	  public static void keyDownAndType(Keys key, CharSequence... keys) {
	    Actions actions = new Actions(driver);
	    actions.keyDown(element, (CharSequence)key).sendKeys(keys).keyUp(element, (CharSequence)key).build().perform();
	  }
	  
	  public static void navigateBack() {
	    driver.navigate().back();
	  }
	  
	  public static void navigateForward() {
	    driver.navigate().forward();
	  }
	  
	  public static void refreshPage() {
	    driver.navigate().refresh();
	  }
	  
	  public static void acceptAlert() {
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	  }
	  
	  public static void dismissAlert() {
	    Alert alert = driver.switchTo().alert();
	    alert.dismiss();
	  }
	  
	  public static String getAlertText() {
	    Alert alert = driver.switchTo().alert();
	    return alert.getText();
	  }
	  
	  public static void sendKeysToAlert(String keys) {
	    Alert alert = driver.switchTo().alert();
	    alert.sendKeys(keys);
	  }
	  
	  public static String getElementTagName() {
	    return element.getTagName();
	  }
	  
	  public static String getElementCssValue(String propertyName) {
	    return element.getCssValue(propertyName);
	  }
	  
	  public static int getTotalNumberOfWindows() {
	    try {
	      return driver.getWindowHandles().size();
	    } catch (Exception e) {
	      e.printStackTrace();
	      return 0;
	    } 
	  }
	  
	  public static boolean switchToWindowAtIndex(int index) {
	    try {
	      Set<String> windowHandles = driver.getWindowHandles();
	      List<String> handlesList = new ArrayList<>(windowHandles);
	      if (index >= 0 && index < handlesList.size()) {
	        driver.switchTo().window(handlesList.get(index));
	        return true;
	      } 
	      System.out.println("Window index out of bounds");
	      return false;
	    } catch (Exception e) {
	      e.printStackTrace();
	      return false;
	    } 
	  }
	  
	  public static void maximizeWindow() {
	    try {
	      driver.manage().window().maximize();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	  }
	  
	  public static void minimizeWindow() {
	    try {
	      driver.manage().window().minimize();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	  }
	  
	  public static void enterFullscreenMode() {
	    try {
	      driver.manage().window().fullscreen();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	  }
	  
	  public static boolean switchToWindowHandle(String windowHandle) {
	    try {
	      driver.switchTo().window(windowHandle);
	      return true;
	    } catch (NoSuchWindowException e) {
	      System.out.println("Window with handle '" + windowHandle + "' not found.");
	      return false;
	    } catch (Exception e) {
	      e.printStackTrace();
	      return false;
	    } 
	  }
	  
	  public static boolean switchToFrameByIndex(int index) {
	    try {
	      driver.switchTo().frame(index);
	      return true;
	    } catch (NoSuchFrameException e) {
	      System.out.println("Frame with index '" + index + "' not found.");
	      return false;
	    } 
	  }
	  
	  public static boolean switchToFrameByNameOrId(String nameOrId) {
	    try {
	      driver.switchTo().frame(nameOrId);
	      return true;
	    } catch (NoSuchFrameException e) {
	      System.out.println("Frame with name or ID '" + nameOrId + "' not found.");
	      return false;
	    } 
	  }
	  
	  public static boolean switchToFrameByElement() {
	    try {
	      driver.switchTo().frame(element);
	      return true;
	    } catch (NoSuchFrameException e) {
	      System.out.println("Frame with element '" + element + "' not found.");
	      return false;
	    } 
	  }
	  
	  public static void takeScreenshot(String fileName) {
	    try {
	      File screenshotFile = (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(screenshotFile, new File(fileName));
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	  }
	  
	  public static void openNewTabAndSwitchToIt() {
	    try {
	      ((JavascriptExecutor)driver).executeScript("window.open()", new Object[0]);
	      Set<String> windowHandles = driver.getWindowHandles();
	      List<String> handlesList = new ArrayList<>(windowHandles);
	      String newTabHandle = handlesList.get(handlesList.size() - 1);
	      driver.switchTo().window(newTabHandle);
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	  }
	  
	  public static void openNewWindowAndSwitchToIt() {
	    try {
	      ((JavascriptExecutor)driver).executeScript("window.open()", new Object[0]);
	      Set<String> windowHandles = driver.getWindowHandles();
	      List<String> handlesList = new ArrayList<>(windowHandles);
	      String newWindowHandle = handlesList.get(handlesList.size() - 1);
	      driver.switchTo().window(newWindowHandle);
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	  }
	  
	  public static void switchToOriginalWindow(String originalWindowHandle) {
	    try {
	      driver.switchTo().window(originalWindowHandle);
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	  }
	  
	  public static List<String> getAllOptions() {
	    List<String> optionsList = new ArrayList<>();
	    try {
	      Select select = new Select(element);
	      List<WebElement> options = select.getOptions();
	      for (WebElement option : options)
	        optionsList.add(option.getText()); 
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	    return optionsList;
	  }
	  
	  public static String getFirstSelectedOption() {
	    String firstSelectedOption = null;
	    try {
	      Select select = new Select(element);
	      WebElement selectedOption = select.getFirstSelectedOption();
	      firstSelectedOption = selectedOption.getText();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	    return firstSelectedOption;
	  }
	  
	  public static List<String> getAllSelectedOptions() {
	    List<String> selectedOptionsList = new ArrayList<>();
	    try {
	      Select select = new Select(element);
	      List<WebElement> selectedOptions = select.getAllSelectedOptions();
	      for (WebElement option : selectedOptions)
	        selectedOptionsList.add(option.getText()); 
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	    return selectedOptionsList;
	  }
	  
	  
	  private static String filepath;

		public static void setFilepath(String filepath) {
			GenericStaticMethods.filepath = filepath;
		}

	  
	  
	  public static String getProperty(String key) {
	    try {
	      FileInputStream fileInputStream = new FileInputStream(filepath);
	      Properties properties = new Properties();
	      properties.load(fileInputStream);
	      String value = properties.getProperty(key);
	      fileInputStream.close();
	      return value;
	    } catch (IOException e) {
	      e.printStackTrace();
	      return null;
	    } 
	  }
	  
	  public static String readExcelData(String sheetName, int rowNum, int cellNum, String fileloc) throws EncryptedDocumentException, IOException {
	    FileInputStream fileInputStream = new FileInputStream(fileloc);
	    try {
	      Workbook workbook = WorkbookFactory.create(fileInputStream);
	      try {
	        Sheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null)
	          throw new IllegalArgumentException("Sheet not found: " + sheetName); 
	        Row row = sheet.getRow(rowNum);
	        if (row == null)
	          throw new IllegalArgumentException("Row not found: " + rowNum); 
	        Cell cell = row.getCell(cellNum);
	        if (cell == null)
	          throw new IllegalArgumentException("Cell not found: " + cellNum); 
	        String str = cell.getStringCellValue();
	        if (workbook != null)
	          workbook.close(); 
	        fileInputStream.close();
	        return str;
	      } catch (Throwable throwable) {
	        if (workbook != null)
	          try {
	            workbook.close();
	          } catch (Throwable throwable1) {
	            throwable.addSuppressed(throwable1);
	          }  
	        throw throwable;
	      } 
	    } catch (Throwable throwable) {
	      try {
	        fileInputStream.close();
	      } catch (Throwable throwable1) {
	        throwable.addSuppressed(throwable1);
	      } 
	      throw throwable;
	    } 
	  }
	  
	  public static void openBrowser(String browser) throws IOException {
	    if (browser.equalsIgnoreCase("firefox")) {
	      WebDriverManager.firefoxdriver().setup();
	      driver = (WebDriver)new FirefoxDriver();
	    } else if (browser.equalsIgnoreCase("chrome")) {
	      WebDriverManager.chromedriver().setup();
	      driver = (WebDriver)new ChromeDriver();
	    } else if (browser.equalsIgnoreCase("edge")) {
	      WebDriverManager.edgedriver().setup();
	      driver = (WebDriver)new EdgeDriver();
	    } else {
	      System.out.println("Unsupported browser: " + browser);
	    } 
	  }
	}
	

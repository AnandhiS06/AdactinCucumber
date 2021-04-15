package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static Actions act;
	public static Alert alrt;
	public static TakesScreenshot ts;
	public static JavascriptExecutor js;
	public static Select sel;
	public static Robot rbt;
	public static WebDriverWait wait;

	// 1. To launch Chrome Browser

	public static void launchChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	// 2. To launch Firefox Browser
	public static void launchFirefoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

	}

	// 3. To launch IE Browser
	public static void launchIEBrowser() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();

	}

	// 4. To launch Url
	public static void launchUrl(String url) {
		driver.get(url);

	}

	// 5. To maximize window
	public static void maximizeWindow() {
		driver.manage().window().maximize();

	}

	// 6. To get title of webpage
	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 7. To get Current Url
	public static String pageUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	// 8. To enter text in input field
	public static void enterText(WebElement txtField, String inputValue) {
		txtField.sendKeys(inputValue);

	}

	// 9.To Click a button/link/radioButton
	public static void clickBtn(WebElement clckElement) {
		clckElement.click();

	}

	// 10.To Clear a text field
	public static void clearTextField(WebElement txtField) {
		txtField.clear();
	}

	// 11. To get text from a page
	public static String returnText(WebElement element) {
		String text = element.getText();
		return text;
	}

	// 12. To get the entered text in a text field
	public static String getTextFromTextField(WebElement txtField) {
		String enteredText = txtField.getAttribute("value");
		return enteredText;

	}

	// 13. To perform move to Element
	public static void moveCursor(WebElement element) {
		act = new Actions(driver);
		act.moveToElement(element).perform();

	}

	// 14. To perform Drag and Drop
	public static void dragAndDropElement(WebElement srcElement, WebElement destElement) {
		act = new Actions(driver);
		act.dragAndDrop(srcElement, destElement).perform();

	}

	// 15. To perform Double Click
	public static void doubleClickElement(WebElement element) {
		act = new Actions(driver);
		act.doubleClick(element).perform();

	}

	// 16 To perform Right Click
	public static void rightClick(WebElement element) {
		act = new Actions(driver);
		act.contextClick(element).perform();

	}

	// 17. To handle Simple Alert
	public static void simpleAlertHandle() {
		alrt = driver.switchTo().alert();
		System.out.println("Alert Message: " + alrt.getText());
		alrt.accept();

	}

	// 18. To handle Confirm Alert
	public static void confirmAlertHandle(String confirmTxt) {
		alrt = driver.switchTo().alert();
		System.out.println("Alert Message: " + alrt.getText());
		if (confirmTxt.equalsIgnoreCase("ok")) {
			alrt.accept();
		} else {
			alrt.dismiss();
		}
		System.out.println("You Pressed" + confirmTxt);
	}

	// 19. To handle Prompt Alert
	public static void promptAlertHandle(String enterTxt, String confirmTxt) {
		alrt = driver.switchTo().alert();
		System.out.println("Alert Message: " + alrt.getText());
		alrt.sendKeys(enterTxt);
		if (confirmTxt.equalsIgnoreCase("ok")) {
			alrt.accept();
		} else {
			alrt.dismiss();
		}
	}

	// 20. To Scroll Down a page
	public static void scrollDown(WebElement scrollDownElement) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", scrollDownElement);

	}

	// 21. To Scroll Up a page
	public static void scrollUp(WebElement scrollUpElement) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", scrollUpElement);

	}

	// 22. To Enter text by JavaScriptExecutor
	public static void enterTextByJSE(WebElement txtField, String inputText) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + inputText + "')", txtField);

	}

	// 23. To Get text by JavaScriptExecutor
	public static Object getTextByJSE(WebElement txtField) {
		js = (JavascriptExecutor) driver;
		Object textEntered = js.executeScript("return arguments[0].getAttribute('value')", txtField);
		return textEntered;

	}

	// 24.To print all the options in Dropdown
	public static void toPrintAllOptions(WebElement selectRef) {
		Select s = new Select(selectRef);
		List<WebElement> allOptions = s.getOptions();
		for (WebElement eachOption : allOptions) {
			System.out.println("Available Options in Dropdown are :" + eachOption);
		}
	}

	// 25. To select by Visible Text in Dropdown
	public static void selectText(WebElement selectRef, String visText) {
		sel = new Select(selectRef);
		sel.selectByVisibleText(visText);
	}

	// 26. To select by Value in Dropdown
	public static void selectValue(WebElement selectRef, String value) {
		sel = new Select(selectRef);
		sel.selectByValue(value);
	}

	// 27. To select by Visible Text in Dropdown
	public static void selectIndex(WebElement selectRef, int indexnum) {
		sel = new Select(selectRef);
		sel.selectByIndex(indexnum);
	}

	// 28. To check whether we can select multiple option in dropdown
	public static void checkMultipleOptions(WebElement selectRef) {
		sel = new Select(selectRef);
		if (sel.isMultiple()) {
			System.out.println("We can select multiple options");
		} else {
			System.out.println("We can select only one option");
		}
	}

	// 29.To print the selected options
	public static void toPrintSelectedOptions(WebElement selectRef) {
		sel = new Select(selectRef);
		List<WebElement> selectedOptions = sel.getAllSelectedOptions();
		for (WebElement eachOption : selectedOptions) {
			System.out.println("Selected Options are :" + eachOption);
		}
	}

	// 30. To print the first selected option
	public static void toPrintFirstSelectedOption(WebElement selectRef) {
		sel = new Select(selectRef);
		WebElement firstSelectedOption = sel.getFirstSelectedOption();
		System.out.println("First Selected Option :" + firstSelectedOption);
	}

	// 31. To deselect the all selected option
	public static void deselectAllSelectedOptions(WebElement selectRef) {
		sel = new Select(selectRef);
		sel.deselectAll();
	}

	// 32. To deselect by value in dropdown
	public static void deselectOptionByValue(WebElement selectRef, String value) {
		sel = new Select(selectRef);
		sel.deselectByValue(value);
	}

	// 33. To deselect by value in dropdown
	public static void deselectOptionByIndex(WebElement selectRef, int indexnum) {
		sel = new Select(selectRef);
		sel.deselectByIndex(indexnum);
	}

	// 34. To deselect by value in dropdown
	public static void deselectOptionByVisibleText(WebElement selectRef, String visText) {
		Select s = new Select(selectRef);
		s.deselectByVisibleText(visText);
	}

	// 35. To switch to new Window
	public static void switchWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String eachWindow : allWindows) {
			if (!eachWindow.equals(parentWindow)) {
				driver.switchTo().window(eachWindow);
			}
		}
	}

	// 36. To take Screenshot of the page
	public static void snapshot(String imgname) throws IOException {
		ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(
				"C:\\Users\\Kamatchi\\eclipse-workspace\\CucumberAdactin\\Screenshots\\" + imgname + ".png");
		FileUtils.copyFile(src, dest);
	}

	// 37. To find number of frames in a webpage
	public static int noOfFrames(String tagName) {
		List<WebElement> allFrames = driver.findElements(By.tagName(tagName));
		int totalFrames = allFrames.size();
		return totalFrames;

	}

	// 38. To switch to frame by index
	public static void switchToFrameByIndex(int frameIndex) {
		driver.switchTo().frame(frameIndex);

	}

	// 39. To switch to frame by frame Id
	public static void switchToFrameById(String frameId) {
		driver.switchTo().frame(frameId);

	}

	// 40. To switch to frame by frame name
	public static void switchToFrameByName(String frameName) {
		driver.switchTo().frame(frameName);
	}

	// 41. To switch to frame by frame name
	public static void switchToFrameWebElement(WebElement frameRef) {
		driver.switchTo().frame(frameRef);
	}

	// 42. To switch to frame by parent frame
	public static void switchToParentFrame(WebElement frameRef) {
		driver.switchTo().parentFrame();
	}

	// 43. To Press Enter Key using Robot Class
	public static void pressEnter() throws AWTException {
		rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyRelease(KeyEvent.VK_ENTER);
	}

	// 44. To Press Down Arrow using Robot Class
	public static void pressDownArrow() throws AWTException {
		rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_DOWN);
		rbt.keyRelease(KeyEvent.VK_DOWN);

	}

	// 45. To Press Up Arrow using Robot Class
	public static void pressUpArrow() throws AWTException {
		rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_UP);
		rbt.keyRelease(KeyEvent.VK_UP);

	}

	// 46. To copy using Robot Class
	public static void copyText() throws AWTException {
		rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_C);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyRelease(KeyEvent.VK_C);
	}

	// 47. To copy using Robot Class
	public static void cutText() throws AWTException {
		rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_X);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyRelease(KeyEvent.VK_X);
	}

	// 48. To copy using Robot Class
	public static void pasteText() throws AWTException {
		rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyRelease(KeyEvent.VK_V);
	}

	// 49. To Close the browser
	public static void closeBrowser() {
		driver.close();
	}

	// 50. To find number of tables
	public static int totalNoOfTables() {
		List<WebElement> Tables = driver.findElements(By.tagName("table"));
		int noOfTables = Tables.size();
		return noOfTables;
	}

	// 51. To Print all Rows and Data except Heading in Table
	public static void printOnlyDataInTable(WebElement tableRef) {
		List<WebElement> allRows = tableRef.findElements(By.tagName("tr"));
		for (WebElement eachRow : allRows) {
			List<WebElement> allData = eachRow.findElements(By.tagName("td"));
			for (WebElement eachData : allData) {
				System.out.println("Datas in Table: " + eachData.getText());
			}
		}

	}

	// 52. To print only heading in Table
	public static void printOnlyHeadingInTable(WebElement tableRef) {
		List<WebElement> allRows = tableRef.findElements(By.tagName("tr"));
		for (WebElement eachRow : allRows) {
			List<WebElement> heading = eachRow.findElements(By.tagName("th"));
			for (WebElement eachHeading : heading) {
				System.out.println("Heading in Table: " + eachHeading.getText());
			}
		}

	}

	// 53. To Print all Rows and Data including Heading in Table
	public static void printWholeTable(WebElement tableRef) {
		List<WebElement> allRows = tableRef.findElements(By.tagName("tr"));
		for (int i = 0; i < allRows.size(); i++) {
			WebElement row = allRows.get(i);
			List<WebElement> heading = row.findElements(By.tagName("th"));
			List<WebElement> allData = row.findElements(By.tagName("td"));
			for (int j = 0; j < heading.size(); j++) {
				WebElement eachHeading = heading.get(j);
				System.out.println("Each Heading :" + eachHeading.getText());
			}
			for (int k = 0; k < allData.size(); k++) {
				WebElement eachData = allData.get(k);
				System.out.println("Each Text in Table :" + eachData.getText());
			}
		}
	}

	// 54. To Print all Input Values in Table
	public static void printInputValueInTable(WebElement tableRef) {
		List<WebElement> allRows = tableRef.findElements(By.tagName("tr"));
		// ((//table)[5]//tbody//tr[2]//td//input)[3]
		for (int i = 0; i < allRows.size(); i++) {
			WebElement row = allRows.get(i);
			List<WebElement> allInputField = row.findElements(By.tagName("input"));
			for (int j = 0; j < allInputField.size(); j++) {
				WebElement inputValue = allInputField.get(j);
				System.out.println("Input Value Field in Table :" + inputValue.getAttribute("value"));
			}
		}
	}

	// 55. To Print Particular Input value from Table
	public static String printParticularInputValueInTable(WebElement tableRef, String idName) {
		List<WebElement> allRows = tableRef.findElements(By.tagName("tr"));
		String inputValue = "";
		for (int i = 0; i < allRows.size(); i++) {
			WebElement row = allRows.get(i);
			WebElement inputField = row.findElement(By.xpath("//input[@id='" + idName + "']"));
			inputValue = inputField.getAttribute("value");
		}
		return inputValue;
	}

	// 56. WebDriver wait for Alert
	public static void waitForAlert() {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());

	}

	// 57. wait with thread
	public static void waitWithThread() throws InterruptedException {
		Thread.sleep(3000);

	}

	// 58. To Read all Data from Excel
	public static void readExcelAllData(String fileName, String sheetName) throws IOException {
		File f = new File("C:\\Users\\Kamatchi\\eclipse-workspace\\AdactinWithCucumber\\Excel\\" + fileName + ".xlsx");
		;
		FileInputStream in = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(in);
		Sheet sh = w.getSheet(sheetName);
		String cellValue = "";
		for (int i = 0; i < sh.getPhysicalNumberOfRows(); i++) {
			Row row = sh.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);

				int cellType = cell.getCellType();
				if (cellType == 1) {
					cellValue = cell.getStringCellValue();
				} else if (DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					cellValue = sdf.format(date);
				} else {
					double d = cell.getNumericCellValue();
					long l = (long) d;
					cellValue = String.valueOf(l);
				}
				System.out.println(cellValue);
			}
		}
	}

	// 59. To Read particular Data from Excel
	public static String readExcelParticualData(String fileName, String sheetName, int rowNum, int cellNum)
			throws IOException {
		File f = new File("C:\\Users\\Kamatchi\\eclipse-workspace\\AdactinWithCucumber\\Excel\\" + fileName + ".xlsx");
		FileInputStream in = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(in);
		Sheet sh = w.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String cellValue;
		if (cell.getCellType() == 1) {
			cellValue = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date d = cell.getDateCellValue();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			cellValue = sdf.format(d);
		} else {
			double d = cell.getNumericCellValue();
			long l = (long) d;
			cellValue = String.valueOf(l);
		}
		return cellValue;
	}

	// 60. To write data in excel
	public static void writeExcel(String fileName, String sheetName, int rowNum, int cellNum, String inputValue)
			throws IOException {
		File f = new File("C:\\Users\\Kamatchi\\eclipse-workspace\\AdactinWithCucumber\\Excel\\" + fileName + ".xlsx");
		FileOutputStream out = new FileOutputStream(f);
		Workbook w = new XSSFWorkbook();
		Sheet sh = w.createSheet(sheetName);
		Row row = sh.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(inputValue);
		w.write(out);
	}

	// 61. To Update excel
	public static void updateExcel(String fileName, String sheetName, int rowNum, int cellNum, String oldValue,
			String newValue) throws IOException {
		File f = new File("C:\\Users\\Kamatchi\\eclipse-workspace\\AdactinWithCucumber\\Excel\\" + fileName + ".xlsx");
		FileInputStream in = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(in);
		Sheet sh = w.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String cellValue;

		if (cell.getCellType() == 1) {
			cellValue = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date d = cell.getDateCellValue();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			cellValue = sdf.format(d);
		} else {
			double d = cell.getNumericCellValue();
			long l = (long) d;
			cellValue = String.valueOf(l);
		}
		if (cellValue.equalsIgnoreCase(oldValue)) {
			cell.setCellValue(newValue);
			FileOutputStream out = new FileOutputStream(f);
			w.write(out);
		}
	}

	// 62. To Launch chrome Browser by disabling notifications

	public static void launchChromeBrowserByDisablingNotifications() {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(op);
	}

	// 63. To Give Implicit Wait

	public static void WaitImplicitly() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// 64. To get complete value of cells in a particular row

	public static Map<String, String> readExcelCompleteCellsInParticularRow(String fileName, String sheetName,
			String rowValue) throws IOException {
		
		Map<String, String> mp = new LinkedHashMap<String, String>();
		File f = new File("C:\\Users\\Kamatchi\\eclipse-workspace\\CucumberAdactin\\Excel\\" + fileName + ".xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet(sheetName);
		String cellValue, txtHeading, txtData;

		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row row = s.getRow(i);
			Cell cell = row.getCell(1);
			if (cell.getCellType() == 1) {
				cellValue = cell.getStringCellValue();
			} else if (DateUtil.isCellDateFormatted(cell)) {
				Date d = cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				cellValue = sdf.format(d);

			} else {
				double d = cell.getNumericCellValue();
				long l = (long) d;
				cellValue = String.valueOf(l);
			}
			if (cellValue.equals(rowValue)) {
				Row headerRow = s.getRow(0);
				Row currentRow = s.getRow(i);

				for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
					Cell heading = headerRow.getCell(j);
					Cell data = currentRow.getCell(j);
					if (heading.getCellType() == 1) {
						txtHeading = heading.getStringCellValue();
					} else if (DateUtil.isCellDateFormatted(heading)) {
						Date d = heading.getDateCellValue();
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						txtHeading = String.valueOf(sdf.format(d));

					} else {
						double d = heading.getNumericCellValue();
						long l = (long) d;
						txtHeading = String.valueOf(l);
					}
					if (data.getCellType() == 1) {
						txtData = data.getStringCellValue();
					} else if (DateUtil.isCellDateFormatted(data)) {
						Date d = data.getDateCellValue();
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						txtData = String.valueOf(sdf.format(d));

					} else {
						double d = data.getNumericCellValue();
						long l = (long) d;
						txtData = String.valueOf(l);
					}
					mp.put(txtHeading, txtData);
				}
			}
		}

		return mp;
	}
}

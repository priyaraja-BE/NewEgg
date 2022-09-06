package org.newegg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Baseclass {
	
	protected static WebDriver driver;
	    public static Actions a ;
		public static Alert alt; 
	    public static TakesScreenshot tk;  
	    public static JavascriptExecutor js;
		public static Select s;
		
		
	    //1.BROWSER LAUNCH
		public static void browserLaunch() {
		 WebDriverManager.chromiumdriver().setup();
		 driver=new ChromeDriver();	
		}
		//2.MAXIMIZE THE WINDOW
		public static void maxWindow() {
		driver.manage().window().maximize();
		}
		
//WEBDRIVER METHOD 
        //3.getTitle()
        public static void getPageTitle() {
 	    String title = driver.getTitle();
	    System.out.println(title);
        }
        //4.getCurrentUrl()
        public static void getCurrentPageUrl() {
	    String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
	     }
        //5.get()
        public static void launchUrl(String url) {
        driver.get(url);
        }
        //6.getWindowHandle()
        public static void getWindowHandle() {
    	String windowHandle = driver.getWindowHandle();
 	    System.out.println(windowHandle);
        }
        //7.getWindowHandles()
        public static void getWindowHandles() {
        Set< String> windowHandles = driver.getWindowHandles();
    	System.out.println(windowHandles);
        }
        //8.close()
        public static void webPageClose() {
        driver.close();
        }
        //9.quit()
        public static void browserQuit() {
        driver.quit();
         }
//WEBELEMENTS METHODS 
         //10.sendKeys()
         public static void pasTxt(String text, WebElement txtbox) {
     	 txtbox.sendKeys(text); 
     	 }
         //11.click()
         public static void clk(WebElement txt) {
         txt.click();		
 	     } 
         //12.getText()
         public static void getText() { 
         alt = driver.switchTo().alert();
         String txxt= alt.getText();
         System.out.println(txxt);
         }
         //13.getAttribute()
         public static void getAttribute(WebElement element, String value) {
         String attributeval = element.getAttribute(value);
         System.out.println(attributeval);
         }
//DATA DRIVEN 
         //14.READ EXCEL
             public static String readExcel(String FileName,String getSheetName, int getRowNum,int getCellNum) throws IOException {
         		File f=new File("C:\\Users\\Mohan\\eclipse-workspace\\NewEgg\\excel\\"+FileName+".xlsx");
         		FileInputStream fis=new FileInputStream(f);
         		Workbook workbook = new XSSFWorkbook(fis);	
         		Sheet sheet = workbook.getSheet(getSheetName);
         		 Row row = sheet.getRow(getRowNum);
         	      Cell cell = row.getCell(getCellNum);
         	      String value="";	        	   		
         		int cellType = cell.getCellType();
         		if (cellType==1) {
         			 value = cell.getStringCellValue();
        		}
         			else if (DateUtil.isCellDateFormatted(cell)) {
         				Date date = cell.getDateCellValue();
         				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
         				 value = sdf.format(date);
         			}
         			else {
         				double dd = cell.getNumericCellValue();
         				long l= (long)dd;
         				value = String.valueOf(l);
         			
         		System.out.println(value);          		       		
         		         		         			
}
				return value;
}


             //15.CREATE ROW
             public static void createRowOnly (String FileName,String getSheetName,int creRow,int creCell,String setData) throws IOException {
         		File f=new File("C:\\Users\\Mohan\\eclipse-workspace\\dataDriven\\excel\\"+FileName+".xlsx");
         		boolean a = f.createNewFile(); //sysout(a);
         		FileInputStream fis=new FileInputStream(f);
         		Workbook w=new XSSFWorkbook(fis);
         		Sheet sheet = w.createSheet(getSheetName);
         		Row row = sheet.createRow(creRow);
         		Cell cell = row.createCell(creCell);
         		cell.setCellValue(setData);
         		FileOutputStream fos=new FileOutputStream(f);
         		w.write(fos);
         	}
             //16.CREATE CELL
         	public static void createcellonly(String FileName,String getSheetName,int getTheRow ,int creCell,String setData) throws IOException {
         		File f=new File("C:\\Users\\Mohan\\eclipse-workspace\\dataDriven\\excel\\"+FileName+".xlsx");
         		FileInputStream fis=new FileInputStream(f);
         		Workbook w=new XSSFWorkbook(fis);
         		Sheet sheet = w.getSheet(getSheetName);
         		Row row = sheet.createRow(getTheRow);
         		Cell cell = row.createCell(creCell);
         		cell.setCellValue(setData);
         		FileOutputStream fos=new FileOutputStream(f);
         		w.write(fos);
         	}
         	//17.READ AND UPDATE
         	public static void readAndUpdate(String FileName,String getSheetName,int getTheRow ,int creCell,String source,String destination) throws IOException {
         		File f=new File("C:\\Users\\Mohan\\eclipse-workspace\\dataDriven\\excel\\"+FileName+".xlsx");
         		FileInputStream fis=new FileInputStream(f);
         		Workbook w=new XSSFWorkbook(fis);
         		Sheet s = w.getSheet(getSheetName);
         		for(int i=0;i<=s.getPhysicalNumberOfRows();i++) {
         			Row r = s.getRow(i);
         			for(int j=0;j<=s.getPhysicalNumberOfRows();j++) {
             			Cell cell = r.getCell(j);
             			int cellType = cell.getCellType();
             			if(cellType ==1) {
             				String stringCellValue = cell.getStringCellValue();
             				if(stringCellValue.equals(source)) {
             					cell.setCellValue(destination);
             					FileOutputStream fos=new  FileOutputStream(f);
             					w.write(fos);
             				}
             			    }             			
         		            }
         		            }
			                }
         	
	//ACTIONS 
             //18.moveToElement()
 public static void actionsMoveToEle(WebElement text1) {
 	a = new Actions(driver);
 	a.moveToElement(text1).perform();
 }
            //19.dragAndDrop()
 public static void actionsDragAndDrop(WebElement sourcetxt, WebElement desttxt) {
 	a = new Actions(driver);
     a.dragAndDrop(sourcetxt, desttxt).perform();
	}
            //20.doubleClick()    
 public static void actionsDoubleClk(WebElement clicktext) {
 	a = new Actions(driver);
     a.doubleClick(clicktext).perform();
 }
            //21.contextClick
 public static void actionsContextClk(WebElement contextclk) {
 	a = new Actions(driver);
     a.contextClick(contextclk).perform();
 }
 
 //ALERT 
 //22.simple alert
 public static void okAlert() { 
 	alt = driver.switchTo().alert();
 	alt.accept();   
 }
 //23.conform alert
 public static void confirmAlert() { 
 	alt = driver.switchTo().alert();
 	alt.dismiss();
 }
 //24.prompt alert
 public static void promptAlert(String alttxt) { 
 	alt = driver.switchTo().alert();
 	alt.sendKeys(alttxt);
 }
//55.Get alert text 
	public static void alertGetText() { 
	alt=driver.switchTo().alert(); 
	String text = alt.getText(); 
	System.out.println(text); 
	}
 
 //25.TAKE SCREEN SHOT
	public static void takeScreenShot(String screentext) throws IOException { 
	tk=(TakesScreenshot)driver;
 File source = tk.getScreenshotAs(OutputType.FILE); 
 File dest=new File(screentext);
 FileUtils.copyFile(source, dest);
 }	
	
	//JAVA SCRIPT EXECUTION
	//26.scrolldown
 public static void javaScriptExescrup(WebElement scrollup) { 
 	js =(JavascriptExecutor)driver;
 	js.executeScript("arguments[0]scrollIntoView(true)", scrollup);
 	}
 //27.scrollup
 public static void javaScriptExescrdwn(WebElement scrolldown) { 
 	js =(JavascriptExecutor)driver;
 	js.executeScript("arguments[0]scrollIntoView(false)", scrolldown);
     }
 //28.sendKeys()
 public static void javaScriptExesendkey(WebElement ttext,String intext) { 
 	js =(JavascriptExecutor)driver;
 	js.executeScript("arguments[0].setAttribute('value','intext')", ttext);
     }
 //29.click()
 public static void javaScriptExeclk(WebElement ttext) { 
 	js =(JavascriptExecutor)driver;
 	js.executeScript("arguments[0].click()", ttext);
     }
 
 //WEBTABLE
 //30.TABLE COUNT
 public static void tableSize(List<WebElement> tab) {
 	System.out.println("total no of table :"+tab.size());
 }
 //31.Display Table Heading Only 
 public static void displayTableHeading(WebElement webEle) { 
 List<WebElement> allRows = webEle.findElements(By.tagName("tr")); 
 WebElement firstRow = allRows.get(0); 
 List<WebElement> heading = firstRow.findElements(By.tagName("th")); 
 for (int j = 0; j < heading.size(); j++) { 
 WebElement headData = heading.get(j); 
 System.out.println(headData.getText()); 
 } 
 }
 
 //32. DISPLAYING PARTICULAR DATA
 	
 public static void particularData(WebElement tabletext, int rowposition,int dataposition)  {
 	 
   List<WebElement> row = tabletext.findElements(By.tagName("tr"));
   WebElement rows = row.get(rowposition);
   List<WebElement> data = rows.findElements(By.tagName("td"));
   WebElement datas = data.get(dataposition);
   String texttable = datas.getText();
   System.out.println(texttable);
 
 }  
 //33.DISPLAY TABLE
  public static void tabledisplay (WebElement webele) { 
 	 
 	List<WebElement> allrow = webele.findElements(By.tagName("tr"));
 	for(int i=0; i<allrow.size(); i++){
 		WebElement row = allrow.get(i);
 		List<WebElement> heading = row.findElements(By.tagName("th"));
 		for(int j=0; j<heading.size(); j++) {
 			WebElement headings = heading.get(j);
 			
 			System.out.println(headings.getText());}
 		
 			List<WebElement> data = row.findElements(By.tagName("td"));
 			for (int k = 0; k < data.size(); k++) {
 				WebElement datas = data.get(k);
 				System.out.println(datas.getText());
					} 	 		
 	}
 	}
  
  //FRAMES
  //34. USING ID
  public static void frameId(String id) {
 	 driver.switchTo().frame(id);
  }
  //35.Name
  public static void frameName(String name) {
 	 driver.switchTo().frame(name);
  }
  //36.WebElement
  public static void frameWebElement(WebElement element) {
 	 driver.switchTo().frame(element);
  }
  //37.Using Index
  public static void frameIndex(int index) {
 	 driver.switchTo().frame(index);       	 
  }
  //38.parentFrame
  public static void frameParent() {
 	 driver.switchTo().parentFrame();
  }
  //39. defaultContent
  public static void defaultContent() {
 	 driver.switchTo().defaultContent();
  } 

 //SELECT
 //40.SELECT BY VALUE 
 public static void selectVal(WebElement refelement, String text1) {
	s=new Select(refelement);
	s.selectByValue(text1);
 }
 //41..SELECT BY INDEX
	public static void selectIndex(WebElement refelement,int value1) {
	s=new Select(refelement);
	s.selectByIndex(value1);
	}
	//42.SELECT BY VISIBLE TEXT
	public static void selectvis(WebElement refelement,String valuevisible) {
	s=new Select(refelement);
	s.selectByVisibleText(valuevisible);
	}
	//43.ISMULTIPLE
	public static void multi(WebElement refelement) {
		s=new Select(refelement);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}
	//44.getALLSelectedOptions()
	public static void allSelectOptions(WebElement refelement) {
		s=new Select(refelement);
		s.getAllSelectedOptions();
		}
	//45.getOptions()
	public static void allOptions(WebElement refelement) {
		s=new Select(refelement);
		s.getOptions();
		}
	//46.getFirstSelectedOption()
	public static void getFirst(WebElement refelement) {
		s=new Select(refelement);
		s.getFirstSelectedOption();
		}
	//47.deselectByValue()
	public static void deselectval(WebElement refelement, String txt) {
		s=new Select(refelement);
		s.deselectByValue(txt);
		}
	//48.deselectByIndex()
	public static void deselectindx(WebElement refelement, int index) {
		s=new Select(refelement);
		s.deselectByIndex(index);
		}
	//49.deselectByVisibleText()
	public static void deselectindx(WebElement refelement, String txt) {
		s=new Select(refelement);
		s.deselectByVisibleText(txt);
		}
	//50.deselectAll()
	public static void deselectindx(WebElement refelement) {
		s=new Select(refelement);
		s.deselectAll();
		}
	
	//56.windows handling 
		public static void handlingWindow(int index) { 
		Set<String> windowHandles = driver.getWindowHandles(); 
		List<String> list=new ArrayList<String>(windowHandles); 
		driver.switchTo().window(list.get(index)); 
		}
		
	//WAITS
	//51.ImplicitWait
	public static void implicitWait(long sec) {
		driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
	}
	//52.ExplicitWait
	//alertIsPresent Wait
	public static void alertIsPresentWait(long sec) {
		WebDriverWait w=new WebDriverWait(driver,sec);
		w.until(ExpectedConditions.alertIsPresent());
	}
	//53.fluent wait
	//invisibilityOf()
	public static void fluentMilliSec(long milliSec,long pollingSec,WebElement element) {
	FluentWait<WebDriver> f=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(milliSec)).
			pollingEvery(Duration.ofMillis(pollingSec)).ignoring(Throwable.class);
	f.until(ExpectedConditions.invisibilityOf(element));
	}
	//54.alertIsPresent()
	public static void fluentSec(long sec,long pollingSec) {
	FluentWait<WebDriver> f=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).
			pollingEvery(Duration.ofSeconds(pollingSec)).ignoring(Throwable.class);
	f.until(ExpectedConditions.alertIsPresent());
	} 
	
	//56.ExplicitWait
	//elementSelectionStateToBe
	public static void elementSelectionStateToBe(long sec,WebElement locator,boolean selected) {
		WebDriverWait w=new WebDriverWait(driver,sec);
		w.until(ExpectedConditions.elementSelectionStateToBe(locator, selected));
	
		
		//57-70
	/*	elementToBeClickable
		public static void elementSelectionStateToBe(long sec,WebElement element;
		WebDriverWait w=new WebDriverWait(driver,sec);
		((FluentWait<WebDriver>) w).until(ExpectedConditions.elementToBeClickable(element));
		
		w.until(ExpectedConditions.elementToBeSelected(locator));
		w.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
		w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		w.until(ExpectedConditions.presenceOfElementLocated(locator));
		w.until(ExpectedConditions.textToBePresentInElement(element, text));
		w.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
		w.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
		w.until(ExpectedConditions.titleIs(title));
		w.until(ExpectedConditions.titleContains(title));
		w.until(ExpectedConditions.visibilityOf(element));
		w.until(ExpectedConditions.visibilityOfAllElements(elements));
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		w.until(ExpectedConditions.visibilityOfElementLocated(locator));
		*/
		
		
	
}			
}		
							

			
		
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	



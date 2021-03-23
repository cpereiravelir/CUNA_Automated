import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement

WebUI.openBrowser('')

WebDriver driver = DriverFactory.getWebDriver()

WebUI.navigateToUrl('https://cuna-stage.adobemsbasic.com/content/cuna/councils/search.html?q=community%20tour')

WebUI.setViewPortSize(1200, 1020)

'click on event dropdown'
Eventdropdown = driver.findElement(By.xpath('//*[@id="downshift-1-toggle-button"]'))

EventTestObject = WebUI.convertWebElementToTestObject(Eventdropdown)

WebUI.click(EventTestObject)

'Check on free webinar'
FreeWebinar = driver.findElement(By.xpath('//*[@id="downshift-1-item-0"]'))

WebinarTestObject = WebUI.convertWebElementToTestObject(FreeWebinar)

WebUI.click(WebinarTestObject)

'Apply item selected'
ClickApply = driver.findElement(By.xpath('//*[@id="downshift-1-menu"]/div/button[1]'))

ApplySelectedTestObject = WebUI.convertWebElementToTestObject(ClickApply)

WebUI.click(ApplySelectedTestObject)

'Verify No results message'

WebUI.verifyTextPresent('Sorry, no results were found for your search.', false, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()


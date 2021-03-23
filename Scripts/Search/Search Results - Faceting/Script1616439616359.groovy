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


// IN PROGRESS
WebUI.openBrowser('')

WebDriver driver = DriverFactory.getWebDriver()

WebUI.navigateToUrl('https://cuna-stage.adobemsbasic.com/content/cuna/councils/search.html')

WebUI.setViewPortSize(1200, 1020)

'click on event dropdown'
Eventdropdown = driver.findElement(By.xpath('//*[@id="downshift-1-toggle-button"]'))

EventTestObject = WebUI.convertWebElementToTestObject(Eventdropdown)

WebUI.click(EventTestObject)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://cuna-stage.adobemsbasic.com/content/cuna/councils/search.html')

WebUI.click(findTestObject('Object Repository/Page_search/svg_Select one or moreContent Types_icon ic_8a2219'))

WebUI.click(findTestObject('Object Repository/Page_search/span_White Paper_checkbox__custom'))

WebUI.click(findTestObject('Page_search/button_Apply'))

WebUI.click(findTestObject('Page_search/svg_Select one or moreEvent Types_icon icon_f28d09'))

WebUI.click(findTestObject('Page_search/svg_Select one or moreEvent Types_icon icon_f28d09'))

WebUI.click(findTestObject('Page_search/use'))

WebUI.click(findTestObject('Object Repository/Page_search/span_Technology_checkbox__custom'))

WebUI.click(findTestObject('Page_search/button_Apply'))

WebUI.click(findTestObject('Object Repository/Page_search/button_2'))

WebUI.click(findTestObject('Object Repository/Page_search/button_1'))

WebUI.click(findTestObject('Page_search/button_clear filters'))


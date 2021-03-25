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
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownTestCase

WebUI.openBrowser('')

WebDriver driver = DriverFactory.getWebDriver()

WebUI.navigateToUrl('https://cuna-stage.adobemsbasic.com/content/cuna/councils.html')

WebUI.setViewPortSize(1200, 820)

WebUI.mouseOver(findTestObject('Page_CUNA Councils/span_Conferences  Events'))

WebUI.mouseOver(findTestObject('Object Repository/Page_CUNA Councils/a_Conferences'))

WebUI.click(findTestObject('Object Repository/Page_CUNA Councils/a_Conferences'))

'click on Logo'
Logo = driver.findElement(By.cssSelector('.global-header__logo'))

LogoObject = WebUI.convertWebElementToTestObject(Logo)

WebUI.click(LogoObject)

url = WebUI.getUrl()

WebUI.verifyEqual(url, 'https://cuna-stage.adobemsbasic.com/content/cuna/councils.html', FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

@TearDown
def onFailure() {
	WebUI.closeBrowser()
}


 
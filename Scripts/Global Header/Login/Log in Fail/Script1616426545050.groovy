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
import com.kms.katalon.core.testobject.ConditionType
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

'Click on Login'
LoginButtonElement = driver.findElement(By.cssSelector(".global-header__login.js-login"))

LoginButtonObject = WebUI.convertWebElementToTestObject(LoginButtonElement)

WebUI.click(LoginButtonObject)

//WebUI.delay(7)

WebUI.waitForPageLoad(10)

'Verify URL'
LoginRedirectionUrl = WebUI.getUrl()

println(LoginRedirectionUrl)

if (!(LoginRedirectionUrl.contains('https://ebus.cuna.org/sso/Login.aspx'))) {
	KeywordUtil.markFailedAndStop('Not the correct URL, the test is failed!')
}

'Input Email'
EmailElement = driver.findElement(By.id("LoginTextBox"))
	
EmailObject = WebUI.convertWebElementToTestObject(EmailElement)

WebUI.setText(EmailObject, 'kai.rasmussen@velir.com')


'Input Password'

PasswordElement = driver.findElement(By.id("PasswordTextBox"))
 
 PasswordObject = WebUI.convertWebElementToTestObject(PasswordElement)
 
 WebUI.setEncryptedText(PasswordObject, 'TNnFnhMdEPFmW4M7lcjj4w==')
 
'Submit'
SubmitElement = driver.findElement(By.id("SubmitButton"))

SubmitObject = WebUI.convertWebElementToTestObject(SubmitElement)

WebUI.click(SubmitObject)

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Single Sign On/div_Please enter a valid email addresspassword'), 30)
/*
WebUI.delay(10)

'verify validation'

ValidationElement = driver.findElement(By.id("MainValidationSummary"))

ValidationObject = WebUI.convertWebElementToTestObject(ValidationElement)
println( WebUI.getText(ValidationObject))

if (!( WebUI.getText(ValidationObject).contains('Please enter a valid email address/password'))) {
	KeywordUtil.markFailedAndStop('Not validation, the test failed!')
}
*/
WebUI.closeBrowser()


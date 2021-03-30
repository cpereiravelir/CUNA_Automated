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

WebUI.setViewPortSize(1200, 1020)

'Click on login'

WebUI.click(findTestObject('Page_CUNA Councils/a_Log In'))

'Verify Login URL'
LoginRedirectionUrl = WebUI.getUrl()

println(LoginRedirectionUrl)

if (!(LoginRedirectionUrl.contains('https://ebus.cuna.org/sso/Login.aspx'))) {
	KeywordUtil.markFailedAndStop('Not the correct URL, the test is failed!')
}

'Fill username and password'
WebUI.setText(findTestObject('Page_Single Sign On/input_Invalid Email_LoginTextBox'), 'kai.rasmussen@velir.com')

WebUI.setEncryptedText(findTestObject('Page_Single Sign On/input_Invalid Password_PasswordTextBox'), 'TNnFnhMdEPHm6g13xQRQ0w==')

'Click on Submit/Login'

WebUI.click(findTestObject('Page_Single Sign On/input_Remember me on this device_SubmitButton'))

'Verify URL'
AfterLoggedUrl = WebUI.getUrl()

if (!(AfterLoggedUrl.equals('https://cuna-stage.adobemsbasic.com/content/cuna/councils.html'))){
	KeywordUtil.markFailedAndStop('Not the correct URL, the test is failed!')
}

'Verify that we are logged'
LoginAuthElement = driver.findElements(By.cssSelector('.global-header__login.js-login.is-auth'))

println(LoginAuthElement)

if (LoginAuthElement.size() < 1) {

	KeywordUtil.markFailedAndStop('Not logged, test failed.')
}

'Click on the Email(login) button'

WebUI.click(findTestObject('Object Repository/Page_CUNA Councils/Logged_button'))

'Verify display of the logout'

WebUI.verifyTextPresent('Logout', true, FailureHandling.STOP_ON_FAILURE)

'Click on Logout'

WebUI.click(findTestObject('Object Repository/Page_CUNA Councils/a_Logout'))

WebUI.delay(3)

'Verify button shows Login again'

WebUI.verifyElementVisible(findTestObject('Page_CUNA Councils/a_Log In'), FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()


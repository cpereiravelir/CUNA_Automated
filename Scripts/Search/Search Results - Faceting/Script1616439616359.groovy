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

//IN PROGRESS pending for sherri
WebUI.openBrowser('')

WebDriver driver = DriverFactory.getWebDriver()

WebUI.navigateToUrl('https://cuna-stage.adobemsbasic.com/content/cuna/councils/search.html')

WebUI.setViewPortSize(1200, 1020)

'click on event dropdown'
Eventdropdown = driver.findElement(By.xpath('//*[@id="downshift-1-toggle-button"]'))

EventTestObject = WebUI.convertWebElementToTestObject(Eventdropdown)

WebUI.click(EventTestObject)

'Check on Conference'
ConferenceItem = driver.findElement(By.xpath('//*[@id="downshift-1-item-1"]'))

ConferenceTestObject = WebUI.convertWebElementToTestObject(ConferenceItem)

WebUI.click(ConferenceTestObject)

'click on Apply'
Applybutton = driver.findElement(By.cssSelector('.custom-select__button.btn.btn--primary.btn--sm'))

ApplyButtonTestObject = WebUI.convertWebElementToTestObject(Applybutton)

WebUI.click(ApplyButtonTestObject)

'click on Council type dropdown'
CouncilTypeDropdown = driver.findElement(By.xpath('//*[@id="downshift-69-toggle-button"]'))

CouncilTestObject = WebUI.convertWebElementToTestObject(CouncilTypeDropdown)

WebUI.click(CouncilTestObject)

'click on Lending dropdown'
LendingItemDropdown = driver.findElement(By.xpath('//*[@id="downshift-69-item-3"]'))

LendingTestObject = WebUI.convertWebElementToTestObject(LendingItemDropdown)

WebUI.click(LendingTestObject)

'click on Apply'
Applybutton = driver.findElement(By.cssSelector('.custom-select__button.btn.btn--primary.btn--sm'))

ApplyButtonTestObject = WebUI.convertWebElementToTestObject(Applybutton)

WebUI.click(ApplyButtonTestObject)

'verify display of active facets'
ActiveFacetElements = driver.findElement(By.xpath('//*[@id="search-facets"]/div[2]'))

ActiveFacetsObject = WebUI.convertWebElementToTestObject(ActiveFacetElements)

ActiveFacetsObjectText = WebUI.getText(ActiveFacetsObject)

println(ActiveFacetsObjectText)

if (ActiveFacetsObjectText.contains('Lending') && ActiveFacetsObjectText.contains('Conference')) {
	KeywordUtil.markFailedAndStop('Facets are not active, the test is failed!')
	
}

WebUI.closeBrowser()

@TearDown
def onFailure() {
	WebUI.closeBrowser()
}



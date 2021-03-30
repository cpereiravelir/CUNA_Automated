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

WebUI.navigateToUrl('https://cuna-dev.adobemsbasic.com/content/cuna/councils/search.html')
//WebUI.navigateToUrl('https://cuna-stage.adobemsbasic.com/content/cuna/councils/search.html')

//WebUI.maximizeWindow()
WebUI.setViewPortSize(1200, 1020)

'Fill a keyword on Search bar'
WebUI.setText(findTestObject('Object Repository/Page_search/input_Search_searchPageKeyword'),'Community Tour')


'Click on magnifying glass'

WebUI.click(findTestObject('Object Repository/Page_search/button_Search_search-btn'))

'Verify search results contains "Community tour" keyowrd'

ResultItems = WebUI.getText(findTestObject('Page_search/div_Search_Results_Region'))

println(ResultItems)

if (!(ResultItems.contains('Community Tour'))) {
	KeywordUtil.markFailedAndStop("There is not Community Tour items visible, so the test is failed!")
}

'click on Council type dropdown'
CouncilTypeDropdown = driver.findElement(By.xpath('//*[@id="downshift-2-toggle-button"]'))

CouncilTestObject = WebUI.convertWebElementToTestObject(CouncilTypeDropdown)

WebUI.click(CouncilTestObject)

'click on Lending type dropdown'
LendingItemDropdown = driver.findElement(By.xpath('//*[@id="downshift-2-item-3"]'))

LendingTestObject = WebUI.convertWebElementToTestObject(LendingItemDropdown)

WebUI.click(LendingTestObject)

'click on Apply'
Applybutton = driver.findElement(By.cssSelector('.custom-select__button.btn.btn--primary.btn--sm'))

ApplyButtonTestObject = WebUI.convertWebElementToTestObject(Applybutton)

WebUI.click(ApplyButtonTestObject)

'verify display of lending button'
LendingButton = driver.findElement(By.xpath('//*[@id="search-facets"]/div[2]'))

LendingButtonTestObject = WebUI.convertWebElementToTestObject(LendingButton)

LendingLabelText = WebUI.getText(LendingButtonTestObject)

println(LendingLabelText)

if (!(LendingLabelText.contains('Lending'))) {
	KeywordUtil.markFailedAndStop("Lending is not visible, so the test is failed!")
}

'Verify more than 1 results'
ResultsLabelElement = driver.findElement(By.xpath('//*[@id="search-f3a80d2db4"]/div[1]/div/div/div[2]/div[2]/p'))

NumberResultsLabelObject = WebUI.convertWebElementToTestObject(ResultsLabelElement)

NumberOfResults = WebUI.getText(NumberResultsLabelObject).replaceAll('\\n|\\r', '')

//Gets Number + Result ex: 10 Results
Pattern regexResults = Pattern.compile('\\d+ Results')

Matcher MatchNumberResults = regexResults.matcher(NumberOfResults)

if (MatchNumberResults.find()) {
    expectedLabelResutl = MatchNumberResults.group()
//Getting just the number
    Pattern regexNumber = Pattern.compile('\\d+')

    Matcher matchNumber = regexNumber.matcher(expectedLabelResutl)

    if (matchNumber.find()) {
        TotalResults = matchNumber.group()

        println(TotalResults)
//comparing with >=1
        WebUI.verifyGreaterThanOrEqual(TotalResults, 1, FailureHandling.STOP_ON_FAILURE)
    }
}

WebUI.closeBrowser()


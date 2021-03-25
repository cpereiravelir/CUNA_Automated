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
import com.kms.katalon.core.annotation.TearDown as TearDown
import com.kms.katalon.core.annotation.TearDownTestCase as TearDownTestCase


WebUI.openBrowser('')

WebDriver driver = DriverFactory.getWebDriver()

WebUI.navigateToUrl('https://cuna-stage.adobemsbasic.com/content/cuna/councils/search.html')

WebUI.click(findTestObject('Object Repository/Page_search/button_Event Type'))

WebUI.click(findTestObject('Object Repository/Page_search/span_Conference_checkbox__custom'))

WebUI.click(findTestObject('Object Repository/Page_search/button_Apply'))

WebUI.click(findTestObject('Object Repository/Page_search/button_Council Type'))

WebUI.click(findTestObject('Object Repository/Page_search/span_Lending_checkbox__custom'))

WebUI.click(findTestObject('Object Repository/Page_search/button_Apply'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_search/div_LendingConferenceclear filters'))

WebUI.click(findTestObject('Object Repository/Page_search/p_Showing 1 - 1 of 1 Results'))

'Verify more than 1 results'
//ResultsLabelElement = driver.findElement(By.xpath('//*[@id="search-f3a80d2db4"]/div[1]/div/div/div[2]/div[2]/p'))

//NumberResultsLabelObject = WebUI.convertWebElementToTestObject(ResultsLabelElement)

NumberOfResults = WebUI.getText(findTestObject('Object Repository/Page_search/p_Showing 1 - 1 of 1 Results')).replaceAll('\\n|\\r', '')

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


WebUI.click(findTestObject('Object Repository/Page_search/button_clear filters'))

WebUI.verifyElementNotPresent(findTestObject('Page_search/div_LendingConferenceclear filters'), 5, FailureHandling.STOP_ON_FAILURE)


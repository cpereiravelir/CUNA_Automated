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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebDriver driver = DriverFactory.getWebDriver()

WebUI.navigateToUrl('https://cuna-dev.adobemsbasic.com/content/cuna/councils/conferences---events0.html')
//WebUI.navigateToUrl('https://cuna-stage.adobemsbasic.com/content/cuna/councils/conferences---events0.html')

//WebUI.maximizeWindow()
WebUI.setViewPortSize(1200, 1020)

'Verify Search Bar functionality'
WebUI.setText(findTestObject('Object Repository/Page_Conferences  Events/input_Search_Keyword'), 'Investment')

WebUI.click(findTestObject('Object Repository/Page_Conferences  Events/button_Search_search-btn'))


'verify more than 1 results'

ResultsLabelElement = driver.findElement(By.xpath('//*[@id="eventssearch-b836e2c9da"]/div[2]/div/div/div[2]/div[2]/p'))
 
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
 
 'Select a facet'
 
 WebUI.click(findTestObject('Object Repository/Page_Conferences  Events/button_Event Type'))
 
 WebUI.click(findTestObject('Object Repository/Page_Conferences  Events/li_Forum'))
 
 WebUI.click(findTestObject('Object Repository/Page_Conferences  Events/button_Apply'))
 
 WebUI.verifyTextPresent('Sorry, no results were found for your search.', false, FailureHandling.STOP_ON_FAILURE)
 
WebUI.closeBrowser()

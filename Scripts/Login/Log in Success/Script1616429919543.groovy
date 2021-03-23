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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://cuna-stage.adobemsbasic.com/content/cuna/councils.html')

WebUI.setViewPortSize(1200, 820)

WebUI.click(findTestObject('Page_CUNA Councils/a_Log In'))

WebUI.setText(findTestObject('Page_Single Sign On/input_Invalid Email_LoginTextBox'), 'kai.rasmussen@velir.com')

WebUI.setEncryptedText(findTestObject('Page_Single Sign On/input_Invalid Password_PasswordTextBox'), 'TNnFnhMdEPHm6g13xQRQ0w==')

WebUI.click(findTestObject('Page_Single Sign On/input_Remember me on this device_SubmitButton'))

WebUI.verifyElementVisible(findTestObject('Page_CUNA Councils/button_kairasmussenvelircom'), FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()




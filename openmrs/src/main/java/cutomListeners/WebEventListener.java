package cutomListeners;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.aventstack.extentreports.Status;

import common.pWait;
import testBase.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		log.info("Navigating to : '"+ url+"'");
		pNode.log(Status.INFO, "Navigating to : '"+ url+"'");
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		log.info("Successfully Navigate to : '"+ url+"'");
		pNode.log(Status.INFO, "Successfully Navigate to : '"+ url+"'");
	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		wait.until(pWait.jQueryAJAXCallsHaveCompleted());
		//wait.until(pWait.angularHasFinishedProcessing());
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		log.info("Trying to click on : '"+element.toString()+"'");
		pNode.log(Status.INFO,"Trying to click on : '"+element.toString()+"'");
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		log.info("Clicked on: '" + element.toString()+"'");
		pNode.log(Status.INFO,"Clicked on: '" + element.toString()+"'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		log.info("Value of the : '" + element.toString()
		+ "' before any changes made");
		pNode.log(Status.INFO,"Value of the : '" + element.toString()
		+ "' before any changes made");
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		log.info("Element value changed to: '" + element.toString()+"'");
		pNode.log(Status.INFO,"Element value changed to: '" + element.toString()+"'");
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}

}

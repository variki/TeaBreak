package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class pWait {
	public static ExpectedCondition<Boolean> angularHasFinishedProcessing() {
		return new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				boolean check;
				if(((JavascriptExecutor) driver).executeScript("return window.angular").equals("undefined"))
						{
					check = true;
						}
				else{
					check = Boolean.valueOf(((JavascriptExecutor) driver).executeScript(
							"return (window.angular !== undefined) && (angular.element(document).injector() !==undefined) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)")
							.toString());
				}
				return check;
			}
		};
	}
	
	public static ExpectedCondition<Boolean> jQueryAJAXCallsHaveCompleted() {
		return new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (Boolean) ((JavascriptExecutor) driver)
						.executeScript("return (window.jQuery!= null) && (jQuery.active === 0);");
			}
		};
	}

}

package cutomListeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import reportManager.ExtentManager;
import testBase.TestBase;

public class ExtentManagerListeners extends TestBase implements IInvokedMethodListener, ITestListener {
	private static ThreadLocal<ExtentTest> testReports = new ThreadLocal<ExtentTest>();

	public void beforeInvocation(IInvokedMethod method, ITestResult result) {
		/*if(result.getMethod().getMethodName().toLowerCase().equals("beforesuite"))
		{
			extent = ExtentManager.getIntance();
		}
		if(result.getMethod().getMethodName().toLowerCase().equals("beforemethod"))
		{
		pNode = extent.createTest(result.getTestClass().getName().toUpperCase() + " | "
				+ result.getMethod().getMethodName().toLowerCase(), result.getMethod().getDescription());
		testReports.set(pNode);
		}*/

	}

	public void onStart(ITestContext context) {

		/*pNode = extent.createTest(
				((ITestResult) context).getTestClass().getName().toUpperCase() + " | "
						+ ((ITestResult) context).getMethod().getMethodName().toLowerCase(),
				((ITestResult) context).getMethod().getDescription());
		testReports.set(pNode);
*/
	}

	public void onFinish(ITestContext context) {

		if (extent != null) {
			extent.flush();
		}

	}

	public void onTestStart(ITestResult result) {
		 pNode = extent.createTest(result.getTestClass().getName().toUpperCase() + " | " +
		 result.getMethod().getMethodName().toLowerCase(),result.getMethod().getDescription());
		 testReports.set(pNode);
	}

	public void onTestFailure(ITestResult result) {

		String code = "<b>" + "TEST CASE" + result.getMethod().getMethodName() + "\n" + "Reason:"
				+ result.getThrowable().getMessage();
		Markup m = MarkupHelper.createCodeBlock(code);
		testReports.get().fail(m);
	}

	public void onTestSkipped(ITestResult result) {
		String code = "<b>" + "TEST CASE" + result.getMethod().getMethodName();
		Markup m = MarkupHelper.createLabel(code, ExtentColor.YELLOW);
		testReports.get().skip(m);
	}

	public void onTestSuccess(ITestResult result) {
		String logText = "<b>" + "TEST CASE: " + result.getMethod().getMethodName().toUpperCase() + "<b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReports.get().pass(m);
	}

}

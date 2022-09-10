package commons;

import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;
import org.apache.commons.logging.Log;

public class MethodListener implements IInvokedMethodListener {

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

		log.debug("Before invocation of " + method.getTestMethod().getMethodName());

	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult result) {
		log.debug("After invocation of " + method.getTestMethod().getMethodName());
		Reporter.setCurrentTestResult(result);
		if (method.isTestMethod()) {
			VerificationFailures allFailures = VerificationFailures.getFailures();

			// Add an existing failure for the result to the failure list
			if (result.getThrowable() != null) {
				allFailures.addFailureForTest(result, result.getThrowable());
			}
			List<Throwable> failures = allFailures.getFailuresForTest(result);
			int size = failures.size() - 1;
			if (size > 0) {
				result.setStatus(ITestResult.FAILURE);
				if (size == 1) {
					result.setThrowable(failures.get(0));
				} else {
					StringBuffer message = new StringBuffer("Multiple failures (").append(size).append("):\n");
					for (int failure = 0; failure < size - 1; failure++) {
						message.append("Failure ").append(failure + 1).append(" of ").append(size).append("\n");
						message.append(Utils.longStackTrace(failures.get(failure), false)).append("\n");
					}
					Throwable last = failures.get(size - 1);
					message.append("Failure ").append(size).append(" of ").append(size).append("\n");
					message.append(last.toString());
					Throwable merged = new Throwable(message.toString());
					merged.setStackTrace(last.getStackTrace());
					result.setThrowable(merged);

				}
			}
		}

	}

	private static final Log log = LogFactory.getLog(MethodListener.class);
}
// có nhiệm vụ log ra những cái message lỗi, tức là trong trường hợp có nhiều hơn 1 cái điểm verify mà bị lỗi thì nó sẽ show hết tất cả nhứng điểm verify
// lỗi đó ra vì mặc định Assert chỉ show có 1 cái bị lỗi nên mình ko có kiểm tra dc thằng nào bị lỗi
// ---------> dùng Class này như 1 thư viện ko cần viết lại nữa

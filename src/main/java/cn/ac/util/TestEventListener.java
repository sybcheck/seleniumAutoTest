package cn.ac.util;

import java.io.IOException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestEventListener extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestFailure(tr);
		// 类名为全类名，包含包名
		String classname = tr.getTestClass().getName();
		// 方法名为执行的方法
		String methodname = tr.getMethod().getMethodName();
		try {
			TestUtil.takeScreenshot(classname, methodname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

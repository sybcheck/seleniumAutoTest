package cn.ac.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

/**
 * 
 * @author sybcheck
 *
 */
public class AssertRewrite {
	public static final Logger LOGGER = LoggerFactory.getLogger(AssertRewrite.class);

	// 重写assertEquals方法，断言失败就截图,然后再抛出error，以便系统能捕获该error
	public static void assertEquals(Object actual, Object expected) {
		try {
			Assert.assertEquals(actual, expected);
		} catch (Error e) {
			LOGGER.error("断言title:" + expected + "----失败");
			LOGGER.error("{}", e);
			throw e;// 这里故意抛出error
		}
	}

	// 重写assertNotEquals方法
	public static void assertNotEquals(Object actual, Object expected) {

	}

	// 重写assertNull方法
	public static void assertNull(Object object) {

	}

	// 后续可继续添加assert方法的重写，以实现更多断言功能
}

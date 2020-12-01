
package cn.ac.base;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import cn.ac.util.TestUtil;
import cn.ac.util.WebEventListener;

public class DriverBase extends propBase {

    public static WebDriver driver;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
    public static final Logger LOGGER = LoggerFactory.getLogger(DriverBase.class);
    public static JavascriptExecutor js;

    public DriverBase() {
        if (driver != null) {
            return;
        }
        String browserName = prop.getProperty("browser");
        LOGGER.info("初始化" + browserName + "浏览器...");
        // 判断所使用的浏览器
        if (browserName.equalsIgnoreCase("chrome")) {
            // 驱动位置设置
            System.setProperty(prop.getProperty("chromeDriverName"), prop.getProperty("chromeDriverPath"));
            // 无头模式
            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--headless");//不打开浏览器
            chromeOptions.addArguments("--no-sandbox");// 参数是让Chrome在root权限下跑
            chromeOptions.addArguments("disable-infobars");// 忽略警告提示语
//		    chromeOptions.addArguments("start-maximized");// 页面最大化
            chromeOptions.addArguments("--disable-gpu");//谷歌文档提到需要加上这个属性来规避bug
//            chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36");//不设置有些网上有问题
//            chromeOptions.addEncodedExtensions("'excludeSwitches', ['enable-automation']");

//		    chromeOptions.addArguments("Referrer Policy=strict-origin-when-cross-origin");
//            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);// 立即返回不等待页面加载
//            chromeOptions.addArguments("user-agent=\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36\"");//不设置有些网上有问题
//            chromeOptions.addArguments("--disable-blink-features");
//            chromeOptions.addArguments("--disable-blink-features=AutomationControlled");

//		    chromeOptions.addArguments("enable-automation");
//		    chromeOptions.addArguments("--disable-extensions");
//		    chromeOptions.addArguments("--dns-prefetch-disable");
//		    chromeOptions.addArguments("--disable-gpu");

            driver = new ChromeDriver(chromeOptions);


//			driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty(prop.getProperty("geckoDriverName"), prop.getProperty("geckoDriverPath"));
            // 无头模式
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary("D:\\Program Files\\Mozilla Firefox\\firefox.exe");
            firefoxOptions.addArguments("--no-sandbox");// 参数是让Chrome在root权限下跑
            firefoxOptions.addArguments("disable-infobars");// 忽略警告提示语
//		    chromeOptions.addArguments("start-maximized");// 页面最大化
            firefoxOptions.addArguments("--disable-gpu");//谷歌文档提到需要加上这个属性来规避bug
            firefoxOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36");//不设置有些网上有问题
//			firefoxOptions.addArguments("--headless");//
            driver = new FirefoxDriver(firefoxOptions);
            // 有头模式
//            System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
//            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty(prop.getProperty("ieDriverName"), prop.getProperty("ieDriverPath"));
            driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty(prop.getProperty("edgeDriverName"), prop.getProperty("edgeDriverPath"));
            System.setProperty("webdriver.edge.bin",
                    "C:\\Windows\\SystemApps\\Microsoft.MicrosoftEdge_8wekyb3d8bbwe\\MicrosoftEdge.exe");
            driver = new EdgeDriver();
        }
        e_driver = new EventFiringWebDriver(driver);
        // 实现自己的监听器
        // EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;
        js = (JavascriptExecutor) driver;
//        driver.manage().window().maximize();
//         加载超时
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         同步浏览器
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

    }

    /**
     */
    @BeforeSuite
    public void bfSuite() {
        System.out.println("@BeforeSuite function......");
    }

    /**
     * 每一组suite后执行 可以做收尾工作
     */
    @AfterSuite
    public void afSuite() {
        System.out.println("@AfterSuite function......");
        try {
            LOGGER.info("关闭退出浏览器...");
            // 不可同时使用 firefox中会有问题
            Thread.sleep(2000);
//			driver.close();
//			driver.quit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 一组测试用例前 做一些初始化工作
     *
     * @throws IOException
     * @throws UnsupportedEncodingException
     * @BeforeTest注解
     */
    @BeforeTest
    public void initial() {
        System.out.println("@BeforeTest function......");
        // 一组测试用例执行前 清除一遍缓存
        driver.manage().deleteAllCookies();
    }

    /**
     * 一组测试用例后 做一些收尾工作
     */
    @AfterTest
    public void clear() {
        System.out.println("@AfterTest function......");
    }

    /**
     * 在调用当前类的第一个测试方法之前运行，注释方法仅运行一次
     */
    @BeforeClass
    public void bfClass() {
        System.out.println("@BeforeClass function......");
    }

    /**
     * 在调用当前类的最后一个测试方法之后运行，注释方法仅运行一次
     */
    @AfterClass
    public void afClass() {
        System.out.println("@AfterClass function......");
    }

    /**
     * 注释方法将在每个测试方法之前运行
     */
    @BeforeMethod
    public void bfMethod() {
        System.out.println("@BeforeMethod function......");
    }

    /**
     * 注释方法将在每个测试方法之后运行
     */
    @AfterMethod
    public void afMethod() {
        System.out.println("@AfterMethod function......");
    }

}

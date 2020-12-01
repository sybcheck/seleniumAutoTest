package cn.ac.testcase;

import cn.ac.base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class ShinewayTest extends DriverBase {

    @Test
    public void test11() {

        driver.get("http://124.42.19.52/certmember/query/login");

        {
            driver.findElement(By.xpath("//input[@id='corpNameId']")).sendKeys("芜湖双汇进出口贸易有限责任公司");
            driver.findElement(By.xpath("//input[@name='email']")).sendKeys("3448617415@qq.com");
            driver.findElement(By.xpath("//input[@id='doLogin']")).click();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //获得所有的窗口句柄
            Set<String> windowHandles = driver.getWindowHandles();
            driver.close();
            driver.switchTo().window((String) windowHandles.toArray()[1]);
//        for (String windowHandle : windowHandles) {
//            if (!currentHandle.equals(windowHandle)) {
//                driver.switchTo().window(windowHandle);
//            }
//        }
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//input[@id='certNo']")).sendKeys("ES2920002949");
            driver.findElement(By.xpath("//input[@id='queryId']")).click();
            // driver.find_elements_by_xpath('//div[@id = "choose-color"]//div[@class = "dd"]//div[not(contains(@class, "disabled"))]')
            driver.findElement(By.xpath("//a[contains(text(),'点击查看')]")).click();
//            driver.findElement(By.xpath("//li[@class='clearfix']//label[2]//a")).click();
//            driver.findElement(By.xpath("//label[contains(text(),'证书编号')]//..//label[2]//a")).click();
            //抓取页面信息
            List<WebElement> list = driver.findElements(By.xpath("//label[@class='tl acc_four fl']"));
            for (WebElement webElement : list) {
                System.out.println(webElement.getText());
            }
            System.out.println("------");
            List<WebElement> trList = driver.findElements(By.xpath("//section[@class='acc_apply']//table//tr[2]//td"));
            for (WebElement webElement : trList) {
                System.out.println(webElement.getText());
            }

        }

    }
}

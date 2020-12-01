package cn.ac;

import cn.ac.base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class TestMain extends DriverBase {

    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        testMain.test();
    }

    //    @Test
    public void test() {
        driver.get("https://www.maersk.com.cn/tracking/#tracking/");
//        driver.get("https://www.baidu.com/");
//        String sText =  js.executeScript("return arguments[0].innerText;").toString();
//        System.out.println(driver.getPageSource());
        System.out.println("-----------------");
        driver.manage().window().setSize(new Dimension(1532, 815));
//        driver.findElement(By.id("trackShipmentSearch")).click();
        driver.findElement(By.id("trackShipmentSearch")).sendKeys("205655190");
        driver.findElement(By.xpath("//button[@class='coi-banner__accept']")).click();
        driver.findElement(By.xpath("//button[@class='button button--primary button--right']")).click();
        String result = driver.findElement(By.xpath("//*[@id=\"table_id\"]/tbody/tr/td[3]/span[4]")).getText();
        System.out.println("------" + result);//
    }
}

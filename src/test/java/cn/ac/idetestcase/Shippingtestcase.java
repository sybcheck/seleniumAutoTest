package cn.ac.idetestcase;

import cn.ac.base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Shippingtestcase extends DriverBase {
    @Test
    public void shippingtestcase() {
        try {
            LOGGER.info("执行谷歌船务网站测试用例");
            driver.get("https://moc.oocl.com/party/cargotracking/ct_search_from_other_domain.jsf?ANONYMOUS_BEHAVIOR=BUILD_UP&domainName=PARTY_DOMAIN&ENTRY_TYPE=OOCL&ENTRY=MCC&ctSearchType=BC&ctShipmentNumber=OOLU2635249080");
            {
                Thread.sleep(5000);

//            builder.clickAndHold(element);
//            builder.moveByOffset(300,0).perform();
                //滑动 滑块
                for (int i = 0; i < 5; i++) {
                    WebElement element = driver.findElement(By.id("nc_1_n1z"));
                    Actions builder = new Actions(driver);
                    builder.moveToElement(element).clickAndHold(element);
                    builder.dragAndDropBy(element, 300, 0).perform();
                    Thread.sleep(2000);
                    builder.release();
                    driver.findElement(By.xpath("//span[@class='nc-lang-cnt']/a")).click();
                }

//                JavascriptExecutor js = (JavascriptExecutor) driver;
//                js.executeScript("alert(00)");
//                js.executeScript("var dragBtn=$('#nc_1_n1z');" +
//                        "    dragBtn[0].addEventListener('mousedown', function(event) { " +
//                        "    var pointX = event.pageX;  " +
//                        "    function fnMove(event){" +
//                        "        var pointX1 = event.pageX; " +
//                        "    } " +
//                        "    function fnEnd(){ " +
//                        "    document.removeEventListener('mousemove', fnMove, false); " +
//                        "    document.removeEventListener('mouseup', fnEnd, false); " +
//                        "    } " +
//                        "    document.addEventListener('mousemove', fnMove, false);" +
//                        "    document.addEventListener('mouseup', fnEnd, false);" +
//                        "},false);");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

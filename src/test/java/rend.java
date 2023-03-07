import driver.Driver;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class rend {


    @Test(priority = 1)
    public void accesKweb() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();

        Driver.getDriver().get("https://rendezvouspasseport.ants.gouv.fr/");
        //input[@placeholder='code postal ou nom de la commune']
        Thread.sleep(2000);


        WebElement distance = Driver.getDriver().findElement(By.xpath("(//input[@class='ng-untouched ng-pristine ng-valid'])[3]"));
        executor.executeScript("arguments[0].click();", distance);

        WebElement commun = Driver.getDriver().findElement(By.xpath("//input[@placeholder='code postal ou nom de la commune']"));
        commun.sendKeys("78160");
        WebElement marly = Driver.getDriver().findElement(By.xpath("(//li[@class='item'])[1]"));
        Thread.sleep(1000);
        marly.click();
        WebElement search = Driver.getDriver().findElement(By.id("search-btn"));
        search.click();
        WebElement text1 = Driver.getDriver().findElement(By.xpath("//div[@class='fr-alert fr-alert--info fr-mt-3w ng-star-inserted']"));
        String text = text1.getText();
        if(text.contains("Aucun créneau")){
            commun.clear();
            commun.sendKeys("78550");
            Thread.sleep(1000);
            WebElement houdan = Driver.getDriver().findElement(By.xpath("(//div[@class='ng-star-inserted'])[1]"));
            houdan.click();
            search.click();
            if(!text.contains("Aucun créneau")) {
                Driver.getDriver().get("https://www.youtube.com/watch?v=Sw4YGCcWq9g");

            }
        } else {
            Driver.getDriver().get("https://www.youtube.com/watch?v=Sw4YGCcWq9g");
        }




    }

}

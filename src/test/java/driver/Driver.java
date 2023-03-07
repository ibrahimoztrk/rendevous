package driver;

import driver.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {


    private Driver() {
    }

    static WebDriver driver;

    public static WebDriver getDriver() {



        if (driver == null) {
            switch (ConfigurationReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static void closeDriver() {

        //   driver.quit();
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
    }





    public static double avoir(WebElement element) {

        //  Avoir : 239,00 €
        String text = element.getText();
        int deuxPoint = text.indexOf(":");
        int indexEuro = text.indexOf("€");
        String total2 = text.replace(",", "");
        String chiffre = total2.substring(deuxPoint+1,indexEuro-1);
        double a = Double.parseDouble(chiffre);

        return a/100;
    }


    public static double intConverteurSansEspece(WebElement element) {

        String str = element.getText();
        int b = str.length();
        String total2 = str.replace(",","");
        // String total3 = total2.substring(0,b-1);
        int a = Integer.parseInt(total2);


        return a/100;




    }







}
package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ariec on 19.07.2019.
 */
public  class MyWebDriverClass {

  private static WebDriver driver;
  private static WebDriverWait webDriverWait;
@Step("Старт окна")
    public static void StartingBrowse(String URLelem){
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        getDriver().get(URLelem);
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
    }
    public static WebDriver getDriver() {
        driver = new ChromeDriver();
        return driver;
    }

    public static WebElement ojidalkaMethod(WebElement element){
        WebElement elemenT=getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
      return elemenT;
    }
    public static void ZakrStranic(){
        for (String str:getDriver().getWindowHandles()) {
            getDriver().switchTo().window(str).close();
        }
    }


    public static WebDriverWait getWebDriverWait() {
        webDriverWait = new WebDriverWait(getDriver(),7, 300);
        return webDriverWait;
    }
    @Step("Переход на новую страницу")
    public static void perehodNaNovuyuStr(WebElement element){
        Set<String> oldElem = getDriver().getWindowHandles();
        element.click();
        Set<String> newElem = getDriver().getWindowHandles();
        newElem.removeAll(oldElem);
        getDriver().switchTo().window(newElem.iterator().next());
        getDriver().manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
    }
}

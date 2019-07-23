package pages.CORE;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


/**
 * Created by Ariec on 19.07.2019.
 */
public class BasePageClass {

    public BasePageClass(){
       PageFactory.initElements(MyWebDriverClass.getDriver(),this);
    }

    public void ClickableElement(WebElement element){
        MyWebDriverClass.ojidalkaMethod(element).click();
    }

    @Step("Экшен клике активен")
    public void zapTextPoley(WebElement element, String s){
        Actions actions = new Actions(MyWebDriverClass.getDriver());
        actions.moveToElement(element).click().perform();
        element.sendKeys(s);
    }

    @Step("Filling fields with some values")
    public void zapolnPoley(List<WebElement> arr, List<String> arrStr){
        for (int i = 0; i < arrStr.size(); i++) {
            zapTextPoley(arr.get(i),arrStr.get(i));
        }
    }

    @Step("Check field for values")
    public void poluchenieIzSravnenia(List<String> arrStr, List<WebElement> arrStrAct){
        for (int i = 0; i <arrStr.size() ; i++) {
            Assert.assertEquals(arrStrAct.get(i), arrStrAct.get(i).getAttribute("kakoe to znach"));
        }
    }
}

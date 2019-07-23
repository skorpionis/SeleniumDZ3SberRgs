package pages.SberBankPages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CORE.BasePageClass;

/**
 * Created by Ariec on 19.07.2019.
 */
public class MainSberPage extends BasePageClass{
    @FindBy(xpath = "//span[contains(text(),'Страхование')]")
    private WebElement glStr;
    @FindBy(xpath = "//span[contains(text(), 'Страхование')]/parent::*/following::*[contains(text(), 'Путешествия и покупки')][1]")
    private WebElement puteshestviya;
    @FindBy(xpath = "//*[@id=\"main\"]/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div[1]/div/div/div/" +
            "div[1]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/p/a")
    private WebElement onlinePurchase;
    @FindBy(xpath = "//*[contains(text(),'Страхование путешественников')]")
    private WebElement  checkStrah;


    @Step("Первый шаг- страхование")
    public void GlStr(){
        ClickableElement(glStr);
    }

    @Step("Второй шаг - Путешествия")
    public void Puteshestviya(){
        ClickableElement(puteshestviya);
    }
    @Step("Третий шаг доп- Проверка")
    public void CheckStrah(){
        Assert.assertEquals("\n Отсутствует поле с ",
                "Страхование путешественников",checkStrah.getText());
    }

    public void OnlinePurchase(){
        ClickableElement(onlinePurchase);
    }

    @Step("Четвертый шаг - Оформить онлайн")
    public  WebElement OnlineClick(){
        return onlinePurchase;
    }
}

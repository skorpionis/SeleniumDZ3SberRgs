package pages.SberBankPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePageClass;

/**
 * Created by Ariec on 19.07.2019.
 */
public class PolisPageAgreement extends BasePageClass{

    @FindBy(xpath = "//div[contains(text(), 'Достаточная')]")
    private WebElement enoughBtn;

    @FindBy(xpath = "//span[@ng-click='save()'][text()='Оформить']")
    private WebElement acceptBtn;

    @Step("Пятый шаг - достаточно")
    public void EnughBtn(){
        ClickableElement(enoughBtn);
    }
    @Step("Шестой шаг - клик по кнопке оформить")
    public void AcceptBtn(){
        ClickableElement(acceptBtn);
    }

}

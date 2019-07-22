package pages.RosGosStrahPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePageClass;

/**
 * Created by Ariec on 21.07.2019.
 */
public class MainRgsPage extends BasePageClass {
    @FindBy(xpath = "//*[contains(text(), 'Страхование')]")
    private WebElement strahovanie;

    /*@FindBy(xpath = "//div[contains(@id," +
            " 'main-navbar-collapse')]//li[contains(@class, " +
            "'dropdown')]/a[contains(text(), 'Страхование')]")
    private WebElement strahovanie;*/

    @FindBy(xpath = "//*[contains(text(), 'ДМС')]")
    private WebElement dms;
    /* @FindBy(xpath = "//a[contains(text(), " + "'ДМС') and not (contains(text(), 'Полис'))]")
    private WebElement dms;*/

    @Step("Нажать - страхование")
    public void Strahovanie(){
        ClickableElement(strahovanie);
    }
    @Step("Нажать - ДМС ")
    public void DMS(){
        ClickableElement(dms);
    }
}

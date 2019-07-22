package pages.RosGosStrahPages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePageClass;

/**
 * Created by Ariec on 21.07.2019.
 */
public class ReqDmsPage extends BasePageClass{

    @FindBy(xpath = "//h1[contains(text(),'добровольное медицинское страхование')]")
    private WebElement checkDMSSentence;

    @FindBy(xpath = "//a[contains(text(), 'Отправить заявку')]")
    private WebElement otprZayavku;

    @Step("Чек заголова - ДМС")
    public void AssertCheckDMSSentence(){
        String str = "ДМС " + "\u2014" +" добровольное медицинское страхование";
        Assert.assertEquals("ДМС —"  +" добровольное медицинское страхование", CheckDMSSentence());
    }
    @Step("Отправить заявку")
    public void OtprZayavku(){
        ClickableElement(otprZayavku);
    }

    public WebElement CheckDMSSentence(){
        return checkDMSSentence;
    }

}

package pages.RosGosStrahPages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePageClass;
import pages.MyWebDriverClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ariec on 19.07.2019.
 */
public class DMSFormPage extends BasePageClass {
    public List<WebElement> neobhElem(){
        List<WebElement> arrWebElem = new ArrayList<WebElement>();
        arrWebElem.add(name);
        arrWebElem.add(surname);
        arrWebElem.add(middlename);
        arrWebElem.add(phonenumner);
        arrWebElem.add(mail);
        arrWebElem.add(data);
        arrWebElem.add(commentarii);
        return arrWebElem;
    }
    public List<String> startZnach(){
        List<String> arrStrElem = new ArrayList<String>();
        arrStrElem.add("Петр");
        arrStrElem.add("Петров");
        arrStrElem.add("Петрович");
        arrStrElem.add("2222222222");
        arrStrElem.add("1234@mail.ru");
        arrStrElem.add("01.01.2000");
        arrStrElem.add("03.03.1993");
        arrStrElem.add("1Комм");
        return arrStrElem;
    }

    @FindBy(xpath = "//*[@class='modal-content']")
    private WebElement formaZayavki;
    @FindBy(xpath = "//b[@data-bind='text: options.title'][text()='Заявка на добровольное медицинское страхование']")
    private WebElement proverkaShapki;
    @FindBy(xpath = "(//input[@class='form-control validation-control-has-error'])[2]")
    private WebElement name;
    @FindBy(xpath = "//input[@class='form-control validation-control-has-success']")
    private WebElement surname;
    @FindBy(xpath = "//input[@class='form-control validation-control-has-success']")
    private WebElement middlename;
    @FindBy(xpath = "(//input[@type='text'])[6]")
    private WebElement phonenumner;
    @FindBy(xpath = "//*[text()= 'Предпочитаемая дата контакта']/following::input[1]")
    private WebElement data;
    @FindBy(xpath = "(//input[@class='form-control validation-control-has-success']")
    private WebElement mail;
    @FindBy(xpath = "//*[@name='Comment']")
    private WebElement commentarii;
    @FindBy(xpath = "//input[@class='checkbox']")
    private WebElement acceptFlag;
    @FindBy(xpath = "//button[@id='button-m']")
    private WebElement saveBtn;
    @FindBy(xpath = "//span[@class='validation-error-text'][text()='Введите адрес электронной почты']")
    private WebElement incorrectMailError;
    @FindBy(xpath = "//select[@name='Region']")
    private List<WebElement> regions;

    public WebElement ProverkaShapki(){
        return proverkaShapki;
    }

    @Step("Incorrect email")
    public void IncorrectMailError(){
        Assert.assertEquals("Чек эл.почты", "Введите адрес электронной почты", incorrectMailError);
    }
    @Step("Send!!")
    public void SaveBtn(){
        saveBtn.click();
    }
    @Step("Checking str for value: Заявка на добровольное медицинское страхование")
    public void ProverkaShapkiSravnenie(){
        Assert.assertEquals("Проверка на наличие текста",
                "Заявка на добровольное медицинское страхование",proverkaShapki.getText());

    }
    public void AcceptFlag(){
        acceptFlag.click();
    }
    public List<WebElement> Regions(){
        return regions;
    }
    public void Mail(String s){
        Actions actions = new Actions(MyWebDriverClass.getDriver());
        actions.moveToElement(mail).click().perform();
        mail.sendKeys(s);
    }











}

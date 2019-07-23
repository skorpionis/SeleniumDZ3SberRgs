package pages.SberBankPages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CORE.BasePageClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ariec on 19.07.2019.
 */
public class PersonalityPage extends BasePageClass{

    public List<String> testStartValues(){
            List<String> arr = new ArrayList<String>();
            arr.add("Петров");
            arr.add("Петр");
            arr.add("01.01.1993");
            arr.add("Петровв");
            arr.add("Петрр");
            arr.add("Петрович");
            arr.add("03.03.1993");
            arr.add("2222");
            arr.add("222222");
            arr.add("20.12.2011");
            return arr;
    }


    @FindBy(xpath = "//input[@name='insured0_surname']")
    private WebElement inNSurname;
    @FindBy(xpath = "//input[@name='insured0_name']")
    private WebElement inName;
    @FindBy(xpath = "//input[@id='dp1563542308428']")
    private WebElement inData;
    @FindBy(xpath = "//input[@name='surname']")
    private WebElement surname;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement name;
    @FindBy(xpath = "//input[@name='middlename']")
    private WebElement middleName;
    @FindBy(xpath = "//input[@id='dp1563542308426']")
    private WebElement data;
    @FindBy(xpath = "//input[@ng-model='formdata.insurer.documentList[0].DOCSERIES']")
    private WebElement passportSeries;
    @FindBy(xpath = "//input[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']")
    private WebElement passportNumber;
    @FindBy(xpath = "//*[contains(text(), 'Дата выдачи')]")
    private WebElement passportData;
    @FindBy(xpath = "//textarea[@name='issuePlace']")
    private WebElement passportIssue;
    @FindBy(xpath = "//span[@ng-click='save()'][text()='Продолжить']")
    private WebElement saveBtn;
    @FindBy(xpath = "//div[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")
    private WebElement errorTextField;

    public List<WebElement> arrElemN(){
        List<WebElement> arrElem = new ArrayList<>();
        arrElem.add(inNSurname);
        arrElem.add(inName);
        arrElem.add(inData);
        arrElem.add(surname);
        arrElem.add(name);
        arrElem.add(middleName);
        arrElem.add(data);
        arrElem.add(passportSeries);
        arrElem.add(passportNumber);
        arrElem.add(passportData);
        arrElem.add(passportIssue);
        return arrElem;
    }

    public WebElement InNSurname(){
        return inNSurname;
    }
    public WebElement InName(){
        return inName ;
    }
    public WebElement InData(){
        return inData;
    }
    public WebElement Surname(){
        return surname;
    }
    public WebElement Name(){
        return name ;
    }
    public WebElement MiddleName(){
        return  middleName;
    }
    public WebElement Data(){
        return data ;
    }
    public WebElement  PassportSeries(){
        return  passportSeries;
    }
    public WebElement PassportNumber(){
        return  passportNumber;
    }
    public WebElement PassportData(){
        return  passportData;
    }
    public WebElement PassportIssue(){
        return  passportIssue;
    }
    public WebElement ErrorTextField(){
        return errorTextField;
    }


    @Step("Проверка на заполнение полей необходимых")
    public void sravnZnachPol(){
        Assert.assertEquals("\n Error","Заполнены не все обязательные поля", ErrorTextField().getText());
    }
    @Step("Первый шаг - отправить кнопка")
    public WebElement ClickSaveBtn(){
        return saveBtn;
    }
    @Step("Первый шаг - продолжить кнопка")
    public void SaveBtn(){
        ClickableElement(ClickSaveBtn());
    }


}

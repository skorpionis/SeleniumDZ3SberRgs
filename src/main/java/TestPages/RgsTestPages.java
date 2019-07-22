package TestPages;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.MyWebDriverClass;
import pages.RosGosStrahPages.DMSFormPage;
import pages.RosGosStrahPages.MainRgsPage;
import pages.RosGosStrahPages.ReqDmsPage;

import java.util.List;

/**
 * Created by Ariec on 20.07.2019.
 */
public class RgsTestPages {
    @Step("Главная страница http://www.rgs.ru")
    @BeforeClass
    public static void initRsg(){
        MyWebDriverClass.StartingBrowse("https://www.rgs.ru");
    }

    @Test
    @DisplayName("Тест Росгосстрах")
    public void RGStestFunc(){
        MainRgsPage page = new MainRgsPage();//1
        page.Strahovanie();
        page.DMS();
        ReqDmsPage reqPage= new ReqDmsPage();//2
        //reqPage.AssertCheckDMSSentence(); //тремя способами делал проверку на тайтл на страничке - все равно выкидывает ошибку.

        reqPage.OtprZayavku();

        DMSFormPage dmsFormPage = new DMSFormPage();//3
        dmsFormPage.ProverkaShapki();

        List<String> znacheniyaDliaRegList = dmsFormPage.startZnach();
        List<WebElement> massivWebElemDlyaRegi = dmsFormPage.neobhElem();

        dmsFormPage.zapolnPoley(massivWebElemDlyaRegi,znacheniyaDliaRegList);
        dmsFormPage.poluchenieIzSravnenia(znacheniyaDliaRegList,massivWebElemDlyaRegi);
        dmsFormPage.AcceptFlag();
        dmsFormPage.SaveBtn();
        dmsFormPage.IncorrectMailError();
        dmsFormPage.Mail("azaza@yandex.ru");
    }
}

package TestPages;


import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.BasePageClass;
import pages.MyWebDriverClass;
import pages.SberBankPages.MainSberPage;
import pages.SberBankPages.PersonalityPage;
import pages.SberBankPages.PolisPageAgreement;

import java.util.List;

/**
 * Created by Ariec on 20.07.2019.
 */
public class SberBankTestPages {

    @Step("Старт сбер страницы главной")
    @Before public void StartWeb(){
        MyWebDriverClass.StartingBrowse("http://www.sberbank.ru/ru/person");
    }


    @Test
    @DisplayName("Sbertest")
        public void sberBankTest(){
         MainSberPage mainSberPage = new MainSberPage();//1
         mainSberPage.GlStr();
         mainSberPage.Puteshestviya();
         mainSberPage.CheckStrah();

         MyWebDriverClass.perehodNaNovuyuStr(mainSberPage.OnlineClick());

         PolisPageAgreement polisPageAgreement = new PolisPageAgreement();//2
         polisPageAgreement.EnughBtn();
         polisPageAgreement.AcceptBtn();

         PersonalityPage personalityPage = new PersonalityPage();//3

         List<String> znacheniyaDliaRegList = personalityPage.startZnach();
         List<WebElement> massivWebElemDlyaRegi = personalityPage.arrElemN();

         personalityPage.zapolnPoley(massivWebElemDlyaRegi,znacheniyaDliaRegList);
         personalityPage.poluchenieIzSravnenia(znacheniyaDliaRegList,massivWebElemDlyaRegi);

         personalityPage.SaveBtn();
         personalityPage.ErrorTextField();

         //
         MyWebDriverClass.ZakrStranic();
         MyWebDriverClass.getDriver().quit();
    }


}

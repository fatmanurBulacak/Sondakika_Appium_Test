package com.sahabt.AppiumTest;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


//implementsle path interfaceten kalıtım alınıyor
public class Sondakika_Anasayfa  extends Base_Sondakika implements Path{
    //extend etmek için super driver yazmak gerekiyor.
    public Sondakika_Anasayfa(AndroidDriver<MobileElement> driver){super(driver);}


    public void sondakikaAnasayfa(){
        swipeDown();

        sleep(3);
        haberTiklama(haberTiklamaXpath);

        swipeDown();
        sleep(3);

        swipeUp();
        sleep(3);

        turnBackButtonClick(btnBackXpath);

        swipeRight();
        sleep(2);

        swipeRight();
        sleep(2);

        swipeLeft();
        sleep(2);

        sonHaberler(txtDigerhaberlerPath);
        sleep(2);

       //sonHaberlerEnAlt();
        // sleep(2);

    }


}

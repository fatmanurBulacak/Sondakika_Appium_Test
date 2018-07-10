package com.sahabt.AppiumTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.offset.PointOption.point;

//Temel metotlarımız burada yer alır
public class Base_Sondakika {


    protected AndroidDriver<MobileElement> driver;

    public Base_Sondakika(AndroidDriver<MobileElement> driver){this.driver=driver;}



    public void sleep(int waitTime){
        try {
            Thread.sleep(waitTime*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public void haberTiklama(String haberTiklamaXpath){
        WebDriverWait wait= new WebDriverWait(driver, 20);
        //Tıklanacak haberi 20 saniye aramak için bekleyecek

        List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(haberTiklamaXpath)));
        list.get(0).click();

    }

    //Aşağı kaydırma metodu
    public void swipeDown(){

        Dimension dimension = driver.manage().window().getSize();
        int height = dimension.height;
        int width = dimension.width;
        int swipeStartWidth=(width*50)/100;
        int swipeEndWidth = (width*50)/100;
        int swipeStartHeight= (height*3)/4;
        int swipeEndHeight=height/4;

        new TouchAction<>(driver).press(point(swipeStartWidth,swipeStartHeight))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(point(swipeEndWidth,swipeEndHeight)).release().perform();


    }

    //Yukarı kaydırma metodu
    public void swipeUp(){

        Dimension dimension = driver.manage().window().getSize();
        int height = dimension.height;
        int width = dimension.width;
        int swipeStartWidth=(width*50)/100;
        int swipeEndWidth = (width*50)/100;
        int swipeStartHeight= height/4;
        int swipeEndHeight=(height*3)/4;

        new TouchAction<>(driver).press(point(swipeStartWidth,swipeStartHeight))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(point(swipeEndWidth,swipeEndHeight)).release().perform();


    }


    //Sağa kaydırma metodu
    public void swipeRight(){

        Dimension dimension = driver.manage().window().getSize();
        int height = dimension.height;
        int width = dimension.width;
        int swipeStartWidth=(width*90)/100;
        int swipeEndWidth = (width*10)/100;
        int swipeStartHeight= (height*50)/100;
        int swipeEndHeight=height/2;

        new TouchAction<>(driver).press(point(swipeStartWidth,swipeStartHeight))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(point(swipeEndWidth,swipeEndHeight)).release().perform();


    }

    //Sola kaydırma metodu
    public void swipeLeft(){

        Dimension dimension = driver.manage().window().getSize();
        int height = dimension.height;
        int width = dimension.width;
        int swipeStartWidth=(width*10)/100;
        int swipeEndWidth = (width*90)/100;
        int swipeStartHeight= (height*50)/100;
        int swipeEndHeight=height/2;

        new TouchAction<>(driver).press(point(swipeStartWidth,swipeStartHeight))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(point(swipeEndWidth,swipeEndHeight)).release().perform();


    }

    public void turnBackButtonClick(String btnBackXpath){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnBackXpath))).click();


    }

/*
    public void sonHaberlerEnAlt(){


        while (true){


            //By.xpath("//android.widget.TextView[@text='Diğer Haberler']")) burada android.widget.TextView yerine tüm yollarda aramak için * konulabilir
            Boolean sonhaberler = driver.findElements(By.xpath("//android.widget.TextView[@text='Diğer Haberler']")).size()>0;

            if(sonhaberler){

                swipeDown();


            whileFlop();


                break;
            }

            swipeDown();

        }




    }

    public void whileFlop(){


        String strBirinci = "test1 ";
        String strIkinci="test2 ";

        WebDriverWait wait= new WebDriverWait(driver,20);

        while (true) {
            List<WebElement> sonhaberList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@resource-id='app.ym.sondakika:id/viewText']")));

        strIkinci=returnString(sonhaberList);
        if(strBirinci.equals(strIkinci)){
            break;

        }

        strBirinci=strIkinci;

        swipeDown();

        }

    }


    public String returnString(List<WebElement> sonhaberlerList){

        String string = null;
        int a = sonhaberlerList.size()-1;

        string=sonhaberlerList.get(a).getText();
        System.out.println(string);

        return string;


    }


    */

    public void sonHaberler(String txtDigerhaberlerPath){

        WebDriverWait wait= new WebDriverWait(driver,20);
        while (true){


            //By.xpath("//android.widget.TextView[@text='Diğer Haberler']")) burada android.widget.TextView yerine tüm yollarda aramak için * konulabilir
            Boolean sonhaberler = driver.findElements(By.xpath(txtDigerhaberlerPath)).size()>0;

            if(sonhaberler){
                List<WebElement> sonhaberList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@resource-id='app.ym.sondakika:id/viewText']")));


                swipeDown();
                sleep(2);
                sonhaberList.get(0).click();
                break;
            }

            swipeDown();

        }




    }


}

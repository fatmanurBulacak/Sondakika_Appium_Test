package com.sahabt.AppiumTest;

import org.junit.Test;

public class SondakikaTest_Anasayfa  extends BaseTest{


    @Test

    public void TestHaberTiklama(){

        new Sondakika_Anasayfa(driver).sondakikaAnasayfa();

    }

}

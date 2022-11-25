package com.ebebek.step_definitions;

import com.ebebek.pages.HomePage;
import com.ebebek.utils.ConfigurationReader;
import com.ebebek.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EBebekTestDefinitions {

    HomePage homePage = new HomePage();
    String ilkUrunAdı;
    String ilkUrununSepettekiAdı;

    @Given(": Kullanıcı ana sayfada")
    public void kullanıcı_ana_sayfada() {

        Driver.getDriver().get(ConfigurationReader.getProperty("ebebek.url"));

    }

    @When("Arama çubuğuna {string} yazılır ve arama yapılır")
    public void arama_çubuğuna_yazılır_ve_arama_yapılır(String item) {


       homePage.aramaCubugu.sendKeys(item );

    }

    @When("İlk ürüne tıklanır")
    public void i̇lk_ürüne_tıklanır() {


       homePage.ilkUrun.click();

       ilkUrunAdı = homePage.ilkUrununAdı.getText();

    }

    @When("Sepete Ekle butonuna tıklanır")
    public void sepete_ekle_butonuna_tıklanır() {

        homePage.ilkUrunSepeteEkleButonu.click();

    }

    @When("Sepeti Gör butonuna tıklanır")
    public void sepeti_gör_butonuna_tıklanır() {

        homePage.ilkUrunSepetiGorButonu.click();

    }


    @Then("Ürünün sepete eklendiği kontrol edilir")
    public void ürünün_sepete_eklendiği_kontrol_edilir() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.visibilityOf(homePage.ilkUrunSepettekiAdi));

        ilkUrununSepettekiAdı= homePage.ilkUrunSepettekiAdi.getText();

        System.out.println(ilkUrunAdı);
        System.out.println(ilkUrununSepettekiAdı);

        String beklenenSepet = "Sepetim (1)";
        String gercekSepet = homePage.sepetim.getText();

        Assert.assertTrue(ilkUrunAdı.equals(ilkUrununSepettekiAdı));

        Assert.assertTrue(beklenenSepet.equals(gercekSepet));

    }




}

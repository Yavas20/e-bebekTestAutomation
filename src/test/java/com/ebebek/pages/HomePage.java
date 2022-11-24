package com.ebebek.pages;

import com.ebebek.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "txtSearchBox")
    public WebElement aramaCubugu;

    @FindBy(xpath = "(//a[@class='has-media'])[1]")
    public WebElement ilkUrun;

    @FindBy(xpath = "(//b[@id='txtProductTitle'])[2]")
    public WebElement ilkUrununAdı;

    @FindBy(xpath = "(//button[@id='addToCartBtn'])[1]")
    public WebElement ilkUrunSepeteEkleButonu;

    @FindBy(id = "btnShowCart")
    public WebElement ilkUrunSepetiGorButonu;

    @FindBy(xpath = "(//h2)[1]")
    public WebElement ilkUrunSepettekiAdi;

    @FindBy(xpath = "//h1")
    public WebElement sepetim;




}

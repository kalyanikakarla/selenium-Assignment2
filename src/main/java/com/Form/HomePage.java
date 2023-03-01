package com.Form;

import Actions.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;
    public SeleniumActions actions;
    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver=driver;
        actions=new SeleniumActions(driver);

    }
    @FindBy(xpath ="//li[@class='rootdropdownmenuitem']/a[text()='Contact']")
    WebElement contactLink;

    /**
     * click on contact link
     * switch to frame1
     */
    public void clickOnContact()
    {

        actions.clickOnElement(contactLink);
        WebElement frame1 = driver.findElement(By.xpath("//div[@id='contactus']/descendant::iframe"));
        driver.switchTo().frame(frame1);
        System.out.println("switching frame ");
    }


}

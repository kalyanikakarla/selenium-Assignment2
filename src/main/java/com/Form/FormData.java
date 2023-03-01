package com.Form;

import Actions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormData {
    public WebDriver driver;
    public SeleniumActions actions;
    public FormData(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= this.driver;
        actions=new SeleniumActions(driver);

    }
    @FindBy(name = "name")
    WebElement nameInputBox;
    @FindBy(name = "email")
    WebElement emailInputBox;
    @FindBy(name = "message")
    WebElement messageInputBox;
    @FindBy(xpath="//div[@role='checkbox']")
    WebElement checkBox;
    @FindBy(xpath = "//div[@id='sendmainButton']//div//div//div//div//div[@tabindex='0']")
    WebElement sendButton;
    @FindBy(xpath="//div[@class='SuccessMessage']")
    WebElement sucssesMessage;

    /**
     * pass values to text fields
     */

    public void data()
    {
        actions.enterValue(nameInputBox,"Kalyani");
        actions.enterValue(emailInputBox,"kakarlakalyani123@gmail.com");
        actions.enterValue(messageInputBox,"file added");
    }

    /**
     * clicking on check box
     * clicking on sendButton
     */
    public void sendButtonClicking()
    {
        actions.clickOnElement(checkBox);
        actions.clickOnElement(sendButton);

    }

    /**
     * return the succesfull message
     * @return
     */
    public String verifyingMessage()
    {
        return sucssesMessage.getText();
    }



}

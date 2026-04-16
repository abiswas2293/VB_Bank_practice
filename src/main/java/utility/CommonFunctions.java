package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CommonFunctions extends Baseclass{

    public void click(By by){
        driver.findElement(by).click();
    }

    public void typeText(By by,String text){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public void dropDown(By by,String text){
        WebElement e=driver.findElement(by);
        Select select=new Select(e);
        select.selectByVisibleText(text);
    }
    public void enter(By by){
        WebElement e=driver.findElement(by);
        Actions actions=new Actions(driver);
        actions.click(e).perform();
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
    public String getUrl(){
       return driver.getCurrentUrl();
    }
    public String getText(By by){
       return  driver.findElement(by).getText();
    }
    public void assertion(String actualText,String expectedText){
        Assert.assertEquals(actualText,expectedText);
    }


}

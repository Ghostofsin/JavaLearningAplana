package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class SubPage {


    @FindBy (xpath = "(//P[@class='kit-button kit-button_color_green kit-button_size_m'])[1]")
    public  WebElement sendBut;

    @FindBy(xpath = "//H3[text()='Страхование путешественников']")
    public WebElement title;

    public SubPage(WebDriver driver){

        PageFactory.initElements(driver, this);

        Wait<WebDriver> wait = new WebDriverWait(driver, 5,2000);
        wait.until(ExpectedConditions.visibilityOf(sendBut));
        wait.until(ExpectedConditions.visibilityOf(title));

        //***********************************************************************************************
        // получаем набор дескрипторов текущих открытых окон
        final Set<String> oldWindowsSet = driver.getWindowHandles();

// нажимаем на ссылку, которая открывает документ в новом окне
        driver.findElement(By.xpath("(//P[@class='kit-button kit-button_color_green kit-button_size_m'])[1]")).click();

// ожидаем открытия и получаем дескриптор нового окна
        String newWindow = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set <String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );
        //****
        driver.switchTo().window(newWindow);
      //  ************************************************************************************************************/



    }



}

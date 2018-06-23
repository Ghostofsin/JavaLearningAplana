package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManePage {

    @FindBy(xpath = "//DIV[@class='kit-col kit-col_xs_10 lg-menu__col']//UL[@class='lg-menu__list']")
    WebElement maneMenuItem;
    @FindBy (xpath = "//DIV[@class='kit-col kit-col_xs_10 lg-menu__col']//UL[@class='lg-menu__list']")
    WebElement subMenuItem;


    public ManePage (WebDriver driver){

        PageFactory.initElements(driver, this);

   }

   public  void selManeMenu (String menuItem){
       maneMenuItem.findElement(By.xpath(".//LI[@class='lg-menu__item']//SPAN//SPAN[@class='lg-menu__text'][text()='" + menuItem +"']")).click();
    }

    public void selSubMenu (String menuItem){
        subMenuItem.findElement(By.xpath("./*//A[text()='"+ menuItem +"']")).click();
    }


}

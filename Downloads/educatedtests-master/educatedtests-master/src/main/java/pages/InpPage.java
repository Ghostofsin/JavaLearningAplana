package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InpPage {


    @FindBy(xpath = "//DIV[@class='b-form-box-title ng-binding'][text()='Минимальная']")
    public WebElement sum;
    @FindBy(xpath = "//SPAN[@ng-click='save()'][text()='Оформить']")
    public  WebElement send;
    @FindBy(xpath = "//INPUT[@name='insured0_name']")
    public WebElement name1;
    @FindBy(xpath = "//INPUT[@name='insured0_surname']")
    public  WebElement sname1;
    @FindBy(xpath = "//INPUT[@name='insured0_birthDate']")
    public   WebElement cdate1;
    @FindBy(xpath = "//INPUT[@name='name']")
    public    WebElement name;
    @FindBy(xpath = "//INPUT[@name='surname']")
    public   WebElement sname;
    @FindBy(xpath = "//INPUT[@name='middlename']")
    public   WebElement mname;
    @FindBy(xpath = "//INPUT[@name='birthDate']")
    public   WebElement cdate;

    @FindBy(xpath = "(//INPUT[@ng-model='formdata.insurer.GENDER'])[1]")
    public    WebElement gendr;
    @FindBy(xpath = "//INPUT[@ng-model='formdata.insurer.documentList[0].DOCSERIES']")
    public    WebElement seria;
    @FindBy(xpath = "//INPUT[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']")
    public   WebElement numb;
    @FindBy(xpath = "//INPUT[@name='issueDate']")
    public   WebElement issdate;
    @FindBy(xpath = "//SPAN[contains(text(),'Продолжить')]")
    public WebElement contbut;


    public InpPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(sum));
        wait.until(ExpectedConditions.visibilityOf(send));

    }

    public void setsum(WebElement sum) {
        sum.click();
        }

    public void setsend(WebElement send) {
        send.click();
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName){
            case "Фамилия анг":
                fillField(sname1, value);
                break;
            case "Имя анг":
                fillField(name1, value);
                break;
            case "Дата рожд анг":
                fillField(cdate1, value);
                break;
            case "Фамилия":
                fillField(sname, value);
                break;
            case "Имя":
                fillField(name, value);
                break;
            case "Отчество":
                fillField(mname, value);
                break;
            case "Дата рождения":
                 fillField(cdate, value);
                 break;
            case "Серия паспорта":
                fillField(seria, value);
                break;
            case "Номер паспорта":
                fillField(numb, value);
                break;
            case "Дата выдачи":
                fillField(issdate, value);
                break;

        default:
        throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
    }
    }

  /*  public String getFillField(String fieldName) {
        switch (fieldName) {

            case "Фамилия":
                return sname.getAttribute("value");
            case "Имя":
                return name.getAttribute("value");
            case "Отчество":
                return mname.getAttribute("value");

        }
        throw new AssertionError("Поле не объявлено на странице");
    }

 /*   public void checkFieldData(String field, String value) {
        Assert.assertEquals(value, getFillField(field));

    }*/

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

}
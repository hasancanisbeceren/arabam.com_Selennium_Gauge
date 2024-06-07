import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class Methods extends BaseTest {
    public static String text = "";


    public WebElement findElement(String key) {
        try {
            Duration waitDuration = Duration.ofSeconds(5);
            WebDriverWait wait = new WebDriverWait(driver, waitDuration);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(key)));
            return element;

        } catch (Exception ex) {
            Assertions.fail("" + key + "'li element 10 saniye boyunca arandı fakat bulunamadı..!!!");
            return null;
        }
    }
    public List<WebElement> findElements(String key){
        try {
            Duration waitDuration = Duration.ofSeconds(30);
            WebDriverWait waitForFormLabel = new WebDriverWait(driver, waitDuration);
            List<WebElement> elements = driver.findElements(By.xpath(key));
            waitForFormLabel.until(ExpectedConditions.visibilityOfAllElements(elements));
            return elements;
        } catch (Exception ex){
            Assertions.fail(" " + key + "'li element 10 saniye boyunca arandı fakat bulunamadı...!!!!");
            return null;
        }
    }
    public void clickToElement(WebElement element) {

        scrollToElement(element);
        element.click();
        waitByMilliSeconds(1000);
    }
    public String saveStaticString(WebElement element){
        scrollToElement(element);
        text = element.getText();
        System.out.println("Elementin text değeri: "+text);
        return text;
    }

    public void sendKeysToElement(WebElement element, String text) {

        scrollToElement(element);
        element.sendKeys(text);
    }
    public void getTextControl(WebElement element, String key){
        System.out.println("Girilen Text Degeri: "+key);
        Assertions.assertEquals(key,getTextElement(element),"Element girilen texti içermiyor..!!!");
        System.out.println("Girilen değer ile Elementin texti uyusuyor..");
    }


    public void getAttributeControl(WebElement element, String key) {
        System.out.println("Girilen Text Degeri: "+key);
       Assertions.assertTrue(getAttributeElement(element).contains(key), "Element girilen texti içermiyor..!!!");
        System.out.println("Girilen değer ile Elementin texti uyusuyor..");

    }

    public void textControl(WebElement element) {

        Assertions.assertTrue(getTextElement(element).contains(text), "Element texti kaydedilen değer ile uyusmuyor..!!!");
        System.out.println("XPATH'li Elementin Gorundugunun Kontrolu Basarili.....");
    }

    public String getTextElement(WebElement element){
        scrollToElement(element);
        waitByMilliSeconds(500);
        String elemaninTexti = "";
        elemaninTexti = element.getText();
        System.out.println("Elementin Text değeri: "+ elemaninTexti);
        return elemaninTexti;
    }
    public String getAttributeElement(WebElement element){
        scrollToElement(element);
        waitByMilliSeconds(500);
        String elemaninAttribute = "";
        elemaninAttribute = element.getAttribute("class");
        System.out.println("Elementin Attribute değeri: " + elemaninAttribute);
        return elemaninAttribute;
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center', inline:'center'})",element);

    }
    public void keysEnterToElement(WebElement element, String text) {

        scrollToElement(element);
        element.sendKeys(text, Keys.ENTER);
        waitByMilliSeconds(500);
    }

    public int randomInt(){
        Random r = new Random();
        int low = 1;
        int high = 20;
        int result = r.nextInt(high-low)+low;
        System.out.println(result + (result+1)+ ". Elemente tıklandı...");
        return result;
    }
    public void waitByMilliSeconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

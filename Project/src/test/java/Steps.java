import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import static java.lang.Thread.sleep;

public class Steps extends Methods {



    @Step("<link> linkine gidilir")
    public void link(String link) {
        driver.get(link);
    }

    @Step("<xpath> xpath'li elemente tiklanir")
    public void clickElement(String xpath) {
        WebElement element = findElement(xpath);
        clickToElement(element);
        System.out.println(" Tiklanilan  " + driver.getTitle());
    }
    @Step("<xpath> liste içindeki random elemente tiklanir")
    public void randomClick(String xpath) {
        List<WebElement> elements = findElements(xpath);
        clickToElement(elements.get(randomInt()));
    }

    @Step("<xpath> li elementin varliği kontrol edilir")
    public void textControlTest(String xpath) {
        WebElement element = findElement(xpath);
        textControl(element);
    }
    @Step("<xpath> ' li elemente <text> yazilir")
    public void sendKeysToElementTest(String xpath, String text) {
        WebElement element = findElement(xpath);
        sendKeysToElement(element, text);
    }

    //istenirse tek bir method içindede adim gerçeklestirilebilir
    public void clickByXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        waitByMilliSeconds(800);
        element.click();
    }

    @Step("<xpath> listesinde bulunan <index> .siradaki elemana tiklanir")
    public void ifElementExistClick(String xpath, int index) {
        waitByMilliSeconds(2);
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        if (elements.size() > 0) {
            clickToElement(elements.get(index));
        }
    }


        @Step("<xpath> li elementin texti ile <text> ile karsilastirilir")
        public void getTextControlTest (String key, String text){
            WebElement element = findElement(key);
            getTextControl(element, text);
            System.out.println(" Elementin Texti:  " + driver.getTitle());
        }

    @Step("<xpath> li elementin class degeri ile <text> karsilastirilir")
        public void getAttributeControlTest (String key, String text){
            WebElement element = findElement(key);
            getAttributeControl(element, text);
        }

        public void saveText (String key){
            WebElement element = findElement(key);
            saveStaticString(element);

        }

    @Step("<xpath> dropdown menude <index> tiklanir")
    public void dropdownSelected (String xpath, String index){
            Select se = new Select(driver.findElement(By.xpath(xpath)));
            se.selectByValue(index);
        }

        @Step("<xpath> li elemente <text> yazilip enter'e tiklanir")
        public void keysEnterToElementTest (String xpath, String text){
            WebElement element = findElement(xpath);
            keysEnterToElement(element, text);
        }

    @Step("<seconds> saniye beklenir")
    public void waitSeconds(int seconds) throws InterruptedException {
        Logger.info(" " + seconds + " Saniye Bekleniyor...");
        sleep(1000L * seconds);
    }
        public void changeControl() {
            if (driver.findElements(By.xpath("div[class='total-price-box']")).size() > 0)
            {
                textControlTest("div[class='total-price-box']"); // ürün fiyatini kontrol et
                dropdownSelected("select[class*='amount']","2");//
                waitByMilliSeconds(2000); // 2 saniye bekle
                getTextControlTest("select[class*='amount']", "100");
                getAttributeControlTest("select[class*='amount']", "2"); //ürün adeti 2 mi kontrol et..
                clickElement("i[class='gg-icon gg-icon-bin-medium']"); //ürünü kaldir butonuna bas
                waitByMilliSeconds(2000);
            }
        }

    }




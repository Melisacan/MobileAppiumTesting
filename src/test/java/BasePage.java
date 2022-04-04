import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.openqa.selenium.By.xpath;

public class BasePage extends BaseTest{



    private String xpath;
    public int s;


    Wait wait = new FluentWait(appiumDriver)
            .withTimeout(10, TimeUnit.SECONDS)
            .pollingEvery(250, TimeUnit.MILLISECONDS)
            .ignoring(NoSuchElementException.class)
            .ignoring(TimeoutException.class);

    @Step("<xpath> popup kabul et")
    public void popup(String xpath) throws InterruptedException {
        appiumDriver.findElement(By.xpath("")).click();
        BaseTest.appiumDriver.findElement(By.xpath(xpath)).click();

       Thread.sleep(3000);
    }
    @Step("<xpath> ile uygulamanın açıldığı kontrol edilir")
    public void Assert(String xpath){
       Assert.assertTrue(appiumDriver.findElement(By.xpath(xpath)).isDisplayed());

        MelLogger.logger.info("Uygulama başarılı bir şekilde açıldı");


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

    }

    @Step("Xpath <xpath> olan Alışverişe başla Butonuna tıkla")
    public void clickByAlisverisButonu(String xpath){
        Assert.assertTrue(appiumDriver.findElement(By.xpath(xpath)).click(););
    }

    @Step("<xpath> xpath'i ile alışveriş sayfasına girildiği doğrulanır")
    public void clickByAlisverisSayfasiDogrulanir(String xpath){
        Assert.assertTrue(BaseTest.appiumDriver.findElement(xpath(xpath)).isDisplayed());
        MelLogger.logger.info("Alışveriş sayfası açılır");
    }


    @Step("Xpath <xpath> kategorilere tıklanır")
    public void clickByxpathCategory(String xpath){
        Assert.assertTrue(appiumDriver.findElement(By.xpath(xpath)).click(););

    }

    @Step("<xpath> ile kategorilerin açıldığı doğrulanır")
    public void clickByCategoryControl(String xpath){
        Assert.assertTrue(BaseTest.appiumDriver.findElement(xpath(xpath)).isDisplayed());
        MelLogger.logger.info("Kategoriler sayfası başarıyla açıldı");

    }

    @Step("Xpath <xpath> kadın secenegine tıklanır")
    public void clickByxpathWomanOption(String xpath){
        Assert.assertTrue(appiumDriver.findElement(By.xpath(xpath)).click(););

    }

    @Step("Xpath <xpath> pantolon kategorisine tıklanır")
    public void clickByxpathPantolon(String xpath){
        BaseTest.appiumDriver.findElement(xpath(xpath)).click();
        Assert.assertTrue(appiumDriver.findElement(By.xpath(xpath)).click(););
    }

    @Step("Sayfayı aşağı doğru kaydır")

        public void swipeUp () {
        for(int i=0;i<2;i++) {
            final int ANIMATION_TIME = 200; // ms
            final int PRESS_TIME = 200; // ms
            int edgeBorder = 10; // better avoid edges
            PointOption pointOptionStart, pointOptionEnd;
            // init screen variables
            Dimension dims = BaseTest.appiumDriver.manage().window().getSize();
            System.out.println("Telefon Ekran Boyutu " + dims);
            // init start point = center of screen
            pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
            System.out.println("Başlangıç noktası " + pointOptionStart);
            pointOptionEnd = PointOption.point(dims.width / 2, dims.height / 4);
            System.out.println("Bitiş noktası " + pointOptionEnd);
            try {
                new TouchAction(BaseTest.appiumDriver)
                        .press(pointOptionStart)
                        // a bit more reliable when we add small wait
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                        .moveTo(pointOptionEnd)
                        .release().perform();
            } catch (Exception e) {
                System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
                return;
            }

            try {
                Thread.sleep(ANIMATION_TIME);
            } catch (InterruptedException e) {
            }
        }

    }

    @Step("Xpath rastgele ürün seçimi yapılır")
    public void selectRandom(){
        List<MobileElement> elements= (List<MobileElement>) BaseTest.appiumDriver.findElement(xpath("//*[@resource-id=\"com.ozdilek.ozdilekteyim:id/imageView\"]\n"));
        Random random= new Random();
        int randomInt=random.nextInt(elements.size());
        elements.get(randomInt).click();
        MelLogger.logger.info("Rastgele ürün seçimi yapıldı");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    @Step("<xpath> ürün detay sayfası kontrolü")
    public void AssertDetails(String xpath){
        Assert.assertTrue(appiumDriver.findElement(By.xpath(xpath)).isDisplayed());
        MelLogger.logger.info("Ürün detay sayfası açıldı");

    }

    @Step("<xpath> favoriler butonuna tıklanır")
    public void clickByFavButon(String xpath){
        Assert.assertTrue(appiumDriver.findElement(By.xpath(xpath)).click(););

    }

    @Step("<xpath> giris yapma sayfası açılır kontrolü")
    public void controlOfLoginPage(String xpath){
        Assert.assertTrue(appiumDriver.findElement(By.xpath(xpath)).isDisplayed());

    }

    @Step("Xpath <xpath> li textbox'a email adresi girilir")
    public void indexOfEmail(String xpath){
        Assert.assertTrue(appiumDriver.findElement(By.xpath(xpath)).sendKeys("melis.acan@testinium.com");

    }
    @Step("Xpath'i <xpath> olan textbox'a password girilir")
    public void indexOfPassword(String xpath){
        Assert.assertTrue(appiumDriver.findElement(By.xpath(xpath)).sendKeys("12345678");

    }

    @Step("<xpath> geri butonuna iki kere tıklanır")
    public void pressBackButton(String xpath){
        for(int k=0;k<2;k++){
            BaseTest.appiumDriver.findElement(By.xpath(xpath)).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    @Step("Geri geldikten sonra rastgele ürün seçimi yapılır")
    public void selectRandomAfterBack(){
        List<MobileElement> elements= (List<MobileElement>) BaseTest.appiumDriver.findElement(xpath("//*[@resource-id=\"com.ozdilek.ozdilekteyim:id/imageView\"]\n"));
        Random random= new Random();
        int randomInt=random.nextInt(elements.size());
        elements.get(randomInt).click();
        MelLogger.logger.info("Rastgele ürün seçimi yapıldı");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    @Step("<xpath> rastgele seçilen ürün sepete eklenir")
    public void addBasket(String xpath){
        BaseTest.appiumDriver.findElement(By.xpath(xpath)).click();
        //bekle(1,xpath(xpath));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }



}



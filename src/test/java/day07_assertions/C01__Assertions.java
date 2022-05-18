package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01__Assertions {
    /*
    Amazon ana sayfaya gidin
    3 farkli test methodu olusturarak asagidaki gorevleri yapin
    1-Url in amazon icerdigini test edin
    2-title in facebook icermedigini test edin
    3-sol ust kosede amazon logosunun gorundugunu test edin

     */

    static WebDriver driver; // tum methodlara ulassin diye class level de olusturduk
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com"); // buraya yazdik cunku tum testler icin gecerli olsun amazon a gitmek
                                                // testleri tek tek calistirirsak gorevlerini yerine getirir bu sayede
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){  // bu test methodlari static olmaz yazarsak run tusu kaybolur!!!


       // 1-Url in amazon icerdigini test edin
        String aranaKelime="amazon";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(aranaKelime));

    }

    @Test
    public void test02(){
        // 2-title in facebook icermedigini test edin
        String istenmeyenKelime="facebook";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));

    }

    @Test
    public void test03(){
        // 3-sol ust kosede amazon logosunun gorundugunu test edin
        WebElement logoElementi=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoElementi.isDisplayed());

    }




}

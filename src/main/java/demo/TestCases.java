package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
// Navigate to URL  www.google.com
driver.get( "https://www.google.com");

// sendkeys "bookmyshow chennai" Using Locator "XPath" //textarea[@class='gLFyf']
WebElement search= driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
search.sendKeys("bookmyshow chennai");
Thread.sleep(1000);
// click on the search button Using Locator "XPath" (//input[@class='gNO89b'])[1]
driver.findElement(By.xpath("(//input[@class='gNO89b'])[1]")).click();
// click on the first link of the loaded page Using Locator "XPath" //a[@href='https://in.bookmyshow.com/explore/home/chennai']
driver.findElement(By.xpath("//a[@href='https://in.bookmyshow.com/explore/home/chennai']")).click();
// "store the all img urls under recommended movies in a list of webelements Using Locator ""XPath" (//div[@class='style__RelativeContainer-sc-lnhrs7-0 hXVmgc'])[1]//child::a
List<WebElement> recommendedMovies = driver.findElements(By.xpath("(//div[@class='style__RelativeContainer-sc-lnhrs7-0 hXVmgc'])[1]//child::a"));

System.out.println("recommendedMovies are :"+ recommendedMovies.size());
Thread.sleep(1000);
// ((//div[@class='sc-133848s-2 sc-291x3n-1 eQCApE'])[1]//parent::div//parent::div//following-sibling::div)[2]//child::div//child::div//child::div//child::a"
// use for each loop and print the links  print(link.getAttribute("href"));
for(WebElement movie : recommendedMovies){
    System.out.println("URL's are :"+ movie.getAttribute("href"));

}
//Thread.sleep(1000);
// get the second movie under premiere using get text Using Locator "XPath" 
// WebElement secondMovieUnderPremiere= driver.findElement(By.xpath("(//div[@class='sc-133848s-2 sc-133848s-12 gUeFZV kQkCeb'])[14]//preceding-sibling::div//child::div"));
// WebElement secondMovieUnderPremiere= driver.findElement(By.xpath("((//div[@class='sc-133848s-3 cUiuCI'])[5]//descendant::div)[2]"));
// System.out.println("secondMovieUnderPremiere"+secondMovieUnderPremiere.getText());
// get the languge of that movie using get text Using Locator "XPath" 
// WebElement secondMovieUnderPremiereLanguage= driver.findElement(By.xpath("((//div[@class='sc-133848s-3 cUiuCI'])[5]//descendant::div)[4]"));
// System.out.println("language of the second movie"+secondMovieUnderPremiereLanguage.getText());


}


}

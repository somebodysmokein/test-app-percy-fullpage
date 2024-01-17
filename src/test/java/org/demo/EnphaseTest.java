package org.demo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.SupportsContextSwitching;
import io.percy.appium.AppPercy;
import io.percy.appium.lib.ScreenshotOptions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class EnphaseTest {

    public AppiumDriver driver;
    private static AppPercy percy;

    @BeforeMethod(alwaysRun=true)
    public void setUp() throws Exception {
        MutableCapabilities capabilities = new UiAutomator2Options();
        driver = new AndroidDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
        // Initialize AppPercy
        percy = new AppPercy(driver);

    }


    @Test
    public void testApp() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Thread.sleep(30000);

        Set<String> contextNames =   ((SupportsContextSwitching) driver).getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("NATIVE"))
                ((SupportsContextSwitching) driver).context(contextName);
        }


        //statusoptions.setFullPage(true);
        //statusoptions.setScreenLengths(4);
        //statusoptions.setScrollableXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[3]");

        ScreenshotOptions signinOptions=new ScreenshotOptions();
        signinOptions.setFullPage(true);
        signinOptions.setScreenLengths(6);
        //signinOptions.setScrollableXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View/android.view.View");
        percy.screenshot("Signin Page", signinOptions);


      /*  WebElement el4 = (WebElement) wait.until(
                ExpectedConditions.elementToBeClickable
                        (driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.Button[2]"))));
        el4.click();

        Thread.sleep(3000);
        WebElement el5 = (WebElement) wait.until(
                ExpectedConditions.elementToBeClickable
                        (driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView[2]"))));
        el5.click();
        Thread.sleep(3000);

        //WebElement doneBtn = (WebElement) driver.findElement(AppiumBy.className("com.enphaseenergy.myenlighten:class/android.widget.Button"));
        WebElement doneBtn = (WebElement) wait.until(
                ExpectedConditions.elementToBeClickable
                        (driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button"))));
        doneBtn.click();

        Thread.sleep(9000);

        WebElement exitElement = fluientWaitforElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[3]"),
        60,5);

        int exitHeight= exitElement.getSize().getHeight();

        WebElement footerElement = fluientWaitforElement(AppiumBy.xpath( "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[3]"),
        60,5);

        int footerHeight= footerElement.getSize().getHeight();

        ScreenshotOptions statusoptions = new ScreenshotOptions();
        List<WebElement> ignoreXpath= new ArrayList<>();
        ignoreXpath.add(exitElement);
        //ignoreXpath.add("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[3]");
        //statusoptions.setIgnoreRegionXpaths(ignoreXpath);
        statusoptions.setIgnoreRegionAppiumElements(Collections.singletonList(ignoreXpath));
        statusoptions.setFullPage(true);
        statusoptions.setScrollableXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[3]");
        statusoptions.setScreenLengths(6);
        statusoptions.setBottomScrollviewOffset(exitHeight+footerHeight);


        //percy.screenshot("Status Page", statusoptions);
        percy.screenshot("Status Page");



        WebElement Fhistory1=fluientWaitforElement( AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[2]/android.widget.Button"),60, 5);
        Fhistory1.click();
        Thread.sleep(6000);

        //percy.screenshot("Energy Page", options);
        percy.screenshot("Energy Page");

        *//*WebElement BleftArrow1 = fluientWaitforElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View/android.widget.Button[1]"), 60, 5);
        BleftArrow1.click();


        Thread.sleep(3000);
        percy.screenshot("Energy Screenshot");*//*

        WebElement array = fluientWaitforElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[3]/android.widget.Button"),
        60, 5);
        array.click();
        Thread.sleep(6000);
        //percy.screenshot("Array Page");


        WebElement fmenu3=  fluientWaitforElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[4]/android.widget.Button"),
        60,5);
        fmenu3.click();
        Thread.sleep(6000);
        //percy.screenshot("Menu Page", options);
        percy.screenshot("Menu Page");*/


    }

    //@Test
    public void testEnlightenApp() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(30000);

        Set<String> contextNames =   ((SupportsContextSwitching) driver).getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("NATIVE"))
                ((SupportsContextSwitching) driver).context(contextName);
        }



        /*WebElement androidElt=(WebElement) wait.until(
                ExpectedConditions.elementToBeClickable(driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.Button[1]"))));*/
        WebElement androidElt = fluientWaitforElement(
                AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.Button[1]"), 60,5);

/*
        WebElement el1 = (WebElement) wait.until(
                ExpectedConditions.elementToBeClickable
                        (driver.findElement(
                                AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.Button[1]"))));
*/


        androidElt.click();

        Thread.sleep(3000);

        Set<String> contextNames2 =   ((SupportsContextSwitching) driver).getContextHandles();
        for (String contextName : contextNames2) {
            if (contextName.contains("WEBVIEW"))
                ((SupportsContextSwitching) driver).context(contextName);
        }

       /* WebElement textView = (WebElement) wait.until(
                ExpectedConditions.elementToBeClickable
                        (driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]"))));
         textView=fluientWaitforElement(textView,45,10);
*/
        WebElement textView = fluientWaitforElement( AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]"),60,5);
        textView.click();

        Thread.sleep(3000);

        WebElement el3 = (WebElement) wait.until(
                ExpectedConditions.elementToBeClickable
                        (driver.findElement(AppiumBy.id("com.enphaseenergy.myenlighten:id/webviewClose"))));
        el3.click();

        Set<String> contextNames3 =   ((SupportsContextSwitching) driver).getContextHandles();
        for (String contextName : contextNames3) {
            if (contextName.contains("NATIVE"))
                ((SupportsContextSwitching) driver).context(contextName);
        }


        WebElement el4 = (WebElement) wait.until(
                ExpectedConditions.elementToBeClickable
                        (driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.Button[2]"))));
        el4.click();

        Thread.sleep(3000);
        WebElement el5 = (WebElement) wait.until(
                ExpectedConditions.elementToBeClickable
                        (driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView[2]"))));
        el5.click();
        Thread.sleep(3000);

        //WebElement doneBtn = (WebElement) driver.findElement(AppiumBy.className("com.enphaseenergy.myenlighten:class/android.widget.Button"));
        WebElement doneBtn = (WebElement) wait.until(
                ExpectedConditions.elementToBeClickable
                        (driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button"))));
        doneBtn.click();

        Thread.sleep(3000);

        WebElement Fhistory1 = (WebElement) wait.until(
                ExpectedConditions.elementToBeClickable
                        (driver.findElement(AppiumBy.id("Fhistory1"))));
        Fhistory1.click();
        Thread.sleep(3000);

        WebElement BleftArrow1 = (WebElement) wait.until(
                ExpectedConditions.elementToBeClickable
                        (driver.findElement(AppiumBy.id("BleftArrow1"))));
        BleftArrow1.click();

        Thread.sleep(3000);
        /*WebElement el6 = (WebElement) driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button"));
        el6.click();

        WebElement el7 = (WebElement) driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.widget.Button[2]"));
        el7.click();

        WebElement el8 = (WebElement) driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.Button[2]"));
        el8.click();*/

        /*WebElement newAcct = (WebElement) wait.until(
                ExpectedConditions.elementToBeClickable(
                        driver.findElement(AppiumBy.id("com.enphaseenergy.myenlighten:id/newAccountLink"))));


        WebElement el4 = (WebElement) wait.until(
                ExpectedConditions.elementToBeClickable(
                        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.widget.EditText"))));
        el4.sendKeys("test");
        WebElement el5 = (WebElement) wait.until(
                ExpectedConditions.elementToBeClickable(
                        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.widget.EditText"))));
        el5.sendKeys("test");
        WebElement el6 = (WebElement) wait.until(
                ExpectedConditions.elementToBeClickable(
                        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[1]/android.widget.EditText"))));
        el6.sendKeys("test@gmail.com");
        WebElement el7 = (WebElement) wait.until(
                ExpectedConditions.elementToBeClickable(
                        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View/android.view.View[2]"))));
        el7.click();
        WebElement el8 = (WebElement) wait.until(
                ExpectedConditions.elementToBeClickable(
                        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]"))));
        el8.click();*/

    }


    @AfterMethod(alwaysRun=true)
    public void tearDown() throws Exception {
        System.out.println("Video => "+driver.getCapabilities().getCapability("browserstack.video"));
        driver.quit();

    }


    public WebElement fluientWaitforElement(By strategy, int timoutSec, int pollingSec) {

        //System.out.println(driver.getTitle());
        FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timoutSec))
                .pollingEvery(Duration.ofSeconds(pollingSec))
                .ignoring(org.openqa.selenium.NoSuchElementException.class)
                .ignoring(TimeoutException.class)
                .ignoring(StaleElementReferenceException.class);


        WebElement element=fWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(strategy);
            }
        });

        /*for (int i = 0; i < 2; i++) {
            try {
                element=fWait.until(ExpectedConditions.visibilityOf(driver.findElement(strategy))) ;
                element=fWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(strategy)));
            } catch (Exception e) {

                //System.out.println("Element Not found trying again - " + element.toString().substring(70));
                e.printStackTrace();

            }
        }*/

        return element;

    }
}

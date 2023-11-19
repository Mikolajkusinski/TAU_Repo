package org.example;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void seleniumCalculatorChromeTest(){
        WebDriver driver = new ChromeDriver();

        log.info("Calculator on Chrome test start.");

        driver.get("https://www.calculator.net/fuel-cost-calculator.html?fbclid=IwAR31gBDtyUzWVk9LZud4jlLb53O_rriDTcvsjazqmYPnavl3AQKqdcIKxx8");
        log.debug("Open chrome and website calculator.net");

        driver.findElement(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr[4]/td/input[2]")).click();
        log.debug("Clear all given values");

        driver.findElement(By.name("tripdistance")).sendKeys("283");
        driver.findElement(By.name("fuelefficiency")).sendKeys("8");
        driver.findElement(By.name("gasprice")).sendKeys("2");
        log.debug("Set trip distance to 283\nSet fuel efficiency to 8\nSet gas price to 2");

        driver.findElement(By.name("x")).click();
        log.debug("Click calculate button");

        boolean isAnswerCorrect = driver.findElement(By.className("verybigtext")).getText().equals("This trip will require 22.6 liters of fuel, which amounts to a fuel cost of $45.28.");
        log.debug("Check if given answer is equals to yours");
        driver.quit();
        if (isAnswerCorrect = true){
            log.debug("Values are equal");
        }else {
            log.debug("Values are not equal");
        }

        log.info("Calculator on Chrome test end.");
    }

    public static void seleniumCalculatorFirefoxTest(){
        WebDriver driver = new FirefoxDriver();

        log.info("Calculator on FireFox test start.");

        driver.get("https://www.calculator.net/fuel-cost-calculator.html?fbclid=IwAR31gBDtyUzWVk9LZud4jlLb53O_rriDTcvsjazqmYPnavl3AQKqdcIKxx8");
        log.debug("Open FireFox and website calculator.net");

        driver.findElement(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr[4]/td/input[2]")).click();
        log.debug("Clear all given values");

        driver.findElement(By.name("tripdistance")).sendKeys("283");
        driver.findElement(By.name("fuelefficiency")).sendKeys("8");
        driver.findElement(By.name("gasprice")).sendKeys("2");
        log.debug("Set trip distance to 283\nSet fuel efficiency to 8\nSet gas price to 2");

        driver.findElement(By.name("x")).click();
        log.debug("Click calculate button");

        boolean isAnswerCorrect = driver.findElement(By.className("verybigtext")).getText().equals("This trip will require 22.6 liters of fuel, which amounts to a fuel cost of $45.28.");
        log.debug("Check if given answer is equals to yours");
        driver.quit();
        if (isAnswerCorrect = true){
            log.debug("Values are equal");
        }else {
            log.debug("Values are not equal");
        }
    }

    public static void seleniumShopFirefoxTest(){
        WebDriver driver = new FirefoxDriver();

        log.info("Shop on FireFox test start.");

        driver.get("https://www.demoblaze.com/index.html");
        log.debug("Open FireFox and website demoblaze.com");
        synchronized (driver){
            try {
                driver.wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        List<WebElement> elementsMainPage = driver.findElements(By.tagName("a"));
        for(WebElement element:elementsMainPage){
            if(element.getText().equals("Nokia lumia 1520")){
                element.click();
                break;
            }
        }
        log.debug("Choose product");

        synchronized (driver){
            try {
                driver.wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        List<WebElement> elementsProductPage = driver.findElements(By.tagName("a"));
        for(WebElement element:elementsProductPage){
            if(element.getText().equals("Add to cart")){
                element.click();
                break;
            }
        }
        log.debug("Add product to cart");

        synchronized (driver){
            try {
                driver.wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        driver.switchTo().alert().accept();
        log.debug("Accept alert");

        driver.findElement(By.id("cartur")).click();

        synchronized (driver){
            try {
                driver.wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        List<WebElement> elementsCartPage = driver.findElements(By.tagName("button"));
        for(WebElement element:elementsCartPage){
            if(element.getText().equals("Place Order")){
                element.click();
                break;
            }
        }
        log.debug("Placing order");

        driver.findElement(By.id("name")).sendKeys("test");
        driver.findElement(By.id("country")).sendKeys("test");
        driver.findElement(By.id("city")).sendKeys("test");
        driver.findElement(By.id("card")).sendKeys("test");
        driver.findElement(By.id("month")).sendKeys("test");
        driver.findElement(By.id("year")).sendKeys("test");
        log.debug("filling form");

        synchronized (driver){
            try {
                driver.wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        List<WebElement> elementsOrderPage = driver.findElements(By.tagName("button"));
        for(WebElement element:elementsOrderPage){
            if(element.getText().equals("Purchase")){
                element.click();
                break;
            }
        }
        log.debug("finalizing order");

        boolean isAnswerCorrect = driver.findElement(By.tagName("h2")).getText().equals("Thank you for your purchase!");

        if (isAnswerCorrect = true){
            log.debug("Values are equal");
        }else {
            log.debug("Values are not equal");
        }

        driver.quit();
    }

    public static void seleniumShopChromeTest(){
        WebDriver driver = new ChromeDriver();

        log.info("Shop on Chrome test start.");

        driver.get("https://www.demoblaze.com/index.html");
        log.debug("Open FireFox and website demoblaze.com");
        synchronized (driver){
            try {
                driver.wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        List<WebElement> elementsMainPage = driver.findElements(By.tagName("a"));
        for(WebElement element:elementsMainPage){
            if(element.getText().equals("Nokia lumia 1520")){
                element.click();
                break;
            }
        }
        log.debug("Choose product");

        synchronized (driver){
            try {
                driver.wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        List<WebElement> elementsProductPage = driver.findElements(By.tagName("a"));
        for(WebElement element:elementsProductPage){
            if(element.getText().equals("Add to cart")){
                element.click();
                break;
            }
        }
        log.debug("Add product to cart");

        synchronized (driver){
            try {
                driver.wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        driver.switchTo().alert().accept();
        log.debug("Accept alert");

        driver.findElement(By.id("cartur")).click();

        synchronized (driver){
            try {
                driver.wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        List<WebElement> elementsCartPage = driver.findElements(By.tagName("button"));
        for(WebElement element:elementsCartPage){
            if(element.getText().equals("Place Order")){
                element.click();
                break;
            }
        }
        log.debug("Placing order");

        synchronized (driver){
            try {
                driver.wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        driver.findElement(By.id("name")).sendKeys("test");
        driver.findElement(By.id("country")).sendKeys("test");
        driver.findElement(By.id("city")).sendKeys("test");
        driver.findElement(By.id("card")).sendKeys("test");
        driver.findElement(By.id("month")).sendKeys("test");
        driver.findElement(By.id("year")).sendKeys("test");
        log.debug("filling form");

        synchronized (driver){
            try {
                driver.wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        List<WebElement> elementsOrderPage = driver.findElements(By.tagName("button"));
        for(WebElement element:elementsOrderPage){
            if(element.getText().equals("Purchase")){
                element.click();
                break;
            }
        }
        log.debug("finalizing order");

        boolean isAnswerCorrect = driver.findElement(By.tagName("h2")).getText().equals("Thank you for your purchase!");

        if (isAnswerCorrect = true){
            log.debug("Values are equal");
        }else {
            log.debug("Values are not equal");
        }
        driver.quit();
    }

    public static void main(String[] args) {
        seleniumCalculatorChromeTest();
        log.debug("\n\n");
        seleniumCalculatorFirefoxTest();
        log.debug("\n\n");
        seleniumShopChromeTest();
        log.debug("\n\n");
        seleniumShopFirefoxTest();
    }
}
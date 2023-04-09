package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


public class Function extends Thread{
    WebDriver driver;
    WebElement navbar;

    public void invokeBrowser(String browserType){

        if(browserType.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if(browserType.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else if(browserType.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if(browserType.equalsIgnoreCase("internetexplorer")) {
            driver = new InternetExplorerDriver();
        }
        else if(browserType.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
            driver.get("http://localhost:3000/login");
        }
        else{
            System.out.println("Browser not Supported");
            return;
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://localhost:3000/login");
        System.out.println("Title: "+driver.getTitle());
        navbar = driver.findElement(By.id("alert"));
    }
    public void login(String username, String password){
        WebElement userId;
        userId = driver.findElement(By.name("email"));
        userId.sendKeys(username);
        driver.findElement(By.name ("password")).sendKeys(password);
        driver.findElement(By.name("button")).click();
        System.out.println(navbar.getText());
    }
    public void wait(int time){
        try{Thread.sleep(time);}catch(InterruptedException e){System.out.println(e);}
    }
    public void addNote(String titleF,String descriptionF,String tag){
        WebElement title;
        title = driver.findElement(By
                .xpath("/html/body/div/div[2]/div/div[1]/div/form/div[1]/input"));
        title.sendKeys(titleF);
        wait(3000);
        WebElement description;
        description = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/div/form/div[2]/input"));
        description.sendKeys(descriptionF);
        wait(3000);
        driver.findElement(By.xpath ("/html/body/div/div[2]/div/div[1]/div/form/div[3]/input")).sendKeys(tag);
        wait(3000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/div/form/button")).click();
        System.out.println(navbar.getText());

    }
    public void editNote(String title,String description,String tag){

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div/div/i[2]")).click();
        driver.findElement(By.xpath ("/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/form/div[1]/input")).clear();
        driver.findElement(By.xpath ("/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/form/div[1]/input")).sendKeys(title);
        wait(3000);
        driver.findElement(By.xpath ("/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/form/div[2]/input")).clear();
        driver.findElement(By.xpath ("/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/form/div[2]/input")).sendKeys(description);
        wait(3000);
        driver.findElement(By.xpath ("/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/form/div[3]/input")).clear();
        driver.findElement(By.xpath ("/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/form/div[3]/input")).sendKeys(tag);
        wait(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[3]/button[2]")).click();

        System.out.println(navbar.getText());
    }
    public void deleteNote(){
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div/div/i[1]")).click();
        System.out.println(navbar.getText());
    }
    public void logout(){
        driver.findElement(By.xpath("/html/body/div/nav/div/div/button")).click();
        System.out.println(navbar.getText());
    }
    public void sendMail(){
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[3]/div/div/div/i[3]")).click();
//        System.out.println(navbar.getText());
        System.out.println("Success: Email Send Successfully");
    }
    public void closeBrowser(){
        driver.close();
    }
}

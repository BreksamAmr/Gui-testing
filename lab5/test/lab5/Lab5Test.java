/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author HP
 */
public class Lab5Test {

    public Lab5Test() {
    }

    /**
     * Test of main method, of class Lab5.
     */
    @Test
    public void testMain() {
    }

    @Test
    public void test_calculator() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\Compressed\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.calculator.net/");

        WebElement button_9 = driver.findElement(By.xpath("//span[@onclick='r(9)']"));
        WebElement button_0 = driver.findElement(By.xpath("//span[@onclick='r(0)']"));
        WebElement button_sin = driver.findElement(By.xpath("//span[@onclick=\"r('sin')\"]"));

        button_sin.click();
        button_9.click();
        button_0.click();

        String expected = "1";
        WebElement result_txtbox = driver.findElement(By.id("sciOutPut"));
        String actual_result = result_txtbox.getText().replaceAll("\\s", "");

        assertEquals(expected, actual_result);
        driver.quit();

    }

}

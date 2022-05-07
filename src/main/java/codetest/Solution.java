package codetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Ques-2:
     * Verify feelsLike-temp value is in between the low-temp value and high-temp value
     * Web: https://www.darksky.net/
     * points: 20
     */

    /**
     * Testcase 1: Verify the feels-like temp value is between low and high temp values at any zipcode
     *
     * Step:
     * 1. Go to https://www.darksky.net
     * 2. Enter zipcode in searchbar
     * 3. Click on search button
     * 4. Collect temparature data for feels like, low and high
     * 5. Verify condition that feels like temperature is between low and high temperature
     */

    @Test
    public void verificationOfTemp(){

        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.darksky.net");

        WebElement searchBar = driver.findElement(By.xpath("//input[@type='text']"));
        searchBar.clear();
        searchBar.sendKeys("10467");

        WebElement searchButton = driver.findElement(By.xpath("//img[@alt='Search Button']"));
        searchButton.click();

        WebElement temp = driver.findElement(By.xpath("//span//span[@class='feels-like-text']"));
        String tempText = temp.getText();
        System.out.println(tempText);
        String[] strings = tempText.split("˚");
        System.out.println(Arrays.toString(strings));
        int flT= Integer.parseInt(strings[0]);
        System.out.println(flT);



        WebElement lowTemperature = driver.findElement(By.xpath("//span[@class='high-low-label']/following-sibling::span[@class='low-temp-text']"));
        String[] lowTemp = lowTemperature.getText().split("˚");
        int lTemp = Integer.parseInt(lowTemp[0]);
        System.out.println(lTemp);

        WebElement highTemperature = driver.findElement(By.xpath("//span[@class='high-low-label']/following-sibling::span[@class='high-temp-text']"));
        String[] highTemp = highTemperature.getText().split("˚");
        int hTemp = Integer.parseInt(highTemp[0]);
        System.out.println(hTemp);

        boolean actualComparingTemp;

        if (flT > lTemp && flT < hTemp) {
            actualComparingTemp = true;
        } else {
            actualComparingTemp = false;

        }

        Assert.assertTrue(actualComparingTemp, "Feels like temparature is not between Low and High");

        driver.quit();

    }

/**
 * Ques-1:
 * Create a method to return factorial value of input-int-value
 * points: 10
 */
    public static int getFactorialValue(int value){
        System.out.println("***Solution1***");
        int factorial = 1;

        for (int i=1; i<=value; i++){
            factorial = factorial * i;
        }
        return factorial;
    }

    /**
     * Ques-3:
     * Create a method to return the common Strings values in two input-String-arrays
     * points: 30
     * Note: two input-String-arrays can be of same size or different size
     */


    public static List<String> printCommonStrings (String[] arr1, String[] arr2){
        System.out.println("\n***Solution3***");
        System.out.println("Common Strings of the both arrays are following");
        List<String> commonStrings = new ArrayList<>();
        for (int i = 0; i<arr1.length; i++){
            for (int j = 0; j<arr2.length; j++){
                if (arr2[j].equalsIgnoreCase(arr1[i])){
                    commonStrings.add(arr2[j]);


                }
            }
        }
        return commonStrings;

    }

    /**
     * Ques-4:
     * Create a method to return missing smallest positive integer (greater than 0) from given int-array.
     * points: 40
     */


    public static int getMissingPositiveNumber(int[] arr){
        System.out.println("\n***Solution4***");
        if (arr.length == 0) {
            return 1;
        }

        int i = 0;
        while (i < arr.length){
            if (arr[i] > 0 && arr[i] <= arr.length &&  arr[i] != arr[arr[i]-1]){
                int j = arr[i]- 1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }else {
                i++;
            }
        }

        for (i =0; i< arr.length; i++){
            if (arr[i] != i+1){
                return i+1;
            }
        }
        return arr.length+1;
    }





    public static void main(String[] args) {

        System.out.println("The factorial value of given int is : "+ getFactorialValue(5));
        String[] input ={"happY", "king", "peace", "living standard"};
        String[] value = {"king kong", "Happy", "PEACE"};

        System.out.println(printCommonStrings(input,value));

        int[] input2 =  {3, 5, 1, 4, 2, 7};
        System.out.println("The smallest positive missing number is : "+getMissingPositiveNumber(input2));
    }










}

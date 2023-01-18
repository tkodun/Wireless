package pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driverPackage.DriverManager;

public class HomePage extends DriverManager{
	

	public String Base_URL = "https://wltest.dns-systems.net/";
	
	By img_logo = By.className("logo");
	By price_Tag = By.className("package-price");
	By price_Txt = By.className("price-big");
	By title_1 = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[1]/section/div/div[4]/div/div[1]/div/div[1]/h3");
	By title_2 = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[1]/section/div/div[4]/div/div[2]/div/div[1]/h3");
	By title_3 = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[1]/section/div/div[4]/div/div[3]/div/div[1]/h3");
	By title_4 = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[2]/section/div/div[4]/div/div[1]/div/div[1]/h3");
	By title_5 = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[2]/section/div/div[4]/div/div[2]/div/div[1]/h3");
	By title_6 = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[2]/section/div/div[4]/div/div[3]/div/div[1]/h3");
	By product_Description = By.className("package-description");
	By discount_1 = By.xpath("//*[@id=\"subscriptions\"]/div/div[4]/div/div[1]/div/div[2]/ul/li[3]/div/p");
	By discount_2 = By.xpath("//*[@id=\"subscriptions\"]/div/div[4]/div/div[2]/div/div[2]/ul/li[3]/div/p");
	By discount_3 = By.xpath("//*[@id=\"subscriptions\"]/div/div[4]/div/div[3]/div/div[2]/ul/li[3]/div/p");
	
	
	public void launchUrl()
	{
		driver.navigate().to(Base_URL);
	}	
	
	public void assertLogo() {
		driver.findElement(img_logo).isDisplayed();		
	}
	
	
	public void getTitle() {
		System.out.println("Page title is : " + driver.getTitle());;	
	}
	
	public void iCountProduct() {
		List<WebElement> prices = driver.findElements(price_Tag);
		System.out.println("Total product on displayed is : " + prices.size());
	}
		
	public void getAllPrice() {
		List<WebElement> prices = driver.findElements(price_Txt);
		for (WebElement webElement : prices) {
            String name = webElement.getText();
            System.out.println(name);
        }
	}
	
	public void orderByPriceDesending() {
		List<WebElement> prices = driver.findElements(price_Txt);
		List<Double> priceList = new ArrayList<>();
		
		for (WebElement p : prices) {
            priceList.add(Double.valueOf(p.getText().replace("£", "")));            
        }
		Collections.sort(priceList);
		Collections.reverse(priceList);
		for (Double element : priceList) {
		    System.out.println(element);
		}
      }
	

	
	public void writeJsonValue()  {
		List<WebElement> prices = driver.findElements(price_Txt);
		WebElement title = driver.findElement(title_1);
		WebElement title2 = driver.findElement(title_2);
		WebElement title3 = driver.findElement(title_3);
		WebElement title4 = driver.findElement(title_4);
		WebElement title5 = driver.findElement(title_5);
		WebElement title6 = driver.findElement(title_6);
		List<WebElement> description = driver.findElements(product_Description);
		WebElement discount = driver.findElement(discount_1);
		WebElement discount2 = driver.findElement(discount_2);
		WebElement discount3 = driver.findElement(discount_3);
		
		JSONObject product = new JSONObject();
		product.put("Title", title.getText());
		product.put("Description", description.get(0).getText());
		product.put("Price", prices.get(0).getText());
		product.put("Discount", "");
		
		JSONObject productObj = new JSONObject();
		productObj.put("subsPackages", product);
		
		
		JSONObject product2 = new JSONObject();
		product2.put("Title", title2.getText());
		product2.put("Description", description.get(1).getText());
		product2.put("Price", prices.get(1).getText());
		product2.put("Discount", "");
		
		JSONObject productObj2 = new JSONObject();
		productObj2.put("subsPackages", product2);
		
		
		JSONObject product3 = new JSONObject();
		product3.put("Title", title3.getText());
		product3.put("Description", description.get(2).getText());
		product3.put("Price", prices.get(2).getText());
		product3.put("Discount", "");
		
		JSONObject productObj3 = new JSONObject();
		productObj3.put("subsPackages", product3);
		
		
		JSONObject product4 = new JSONObject();
		product4.put("Title", title4.getText());
		product4.put("Description", description.get(3).getText());
		product4.put("Price", prices.get(3).getText());
		product4.put("Discount", discount.getText());
		
		JSONObject productObj4 = new JSONObject();
		productObj4.put("subsPackages", product4);
		
		
		JSONObject product5 = new JSONObject();
		product5.put("Title", title5.getText());
		product5.put("Description", description.get(4).getText());
		product5.put("Price", prices.get(4).getText());
		product5.put("Discount", discount2.getText());
		
		JSONObject productObj5 = new JSONObject();
		productObj5.put("subsPackages", product5);
		
		
		JSONObject product6 = new JSONObject();
		product6.put("Title", title6.getText());
		product6.put("Description", description.get(5).getText());
		product6.put("Price", prices.get(5).getText());
		product6.put("Discount", discount.getText());
		
		JSONObject productObj6 = new JSONObject();
		productObj6.put("subsPackages", product6);
		
		JSONArray subsList = new JSONArray();
		subsList.add(productObj);
		subsList.add(productObj2);
		subsList.add(productObj3);
		subsList.add(productObj4);
		subsList.add(productObj5);
		subsList.add(productObj6);
		
		try(FileWriter file = new FileWriter("subscription.json")){
			file.write(subsList.toJSONString());
			file.flush();
		}
		catch(IOException e) {e.printStackTrace();}
	}
	
	
	
	}

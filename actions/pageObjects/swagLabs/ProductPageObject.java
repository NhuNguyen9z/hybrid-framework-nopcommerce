package pageObjects.swagLabs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.swagLabs.ProductPageUI;

public class ProductPageObject extends BasePage {
	private WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropDown(String textItem) {
		waitForElementClickable(driver, ProductPageUI.SELECT_DROPDOWN);
		selectItemInDefaultDropdown(driver, ProductPageUI.SELECT_DROPDOWN, textItem);
	}

	public boolean isProductNameSortByAscending() {
		ArrayList<String> productNameUI = new ArrayList<String>();
		List<WebElement> elements = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);
		for (WebElement element : elements) {
			productNameUI.add(element.getText());
			System.out.println("Product Name  = " + element.getText());
		}

		ArrayList<String> sortProduct = new ArrayList<String>();
		for (String product : productNameUI) {
			sortProduct.add(product);
			System.out.println("Product Name copy = " + product);
		}
		Collections.sort(sortProduct);
		for (String name : sortProduct) {
			System.out.println("Product Name Sort ASC = " + name);
		}

		return sortProduct.equals(productNameUI);
	}

	public boolean isProductNameSortByDescending() {
		ArrayList<String> productNameUI = new ArrayList<String>();
		List<WebElement> elements = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);
		for (WebElement element : elements) {
			productNameUI.add(element.getText());
			System.out.println("Product Name  = " + element.getText());
		}
		ArrayList<String> sortProduct = new ArrayList<String>();
		for (String name : productNameUI) {
			sortProduct.add(name);
			System.out.println("Product Name copy = " + name);
		}
		Collections.sort(sortProduct);
		for (String name : sortProduct) {
			System.out.println("Product Name Sort ASC = " + name);
		}

		Collections.reverse(sortProduct);
		for (String name : sortProduct) {
			System.out.println("Product Name Sort DESC = " + name);
		}

		return sortProduct.equals(productNameUI);
	}

	public boolean isProductPriceSortByAscending() {
		ArrayList<Float> productPriceUI = new ArrayList<Float>();
		List<WebElement> elements = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);
		for (WebElement element : elements) {
			productPriceUI.add(Float.parseFloat(element.getText().replace("$", "")));
			System.out.println("Product Price  = " + element.getText());
		}

		ArrayList<Float> sortPrice = new ArrayList<Float>();
		for (Float price : productPriceUI) {
			sortPrice.add(price);
			System.out.println("Product Price copy = " + price);
		}
		Collections.sort(sortPrice);
		for (Float price : sortPrice) {
			System.out.println("Product Price Sort ASC = " + price);
		}

		return sortPrice.equals(productPriceUI);
	}

	public boolean isProductPriceSortByDescending() {
		ArrayList<Float> productPriceUI = new ArrayList<Float>();
		List<WebElement> elements = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);
		for (WebElement element : elements) {
			productPriceUI.add(Float.parseFloat(element.getText().replace("$", "")));
			System.out.println("Product Price  = " + Float.parseFloat(element.getText().replace("$", "")));
		}

		ArrayList<Float> sortPrice = new ArrayList<Float>();
		for (Float price : productPriceUI) {
			sortPrice.add(price);
			System.out.println("Product Price copy = " + price);
		}
		Collections.sort(sortPrice);
		for (Float price : sortPrice) {
			System.out.println("Product Price Sort ASC = " + price);
		}

		Collections.reverse(sortPrice);
		for (Float price : sortPrice) {
			System.out.println("Product Name Sort DESC = " + price);
		}

		return sortPrice.equals(productPriceUI);
	}

}

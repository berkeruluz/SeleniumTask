package com.n11Login.tests;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.main.tests.ProjectUtil;

public class JUnitN11Test {

	static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.n11.com/");

	}

	// sayfanýn açýldýðýnýn onaylanmasý
	@Test
	public void test1MainPageOpened() throws InterruptedException {
		assertTrue(driver.getCurrentUrl().contains("www.n11.com"));
	}

	@Test
	public void test2SamsungProductSearch() throws InterruptedException {

		driver.findElement(By.className("btnSignIn")).click();

		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("berker93_93@hotmail.com");

		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("07072014b");

		Thread.sleep(1000);
		driver.findElement(By.id("loginButton")).click();

		Thread.sleep(1000);
		driver.findElement(By.id("searchData")).sendKeys("samsung");

		Thread.sleep(1000);
		driver.findElement(By.className("searchBtn")).click();

		// Samsung ile ilgili sonuç bulunduðunun onaylanmasý
		assertTrue(driver.findElement(By.linkText("Samsung")).isDisplayed());
	}

	@Test
	public void test3SecondPageAccess() throws InterruptedException {

		Thread.sleep(1000);
		driver.get("http://www.n11.com/arama?q=samsung&pg=2");

		// 2.sayfanýn gösterimde olduðunun onaylanmasý
		assertTrue(driver.getCurrentUrl().contains(
				"http://www.n11.com/arama?q=samsung&pg=2"));

	}

	@Test
	public void test4Favourites() throws InterruptedException {

		Thread.sleep(1000);
		ProjectUtil.getFileContent(driver, 3);

		Thread.sleep(1000);
		driver.findElement(By.id("addToFavourites")).click();

		Thread.sleep(1000);
		driver.get("https://www.n11.com/hesabim/favorilerim");

		Thread.sleep(1000);
		driver.findElement(By.className("removeSelectedProduct")).click();

		// Favorilerin boþ olduðunun onaylanmasý
		assertTrue(driver.findElement(By.className("emptyWatchList"))
				.isDisplayed());

	}

}

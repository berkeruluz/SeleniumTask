package com.facebook.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.main.tests.ProjectUtil;

public class FacebookLogin {

	public static void main(String[] args) throws InterruptedException {

		ProjectUtil ns = new ProjectUtil();
		WebDriver driver = new FirefoxDriver();
		// açýlan pencereyi büyütme
		ns.windowMaximize(driver);

		// tarayýcý açýldýðýnda gelecek sayfa
		ns.homePage(driver, "https://tr-tr.facebook.com");

		// email textbox'unu doldurma
		Thread.sleep(1000);
		ns.fillEMailElement(driver, "email", "berkeruluz22@gmail.com");

		// password alanýný doldurma
		Thread.sleep(1000);
		ns.fillPasswordElement(driver, "pass", "1q2w3e4r.");

		// buttona týklama
		Thread.sleep(1000);
		ns.clickOnButtonElementById(driver, "u_0_l");
	}

}

package com.facebook.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.main.tests.ProjectUtil;

public class FacebookLogin {

	public static void main(String[] args) throws InterruptedException {

		ProjectUtil ns = new ProjectUtil();
		WebDriver driver = new FirefoxDriver();
		// a��lan pencereyi b�y�tme
		ns.windowMaximize(driver);

		// taray�c� a��ld���nda gelecek sayfa
		ns.homePage(driver, "https://tr-tr.facebook.com");

		// email textbox'unu doldurma
		Thread.sleep(1000);
		ns.fillEMailElement(driver, "email", "berkeruluz22@gmail.com");

		// password alan�n� doldurma
		Thread.sleep(1000);
		ns.fillPasswordElement(driver, "pass", "1q2w3e4r.");

		// buttona t�klama
		Thread.sleep(1000);
		ns.clickOnButtonElementById(driver, "u_0_l");
	}

}

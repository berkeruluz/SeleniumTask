package com.main.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectUtil {
//	private WebDriver webDriver = new FirefoxDriver();

	public void homePage(WebDriver webDriver, String url) {
		webDriver.get(url);
	}

	public void windowMaximize(WebDriver webDriver) {
		webDriver.manage().window().maximize();
	}

	public void fillEMailElement(WebDriver webDriver, String deger, String mail) {
		webDriver.findElement(By.id(deger)).sendKeys(mail);
	}

	public void fillPasswordElement(WebDriver webDriver, String deger, String sifre) {
		webDriver.findElement(By.id(deger)).sendKeys(sifre);
	}

	public void clickOnButtonElementById(WebDriver webDriver, String buttonId) {
		webDriver.findElement(By.id(buttonId)).click();
	}

	public void fillTextBoxElement(WebDriver webDriver, String deger, String deger2) {
		webDriver.findElement(By.id(deger)).sendKeys(deger2);
	}

	public void clickOnButtonElementByClass(WebDriver webDriver, String btnID) {
		webDriver.findElement(By.className(btnID)).click();
	}
	
	public static void getFileContent(WebDriver webDriver, int lineIndex) {

		File textFile = new File("webDosya.txt");
		String keyword = "class=\"pro\"";
		String link = "";
		String[] line;
		// class name'i pro olanlar arandý ve saydýrýldý
		try {
			Scanner scanner = new Scanner(textFile);
			int count = 0;
			while (scanner.hasNextLine()) {
				String str = scanner.nextLine();
				if (str.contains(keyword)) {
					count++;
					System.out.println(count);
				}
				// linki getirildi
				if (count == lineIndex && str.contains("href=\"")) {
					line = str.split("\"");
					link = line[1];
					System.out.println(link);
					// link açýldý
					webDriver.get(link);
					scanner.close();
					break;
				}
			}

		} catch (FileNotFoundException ex) {
			Logger.getLogger(ProjectUtil.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}


}

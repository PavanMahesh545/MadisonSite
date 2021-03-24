package com.htc.madisonsite.utilites;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Screenshot {
	public static String capturescreenShot(WebDriver driver, String path,String methodname) throws IOException, InterruptedException {

		String screenshotpath = path +"\\"+methodname+ Utility.getCurrentTime() +".jpg";
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File s = new File(screenshotpath);
		FileHandler.copy(file, s);
		Thread.sleep(3000);
		return screenshotpath;
	}
}

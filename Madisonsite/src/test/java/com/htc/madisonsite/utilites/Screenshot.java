package com.htc.madisonsite.utilites;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Screenshot {

		public static String capturescreenShot(WebDriver driver, String path,String methodname) throws IOException, InterruptedException {

			String screenshotpath = path +"\\"+methodname+ Utility.getCurrentTime();
			 //File name=new File(screenshotpath);
			File name=Utility.creatingFile(screenshotpath);
			  name.mkdir();

			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			//File s = new File(screenshotpath+"\\"+methodname+".jpg");
			File s=Utility.creatingFile((screenshotpath+"\\"+methodname+".jpg"));
			FileHandler.copy(file, s);
			return screenshotpath;
		}
	}
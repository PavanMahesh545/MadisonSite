package com.htc.madisonsite.utilites;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

import com.htc.madisonsite.constants.Constants;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;



public class TestDataProvider {

	@DataProvider(name = "Madison")
	public Object[][] Madison_Valid_And_Invalid_RegisterData(Method m) {
		Object[][] loginDataSet = null;
		ExcelFileManager excelfile = new ExcelFileManager(Constants.EXCELFILE_PATH);
		if (m.getName().equals("Valid_And_Invalid_Registration")) {
			loginDataSet = excelfile.getDataAsHashMap(Constants.REGISTRATION_SHEETNAME);
		} else if (m.getName().equals("Valid_And_Invalid_Login")) {
			loginDataSet = excelfile.getDataAsHashMap(Constants.LOGIN_SHEETNAME);
		}

		return loginDataSet;

	}

}

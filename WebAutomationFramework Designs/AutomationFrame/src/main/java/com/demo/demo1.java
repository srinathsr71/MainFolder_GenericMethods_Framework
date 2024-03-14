package com.demo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.operationmethods.GenericMethods;
import com.operationmethods.GenericStaticMethods;

public class demo1 {

public static WebDriver driver;
public GenericMethods gm=new GenericMethods();


public void intialization() throws IOException {
	//String dg=gm.getProperty("browser");
	GenericMethods.setFilepath("./src/test/resources/configuration/config.properties");
	gm.openBrowser();
	gm.maximizeWindow();
	
}
public void openingurl() {
	gm.geturl(gm.getProperty("url"));
}
}

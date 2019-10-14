package com.OH.pom;

import org.openqa.selenium.By;

import com.OH.libraries.Utility_Libraries;

public class Page_Object_Model {

	public static By Run(String Locaters_type,String Locater_name, String FileName) throws Throwable
	{
	switch(Locaters_type.toLowerCase())
	{
	case "xpath":
	By xpath = By.xpath(Utility_Libraries.GetElement(Locater_name, FileName));
	return xpath;
	case "css":
	By css = By.cssSelector(Utility_Libraries.GetElement(Locater_name, FileName));
	return css;
	case "id":
	By id = By.id(Utility_Libraries.GetElement(Locater_name, FileName));
	return id;
	case "classname":
	By className = By.className(Utility_Libraries.GetElement(Locater_name, FileName));
	return className;
	case "tagname":
	By tagname = By.tagName(Utility_Libraries.GetElement(Locater_name, FileName));
	return tagname;
	case "name":
	By name = By.name(Utility_Libraries.GetElement(Locater_name, FileName));
	return name;
	case "linktext":
	By linktext = By.linkText(Utility_Libraries.GetElement(Locater_name, FileName));
	return linktext;
	case "partiallinktext":
	By partiallinktext = By.partialLinkText(Utility_Libraries.GetElement(Locater_name, FileName));
	return partiallinktext;
	}
	return null;
	}
	
}

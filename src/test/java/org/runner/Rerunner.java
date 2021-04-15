package org.runner;

import org.baseclass.JVMReportGeneration;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@src\\test\\resources\\Rerun\\failed.txt", glue = "org.stepdefinition", plugin = {
		"pretty", "html:target\\Reports", "json:target\\Reports\\output.json", "junit:target\\Reports\\output.xml",
		"rerun:src\\test\\resources\\Rerun\\failed.txt" }, tags = { "@sanity,@smoke " })
public class Rerunner {

	@AfterClass
	public static void jvmReport() {
		JVMReportGeneration.generateJVM(System.getProperty("user.dir") + "\\target\\Reports\\output.json");

	}
}

package org.stepdefinition;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksAdactin extends BaseClass {

	@Before("@sanity")
	public void beforeSanity() {
		System.out.println("Before Sanity");

	}

	@After("@sanity")
	public void afterSanity() {
		System.out.println("After Sanity");

	}

	@Before("@smoke")
	public void beforeSmoke() {
		System.out.println("Before Smoke");

	}

	@After("@smoke")
	public void afterSmoke() {
		System.out.println("After Smoke");

	}

	@Before("@regression")
	public void beforeRegression() {
		System.out.println("Before Regression");

	}

	@After("@regression")
	public void afterRegression() {
		System.out.println("After Regression");

	}

	@Before(order = 1)
	public void beforeOrder1() {
		System.out.println("Before Order 1");

	}

	@After(order = 1)
	public void afterOrder1() {
		System.out.println("After Order 1");

	}

	@Before(order = 2)
	public void beforeOrder2() {
		System.out.println("Before Order 2");

	}

	@After(order = 2)
	public void afterOrder2() {
		System.out.println("After Order 2");

	}

	@Before
	public void beforeEachScenario() {
		launchChromeBrowser();
		maximizeWindow();

	}

	@After
	public void afterEachScenario(Scenario s) throws IOException {
		if (s.isFailed()) {
			TakesScreenshot ts=(TakesScreenshot)driver;
			byte[] sc = ts.getScreenshotAs(OutputType.BYTES);
			s.embed(sc, "image/png");
		}
		String name = s.getName();
		String fileName = name.replace(" ", "_");
		snapshot(fileName);
		closeBrowser();
	}
	
	
}

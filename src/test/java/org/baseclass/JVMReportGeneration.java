package org.baseclass;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReportGeneration {

	public static void generateJVM(String jsonpath) {
		File f=new File(System.getProperty("user.dir")+"\\target\\Reports\\JVMReport");
		
		Configuration conf=new Configuration(f, "AdactinHotel");
		conf.addClassifications("Platform name", "Windows 10");
		conf.addClassifications("Browser name", "Chrome");
		conf.addClassifications("Browser version", "89.0");
		
		List<String> li=new ArrayList<String>();
		li.add(jsonpath);
		
		ReportBuilder rb=new ReportBuilder(li, conf);
		rb.generateReports();

	}
}

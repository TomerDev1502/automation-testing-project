package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import applogic.ApplicationManager1;

public class ParamsUtils {

	private Properties prop;
	private ApplicationManager1 app;

	private static final String PROP_FILE = "/application.properties";

	public final static String WORKSPACE = "workspace";

	public final static String BROWSER_NAME = "browser.name";
	public final static String BROWSER_VERSION = "browser.version";
	public final static String HEADLESS_MODE = "headless_mode";
	public final static String RECORDING = "recording";
	public final static String URL = "url";
	public final static String DEVICE_NAME = "device_name";
	public final static String PLATFORM_VERSION = "platform_version";// for desktops
	public final static String VERSION = "version";// for mobiles
	public final static String PLATFORM_NAME = "platform_name";
	public final static String APP_PACKAGE = "app_package";
	public final static String APP_ACTIVITY = "app_activity";
	public final static String AUTOMATION_NAME="automationName";


	public ParamsUtils(ApplicationManager1 app) {

		prop = new Properties();
		this.app = app;
		try {
			prop.load(new FileInputStream(new File("src/main/resources", PROP_FILE)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		storeValue(BROWSER_NAME, "chrome");
		storeValue(BROWSER_VERSION, "");
		storeValue(HEADLESS_MODE, "false");
		storeValue(WORKSPACE, "C:\\Selenium Workspace");
		storeValue(RECORDING, "false");
		storeValue(URL, "");
		storeValue(DEVICE_NAME, "");
		storeValue(PLATFORM_VERSION, "");
		storeValue(VERSION, "");
		storeValue(PLATFORM_NAME, "");
		storeValue(APP_PACKAGE, "");
		storeValue(APP_ACTIVITY, "");
		storeValue(AUTOMATION_NAME,"UiAutomator2");

	}



	private void storeValue(String name, String defaultValue) {
		/**
		 * Priorities: 1. System argument (-D) 2. application.properties 3.
		 * default params above
		 */
		String value = System.getProperty(name);
		if (value != null) {
			prop.setProperty(name, value);
		} else if (!prop.containsKey(name)) {
			prop.setProperty(name, defaultValue);
		}
	}


	public String getPropValue(String name) {
		return prop.getProperty(name);
	}


}
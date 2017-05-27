package utilities;

public class Configuration {
	public static String apiIp = "34.195.47.250";
//	public static String apiIp = "10.0.1.201";
//	public static String apiPort = "8082";
	public static String apiPort = "8081";
	public static String applicationIp = "34.192.19.10";
//	public static String applicationIp = "10.0.1.201:8084/invoices";
//	public static String pathToChromeDriver = "/Users/dpm3354/working/DataStrategiesWorkspace/KylesWork/exampletests/src/main/resources/chromedriver";
	public static String pathToChromeDriver = System.getProperty("user.dir") + "/src/test/resources/chromedriver";
}

package tests2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
	Properties properties;
	String path = "C:\\Users\\richatiwari\\eclipse-workspace\\GmailAutomation\\src\\test\\java\\tests2\\Config.properties";
	
	public ReadConfigFile()
	{
		properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public String getURL()
	{
		String url = properties.getProperty("url");
		if(url!=null)
			return url;
		else
			throw new RuntimeException("url not specified in config file");
	}
	public String getProdName()
	{
		String prodName = properties.getProperty("prodName");
		if(prodName!=null)
			return prodName;
		else
			throw new RuntimeException("Product Name not specified in config file");
	}
	public String getProdUrl()
	{
		String prodUrl = properties.getProperty("prodUrl");
		if(prodUrl!=null)
			return prodUrl;
		else
			throw new RuntimeException("Product URL not specified in config file");
	}
	public String getEmail()
	{
		String email = properties.getProperty("email");
		if(email!=null)
			return email;
		else
			throw new RuntimeException("Email not specified in config file");
	}
	public String getPassword()
	{
		String password = properties.getProperty("password");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("Password not specified in config file");
	}
	public String getPincode()
	{
		String pincode = properties.getProperty("pincode");
		if(pincode!=null)
			return pincode;
		else
			throw new RuntimeException("Pincode not specified in config file");
	}
}

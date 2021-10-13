package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Reading {
	Properties props;
	
	public Reading(){
		File src = new File("./Configuration/Read_config.properties");
		try{
			FileInputStream fis = new FileInputStream(src);
			props = new Properties();
			props.load(fis);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public String getBaseurl(){
		String url = props.getProperty("baseurl");
		return url;
	}
	
	public String getusername(){
		String name = props.getProperty("uname");
		return name;
	}
	
	
	public String getuserpassword(){
		String password = props.getProperty("upassword");
		return password;
	}
	
	public String getChrome(){
		String chrome = props.getProperty("chromepath");
		return chrome;
	}
	
	public String getgecko(){
		String gecko = props.getProperty("geckopath");
		return gecko;
	}
	
	public String getedge(){
		String edge = props.getProperty("edgepath");
		return edge;
	}
	
	

}

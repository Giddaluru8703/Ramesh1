package javaConcepts;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



public class WorkWithProperties {

	public static void main(String args[]) throws Throwable, Throwable{
		Properties prop=new Properties();
		prop.load(new FileReader("src\\test\\java\\javaConcepts\\Global.properties"));
		
		System.out.println(prop.getProperty("baseuri"));
		System.out.println(prop.getProperty("resourceForpost"));
		System.out.println(prop.getProperty("key"));
	}
}

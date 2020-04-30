package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	JsonPath js;
	public static RequestSpecification reqSpec1;
	
	public RequestSpecification requestSpecification() throws IOException{
		if(reqSpec1==null)
		{
		PrintStream log= new PrintStream(new FileOutputStream("logging.txt"));
		 reqSpec1= new RequestSpecBuilder().setBaseUri(GlobalValues("baseUrl")).addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON)
		.addFilter(RequestLoggingFilter.logRequestTo(log))
		.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		 return reqSpec1;
	}
		else
			return reqSpec1;
	}
	public static String GlobalValues(String Key) throws IOException{
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream("D:\\Aparna Selenium\\Selenium Practice\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(Key);
		
	}
	
	public String JsonParser(Response response, String key){
		
		
		js= new JsonPath(response.asString());
		return js.get(key).toString();
	
		
	}
}

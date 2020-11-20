package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.Utils;

public class StepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	static String place_id;
	APIResources resourceAPI;
	String strURI;
	

@Given("get FXRatesAPI")
public void get_FXRatesAPI() throws IOException
{
	res= given().spec(requestSpecification());
}
@When("user calls {string} with http request")
public void user_calls_with_http_request(String Uri)
{
	//resourceAPI=APIResources.valueOf(Uri);
	this.strURI = Uri;
	//System.out.println("url is ==>"+resourceAPI.getResource());
	
	resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

}
@Then("the API call got success with status code {int}")
public void the_API_call_got_success_with_status_code(Integer int1) {
	//response =res.when().get(resourceAPI.getResource());
	response =res.when().get(strURI);
	System.out.println("body is =="+response.getBody().asString());
    // Write code here that turns the phrase above into concrete actions
	assertEquals(response.getStatusCode(),200);
	

}

@Then("{string} in response body is {string}")
public void in_response_body_is(String base, String Expectedbasevalue) {
    // Write code here that turns the phrase above into concrete actions
  System.out.println("base =="+base);
 assertEquals(getJsonPath(response,base),Expectedbasevalue);
}
	
	}

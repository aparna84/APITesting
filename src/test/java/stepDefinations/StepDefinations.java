package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.testng.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.UpdatePlace;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinations extends Utils {
	RequestSpecification reqSpec2;
	ResponseSpecification respSpec;
	Response response;
	String newAddress="70 Hyd walk, USA";
	TestDataBuild addPlaceData= new TestDataBuild();
	static private String place_id = "";
	

	@Given("Add Place Payload with {string} {string} {string}")
	public void add_Place_Payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		//RequestSpecification reqSpec1= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		//.setContentType(ContentType.JSON).build();			
		 
		reqSpec2= given().spec(requestSpecification()).body(addPlaceData.AddPlacePayLoad(name, language, address));
		
	}

	@When("user calls {string} with {string} Http request")
	public void user_calls_with_Http_request(String resource, String method) {
		System.out.println("Enter into user_calls_with_Http_request");
	    // Write code here that turns the phrase above into concrete actions
		respSpec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		APIResources getResource=APIResources.valueOf(resource);
		System.out.println(getResource);
		System.out.println(getResource.getAPIResourse());
		
		
		if(method.equalsIgnoreCase("POST"))
				{
		
		 response=reqSpec2.when().post(getResource.getAPIResourse());
				
				}
		else if(method.equalsIgnoreCase("Put"))
				{
			response= reqSpec2.when().put(getResource.getAPIResourse());					
			
				}
		else if(method.equalsIgnoreCase("get"))
		{
	response= reqSpec2.when().get(getResource.getAPIResourse());					
	
		}
		else{
			response= reqSpec2.when().delete(getResource.getAPIResourse());
		}
		System.out.println("End the method user_calls_with_Http_request");
	}
	
	@Then("the API call is successful with status code {int}")
	public void the_API_call_is_successful_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		
		/*Response responseL = response.then().log().all().spec(respSpec).extract().response();
		System.out.println("This is Staus code block---->"+responseL);
		System.out.println("esponse.asString(); ===========>"+responseL.asString());
 		String responseString=responseL.asString();
 		
 		System.out.println("the_API_call_is_successful_with_status_code==>"+responseString);*/
		assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String RespStatus, String Expvalue) {
		System.out.println("Enter into in_response_body_is");
		
		
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("in_response_body_is=======>"+response.asString());
		assertEquals(JsonParser(response,RespStatus),Expvalue);
		
		System.out.println("End the method in_response_body_is");
	}

	/*@Given("Update Place Payload")
	public void update_Place_Payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		UpdatePlace updatebody= new UpdatePlace();
		updatebody.setAddress("70 Hyd walk, USA");
		updatebody.setPlace_id("9539443d151759385ea2f6bedf819c72");
		updatebody.setKey("qaclick123");
		System.out.println("Enter into update_Place_Payload_with");
		
		 reqSpec2= given().log().all().spec(requestSpecification().queryParam("place_id", place_id))
		.body(updatebody);
		 System.out.println("End of the method update_Place_Payload_with");
	}
*/
	
	
	/*@Given("Update Place Payload with {string} {string} {string}")
	public void update_Place_Payload_with(String place_id, String address, String key) throws IOException {
		    // Write code here that turns the phrase above into concrete actions
			UpdatePlace updatebody= new UpdatePlace();
			updatebody.setAddress("70 Hyd walk, USA");
			updatebody.setPlace_id(place_id);
			updatebody.setKey("qaclick123");
			
			//RequestSpecification reqSpec1=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").build();			
			
			System.out.println("Enter into update_Place_Payload_with");
			
			 reqSpec2= given().log().all().spec(requestSpecification().queryParam("place_id", place_id))
			.body(addPlaceData.UpdatePayload(place_id, address, key));
			 System.out.println("End of the method update_Place_Payload_with");
				}
		*/
		/*@When("user calls {string} with put Http request")
		public void user_calls_with_put_Http_request(String string) {
		    // Write code here that turns the phrase above into concrete actions
			respSpec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			 response= reqSpec2.when().put("/maps/api/place/update/json")
					.then().spec(respSpec).extract().response();
					JsonPath js= new JsonPath(response.asString());
					assertEquals(js.get("msg"),"Address successfully updated");
		}*/
		
		
	@Given("Delete Place Payload")
	public void delete_Place_Payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Enter into method get_Place_Payload");
		
		System.out.println("get_Place_Payload-->place_id:: "+place_id);
		 reqSpec2 =given().log().all().spec(requestSpecification()).body(addPlaceData.DeletePlacePayload(place_id));
		 System.out.println("End of the method get_Place_Payload");
	}
		
		@Then("retrieving {string}")
		public void retrieving(String string) {
		    // Write code here that turns the phrase above into concrete actions
			if(response != null && response.asString().contains("place_id")){
				place_id=JsonParser(response,"place_id");
				System.out.println("place id-->"+place_id);
			}
			
		}
		
		@Then("verify place Id created maps to {string} using with {string}")
		public void verify_place_Id_created_maps_to_using_with(String Expectedname, String resource) throws IOException {
		    // Write code here that turns the phrase above into concrete actions
			place_id=JsonParser(response,"place_id");
			 reqSpec2 =given().log().all().spec(requestSpecification()).queryParam("place_id", place_id);
			 user_calls_with_Http_request(resource,"Get");
			 String actualname=JsonParser(response, "name");
			 assertEquals(actualname,Expectedname);
			 
		
		}

		/*@When("user calls {string} with get Http request")
		public void user_calls_with_get_Http_request(String string) {
		    // Write code here that turns the phrase above into concrete actions
			 respSpec=new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
			 response=reqSpec2.when().get("/maps/api/place/get/json")
					.then().spec(respSpec).extract().response();
					
					JsonPath js1= new JsonPath(response.asString());
					String ActualAddress=js1.getString("address");
					System.out.println(ActualAddress);
					Assert.assertEquals(newAddress, ActualAddress);	
							
		}*/
}

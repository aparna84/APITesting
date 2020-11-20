package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{		//execute this code only when place id is null
		//write a code that will give you place id
		
		StepDefination m =new StepDefination();
		if(StepDefination.place_id==null)
		{
		
		m.get_FXRatesAPI();
		m.user_calls_with_http_request("/api/2020-05-08");
		m.the_API_call_got_success_with_status_code(200);
		m.in_response_body_is("EUR",  "EUR");
		}
		
		

	}
}

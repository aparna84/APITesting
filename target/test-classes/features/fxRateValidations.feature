Feature: Validate foreign exchange rates for positive

Scenario Outline: Verify rates for latest and past dated foreign exchange rates
	Given get FXRatesAPI
	When user calls "<Uri>" with http request
	Then the API call got success with status code 200
	And "<base>" in response body is "<Expectedbasevalue>"
	
	@Regression

    Examples: Positive scenarios
    |Uri            |base  |Expectedbasevalue|
    |/api/latest    |base  |EUR      |
    |/api/2020-05-08|base  |EUR      |
    |/api/2010-01-14|base  |EUR      | 

Scenario Outline: Verify rates for latest and past dated foreign exchange rates
	Given get FXRatesAPI
	When user calls "<Uri>" with http request
	Then the API call got success with status code 200
	And "<base>" in response body is "<Expectedbasevalue>"
	
	@Regression

    Examples: Negative scenarios
    |Uri            |base  |Expectedbasevalue|
    |/api/    		|base  |EUR      |
    |/api/2020-02-30|base  |EUR      |
    |/api/20100114	|base  |EUR      | 
    |/api/2022-01-01|base  |EUR      | 
    |/api/2010-01-14|base  |INR      | 


	
	
	
	
	
	

	
	
	
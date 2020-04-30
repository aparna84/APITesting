Feature: Validating All Place API's
@AddPlace @Regression
Scenario Outline: Verify if place is being successsfully added using AddPlace API

	Given Add Place Payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "POST" Http request
	Then the API call is successful with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place Id created maps to "<name>" using with "GetPlaceAPI"
#	And verify retrieving place id and sending to "UpdatePlaceAPI"
	
Examples: 
	|name		|language	|address	|
	|new name	|English	|Hyd		|
@DeletePlace @Regression
Scenario: Verify if details deleted successfully using DeletePlaceAPI
	Given Delete Place Payload
	When user calls "DeletePlaceAPI" with "Post" Http request
	Then the API call is successful with status code 200
	#And "status" in response body is "OK"
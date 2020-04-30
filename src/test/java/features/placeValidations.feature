Feature: Validating Place API's

Scenario Outline: Verify if place is being successsfully added using AddPlace API

	Given Add Place Payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "POST" Http request
	Then the API call is successful with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And retrieving "place_id" 

Examples: 
	|name		|language	|address	|
	|new name	|English	|Hyd		|
	#|ABC123		|Telugu		|Telangana	|

#Scenario Outline: Verify if place is being updated successfully using UpdatePlace API
#	Given Update Place Payload with "<place_id>" "<address>" "<key>"
#	When user calls "UpdatePlaceAPI" with "Post" Http request
#	Then the API call is successful with status code 200
#	And "msg" in response body is "Address successfully updated"
	
#Examples: 
#	|place_id						 |address	|key		|
#ss	|9539443d151759385ea2f6bedf819c72|Hyd		|qaclick123	|

Scenario: Verify if place is being updated successfully using UpdatePlace API
	Given Update Place Payload
	When user calls "UpdatePlaceAPI" with "Post" Http request
	Then the API call is successful with status code 200
	And "msg" in response body is "Address successfully updated"
		
		
Scenario: Verify if details being retrieved successfully using getPlace API
	Given Get Place Payload
	When user calls "GetPlaceAPI" with "Get" Http request
	Then the API call is successful with status code 200
	And "address" in response body is "Hyd"
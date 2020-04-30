package resources;

public enum APIResources {
	
	AddPlaceAPI("/maps/api/place/add/json"), 
	UpdatePlaceAPI("/maps/api/place/update/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");

	private  String resource;
	
	APIResources(String dd) {
	
		this.resource = dd;
	}
	
	public String getAPIResourse(){
		return resource;
	}
	}

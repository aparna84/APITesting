package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlaceBody;
import pojo.AddPlaceLocation;
import pojo.UpdatePlace;

public class TestDataBuild {

	public AddPlaceBody AddPlacePayLoad(String name, String language, String address){
		AddPlaceBody bodydata= new AddPlaceBody();
		bodydata.setAccuracy("50");
		bodydata.setName(name);
		bodydata.setPhone_number("(+91) 983 893 3937");
		bodydata.setAddress(address);
		bodydata.setWebsite("http://google.com");
		bodydata.setLanguage(language);
		
		List <String> typesdata=  new ArrayList();
		typesdata.add("shoe park");
		typesdata.add("shop");
		typesdata.add("demo");	
		bodydata.setTypes(typesdata);
		
		AddPlaceLocation location= new AddPlaceLocation();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		
		bodydata.setLocation(location);
		return bodydata;
	}
	public UpdatePlace UpdatePayload(String place_id, String address, String key){
		
		UpdatePlace updatebody= new UpdatePlace();
		updatebody.setAddress(address);
		updatebody.setPlace_id(place_id);
		updatebody.setKey(key);
		return updatebody;
		
	}
	public String DeletePlacePayload(String PlaceId){
		return "{place_id:"+PlaceId+"}";
		
	}
	
}

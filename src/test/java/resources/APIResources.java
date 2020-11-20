package resources;
//enum is special class in java which has collection of constants or  methods
public enum APIResources {
	
	
	getFXRateAPI("/api/2010-01-12"),
	getFXRateLatestAPI("/api/latest");
	
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}

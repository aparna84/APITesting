package pojo;

import java.util.List;

import org.json.simple.JSONObject;

public class FXRates {

		private String base;
		public String getBase() {
			return base;
		}
		public void setBase(String base) {
			this.base = base;
		}
		public List<JSONObject> getRates() {
			return rates;
		}
		public void setRates(List<JSONObject> rates) {
			this.rates = rates;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		private List<JSONObject> rates;
		private String date;
		
		}
		
		
		


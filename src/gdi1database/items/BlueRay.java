package gdi1database.items;

public class BlueRay extends Data {
	
	BlueRay(String key, String artists, String title, int amount, int year) {
		super(key, artists, title, amount, year);
	}

	public String getAdditionalData(){
		StringBuilder report = new StringBuilder();
		report.append(this.amount).append(" minutes (").append(this.year).append("). BlueRay. ASIN ").append(this.key);
		return report.toString();
	}
}

package gdi1database.items;
public class CD extends Data{
	
	CD(String key, String artists, String title, int amount, int year) {
		super(key, artists, title, amount, year);
	}

	public String getAdditionalData(){
		StringBuilder report = new StringBuilder();
		report.append(this.amount).append(" track (").append(this.year).append("). ASIN ").append(this.key);
		return report.toString();
	}
}

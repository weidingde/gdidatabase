package gdi1database.items;

/**
 * CD class with its own getAdditional method
 * 
 *
 */
public class CD extends SpecialData{
	
	CD(String key, String artists, String title, int amount, int year) {
		super(key, artists, title, amount, year);
	}

	public String getAdditionalData(){
		StringBuilder report = new StringBuilder();
		report.append(this.amount).append(" track (").append(this.year).append("). ASIN ").append(this.key);
		return report.toString();
	}
}

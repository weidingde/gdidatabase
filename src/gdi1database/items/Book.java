package gdi1database.items;

/**
 * Book class with its own getAdditional method
 * 
 *
 */
public class Book extends SpecialDatabankObject {
	
	public Book(String key, String artists, String title, int amount, int year) {
		super(key, artists, title, amount, year);
	}

	public String getAdditionalData(){
		StringBuilder report = new StringBuilder();
		report.append(this.amount).append(" pages (").append(this.year).append("). ISBN ").append(this.key);
		return report.toString();
	}
}

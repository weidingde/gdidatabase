package gdi1database.items;

/**
 * DVD class with its own getAdditional method
 * 
 *
 */
public class DVD extends SpecialDatabankObject {

	DVD(String key, String artists, String title, int amount, int year) {
		super(key, artists, title, amount, year);
		// TODO Auto-generated constructor stub
	}

	public String getAdditionalData() {
		StringBuilder report = new StringBuilder();
		report.append(this.amount).append(" minutes (").append(this.year)
				.append("). DVD. ASIN ").append(this.key);
		return report.toString();
	}
}

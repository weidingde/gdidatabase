package gdi1database.items;

/**
 * 
 * this class the base class of Book, BlueRay, CD and DVD. because these four
 * classes have same parameter list and similar implements for all methods in
 * DatabankObjekt
 * 
 */

public abstract class Data extends DatabankObjekt {

	String artists, title;
	int amount, year;

	Data(String key, String artists, String title, int amount, int year) {
		super(key);
		this.artists = artists;
		this.title = title;
		this.amount = amount;
		this.year = year;
	}

	public String getName() {
		return this.title;
	}

	public String getData() {
		StringBuilder report = new StringBuilder();
		report.append(this.artists).append(": ").append(this.title);
		return report.toString();
	}

	public abstract String getAdditionalData();

	public String getKey() {
		return this.key;
	}

	public String toString() {
		StringBuilder report = new StringBuilder();
		report.append(this.getData()).append(". ")
				.append(this.getAdditionalData());
		return report.toString();
	}
}

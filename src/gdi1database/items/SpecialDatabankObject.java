package gdi1database.items;

/**
 * 
 * This class is the base class of Book, BlueRay, CD and DVD. Because these four
 * classes have same parameter list and similar implements for all methods in
 * DatabankObjekt
 * 
 * @param artists
 *            , title, year: same meaning as word it self
 * @param amout
 *            : is pages of book, duration of CD, DVD and BlueRay
 * 
 */
public abstract class SpecialDatabankObject extends DatabankObjekt {

	String artists, title;
	int amount, year;

	SpecialDatabankObject(String key, String artists, String title, int amount, int year) {
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

	/**
     * will be implemented in subclass, because there are no common 
     * getAdditionalData method for BlueRay, Book, CD and DVD classes.
     */
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

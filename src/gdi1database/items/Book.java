package gdi1database.items;

public class Book extends Data {
	Book(String key, String artists, String title, int amount, int year) {
		super(key, artists, title, amount, year);
	}

	public String getAdditionalData(){
		StringBuilder report = new StringBuilder();
		report.append(this.amount).append(" pages (").append(this.year).append("). ISBN ").append(this.key);
		return report.toString();
	}
}

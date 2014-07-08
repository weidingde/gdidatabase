package gdi1database.items;
public abstract class Data implements DatabaseItem{
	
	String key, artists, title;
	int amount, year;
	
	Data (String key, String artists, String title, int amount, int year){
		this.key = key;
		this.artists = artists;
		this.title = title;
		this.amount = amount;
		this.year = year;
	}
	
	public String getName(){
		return this.title;
	}
	
	public String getData(){
		StringBuilder report = new StringBuilder();
		report.append(this.artists).append(": ").append(this.title);
		return report.toString() ;
	}
	
	public abstract String getAdditionalData();
	
	public String getKey(){
		return this.key;
	}
	
	public String toString(){
		StringBuilder report = new StringBuilder();
		report.append(this.getData()).append(". ").append(this.getAdditionalData());
		return report.toString();
	}
}

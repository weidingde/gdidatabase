package gdi1database;

import java.util.Set;

import gdi1database.items.DatabaseItem;

public class Database<t extends DatabaseItem> implements DatabaseInterface<DatabaseItem>{

	public Database(){
		
	}
	@Override
	public boolean addEntry(DatabaseItem e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntry(DatabaseItem e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dropDatabase() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean entryExists(DatabaseItem e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DatabaseItem getEntry(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

}

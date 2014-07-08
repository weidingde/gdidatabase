package gdi1database;

import java.util.HashMap;
import java.util.Set;

import gdi1database.items.DatabaseItem;

public class Database<T extends DatabaseItem> implements
		DatabaseInterface<DatabaseItem> {

	HashMap<String, DatabaseItem> databank;

	public Database() {
		databank = new HashMap<String, DatabaseItem>();
	}

	@Override
	public boolean addEntry(DatabaseItem e) {
		// make sure that data bank doesn't have this data and its key has not
		// been used
		if (!databank.containsValue(e) && !databank.containsKey(e.getKey())) {
			databank.put(e.getKey(), e);
			return true;
		} else
			return false;
	}

	@Override
	public boolean deleteEntry(DatabaseItem e) {
		// make sure that exactly e were deleted
		if (databank.remove(e.getKey()) == e) {
			return true;
		} else
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

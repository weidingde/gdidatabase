package gdi1database;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import gdi1database.items.DatabaseItem;

public class Database<T extends DatabaseItem> implements
		DatabaseInterface<DatabaseItem> {

	HashMap<String, DatabaseItem> databank;// the databank

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
		// make sure that exactly data e were deleted
		if (databank.remove(e.getKey()) == e) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean dropDatabase() {
		databank.clear();
		if (databank.isEmpty()) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean entryExists(DatabaseItem e) {
		if (databank.containsValue(e)) {
			return true;
		} else
			return false;
	}

	@Override
	public DatabaseItem getEntry(String key) {
		return databank.get(key);
	}

	@Override
	public Set<String> getKeys() {
		return databank.keySet();
	}

	@Override
	public int getSize() {
		return databank.size();
	}

	@Override
	public String toString() {
		if (databank == null) {
			// this will never happen, because databank can't be null, it will
			// be
			// initialized when this class is initialized
			System.out.print("<<database is null>>");
			return null;
		} else if (databank.isEmpty()) {
			System.out.print("<<database is empty>>");
			return null;
		} else {
			// sort the data bank at first
			this.tidyDatabank();
			Collection<DatabaseItem> allData = databank.values();
			StringBuilder report = new StringBuilder();
			for (DatabaseItem e : allData) {
				report.append(e.toString()).append("\n");
			}
			return report.toString();
		}
	}

	// sort all data in databank by their keys
	private void tidyDatabank() {
		// get all keys, which is going to be sorted
		String[] keys = (String[]) databank.keySet().toArray();
		// use a new data bank to store sorted data
		HashMap<String, DatabaseItem> tidyDB = new HashMap<String, DatabaseItem>();
		Arrays.sort(keys);// sort keys
		// construct the sorted data bank
		for (String k : keys) {
			tidyDB.put(k, databank.get(k));
		}
		// in the end replace the old data bank with new, sorted data bank
		databank = tidyDB;
	}
}

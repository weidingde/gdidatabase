package gdi1database;

import gdi1database.items.DatabaseItem;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;


/**
 * 
 * Implementation of all basic function of a data bank including add, delete,
 * erase whole data bank, check for existent, get a value get all keys, get all
 * values and get size.
 * 
 * @param <T>
 *            is the subclass that implements DatabaseItem
 * 
 */
public class Database<T extends DatabaseItem> implements DatabaseInterface<T> {

	private HashMap<String, T> cacheMap = null;

	public Database() {
		cacheMap = new HashMap<String, T>();
		this.cacheMap.clear();
	}

	public boolean addEntry(T t) {
		boolean flag = false;
		if (!this.cacheMap.containsValue(t)
				&& !this.cacheMap.containsKey(t.getKey())) {
			this.cacheMap.put(t.getKey(), t);
			flag = true;
		}
		return flag;
	}

	public boolean deleteEntry(T t) {
		boolean flag = false;
		if (this.cacheMap.remove(t.getKey()) != null) {
			flag = true;
		}
		return flag;
	}

	public boolean dropDatabase() {
		boolean flag = false;
		try {
			this.cacheMap.clear();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean entryExists(T t) {
		return this.cacheMap.containsValue(t);
	}

	public T getEntry(String key) {
		return this.cacheMap.get(key);
	}

	public Set<String> getKeys() {
		return this.cacheMap.keySet();
	}

	public int getSize() {
		return this.cacheMap.size();
	}

	/***
	 * liefert eine textuelle Repräsentation der Datenbankinhalte.
	 * 
	 * @return String
	 */
	public String toString() {
		if (cacheMap == null) {
			return "<<database is null>>";
		} else if (cacheMap.isEmpty()) {
			return "<<database is empty>>";
		} else {
			/**
			 * this block can sort all keys and return a string that describe
			 * the data, in the order of sorted keys.
			 * 
			 * 
			 */
			// get all keys, which is going to be sorted
			String[] keys = (String[]) cacheMap.keySet().toArray();
			Arrays.sort(keys);// sort keys
			// use a StringBuilder to store the result String
			StringBuilder report = new StringBuilder();
			// generate the report
			for (String k : keys) {
				report.append(this.getEntry(k).toString()).append("\n");
			}
			return report.toString();
		}
	}

	/**
	 * this method is for DatabaseAccess implemented
	 * 
	 * @return all values of data bank
	 */
	public Collection<T> getAll() {
		return cacheMap.values();
	}

}

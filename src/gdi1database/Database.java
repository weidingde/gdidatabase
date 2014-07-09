package gdi1database;

import gdi1database.items.DatabaseItem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Database<T extends DatabaseItem> implements DatabaseInterface<T> {
	
	private HashMap<String, T> cacheMap = new HashMap<String, T>();

	public Database() {
		super();
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
	 * Add by myself, it used to query data easily!
	 * 
	 * @return
	 */
	public Collection<T> getAll() {
		return this.cacheMap.values();
	}

}

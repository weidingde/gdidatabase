/**
 * die eigentliche Datenbank zu realisieren
 * @author Hengwen Zhang, Wei Ding, Julius Friedrich Muth, Cong Chen
 * @version 3.0
 */
package gdi1database;

import gdi1database.items.DatabaseItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
public class Database<T extends DatabaseItem> implements DatabaseInterface<T>,
		DatabaseAccessInterface<T> {

	private HashMap<String, T> cacheMap = null;

	public Database() {
		cacheMap = new HashMap<String, T>();
		this.cacheMap.clear();
	}

	public boolean addEntry(T t) {
		boolean flag = false;
		// make sure that not only the value, also its key has not been used
		// in chacheMap before
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
	@Override
	public String toString() {
		if (cacheMap == null) {
			// this will never happen, because databank can't be null, it will
			// be
			// initialized when this class is initialized
			return "<<database is null>>";

		} else if (cacheMap.isEmpty()) {
			return "<<database is empty>>";
		} else {
			// sort the data bank at first
			this.tidyDatabank();
			Collection<T> allData = cacheMap.values();
			StringBuilder report = new StringBuilder();
			for (DatabaseItem e : allData) {
				report.append(e.toString()).append("\n");
			}
			return report.toString();
		}
	}

	/**
	 * sort all data in cacheMap by their keys
	 * 
	 */
	private void tidyDatabank() {
		// get all keys, which is going to be sorted
		String[] keys =(String[]) cacheMap.keySet().toArray(new String[cacheMap.size()]);
		// use a new data bank to store sorted data
		HashMap<String, T> tidyDB = new HashMap<String, T>();
		Arrays.sort(keys);// sort keys
		// construct the sorted data bank
		for (String k : keys) {
			tidyDB.put(k, cacheMap.get(k));
		}
		// in the end replace the old data bank with new, sorted data bank
		cacheMap = tidyDB;
	}

	/**
	 * this method is for select method implemented
	 * 
	 * @return all values of data bank
	 */
	public Collection<T> getAll() {
		return cacheMap.values();
	}

	/**
	 * Search and return the right data list
	 * 
	 * @param col
	 *            : condition for matching
	 * 
	 * @param str
	 *            : key word for matching
	 * 
	 */
	public List<T> select(DatabaseColumn col, String str) {
		// rows stores the data that match the query condition(String)
		List<T> rows = new ArrayList<T>();
		// list stores all values of data bank
		Collection<T> list = this.getAll();
		try {
			if (col == col.DATA) {
				for (T t : list) {
					String data = t.getData();
					if (data.indexOf(str) != -1) {
						rows.add(t);
					}
				}

			} else if (col == col.NAME) {
				for (T t : list) {
					String name = t.getName();
					if (name.indexOf(str) != -1) {
						rows.add(t);
					}
				}

			} else if (col == col.ADDITIONAL_DATA) {
				for (T t : list) {
					String additionalData = t.getAdditionalData();
					if (additionalData.indexOf(str) != -1) {
						rows.add(t);
					}
				}

			} else if (col == col.KEY) {
				Set<String> keys = this.getKeys();
				for (String keyName : keys) {
					if (keyName.indexOf(str) != -1) {
						T t = this.getEntry(str);
						rows.add(t);
					}
				}

			} else if (col == col.DATA_NAME) {
				for (T t : list) {
					String data = t.getData();
					String name = t.getName();
					if (data.indexOf(str) != -1 || name.indexOf(str) != -1) {
						rows.add(t);
					}
				}

			} else if (col == col.KEY_DATA) {
				for (T t : list) {
					String data = t.getData();
					String key = t.getKey();
					if (data.indexOf(str) != -1 || key.indexOf(str) != -1) {
						rows.add(t);
					}
				}

			} else if (col == col.KEY_DATA_NAME) {
				for (T t : list) {
					String data = t.getData();
					String key = t.getKey();
					String name = t.getName();
					if (data.indexOf(str) != -1 || key.indexOf(str) != -1
							|| name.indexOf(str) != -1) {
						rows.add(t);
					}
				}

			} else if (col == col.ALL) {
				for (T t : list) {
					String data = t.getData();
					String key = t.getKey();
					String name = t.getName();
					String additionalData = t.getAdditionalData();
					if (data.indexOf(str) != -1 || key.indexOf(str) != -1
							|| name.indexOf(str) != -1
							|| additionalData.indexOf(str) != -1) {
						rows.add(t);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rows;
	}

}

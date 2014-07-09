package gdi1database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import gdi1database.items.DatabaseItem;

public class DatabaseAccess<T extends DatabaseItem> implements
		DatabaseAccessInterface<T> {
	private Database<T> db = null;

	public DatabaseAccess(Database<T> db) {
		this.db = db;
	}

	public List<T> select(DatabaseColumn col, String str) {
		List<T> rows = new ArrayList<T>();
		/***
		 *  rows store the data that match the query condition(String) 
		 */
		try {
			if (col == col.DATA) {
				Collection<T> list = this.db.getAll();
				for (T t : list) {
					String data = t.getData();
					if (data.indexOf(str) != -1) {
						rows.add(t);
					}
				}

			} else if (col == col.NAME) {
				Collection<T> list = this.db.getAll();
				for (T t : list) {
					String name = t.getName();
					if (name.indexOf(str) != -1) {
						rows.add(t);
					}
				}

			} else if (col == col.ADDITIONAL_DATA) {
				Collection<T> list = this.db.getAll();
				for (T t : list) {
					String additionalData = t.getAdditionalData();
					if (additionalData.indexOf(str) != -1) {
						rows.add(t);
					}
				}

			} else if (col == col.KEY) {
				Set<String> keys = this.db.getKeys();
				for (String keyName : keys) {
					if (keyName.indexOf(str) != -1) {
						T t = db.getEntry(str);
						rows.add(t);
					}
				}

			} else if (col == col.DATA_NAME) {
				Collection<T> list = this.db.getAll();
				for (T t : list) {
					String data = t.getData();
					String name = t.getName();
					if (data.indexOf(str) != -1 || name.indexOf(str) != -1) {
						rows.add(t);
					}
				}

			} else if (col == col.KEY_DATA) {
				Collection<T> list = this.db.getAll();
				for (T t : list) {
					String data = t.getData();
					String key = t.getKey();
					if (data.indexOf(str) != -1 || key.indexOf(str) != -1) {
						rows.add(t);
					}
				}

			} else if (col == col.KEY_DATA_NAME) {
				Collection<T> list = this.db.getAll();
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
				Collection<T> list = this.db.getAll();
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

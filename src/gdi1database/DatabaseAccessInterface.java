package gdi1database;

import gdi1database.items.DatabaseItem;

import java.util.List;

public interface DatabaseAccessInterface <T extends DatabaseItem> {
	public List<T> select(DatabaseColumn col, String str);
}

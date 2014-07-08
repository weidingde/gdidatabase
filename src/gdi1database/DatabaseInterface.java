package gdi1database;

import gdi1database.items.DatabaseItem;

import java.util.Set;

/**
 * Describes the interface for a (simplified) database implementation.
 *
 * @author Guido R&ouml;&szlig;ling (roessling@acm.org)
 */
public interface DatabaseInterface<T extends DatabaseItem> {

  /**
   * adds a DatabaseItem to the database. Note: entries that already
   * exist will not be added again.
   * 
   * @param e
   *          the DatabaseItem that should be inserted to the database.
   * @return true if DatabaseItem has been successfully inserted to the
   *         database, else false (usually because the value is null or already
   *         existed).
   */
  public boolean addEntry(T e);

  /**
   * deletes the DatabaseItem e if it exists and updates the database
   * 
   * @param e
   *          the DatabaseItem which should be deleted.
   * @return true if the DatabaseItem has been deleted successfully, else
   *         false.
   */
  public boolean deleteEntry(T e);

  /**
   * Drops the database and replaces it with one of size 0
   * 
   * @return true if database has been deleted correctly, else false.
   */
  public boolean dropDatabase();

  /**
   * returns true if an DatabaseItem matching the parameter exists in
   * the database
   * 
   * @param e
   *          the DatabaseItem that should exist.
   * @return true if the DatabaseItem exists inside the database, else
   *         false.
   */
  public boolean entryExists(T e);

  /**
   * returns the element at the chosen position of null if the position is
   * invalid
   * 
   * @param key
   *          the key of the DatabaseItem to be returned.
   * @return the DatabaseItem object at the given position, if any, else
   *         null.
   */
  public T getEntry(String key);

  /**
   * returns the keys for all elements in this database
   * 
   * @return the set of (String) keys for all elements in this database
   */
  public Set<String> getKeys();
  
  /**
   * returns the size of this database
   * 
   * @return the size of this database.
   */
  public int getSize();
}

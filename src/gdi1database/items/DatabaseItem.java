package gdi1database.items;

/**
 * describes the interface for an arbitrary database item
 * that can be described by its name, data, key, and "additional data".
 *
 * @author Guido R&ouml;&szlig;ling (roessling@acm.org)
 */
public interface DatabaseItem {

  /**
   * returns the name of the database item
   *
   * @return the name of the database item
   */
  public String getName();
  
  /**
   * returns the main data of the database item
   *
   * @return the data of the database item
   */
  public String getData();
  
  /**
   * returns additional data for the database item
   *
   * @return the additional data for the database item
   */
  public String getAdditionalData();
  
  /**
   * returns the key of the database item
   *
   * @return the key of the database item
   */
  public String getKey();
}

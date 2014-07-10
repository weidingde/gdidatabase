/**
 * creat the Oberklasse
 * @author Hengwen Zhang, Wei Ding, Julius Friedrich Muth, Cong Chen
 * @version 2.0
 */
package gdi1database.items;

/**
 * 
 * base class of all data bank objects
 *
 */
public abstract class DatabankObjekt implements DatabaseItem{
	
	String key;
	
	public DatabankObjekt(String key) {
		this.key=key;
	}

	@Override
	abstract public String getName();

	@Override
	abstract public String getData();

	@Override
	abstract public String getAdditionalData();

	@Override
	abstract public String getKey();
	
}

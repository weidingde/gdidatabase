package gdi1database;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import gdi1database.items.*;

/**
 * test some operations of our data bank
 * 
 * 
 */
public class Run {

	public static void main(String[] args) {
		// initialize 2 data bank objects
		Book book1 = new Book("9785353003083", "J.K. Rowling",
				"Harry Potter and the Philosopher's Stone", 189, 2003);
		CD cd1 = new CD("0602498669105", "Thirteen Senses", "The Invitation",
				12, 2004);

		Database testDB = new Database<>();
		testDB.addEntry(book1);
		testDB.deleteEntry(book1);

		testDB.addEntry(cd1);
		testDB.dropDatabase();

		testDB.addEntry(cd1);
		testDB.addEntry(book1);
		if (testDB.entryExists(book1)) {
			System.out.println("book1 ist schoen drin. Information:");
			System.out.println(testDB.getEntry(book1.getKey()).toString());
		} else
			System.out.println("book1 ist noch nicht drin");

		// test getKeys method
		String[] keys = (String[]) testDB.getKeys().toArray(
				new String[testDB.getSize()]);
		System.out.print("\nKeys are:");
		for (String k : keys) {
			System.out.print(k);
			System.out.print(" ");
		}
		System.out.println("\n");

		// test select method
		List list1 = testDB.select(DatabaseColumn.ALL, "200");
		for (int i = 0; i < list1.size(); i++) {
			System.out.println("No." + (i + 1) + " item has been found is: "
					+ list1.get(i).toString());
		}
		// test toString and get size
		System.out.println("\n" + testDB.getSize() + " datas are:" + "\n"
				+ testDB.toString());
	}

}

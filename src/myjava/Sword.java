/**
 * 
 */
package myjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 *
 */
public class Sword {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List list = Arrays
				.asList(new Object[][] { { 1 }, { 3 }, { 6 }});
		System.out.println(list);
		
		List ids = new ArrayList<Object>();
		ids.add(new Object[]{1});
		ids.add(new Object[]{3});
		ids.add(new Object[]{6});
		System.out.println(ids);
		
		
		System.err.println(Arrays.asList("Larry", "Moe", "Curly"));

	}

}

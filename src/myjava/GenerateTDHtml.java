/**
 * GenerateTDHtml.java
 */
package myjava;

import java.io.File;
import java.io.FileFilter;

/**
 * @author jack 2016年8月31日 下午10:42:00
 */
public class GenerateTDHtml {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File(".");
		File[] files = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName()
		                       .endsWith(".html")
		                && pathname.getName()
		                           .startsWith("0");
			}
		});
		
		String result = "";
		int index = 25;
		
		for (File f : files) {
			String name = f.getName();
			System.out.println(name); // 00026_100个伟大的商业理念.html
			String bookName = name.substring(name.indexOf("_") + 1,
			                                 name.lastIndexOf(".html"));
			
			result += "<tr><td>" + index + "</td>" + "<td><a href=\"epubjs/html/" + name + "\">" + bookName
			        + "</a></td></tr>" + "\n";
			
			index++;
			
		}
		
		System.out.println(result);
		
	}
	
}

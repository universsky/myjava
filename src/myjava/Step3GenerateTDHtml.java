/**
 * GenerateTDHtml.java
 */
package myjava;

import java.io.File;
import java.io.FileFilter;

/**
 * @author jack 2016年8月31日 下午10:42:00
 */
public class Step3GenerateTDHtml {
	
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
		                && !pathname.getName().endsWith("template.html");
			}
		});
		
		String result = "";
		
		int index = Contant.START_INDEX;
		
		for (File f : files) {
			String name = f.getName();
			//System.out.println(name); // name = 00026_100个伟大的商业理念.html
			String bookName = name.substring(name.indexOf("_") + 1,
			                                 name.lastIndexOf(".html"));
			
			result += "<tr><td>" + index + "</td>" + "<td><a href=\"epubjs/html/" + name + "\">" + bookName
			        + "</a></td></tr>" + "\n";
			
			index++;
			
		}
		
		System.out.println(result);
		
	}
	
}

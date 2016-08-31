/**
 * RenameFiles.java
 */
package myjava;

import java.io.File;
import java.io.FileFilter;

/**
 * @author jack 2016年8月31日 下午2:52:36
 */
public class RenameFiles {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String pathname = "/Users/jack/epub";
		File file = new File(pathname);
		File[] files = file.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				return pathname.getName()
		                       .endsWith(".epub");
			}
		});
		int startIndex = 25;
		for (File f : files) {
			String name = f.getName();
			
			String startIndexStr = fillZero(5,
			                                startIndex + "");
			String prefix = startIndexStr + "_";
			name = prefix + name;
			System.out.println(name);
			
			File newfile = new File("/Users/jack/epub/" + name);
			f.renameTo(newfile);
			
			startIndex++;
		}
		
	}
	
	public static String fillZero(int width, String src) {
		
		int length = src.length();
		if (width <= length)
			return src;
		
		int fillZeros = width - length;
		for (int i = 0; i < fillZeros; i++) {
			src = "0" + src;
		}
		return src;
		
	}
	
}

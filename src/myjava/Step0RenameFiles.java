/**
 * RenameFiles.java
 */
package myjava;

import java.io.File;
import java.io.FileFilter;

/**
 * @author jack 2016年8月31日 下午2:52:36
 */
public class Step0RenameFiles {
	
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
		for (File f : files) {
			String name = f.getName();
			System.out.println(name);
			
//			name = name.substring(name.indexOf("_") + 1);
//			System.out.println(name);
//			
//			File newfile = new File("/Users/jack/epub/" + name);
//			f.renameTo(newfile);
			
		}
		
	}
	
	
}

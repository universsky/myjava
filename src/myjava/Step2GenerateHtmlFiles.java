/**
 * GenerateHtmlFiles.java
 */
package myjava;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

/**
 * @author jack
 * 2016年8月31日 下午10:21:47
 */
public class Step2GenerateHtmlFiles {
	
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
		    
		    String epubBookPath = name;
		    String htmlName = name.replace(".epub", ".html");

		    String srcFile = "template.html";
	        String toFile = htmlName;
	        try {
	            String result = read(srcFile,epubBookPath);
	            write(result, toFile);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		    
		}
		
	}
	
	
	private static String read(String srcFile, String epubBookPath) throws FileNotFoundException {
		 
        Scanner in = new Scanner(new File(srcFile));
        String result = "";
 
        while (in.hasNextLine()) {
        	String line = in.nextLine();
        	if(line.contains("{{EPUB_NAME}}")){
        		line = line.replace("{{EPUB_NAME}}", epubBookPath);
        	}
        	
            result += line + "\r\n";
        }
 
        in.close();
 
        return result;
    }
 
    private static void write(String result, String toFile) throws Exception {
 
        Writer w = new FileWriter(new File(toFile));
 
        w.write(result);
        w.flush();
        w.close();
    }
}
	


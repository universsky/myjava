/**
 * GenerateHtmlFiles.java
 */
package myjava.addbaidutongji;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

/**
 * @author jack 2016年8月31日 下午10:21:47
 */
public class GenerateHtmlFiles {

    /**
     * @param args
     */
    public static void main(String[] args) {
	
	String oldPath = "/Users/jack/ehtmls";
	String newPath = "/Users/jack/blog/cc/universsky.github.io/epubjs/html/"; 
	copyFolderFiles(oldPath, newPath);
	
//	String pathname = "/Users/jack/blog/cc/universsky.github.io/epubjs/books";
//	File file = new File(pathname);
//	File[] files = file.listFiles(new FileFilter() {
//
//	    @Override
//	    public boolean accept(File pathname) {
//		return pathname.getName().endsWith(".epub");
//	    }
//	});
//	for (File f : files) {
//	    String name = f.getName();
//	    //System.out.println(name);
//
//	    String epubBookPath = name;
//	    String htmlName = name.replace(".epub", ".html");
//
//	    String srcFile = "template.html";
//	    String toFile = "/Users/jack/ehtmls/" + htmlName;
//	    try {
//		String result = read(srcFile, epubBookPath);
//		write(result, toFile);
//	    } catch (Exception e) {
//		e.printStackTrace();
//	    }
//
//	}

    }

    private static String read(String srcFile, String epubBookPath) throws FileNotFoundException {

	System.out.println(epubBookPath);
	
	Scanner in = new Scanner(new File(srcFile));
	String result = "";

	while (in.hasNextLine()) {
	    String line = in.nextLine();
	    if (line.contains("{{EPUB_NAME}}")) {
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
    
    
    /**
     * 拷贝A目录下面所有文件到B目录
     */
    
    public static void copyFolderFiles(String oldPath, String newPath){
	try{
	    (new File(newPath)).mkdirs();
	    File oldFile = new File(oldPath);
	    String[] file = oldFile.list();
	    File temp = null;
	    for(int i=0; i < file.length; i++){
		if(oldPath.endsWith(File.separator)){
		    temp = new File(oldFile + file[i]);
		} else{
		    temp = new File(oldFile + File.separator + file[i]);
		}
		System.out.println(temp);
		if(temp.isFile()){
		    FileInputStream inputStream = new FileInputStream(temp);
		    FileOutputStream outputStream = new FileOutputStream(newPath + "/" + (temp.getName().toString()));
		    byte[] b = new byte[1024*5];
		    int len;
		    while ( ( len=inputStream.read(b)) !=-1) {
			outputStream.write(b,0,len);
		    }
		    outputStream.flush();
		    outputStream.close();
		    inputStream.close();
		}
		
		if(temp.isDirectory()){
		    copyFolderFiles(oldPath + "/" + file[i], newPath + "/" + file[i]);
		}
		
		
	    }
	    
	}catch(Exception e){
	    System.err.println("复制文件夹出错:");
	    e.printStackTrace();
	    
	}
    }
    
    
    
    
}

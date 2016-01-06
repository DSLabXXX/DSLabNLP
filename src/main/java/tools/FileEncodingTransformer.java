package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileEncodingTransformer {

	public static String transform(String inputPath, String inputEncoding, String outputPath, String outputEncoding) throws IOException{
		
		
		FileInputStream fis = new FileInputStream(new File(inputPath));
	    BufferedReader br =new BufferedReader(new InputStreamReader(fis, inputEncoding));
		
		FileOutputStream fos = new FileOutputStream(new File(outputPath));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, outputEncoding));
	    
		String line;
		while((line=br.readLine())!=null){
			
			System.out.println(line);
			bw.write(line+"\n");
			
		}
		
		fis.close();
		br.close();
	
		bw.close();
		fos.close();
		
		return "";
	}
	
	public static void main(String[] args) {
		
		String inputPath = "./news/結婚30年 蔡正元去年4月離婚.txt";
		String outputPath = "./news_utf8/結婚30年 蔡正元去年4月離婚.txt";
		
		try {
			FileEncodingTransformer.transform(inputPath, "utf-8", outputPath, "utf-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
	
}

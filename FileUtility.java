import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class FileUtility {
	public static boolean createFile(String fileNameWithPath) {
		boolean fileCreated=false;
		File file=new File(fileNameWithPath);
		try {
			fileCreated=file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileCreated;
	}
	public static ArrayList<String> readFileAsList(String filename) throws Exception {
		Scanner scanner=null;
		ArrayList<String> strings=new ArrayList<String>();
		try {
			File file = new File(filename);
			scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
			String line=scanner.nextLine();
			strings.add(line);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(scanner != null) {
				scanner.close();
			}
		}
		return strings;
//		BufferedReader br = new BufferedReader(new FileReader(filename));
//		try {
//			StringBuilder sb = new StringBuilder();
//			String line=br.readLine();
//			while(line != null) {
//				sb.append(line);
//				sb.append("\n");
//				if(line != null) {
//				System.out.println(line);}
//				line=br.readLine();
//			}
//			String everything=sb.toString();
//		}
//		finally {
//			br.close();
//		}
	}
	public static boolean writeToFile(String fileNameWithPath,String content) {
//		File file=new File(fileNameWithPath);
//		FileWriter fw = new FileWriter(file.getAbsoluteFile());
//		BufferedWriter bw = new BufferedWriter(fw);
		BufferedWriter bw1=null;
		try {
			File file1=new File(fileNameWithPath);
			if(!file1.exists()) {
				file1.createNewFile();
			}
			FileWriter fw1 = new FileWriter(file1.getAbsoluteFile());
			bw1 = new BufferedWriter(fw1);
			bw1.write(content);
		} catch (IOException e) {
			return false;
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
		finally{
			if(bw1!=null)
				try {
					bw1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return true;
	}
	public static boolean appendtofile(String fileName,String content) {
		try {
			FileWriter filewriter=new FileWriter(fileName,true);
			filewriter.append("\n");
			filewriter.append(content);
			filewriter.close();
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		System.out.println("RUNNING FILE UTILITY AT "+new Date().toString());
		String nameofnewfile="C:\\Users\\aksha\\eclipse-workspace\\TopKeywordsAnalyser\\data\\practise\\file\\"+"create-file1.txt";
		Boolean created= createFile(nameofnewfile);
		System.out.println("FILE CREATED: "+ created);
//		try {
//			readAndPrintFile(nameofnewfile);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ArrayList<String> stringArrayList = readFileAsList(nameofnewfile);
		for(String row:stringArrayList) {
			System.out.println("LINE: "+row);
		}
		System.out.println("NO. OF LINES IN FILE: "+stringArrayList.size());
		String nameofwritefile="C:\\Users\\aksha\\eclipse-workspace\\TopKeywordsAnalyser\\data\\practise\\file\\"+"write-file1.txt";
		boolean wroteToFile = writeToFile(nameofwritefile,"THIS LINE IS WRITTEN BY BUFFERED WRITER.");
		System.out.println(wroteToFile);
		for(int i=1;i<=100;i++) {
			String data=i+"";//to convert into string we passed or added double quotes.
			appendtofile(nameofwritefile,data);
		}
		//TO DELETE A FILE.
		//File file = new File("FILENAME WITH PATH");
		//file.delete();
		System.out.println("APPENDED FILE LENGTH "+readFileAsList(nameofwritefile).size());
}

	
}

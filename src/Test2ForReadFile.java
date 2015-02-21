import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Test2ForReadFile {
	
	public static void main(String[] args) {
		
		System.out.println("reading process starts");
		
		File inputFile = null;
		
		//initalize the inputFile
		inputFile = new File(Test2ForReadFile.class.getClassLoader().getResource("textFile.txt").getFile());
		
//		inputFile = new File(Main4.class.getClassLoader().getResource("textFile.txt").getPath());

		System.out.println("getPath is:" + inputFile.getPath());
		System.out.println("getAbsolutePath is:" + inputFile.getAbsolutePath());
		
		BufferedReader br = null;
		
		try{
			
			//initalize the FileInputStream
			FileInputStream fileInputStream = new FileInputStream(inputFile);
			
			
			//initalize the InputStreamReader
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			
			//initalize the BufferedReader
			br = new BufferedReader(inputStreamReader);
			
			String line = null;
			
			int count = 1;
			
			while((line = br.readLine()) != null){
				
				String [] splits = line.split(" ");
				
				System.out.print("the "+count+" line is:");
				
				for(String str:splits){
					System.out.print(str+" ");
				}
				
				System.out.println();
			}
			
			br.close();
			
		}
		
		
		catch(Exception e){
			
			e.printStackTrace();
		
		}
		
		
		System.out.println("reading process ends");
		
	}
	
	
}

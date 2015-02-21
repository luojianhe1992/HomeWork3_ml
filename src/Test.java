import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;



//reading file method2
public class Test {
	

	public static void main(String [] args){
		
		System.out.println("the reading process starts");
		
		String inputFile = "resources/9Cat-Train.labeled";
		
		try{
			
			FileReader fileReader = new FileReader(inputFile);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line = null;
			
			int count = 1;
			
			while((line = bufferedReader.readLine())!=null){
				String [] splits = line.split(" ");
				
				System.out.print("the "+count+" line is: ");
				
				for(String str:splits){
					
					System.out.print(str+" ");
				}
				
				System.out.println();
				
				count++;
			}
			
			bufferedReader.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("the reading process ends");
		
		
		
		
		
		
	}
	
	
	
	
	
}	

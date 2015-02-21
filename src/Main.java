import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

//reading file method2
public class Main {
	
	
	public static void main(String [] args){
		
		//the path of input file
		String inputFile = "resources/9Cat-Train.labeled";
		
		try{
			InputStream inputStream = new FileInputStream(inputFile);
			
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			String line = null;
			
			int count = 1;
			
			while((line = bufferedReader.readLine())!=null){
				
				String [] split = line.split(" ");
				
				System.out.print("the "+count+" line is: ");
				
				for(String str:split){
					System.out.print(str + "\t");
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

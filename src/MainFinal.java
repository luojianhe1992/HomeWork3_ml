import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainFinal {
	public static void main(String[] args) {
		
		System.out.println("read process starts");
		
		String inputFilePath = "9Cat-Train.labeled";
		
		File inputFile = new File(MainFinal.class.getClassLoader().getResource(inputFilePath).getFile());
		
		System.out.println("the relative path is:"+inputFile.getPath());
		
		System.out.println("the absolute path is:"+inputFile.getAbsolutePath());
		
		List<String[]> result = new ArrayList<String []>();
		
		BufferedReader br = null;
		
		int attributeAmount = 0;
		
		//use hash map to store the training data
		Map<String, String> trainingData = new HashMap<String, String>();
		
		//
		Map<int [], Integer> traingDateInteger = new HashMap<int[], Integer>();
		
		try{
			FileInputStream fileInputStream = new FileInputStream(inputFile);
			
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			
			br = new BufferedReader(inputStreamReader);
			
			String line = null;
			
			while((line = br.readLine()) != null){
				
				String [] splits = line.split("\t");
				
				attributeAmount = splits.length - 1;
				
				//
				String attribute = "";
				String label = splits[splits.length - 1].split(" ")[1];
				
				for(int i=0;i<attributeAmount - 1;i++){
					attribute = attribute + splits[i].split(" ")[1]+" ";
				}
				
				attribute = attribute + splits[attributeAmount - 1].split(" ")[1];
				
				
				
				/*
				
				//
				int [] attributeIntArray = new int [splits.length - 1];
				int lableInt;
				
				if(splits[0].split(" ")[1].equals("Male")){
					attributeIntArray[0] = 1;
				}
				else{
					attributeIntArray[0] = -1;
				}
				
				if(splits[1].split(" ")[1].equals("Young")){
					attributeIntArray[0] = 1;
				}
				else{
					attributeIntArray[0] = -1;
				}
				
				if(splits[2].split(" ")[1].equals("Yes")){
					attributeIntArray[0] = 1;
				}
				else{
					attributeIntArray[0] = -1;
				}
				
				if(splits[3].split(" ")[1].equals("Yes")){
					attributeIntArray[0] = 1;
				}
				else{
					attributeIntArray[0] = -1;
				}
				
				if(splits[4].split(" ")[1].equals("Long")){
					attributeIntArray[0] = 1;
				}
				else{
					attributeIntArray[0] = -1;
				}
				
				if(splits[5].split(" ")[1].equals("Yes")){
					attributeIntArray[0] = 1;
				}
				else{
					attributeIntArray[0] = -1;
				}
				
				if(splits[6].split(" ")[1].equals("House")){
					attributeIntArray[0] = 1;
				}
				else{
					attributeIntArray[0] = -1;
				}
				
				if(splits[7].split(" ")[1].equals("Yes")){
					attributeIntArray[0] = 1;
				}
				else{
					attributeIntArray[0] = -1;
				}
				
				if(splits[8].split(" ")[1].equals("Yes")){
					attributeIntArray[0] = 1;
				}
				else{
					attributeIntArray[0] = -1;
				}
				
				if(splits[9].split(" ")[1].equals("high")){
					lableInt = 1;
				}
				else{
					lableInt = -1;
				}
				
				*/
				
				//
				trainingData.put(attribute, label);

				//
//				traingDateInteger.put(attributeIntArray, lableInt);
				
				//
				result.add(splits);
				
				for(String str:splits){
					System.out.print(str + " ");
				}
				
				System.out.println();
				
			}
			
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("read process ends");
		
		System.out.println();
		
		
		System.out.println("**********************");
		
		System.out.println("total length file is:"+result.size());
		
		/*
		for(int i=0;i<result.size();i++){
			System.out.println("each length :" + result.get(i).length);
			
		}
		
		System.out.println();
		
		for(String str:result.get(0)){
			System.out.println(str+",");
		}
		
		*/
		
		System.out.println("**********************");
		
		System.out.println("training data:"+trainingData);
		
		System.out.println("length of trainingData:"+trainingData.size());
		
		int sizeConcept = (int) Math.pow(2, Math.pow(2, 9));
		
		System.out.println("The size of concept space:"+ sizeConcept);
		
		int digitsNum = 0;
		
		int temp = sizeConcept;
		
		while(temp != 0){
			temp = temp/10;
			digitsNum++;
		}
		
		System.out.println("the number of decimal digits is:"+digitsNum);
		
		System.out.println("start to run the find-S algorithm");
	
		System.out.println("*******************");
		
//		System.out.println(traingDateInteger.size());
		
		System.out.println("*******************");
		
		int numPositive = 0;
		int numNegative = 0;
		

		for(String str:trainingData.keySet()){
			String [] splits = str.split(" ");
			
			
			
			
			//
			int [] attributeIntArray = new int [splits.length];
			int lableInt;
			
			
			if(splits[0].equals("Male")){
				attributeIntArray[0] = 1;
			}
			else{
				attributeIntArray[0] = -1;
			}
			
			if(splits[1].equals("Young")){
				attributeIntArray[1] = 1;
			}
			else{
				attributeIntArray[1] = -1;
			}
			
			if(splits[2].equals("Yes")){
				attributeIntArray[2] = 1;
			}
			else{
				attributeIntArray[2] = -1;
			}
			
			if(splits[3].equals("Yes")){
				attributeIntArray[3] = 1;
			}
			else{
				attributeIntArray[3] = -1;
			}
			
			if(splits[4].equals("Long")){
				attributeIntArray[4] = 1;
			}
			else{
				attributeIntArray[4] = -1;
			}
			
			if(splits[5].equals("Yes")){
				attributeIntArray[5] = 1;
			}
			else{
				attributeIntArray[5] = -1;
			}
			
			if(splits[6].equals("House")){
				attributeIntArray[6] = 1;
			}
			else{
				attributeIntArray[6] = -1;
			}
			
			if(splits[7].equals("Yes")){
				attributeIntArray[7] = 1;
			}
			else{
				attributeIntArray[7] = -1;
			}
			
			if(splits[8].equals("Yes")){
				attributeIntArray[8] = 1;
			}
			else{
				attributeIntArray[8] = -1;
			}
			
			if(trainingData.get(str).equals("high")){
				lableInt = 1;
				
				numPositive++;
				
			}
			else{
				lableInt = -1;
				
				numNegative++;
				
			}
			
			traingDateInteger.put(attributeIntArray, lableInt);
			
		}
		
		System.out.println("*****************");
		
		System.out.println(traingDateInteger);
		
		for(int [] tempArray :traingDateInteger.keySet()){
			
			for(int i=0;i<tempArray.length;i++){
				System.out.print(tempArray[i]+" ");
			}
			
			System.out.print(" = "+traingDateInteger.get(tempArray)+" ");
			
			System.out.println();
			
		}
		
		System.out.println("numPositive = "+numPositive);
		
		System.out.println("numNegative = "+numNegative);
		
		System.out.println("attributeAmount = "+attributeAmount);
		
		int[] hypothesis = new int [attributeAmount];

		boolean initialization = false;

		
		//find-S algorithm
		for(int[] tempArray :traingDateInteger.keySet()){
			
			if(traingDateInteger.get(tempArray) == 1){
				
				if(!initialization){
					
					hypothesis = tempArray.clone();
					
					System.out.println("first hypothesis:");
					
					for(int i=0;i<attributeAmount;i++){
						System.out.print(hypothesis[i]+" ");
					}
					System.out.println();
					
					initialization = true;
				}
				
				
				boolean [] checkArray = new boolean [attributeAmount];
				
				for(int i=0;i<attributeAmount;i++){
					if(hypothesis[i] != tempArray[i]){
						checkArray[i] = true;
					}
				}
				
				for(int i=0;i<attributeAmount;i++){
					if(checkArray[i]){
						hypothesis[i] = 0;
					}
				}
				
				
				
			}
		}
		
		System.out.print("hypothesis is:");
		
		for(int i=0;i<attributeAmount;i++){
			System.out.print(hypothesis[i]+" ");
		}
		
		
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class partA{
	
	public static void main(String [] args){
		
//		System.out.println("read process starts");
		String inputFilePath = args[0];
		String outputFilePath = "partA4.txt";
		File inputFile = new File(partA.class.getClassLoader().getResource(inputFilePath).getFile());
//		System.out.println("the relative path is:"+inputFile.getPath());
//		System.out.println("the absolute path is:"+inputFile.getAbsolutePath());
		
		List<String[]> result = new ArrayList<String []>();
		BufferedReader br = null;
		int attributeAmount = 0;
		//use hash map to store the training data
		Map<String, String> trainingData = new HashMap<String, String>();
		//
		Map<int [], Integer> traingDateInteger = new HashMap<int[], Integer>();
		
		Map<String [], String> trainingDataString = new HashMap<String[], String>();
		
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
				
				trainingData.put(attribute, label);
				
				
			}
			
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		for(String line:trainingData.keySet()){
			String [] Temp = line.split(" ");
			String label = trainingData.get(line);
			
			trainingDataString.put(Temp, label);
		}
		
		/*
		
		for(String[] line:trainingDataString.keySet()){
			for(int i=0;i<line.length;i++){
				System.out.print(line[i]+" ");
			}
			System.out.println();
		}
		
		System.out.println("________"+trainingDataString.size());
		
		*/
		
		int sizeInputSpace = (int) Math.pow(2, 9);
		System.out.println(sizeInputSpace);
		
		double tempInt = Math.pow(2, 9);
		
		Double sizeConcept = Math.pow(2, tempInt);
		

		System.out.println(155);
		
		int numPositive = 0;
		int numNegative = 0;
		
		for(String str:trainingData.keySet()){
			String [] splits = str.split(" ");

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
		
		/*
		for(int [] tempArray :traingDateInteger.keySet()){
			for(int i=0;i<tempArray.length;i++){
				System.out.print(tempArray[i]+" ");
			}
			System.out.print(" = "+traingDateInteger.get(tempArray)+" ");
			System.out.println();
		}
		*/
		
		/*
		System.out.println("numPositive = "+numPositive);
		System.out.println("numNegative = "+numNegative);
		System.out.println("attributeAmount = "+attributeAmount);
		*/
		
		String[] hypothesis = new String [attributeAmount];

		for(int i=0;i<hypothesis.length;i++){
			hypothesis[i] = "null";
		}
		
		
//		for(int i=0;i<hypothesis.length;i++){
//			System.out.print(hypothesis[i]+"\t");
//		}
		
		boolean initialization = false;
		
		int count = 1;
		PrintWriter printWriter = null;
		
		StringBuilder sb = new StringBuilder();
		
		int hypothsisSize = (int) (Math.pow(3, 9) + 1);
		System.out.println(hypothsisSize);
		
		for(int i=0;i<hypothesis.length;i++){
			sb.append(hypothesis[i]+"\t");
		}
		
		sb.deleteCharAt(sb.length() - 1);
		
		sb.append("\n");
				
		//find-S algorithm
		for(String[] tempArray :trainingDataString.keySet()){
			count++;
			
			//positive label
			if(trainingDataString.get(tempArray).equals("high")){
				
				//initialization
				if(!initialization){
					hypothesis = tempArray.clone();
					initialization = true;
					/*
					
					System.out.print("first hypothesis:");
					
					for(int i=0;i<hypothesis.length;i++){
						System.out.print(hypothesis[i]+" ");
					}
					
					System.out.println();
					*/
				}
				
				
				boolean [] checkArray = new boolean [attributeAmount];
				//compare the hypothesis and the positive instance
				for(int i=0;i<attributeAmount;i++){
					if(!(hypothesis[i].equals(tempArray[i]))){
						checkArray[i] = true;
					}
				}
				//change the attribute of the hypothesis
				for(int i=0;i<attributeAmount;i++){
					if(checkArray[i]){
						hypothesis[i] = "?";
					}
				}
			}
			if(count%30 == 0){
				for(int i=0;i<hypothesis.length;i++){
					sb.append(hypothesis[i]+"\t");
				}
				
				sb.append(hypothesis[hypothesis.length - 1]);
				
				sb.append("\n");
			}
			
		}
		
		sb.deleteCharAt(sb.length() - 1);
		
		
		//print to the file
		try{
			FileWriter fileWriter = new FileWriter(outputFilePath);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			printWriter = new PrintWriter(bufferedWriter);
			printWriter.print(sb.toString());
			printWriter.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		for(int i=0;i<attributeAmount;i++){
			System.out.print(hypothesis[i]+"\t");
		}
		
		System.out.println();
		
		String inputFilePathDev = args[1];
		File inputFileDev = new File(partA.class.getClassLoader().getResource(inputFilePathDev).getFile());
		
		BufferedReader brDev = null;
		
		Map<String, String > devData = new HashMap<String, String>();
		Map<int[], Integer > devDataInteger = new HashMap<int [], Integer>();
		Map<String [], String> devDataString = new HashMap<String[], String>();
		
		
		try{
			FileInputStream fileInputStream = new FileInputStream(inputFileDev);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			brDev = new BufferedReader(inputStreamReader);
			String line = null;
			while((line = brDev.readLine()) != null){
				String [] splits = line.split("\t");
				
				//
				String attribute = "";
				String label = splits[splits.length - 1].split(" ")[1];
				for(int i=0;i<attributeAmount;i++){
					attribute = attribute + splits[i].split(" ")[1]+" ";
				}
				devData.put(attribute, label);
			}
			
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		for(String line : devData.keySet()){
			String []splits = line.split(" ");
			String label = devData.get(line);
			
			devDataString.put(splits, label);
		}
		
		
		for(String str:devData.keySet()){
			String [] splits = str.split(" ");

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
			
			if(devData.get(str).equals("high")){
				lableInt = 1;
				numPositive++;
			}
			else{
				lableInt = -1;
				numNegative++;
			}
			devDataInteger.put(attributeIntArray, lableInt);
		}
		
		int total = devDataInteger.size();
		int fault = 0;
		
		for(String [] Temp : devDataString.keySet()){
			
			/*
			for(int i=0;i<attributeAmount;i++){
				System.out.print(Temp[i]+" ");
			}
			
			System.out.print(devDataInteger.get(Temp));
			
			System.out.println();
			
			*/
			
			if(Temp[6].equals("Car")){
				
				if(!(devDataString.get(Temp).equals("high"))){
					fault++;
				}
			}
		}
		System.out.println(1.0*(fault)/total);
		
	}
}

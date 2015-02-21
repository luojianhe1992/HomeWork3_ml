import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class partB{
	
	public static void main(String [] args){
		
//		System.out.println("read process starts");
		
		
		//reading training data
		String inputFilePath = "4Cat-Train.labeled";
		File inputFile = new File(partB.class.getClassLoader().getResource(inputFilePath).getFile());
//		System.out.println("the relative path is:"+inputFile.getPath());
//		System.out.println("the absolute path is:"+inputFile.getAbsolutePath());
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
				
				trainingData.put(attribute, label);

				result.add(splits);
				/*
				for(String str:splits){
					System.out.print(str + " ");
				}
				System.out.println();
				*/
			}
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
//		System.out.println("read process ends");
		
//		System.out.println("total length file is:"+result.size());
//		System.out.println("training data:"+trainingData);
		
//		System.out.println("length of trainingData:"+trainingData.size());
		
		int inputSpaceSize = (int) Math.pow(2, 4);
		System.out.println(inputSpaceSize);
		
		int sizeConcept = (int) Math.pow(2, Math.pow(2, 4));
		System.out.println(sizeConcept);
	
		/*
		
		int digitsNum = 0;
		int temp = sizeConcept;
		while(temp != 0){
			temp = temp/10;
			digitsNum++;
		}
		System.out.println("the number of decimal digits is:"+digitsNum);
		
		*/
		
//		System.out.println("start to run the list-then-eliminate algorithm");
	
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
		
//		System.out.println(traingDateInteger);
		
		/*
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
		*/
		
		//list-then-eliminate algorithm
//		int [] hypothesisPositive = null;
//		int [] hypothesisNegative = null;
		
		//
//		for(int [] tempArray:traingDateInteger.keySet()){
//			if(traingDateInteger.get(tempArray) == 1){
//				hypothesisPositive = tempArray.clone();
//				break;
//			}
//		}
//		System.out.println("the hypothesisPositive:");
//		for(int i=0;i<attributeAmount;i++){
//			System.out.print(hypothesisPositive[i]+" ");
//		}
//		System.out.println();
		
		//
//		for(int [] tempArray:traingDateInteger.keySet()){
//			if(traingDateInteger.get(tempArray) == -1){
//				hypothesisNegative = tempArray.clone();
//				break;
//			}
//		}
//		System.out.println("the hypothesisNegative");
//		for(int i=0;i<attributeAmount;i++){
//			System.out.print(hypothesisNegative[i]+" ");
//		}
//		for(int i = 0;i<attributeAmount;i++){
//			if(i == 0){
//				continue;
//			}
//			else{
//				hypothesisPositive[i] = 0;
//			}
//		}
//		
//		for(int i=0;i<attributeAmount;i++){
//			if(i == 1){
//				continue;
//			}
//			else{
//				hypothesisNegative[i] = 0;
//			}
//		}
//		System.out.println("the hypothesisPositive:");
//		for(int i=0;i<attributeAmount;i++){
//			System.out.print(hypothesisPositive[i]+" ");
//		}
//		System.out.println();
//		System.out.println("the hypothesisNegative");
//		for(int i=0;i<attributeAmount;i++){
//			System.out.print(hypothesisNegative[i]+" ");
//		}
//		System.out.println();
		
		
		//list-then-eliminate algorithm
//		for(int [] tempArray:traingDateInteger.keySet()){
//			if(traingDateInteger.get(tempArray) == 1){
//				System.out.print("positive label:");
//				for(int i=0;i<attributeAmount;i++){
//					System.out.print(tempArray[i]+" ");
//				}
//				System.out.println();
//			}
//			else{
//				System.out.print("negative label:");
//				for(int i=0;i<attributeAmount;i++){
//					System.out.print(tempArray[i]+" ");
//				}
//				System.out.println();
//			}
//		}
		
//		HashMap<int [], Integer> positiveHypothesisSet = new HashMap<int[], Integer>();
//		HashMap<int [], Integer> negativeHypothesisSet = new HashMap<int[], Integer>();
		
		ArrayList<int[]> positive = new ArrayList<int[]>();
		ArrayList<int[]> negative = new ArrayList<int[]>();
		
		int [] hypothesisArray = new int [attributeAmount];
		
		for(int i=0;i<2;i++){
			hypothesisArray[0] = i;
			for(int j=0;j<2;j++){
				hypothesisArray[1] = j;
				for(int m=0;m<2;m++){
					hypothesisArray[2] = m;
					for(int n=0;n<2;n++){
						hypothesisArray[3] = n;
						//
						
						for(int t=0;t<attributeAmount;t++){
							if(hypothesisArray[t] == 0){
								hypothesisArray[t] = -1;
							}
						}
						positive.add(hypothesisArray.clone());
						negative.add(hypothesisArray.clone());

						/*
						for(int k=0;k<attributeAmount;k++){
							System.out.print(hypothesisArray[k] + " ");
						}
						System.out.println();
						*/
					}
				}
			}
		}
		/*
		
		System.out.println("positive:");
		
		for(int [] arr:positive){
			for(int i=0;i<arr.length;i++){
				System.out.print(arr[i]+" ");
			}
			
			System.out.println();
		}
		*/
		
		//
		ArrayList<int []> Hypothesis = new ArrayList<int[]>();
		for(int a=0;a<2;a++){
			int [] aTempWay = new int[attributeAmount + 1];
			for(int Temp=0;Temp<attributeAmount;Temp++){
				aTempWay[Temp] = positive.get(0)[Temp];
			}
			aTempWay[attributeAmount] = a;
			Hypothesis.add(aTempWay);
			
			for(int b=0;b<2;b++){
				if(a == 1){
					continue;
				}
				int [] bTempWay = new int[attributeAmount + 1];
				for(int Temp=0;Temp<attributeAmount;Temp++){
					bTempWay[Temp] = positive.get(1)[Temp];
				}
				bTempWay[attributeAmount] = b;
				Hypothesis.add(bTempWay);
				
				for(int c=0;c<2;c++){
					if(a== 1 && b == 1){
						continue;
					}
					int [] cTempWay = new int[attributeAmount + 1];
					for(int Temp=0;Temp<attributeAmount;Temp++){
						cTempWay[Temp] = positive.get(2)[Temp];
					}
					cTempWay[attributeAmount] = c;
					Hypothesis.add(cTempWay);
					
					for(int d=0;d<2;d++){
						if(a== 1 && b == 1 && c==1){
							continue;
						}
						int [] dTempWay = new int[attributeAmount + 1];
						for(int Temp=0;Temp<attributeAmount;Temp++){
							dTempWay[Temp] = positive.get(3)[Temp];
						}
						dTempWay[attributeAmount] = d;
						Hypothesis.add(dTempWay);
					
						for(int e=0;e<2;e++){
							if(a== 1 && b == 1 && c==1 && d==1){
								continue;
							}
							int [] eTempWay = new int[attributeAmount + 1];
							for(int Temp=0;Temp<attributeAmount;Temp++){
								eTempWay[Temp] = positive.get(4)[Temp];
							}
							eTempWay[attributeAmount] = e;
							Hypothesis.add(eTempWay);
							
							for(int f=0;f<2;f++){
								
								if(a== 1 && b == 1 && c==1 && d==1 && e==1){
									continue;
								}
								int [] fTempWay = new int[attributeAmount + 1];
								for(int Temp=0;Temp<attributeAmount;Temp++){
									fTempWay[Temp] = positive.get(5)[Temp];
								}
								fTempWay[attributeAmount] = f;
								Hypothesis.add(fTempWay);
							
								for(int g=0;g<2;g++){
									if(a== 1 && b == 1 && c==1 && d==1 && e==1 && f==1){
										continue;
									}
									int [] gTempWay = new int[attributeAmount + 1];
									for(int Temp=0;Temp<attributeAmount;Temp++){
										gTempWay[Temp] = positive.get(6)[Temp];
									}
									gTempWay[attributeAmount] = g;
									Hypothesis.add(gTempWay);
									
									for(int h=0;h<2;h++){
										if(a== 1 && b == 1 && c==1 && d==1 && e==1 && f==1 && g==1){
											continue;
										}
										int [] hTempWay = new int[attributeAmount + 1];
										for(int Temp=0;Temp<attributeAmount;Temp++){
											hTempWay[Temp] = positive.get(7)[Temp];
										}
										hTempWay[attributeAmount] = h;
										Hypothesis.add(hTempWay);
									
										for(int i=0;i<2;i++){
											if(a== 1 && b == 1 && c==1 && d==1 && e==1 && f==1 && g==1 && h==1){
												continue;
											}
											int [] iTempWay = new int[attributeAmount + 1];
											for(int Temp=0;Temp<attributeAmount;Temp++){
												iTempWay[Temp] = positive.get(8)[Temp];
											}
											iTempWay[attributeAmount] = i;
											Hypothesis.add(iTempWay);
										
											for(int k=0;k<2;k++){
												if(a== 1 && b == 1 && c==1 && d==1 && e==1 && f==1 && g==1 && h==1 && i==1){
													continue;
												}
												int [] kTempWay = new int[attributeAmount + 1];

												for(int Temp=0;Temp<attributeAmount;Temp++){
													kTempWay[Temp] = positive.get(9)[Temp];
												}
												kTempWay[attributeAmount] = k;
												Hypothesis.add(kTempWay);
												
												for(int l=0;l<2;l++){
													if(a== 1 && b == 1 && c==1 && d==1 && e==1 && f==1 && g==1 && h==1 && i==1 && k==1){
														continue;
													}
													int [] lTempWay = new int[attributeAmount + 1];
													for(int Temp=0;Temp<attributeAmount;Temp++){
														lTempWay[Temp] = positive.get(10)[Temp];
													}
													lTempWay[attributeAmount] = l;
													Hypothesis.add(lTempWay);
												
													for(int o=0;o<2;o++){
														if(a== 1 && b == 1 && c==1 && d==1 && e==1 && f==1 && g==1 && h==1 && i==1 && k==1 && l==1){
															continue;
														}
														int [] oTempWay = new int[attributeAmount + 1];
														for(int Temp=0;Temp<attributeAmount;Temp++){
															oTempWay[Temp] = positive.get(11)[Temp];
														}
														oTempWay[attributeAmount] = o;
														Hypothesis.add(oTempWay);
													
														for(int m=0;m<2;m++){
															if(a== 1 && b == 1 && c==1 && d==1 && e==1 && f==1 && g==1 && h==1 && i==1 && k==1 && l==1 && o==1){
																continue;
															}
															int [] mTempWay = new int[attributeAmount + 1];
															for(int Temp=0;Temp<attributeAmount;Temp++){
																mTempWay[Temp] = positive.get(12)[Temp];
															}
															mTempWay[attributeAmount] = m;
															Hypothesis.add(mTempWay);
															
															for(int n=0;n<2;n++){
																if(a== 1 && b == 1 && c==1 && d==1 && e==1 && f==1 && g==1 && h==1 && i==1 && k==1 && l==1 && o==1 && m==1){
																	continue;
																}
																int [] nTempWay = new int[attributeAmount + 1];
																for(int Temp=0;Temp<attributeAmount;Temp++){
																	nTempWay[Temp] = positive.get(13)[Temp];
																}
																nTempWay[attributeAmount] = n;
																Hypothesis.add(nTempWay);
															
																for(int p=0;p<2;p++){
																	if(a== 1 && b == 1 && c==1 && d==1 && e==1 && f==1 && g==1 && h==1 && i==1 && k==1 && l==1 && o==1 && m==1 && n==1){
																		continue;
																	}
																	int [] pTempWay = new int[attributeAmount + 1];
																	for(int Temp=0;Temp<attributeAmount;Temp++){
																		pTempWay[Temp] = positive.get(14)[Temp];
																	}
																	pTempWay[attributeAmount] = p;
																	Hypothesis.add(pTempWay);
																
																	for(int q=0;q<2;q++){
																		if(a== 1 && b == 1 && c==1 && d==1 && e==1 && f==1 && g==1 && h==1 && i==1 && k==1 && l==1 && o==1 && m==1 && n==1 && p==1){
																			continue;
																		}
																		int [] qTempWay = new int[attributeAmount + 1];
																		for(int Temp=0;Temp<attributeAmount;Temp++){
																			qTempWay[Temp] = positive.get(15)[Temp];
																		}
																		qTempWay[attributeAmount] = q;
																		Hypothesis.add(qTempWay);
																		
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					
				}
			}
		}
		
		for(int [] Temp :Hypothesis){
			if(Temp[attributeAmount] == 0){
				Temp[attributeAmount] = -1;
			}
		}
		/*
		for(int [] Temp:Hypothesis){
			for(int i = 0;i<Temp.length;i++){
				System.out.print(Temp[i]+" ");
			}
			System.out.println();
		}
		System.out.println("size = "+ Hypothesis.size());
		*/
		
		/*
		HashSet<String> HypothesisSet = new HashSet<String>();
		
		for(int i=0;i<Hypothesis.size();i++){
			String Temp = "";
			
			for(int j=0;j<attributeAmount + 1;j++){
				Temp = Temp + Hypothesis.get(i)[j];
			}
			
			HypothesisSet.add(Temp);
			
		}
		
		System.out.println("Hypothesis Set is:"+HypothesisSet.size());
		
		System.out.println("****************");
		
		for(int[] tempArray:traingDateInteger.keySet()){
			int [] Temp = new int [attributeAmount + 1];
			for(int i = 0;i<attributeAmount;i++){
				Temp[i] = tempArray[i];
			}
			Temp[attributeAmount] = traingDateInteger.get(tempArray);
			
			for(int i = 0;i<Hypothesis.size();i++){
				if(compareArray(Temp,Hypothesis.get(i))){
					Hypothesis.remove(i);
				}
			}
		}
		
		System.out.println("after size = "+Hypothesis.size());
		
		*/
		
		
		
		//read the dev file
		String inputFilePathDev = "4Cat-Dev.labeled";
		File inputFileDev = new File(partB.class.getClassLoader().getResource(inputFilePathDev).getFile());
//		System.out.println("the relative path is:"+inputFile.getPath());
//		System.out.println("the absolute path is:"+inputFile.getAbsolutePath());
		List<String[]> resultDev = new ArrayList<String []>();
		BufferedReader brDev = null;
		
		//use hash map to store the training data
		Map<String, String> devData = new HashMap<String, String>();
		
		//
		Map<int [], Integer> devDateInteger = new HashMap<int[], Integer>();
		
		try{
			FileInputStream fileInputStream = new FileInputStream(inputFileDev);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			brDev = new BufferedReader(inputStreamReader);
			String line = null;
			while((line = brDev.readLine()) != null){
				String [] splits = line.split("\t");
				attributeAmount = splits.length - 1;
				//
				String attribute = "";
				String label = splits[splits.length - 1].split(" ")[1];
				for(int i=0;i<attributeAmount - 1;i++){
					attribute = attribute + splits[i].split(" ")[1]+" ";
				}
				attribute = attribute + splits[attributeAmount - 1].split(" ")[1];
				devData.put(attribute, label);

				resultDev.add(splits.clone());
				
				
				/*
				for(String str:splits){
					System.out.print(str + " ");
				}
				System.out.println();
				*/
			}
			brDev.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		for(String str:devData.keySet()){
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
			
			if(devData.get(str).equals("high")){
				lableInt = 1;
				numPositive++;
			}
			else{
				lableInt = -1;
				numNegative++;
			}
			
			devDateInteger.put(attributeIntArray, lableInt);
		}
		
		/*
		
		for(int[] Temp:devDateInteger.keySet()){
			for(int i=0;i<Temp.length;i++){
				System.out.print(Temp[i]+" ");
			}
			
			System.out.print("="+devDateInteger.get(Temp));
			
			System.out.println();
		}
		*/
		
		int faultNum = 0;
		boolean found = true;
		
		for(int [] Temp: devDateInteger.keySet()){
			for(int i=0;i<Hypothesis.size();i++){
				for(int j=0;j<attributeAmount;j++){
					if(Temp[j] != Hypothesis.get(i)[j]){
						found = false;
						break;
					}
				}
				
				if(found){
					if(devDateInteger.get(Temp) != Hypothesis.get(i)[attributeAmount]);
					
					faultNum ++;
				}
				
			}
		}
		
		System.out.println("faultNum = " + faultNum);
		
		
		
	}
	
	
	
	
	
	
	public static boolean compareArray(int[] arr1, int[] arr2){
		for(int i=0;i<arr1.length;i++){
			if(arr1[i] != arr2[i]){
				return false;
			}
		}
		
		return true;
	}
	
	
}

/*cryptanalysis class for krypton3 of overthewire.org's krypton game.
for the purposes of this particular game, the program acccepts three
file arguments and does not check if they are indeed present on the 
command line at execution. */ 

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Cryptanalysis{
	public static void main(String[] args){
		//read the file arguments.
		File foundOne = new File(args[0]);
		File foundTwo = new File(args[1]);
		File foundThree = new File(args[2]);
		int letterCount = 0;

		//add the files to a list
		ArrayList<File> files = new ArrayList<File>();
		files.add(foundOne);
		files.add(foundTwo);
		files.add(foundThree);

		//create a hash map for frequency analysis
		HashMap<Character, Integer> letFreq = new HashMap<Character, Integer>();
		
		
		

		//now we can analyze the files 
		for(File f : files){
			BufferedReader input = null;
			try{
				//read the file 
				input = new BufferedReader(new FileReader(f)); 
				String line;
				while((line = input.readLine()) != null){
					//iterate through the line and count the frequency of each letter
					for(int i = 0; i < line.length(); i++){
						if(line.charAt(i) == ' '){
							continue;
						}else{
							letFreq.put(line.charAt(i), letFreq.getOrDefault(line.charAt(i), 0) + 1);
							letterCount++;
						}
					}
				}
				input.close();
				


			}catch(IOException i){
				if (input != null){
					System.out.println("Error.");

				}
			}
		}
		//print the frequency analysis
		System.out.println("Frequency analysis successful");
		System.out.println("Results: ");
		letFreq.forEach((k,v) -> System.out.println("Letter: " + k + " Frequency: " + v));

		//print probablities
		Iterator letIter = letFreq.entrySet().iterator();
		System.out.println("Probabilities: ");
		float p = 0;
		while(letIter.hasNext()){
			Map.Entry element = (Map.Entry)letIter.next();
			int elVal = (int)element.getValue();
			p = (float)elVal / letterCount;
			System.out.println("Letter : " + element.getKey() + " Probability: " + p);
		}
		
	}
}
/*
* File: WordCounter.java
* Derek Hessinger
* CS231 B
* 10/27/22
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File; 
import java.io.FileWriter;

public class WordCounter{

	// Fields for Word Counter
	BSTMap<String, Integer> tree;
	int total;

	public WordCounter(){

		this.tree = new BSTMap<String, Integer>();
		this.total = 0;
	}


	//Reads file and prints out board
	public void analyze(String filename) {

		try {

			// assign to a variable of type FileReader a new FileReader object, passing filename to the constructor
			FileReader fr = new FileReader(filename);

			// assign to a variable of type BufferedReader a new BufferedReader, passing the FileReader variable to the constructor
			BufferedReader br = new BufferedReader(fr);

			// assign to a variable of type String line the result of calling the readLine method of your BufferedReader object.
			String line = br.readLine();

			// start a while loop that loops while line isn't null
			while(line != null){

				// split line into words. The regular expression can be interpreted
				// as split on anything that is not (^) (a-z or A-Z or 0-9 or ').
				String[] words = line.split("[^a-zA-Z0-9']");

				for (int i = 0; i < words.length; i++) {

					String word = words[i].trim().toLowerCase();

					// Check for a word of length 0 and not process it
					if (word.length()>0){

						// If the word is already in the tree
						if (this.tree.containsKey(word) == true){

							// Get its value and update by one
							int value = this.tree.get(word);
							value += 1;
							this.tree.put(word, value);
							this.total += 1;
						}

						// If the word is not in the tree
						else{

							this.tree.put(word, 1);
							this.total += 1;
							}
						}
				  	}
				  	line = br.readLine();
		    	}
      		br.close();
    		}
    	catch(FileNotFoundException ex) {

      	System.out.println("WordCounter.analyze():: unable to open file " + filename );
    	}
   		catch(IOException ex) {

    	System.out.println("WordCounter.analyze():: error reading file " + filename);
    	}
  	}

  	public int getTotalWordCount(){

  		return this.total;
  	}

  	public int getUniqueWordCount(){

  		return this.tree.size();
  	}

  	public int getCount(String word){

  		return this.tree.get(word);
  	}

  	public double getFrequency(String word){

  		double result = (double)this.tree.get(word) / (double)this.total;
  		return result;
  	}

  	public void writeWordCountFile(String filename){

  		try{

  			//Create new file and FileWriter object to the new file
  			File file = new File(filename);
  			FileWriter fw = new FileWriter(filename);

  			// First line of file
  			String str = "totalWordCount: " + this.getTotalWordCount() + "\n";
  			fw.write(str); 

  			// Get an array list of each key value pair
  			ArrayList<MapSet.KeyValuePair<String, Integer>> data = this.tree.entrySet();

  			for (MapSet.KeyValuePair<String, Integer> entry: data){

  				str = entry.getKey() + " " + entry.getValue() + "\n";
  				fw.write(str);
  			}
  			fw.close();
  		}
  		catch (IOException e) 
      	{
      		System.out.println("WordCounter.writeWordCountFile():: error writing to file");
    	}
  	}

  	// Reads a word count file and reconstructs tree from it
  	public void readWordCountFile(String filename){

  		try{

  			// Create file reader with file passed
  			FileReader fr = new FileReader(filename);

  			// Create buffered reader with file reader passed
  			BufferedReader br = new BufferedReader(fr);

  			// Read the first line so it is not included in tree
  			String line = br.readLine();

  			// Read again to get to first line of data in file
  			line = br.readLine();

  			// While the line is not equal to null
  			while (line != null){

  				// Split on anything that isnt a letter or number
  				String[] words = line.split("[^a-zA-Z0-9']");

  				// Add line to tree
  				this.tree.put(words[0], Integer.parseInt(words[1]));

  				// Go to next line
  				line = br.readLine();
  			}
  		}
  		catch(FileNotFoundException ex) {

      	System.out.println("WordCounter.analyze():: unable to open file " + filename );
    	}
   		catch(IOException ex) {

    	System.out.println("WordCounter.analyze():: error reading file " + filename);
    	}
  	}

  	public static void main(String[] args){

  		WordCounter wc = new WordCounter();
  		//Scanner sc = new Scanner(System.in);
  		// wc.analyze("counttest.txt");
  		// System.out.println(wc.tree);
  		// System.out.println(wc.getTotalWordCount());
  		// System.out.println(wc.getUniqueWordCount());
  		// System.out.println(wc.getCount("it"));
  		// System.out.println(wc.getFrequency("it"));
  		// wc.writeWordCountFile("output.txt");
  		// wc.readWordCountFile("output.txt");
  		// System.out.println(wc.tree);
  		for (String str : args){
  			long start = System.currentTimeMillis();
  			wc.analyze(str);
  			wc.writeWordCountFile("OUTPUT" + str);
  			long end =  System.currentTimeMillis();
  			System.out.println("Time elapsed for " + str + ": " + (end - start));
  			System.out.println("Unique word count: "+ wc.getUniqueWordCount());
  		}

  		// Possible extension: use commonwords.txt to create BST, check if each new word is in that bst, if not, then add word to output file bst

  		// // Extension to have main method print out top twenty words in file
  		// for (String str : args){

  		// 	try{

	  	// 		// Create file reader and buffered reader
	  	// 		FileReader fr = new FileReader("OUTPUT" + str);
	  	// 		BufferedReader br = new BufferedReader(fr);

	  	// 		// Read the first line so it is not included in tree
	  	// 		String line = br.readLine();

	  	// 		// Read again to get to first line of data in file
	  	// 		line = br.readLine();

	  	// 		// While the line is not equal to null
	  	// 		for (int i = 0; i < 20; i++){

	  	// 			// Split on anything that isnt a letter or number
	  	// 			String[] words = line.split("[^a-zA-Z0-9']");

	  	// 			// Print out contents
	  	// 			System.out.println(words[0]);

	  	// 			i++;

	  	// 			line = br.readLine();
	  	// 		}
  		// 	}
  		// 	catch(FileNotFoundException ex) {

	   //    	System.out.println("WordCounter.analyze():: unable to open file " + str );
	   //  	}
	   // 		catch(IOException ex) {

	   //  	System.out.println("WordCounter.analyze():: error reading file " + str);
	   //  	}
  		// }
  	}
}
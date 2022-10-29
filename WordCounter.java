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

  		double result = this.tree.get(word) / this.total;
  		return result;
  	}
}
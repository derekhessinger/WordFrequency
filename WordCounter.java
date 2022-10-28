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

	
}
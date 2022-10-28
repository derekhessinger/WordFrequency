/*
* File: BSTMap.java
* Derek Hessinger
* CS231
* 10/27/22
*/

import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>, V> implements MapSet<K, V>{

	private class Node{

		Node left;
		Node right;
		KeyValuePair<K,V> kvp;

		public Node(KeyValuePair<K, V> kvp){

			this.kvp = kvp;
			this.left = null;
			this.right = null;
		}

		public K getKey(){
			return kvp.getKey();
		}

		public V getValue(){

			return kvp.getValue();
		}
	}

	private Node root;
	private int size;


	// Constructor for BSTMap
	public BSTMap(){

		root = null;
		size = 0;
	}

	// Returns value to key recursively
	public V get(K key){

		return get(key, root);
	}

	// Helper function to return value from key
	private V get(K key, Node cur){

		if (cur == null){

			return null;
		}

		if (cur.getKey().compareTo(key) < 0){

			return get(key, cur.right);
		}

		else if (cur.getKey().compareTo(key) > 0){

			return getKey(key, cur.left);
		}

		else{

			return cur.getValue();
		}
	}

	// Returns the size of the BST
	public int size(){

		return this.size;
	}

	// Clears the BST
	public void clear(){

		this.root = null;
		this.size = 0;
	}

	// Puts a value at key k passed
	public V put(K key, V value, Node cur) {

	    if (key.compareTo(cur.getKey()) < 0){

	        if (cur.left != null){

	            return key.put(cur.left);
	        } 
	        else {
	            //insert a new Node with the given KeyValuePair to the left of cur
	            Node newNode = new Node(key, value);
	            cur.left = newNode;
	            return null;
	        }
	    } 
	    else if (key.compareTo(cur.getKey()) > 0){

	        if (cur.right != null){

	            return key.put(cur.right);
	        } 
	        else {

	            //insert a new Node with the given KeyValuePair to the right of cur
	            Node newNode = new Node(key, value);
	            cur.right = newNode;
	            return null;
	        }
	    } 
	    else { // in this case, cur.getKey() == key

	        //Set the value of cur's KeyValuePair to be the given value and return the old one
	    	V oldVal = cur.getValue();
	    	cur.setValue(value);
	    	return oldVal;
	    }
	}

	// Returns true if the key passed is in the BST
	public boolean containsKey(K key){

		if (this.get(key) != null){

			return true;
		}

		else{

			return false;
		}
	}

	// Returns an array list of all keys in the map ordered from least to greatest
	public ArrayList<K> keySet(){

		ArrayList<K> output = new ArrayList<K>();
		keySet(root, output);
	}

	// Helper function for keySet()
	private void keySet(Node cur, ArrayList<K> output){

		if (cur == null){

			return;
		}

		keySet(cur.left, output);
		output.add(cur.getKey());
		keySet(cur.right, output);
	}

	public ArrayList<V> values(){

		ArrayList<V> output = new ArrayList<V>();
		values(root, output);
	}

	private void values(Node cur, ArrayList<K> output){

		if (cur == null){

			return
		}

		values(cur.left, output);
		output.add(cur.getValue());
		values(cur.right, output);
	}

	// // Returns an array lit of all values in the map in order from least to greatest
	// public ArrayList<V> values(){

	// 	ArrayList<V> output = new ArrayList<V>();

	// 	ArrayList<K> keys = this.keySet();
		
	// 	for (K k: keys){

	// 		V val = k.getValue();
	// 		output.add(val);
	// 	}

	// 	return output;
	// }
	
	// Returns an array list of all KVP in the map ordered from least to greatest
	public ArrayList<KeyValuePair<K, V>> entrySet(){

		ArrayList<KeyValuePair<K, V>> kvpList = new ArrayList<KeyValuePair<K, V>>();

		ArrayList<K> keys = this.keySet();

		for (K k: keys){

			V v = k.getValue();
			KeyValuePair kvp = new KeyValuePair(k, v);
			kvpList.add(kvp);
		}

		return kvpList;
	}

	// // To string method
	// public String toString(){

	// 	String str = "";
	// 	str += "root:	" + root + "\n";
	// 	str = this.toString(root, str);
	// 	return str;
	// }

	// private String toString(Node n, String str){

	// 	int countLeft = 1;
	// 	int countRight = 1;

	// 	if (n.left != null && n.right != null){

	// 		str += "left:	" + "	" * countLeft + n.left.toString() + "\n";
	// 		str += "right:	" + "	" * countLeft + n.right.toString() + "\n";
	// 		countLeft+=1;
	// 		countRight+=1;
	// 		this.toString(n.left, str);
	// 		this.toString(n.right, str);
	// 	}

	// 	else if(n.right != null){

	// 		str += "right:	" + "	" * countLeft + n.right.toString() + "\n";
	// 		this.toString(n.right, str);
	// 	}

	// 	else{

	// 		return str;
	// 	}
	// }

	public static void main(String[] args){

		BSTMap map = new BSTMap();
	}
}








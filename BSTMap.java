/*
*
*
*
*
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

	public BSTMap(){

		root = null;
		size = 0;
	}

	public V get(K key){

		return get(key, root);
	}

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

	public int size(){

		return this.size;
	}

	public void clear(){

		this.root = null;
		this.size = 0;
	}

	private V put(K key, V value, Node cur) {

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

	public boolean containsKey(K key){

		if (this.getKey() == null){

			return false;
		}
		else{

			return true;
		}
	}

	public ArrayList<K> keySet(){

		ArrayList<K> output = new ArrayList<K>();
		keySet(root, output);
	}

	public void keySet(Node cur, ArrayList<K> output){

		if (cur == null){

			return;
		}

		keySet(cur.left, output);
		output.add(cur.getKey());
		keySet(cur.right, output);
	}

	public ArrayList<V> values(){

		ArrayList<V> output = new ArrayList<V>();

		ArrayList<K> keys = this.keySet();
		
		for (K k: keys){

			V val = k.getValue();
			output.add(val);
		}

		return output;
	}
	
	public ArrayList<KeyValuePair<K, V>> entrySet(){

		ArrayList<KeyValuePair<K, V>> kvpList = new ArrayList<KeyValuePair<K, V>>();

		ArrayList<K> keys = this.keySet();

		for (K k: keys){

			V v = key.getValue();
			KeyValuePair kvp = new KeyValuePair(k, v);
			kvpList.add(kvp);
		}

		return kvpList;
	}

	public String toString(){

		
	}
}








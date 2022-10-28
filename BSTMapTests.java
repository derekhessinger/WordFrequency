/*
* File: BSTMapTests.java
* Derek Hessinger
* CS231
* 10/28/22
*/

public class BSTMapTests{

	public static void main(String[] args){

		// case 1: testing BSTMap()
		{
			System.out.println("TESTING: BSTMap()");

			// setup
			BSTMap<String, Integer> map = new BSTMap<String, Integer>();

			// verify
			System.out.println(map.getObjType() + " == BSTMap");

			// test
			assert map.getObjType() == "BSTMap" : "Error in BSTMap::BSTMap()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 2: testing get() ***TODO: Finish this test***
		{
			System.out.println("TESTING: put()");

			// setup
			BSTMap<String, Integer> map1 = new BSTMap<String, Integer>();	// testing null as root
			BSTMap<String, Integer> map2 = new BSTMap<String, Integer>();	// testing adding a value
			BSTMap<String, Integer> map3 = new BSTMap<String, Integer>();	// testing replacing a value

			// return1 = map1.put("first", 1);

			// map2.put("first", 1);
			// return2 = map2.put("second", 2);

			map3.put("first", 1);
			map3.put("second" ,2);
			int return3 = map3.put("second", 3);

			// verify
			// System.out.println(return1 + " == null");
			// System.out.println(return2 + " == null");
			System.out.println(return3 + " == 2");

			// test
			// assert return1 == null : "Error in BSTMap::get()";
			// assert return2 == null : "Error in BSTMap::get()";
			assert return3 == 2 : "Error in BSTMap::get()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 3: testing size()
		{
			System.out.println("TESTING: size()");

			// setup
			BSTMap<String, Integer> map1 = new BSTMap<String, Integer>();

			map1.put("first", 1);
			map1.put("second", 2);
			map1.put("third", 3);

			// verify
			System.out.println(map1.size() + " == 3");

			// test
			assert map1.size() == 3 : "Error in BSTMap::size()";

			System.out.println("Testing complete!");
			System.out.println("");
		}
	}
}
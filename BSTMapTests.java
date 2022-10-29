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

		// case 2: testing put() ***TODO: Finish this test***
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

		// case 4: testing clear()
		{
			System.out.println("TESTING: clear()");

			// setup
			BSTMap<String, Integer> map1 = new BSTMap<String, Integer>();
			map1.put("first", 1);
			map1.put("second", 2);
			map1.put("third", 3);
			map1.clear();

			// verify
			System.out.println(map1 + " == ");

			// test
			assert map1.size() == 0 : "Error in BSTMap::clear()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 5: testing get()
		{
			System.out.println("TESTING: get()");

			// setup
			BSTMap<String, Integer> map1 = new BSTMap<String, Integer>();
			map1.put("first", 1);

			// verify
			System.out.println(map1.get("first") + " == 1");
			System.out.println(map1.get("second") + " == null");

			// test
			assert map1.get("first") == 1 : "Error in BSTMap::get()";
			assert map1.get("second") == null : "Error in BSTMap::get()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 6: testing contains()
		{
			System.out.println("TESTING: contains()");

			// setup
			BSTMap<String, Integer> map1 = new BSTMap<String, Integer>();
			map1.put("first", 1);

			// verify
			System.out.println(map1.containsKey("first") + " == true");
			System.out.println(map1.containsKey("second") + " == false");

			// test
			assert map1.containsKey("first") == true : "Error in BSTMap::contains()";
			assert map1.containsKey("second") == false : "Error in BSTMap::contains()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 7: testing keySet() ***TODO: Finish this test***
		{
			System.out.println("TESTING: keySet()");

			// setup
			BSTMap<String, Integer> map1 = new BSTMap<String, Integer>();
			map1.put("first", 1);
			map1.put("second", 2);
			map1.put("third", 3);

			// verify
			System.out.println(map1.keySet() + " == [first, second, third]");

			// test
			//assert map1.keySet() ==  : "Error in BSTMap::keySet()";
		}

		// case 8: testing values() ****Finish test****
		{
			System.out.println("TESTING: values()");

			// setup
			BSTMap<String, Integer> map1 = new BSTMap<String, Integer>();
			map1.put("first", 1);
			map1.put("second", 2);
			map1.put("third", 3);

			// verify
			System.out.println(map1.values() + " == [1, 2, 3]");

			// TODO: add test
		}

		// case 9: testing entrySet() ***FINISH TEST****
		{
			System.out.println("TESTING: entrySet()");

			// setup
			BSTMap<String, Integer> map1 = new BSTMap<String, Integer>();
			map1.put("first", 1);
			map1.put("second", 2);
			map1.put("third", 3);

			// verify
			System.out.println(map1.entrySet() + " == [<first -> 1>, <second -> 2>, <third -> 3>]");
		}
	}
}
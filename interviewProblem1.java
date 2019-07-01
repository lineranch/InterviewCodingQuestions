package randomThoughts;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class interviewProblem1 {

	/*
	 * This is a coding problem I did for a phone technical test. The goal here is
	 * print these IDs one at a time and to ensure that an ID doesn't get printed
	 * multiple times in a row unless it's the last ID.
	 * 
	 * An Android ID always starts with an 'A' and is four characters long. An
	 * IPhone ID always starts with 'I' and is three characters long. At the end of
	 * each ID is the number of times the ID appears. This is always a single digit.
	 * 
	 * My game plan was to parse the string for its IDs so I could hash them. The
	 * IDs are the keys and their occurrences are the values. Each value pair is
	 * then added to an ArrayList. From there, I use a for loop nested in a while
	 * loop to print and decrement the IDs. The for loop then proceeds to print and
	 * decrement each value and the while loop continues until the list is empty.
	 * This method will ensure that an ID won't print multiple times in a row unless
	 * it's the last ID.
	 */

	public static void main(String[] args) {
		String test1 = "Abgn3Idd2Ahjk2Abvc2Igh7";
		String test2 = "Abgn2Abgn6";

		organizer(test1);
		organizer(test2);

	}

	private static void organizer(String string) {
		// Initializes each variable
		Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
		ArrayList<String> list = new ArrayList<String>();
		String ID = "";
		String toBeFilled = "";
		int occurrence = 0;

		// This chunk determines if the ID is Android or IPhone. From there, the ID is hashed
		for (int i = 0; i < string.length(); i++) {

			if (string.charAt(i) == 'A') {
				ID += string.charAt(i);
				ID += string.charAt(i + 1);
				ID += string.charAt(i + 2);
				ID += string.charAt(i + 3);

				occurrence += Character.getNumericValue(string.charAt(i + 4));
				hash.put(ID, occurrence);

				ID = "";
				occurrence = 0;
			}

			if (string.charAt(i) == 'I') {
				ID += string.charAt(i);
				ID += string.charAt(i + 1);
				ID += string.charAt(i + 2);

				occurrence += Character.getNumericValue(string.charAt(i + 3));
				hash.put(ID, occurrence);

				ID = "";
				occurrence = 0;
			}
		}

		// This chunk turns the key value pairs into an ArrayList
		Set<String> set = hash.keySet();
		for (String key : set)
			list.add(key);
		System.out.println(hash.toString());

		// This chunk loops through the list, printing and decrementing IDs.
		while (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				if (hash.get(list.get(i)) != 0) {
					toBeFilled += list.get(i) + " ";
					int valueReplacement = hash.get(list.get(i)) - 1;
					hash.replace(list.get(i), valueReplacement);

				}
				if (hash.get(list.get(i)) == 0) {
					list.remove(i);
				}
			}
		}
		
		// Prints the final answer
		System.out.println(toBeFilled);
		System.out.println();
	}
}

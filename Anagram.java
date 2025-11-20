/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		if (str1.length() != str2.length()) {
			return false;
		}
		for (int i = 0; i < str1.length(); i++) {
			char ch1 = str1.charAt(i);
			int count1 = 0;
			int count2 = 0;
			for (int j = 0; j < str1.length(); j++) {
				if (str1.charAt(j) == ch1) {
					count1++;
				}
			}
			for (int j = 0; j < str1.length(); j++) {
				if (str2.charAt(j) == ch1) {
					count2++;
				}
			}
			if (count1 != count2) {
		return false;
			}
		}

		return true;
	}

	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String ans = "";
		for (int i = 0; i < str.length(); i++) { 
			char ch = str.charAt(i);
			if (ch >= 'a' && str.charAt(i) <= 'z' || ch >= 'A' && ch <= 'Z') {
				ans += ch;
			}
		}
		return ans.toLowerCase();
	} 
	   
	public static String randomAnagram(String str) {
		char currentChar = 0;
		String ans = "";
		while (str.length() > 0) {
			int randomIndex = (int) (Math.random() * str.length());
			currentChar = str.charAt(randomIndex);
			ans += currentChar;
			str = str.substring(0, randomIndex) + str.substring(randomIndex + 1);
		}
		return ans;
	}
}

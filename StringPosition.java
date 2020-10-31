package slash.com.pack.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPosition {

	public static void main(String[] args) {
		
		StringPosition sp = new StringPosition();
		String[] words = { "foo", "bar", "the" };
		String word = "barfoofoobarthefoobarman";
	
		
		String[] permuatedWords = sp.addStrings(words);
		int eachWordLength = permuatedWords[0].length();
		
		for(int i = 0; i<word.length()-eachWordLength; i++) {
			for(int j=0;j<permuatedWords.length;j++) {
				
				if(permuatedWords[j].equals(word.substring(i,i+eachWordLength))) {
					System.out.print( i + " ");
				}
			}
		}
		
	}

	public static String[] addStrings(String[] words) {

		String[] letters = new String[words.length];

		// String str = "ABC";
		String[] str = words;
		int n = str.length;
		

		StringPosition sp = new StringPosition();
		List<String> list = sp.permute(str, 0, n - 1);
		
		System.out.println("The size of the list is --> " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println("The value in the set is " + list.get(i));
			letters[i]=list.get(i);
		}

		return letters;

	}

	private List permute(String[] str, int l, int r) {
		List<String> a = new ArrayList<String>();
		String y = new String();
		if (l == r) {
			String x = new String();
			List<String> oneWord = new ArrayList<String>();
			for (int i = 0; i < str.length; i++) {
				x = x + str[i];

			}
			
			oneWord.add(x);
//			createList(x);
			System.out.println("The value in x is " + x + "Size --> "+oneWord.size());
			return oneWord;
		} else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				List<String> oneWord = permute(str, l + 1, r);
				a.add(oneWord.get(0));
				str = swap(str, l, i);
				//a.add(oneWord.get(0));
			}
			return a;
		}
		
	}



	public String[] swap(String[] a, int i, int j) {
		String temp;
		String[] charArray = a;
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return charArray;
	}
}

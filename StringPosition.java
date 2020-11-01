package slash.com.pack.practice;

import java.util.ArrayList;
import java.util.List;

public class StringPosition {

	public static void main(String[] args) {
		
		StringPosition sp = new StringPosition();
		String[] words = { "foo", "bar", "the" };
		String word = "barfoofoobarthefoobarman";
	
		
		List <String> permuatedWords = sp.addStrings(words);
		int eachWordLength = permuatedWords.get(0).length();
		String positions = "";
		for(int i = 0; i<word.length()-eachWordLength; i++) {
			if(permuatedWords.contains(word.substring(i,i+eachWordLength))) {
				positions = positions + i + " ";
			}
		}
		
		System.out.println("Positions "+positions.trim());
		
	}

	public static List addStrings(String[] words) {

		String[] str = words;
		int n = str.length;
		
		List<String> list = new ArrayList<String> ();
		StringPosition sp = new StringPosition();
		 list = sp.permute(str, 0, n - 1, list);

		return list;

	}

	private List permute(String[] str, int l, int r, List<String> list) {
		
		String y = new String();
		if (l == r) {
			String x = new String();
			
			for (int i = 0; i < str.length; i++) {
				x = x + str[i];

			}
			
			list.add(x);
			return list;
		} else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				list = permute(str, l + 1, r, list);
				str = swap(str, l, i);
				
			}
			return list;
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

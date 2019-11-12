package com.revature.eval;

import java.util.HashMap;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		// TODO Write an implementation for this method declaration
		
		if (string == null) {
			return null;
		}
		
		String n = "";
		
		try {
			for (int i = string.length() - 1; i >= 0; i--) {
				String x = string.substring(i, i+1);
				n += x;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n; 
		
	}

	
	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
			
		// iterate through the string with for loop, 
		// create Arrays of words, word[0] added to new acronym array
		
		if (phrase == null) {
			return null;
		}
	    String[] splitted = phrase.split("\\W+");
	    String answer = "";

	    int i = 0;
	    while ( i < splitted.length) {
	      String word = splitted[i];
	      answer += word.charAt(0);
	      i++;
	    };
	    return answer.toUpperCase();
	}
	
	
	/**
	 * 3. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		
		// create hash with key and value pairs  
		
		String newString = string.toUpperCase();
 		char[] splittedWord = newString.toCharArray();
 		int addScore = 1;
 		int score = 0;

 		for ( char character : splittedWord) {
 			System.out.println(character);
 			if (character == 'D' || character == 'G') {
 				addScore = 2;
 				score += addScore;
 			} else if (character == 'B' || character == 'C' || character == 'M' || character == 'P') {
 				addScore = 3;
 				score += addScore;
 			} else if (character == 'F' || character == 'H' || character == 'W' || character == 'Y') {
 				addScore = 4;
 				score += addScore;
 			} else if (character == 'K') {
 				addScore = 5;
 				score += addScore;
 			} else if (character == 'J' || character == 'X') {
 				addScore = 8;
 				score += addScore;
 			} else if (character == 'Q' || character == 'Z') {
 				addScore = 10;
 				score += addScore;
 			} else {
 				addScore = 1;
 				score += addScore;
 			}
 		}
    

    	System.out.println(score);
    	return score; 
	}
	
	
	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return 
	 */
	public Map<String, Integer> wordCount(String string) {
	
	    
	    String[] words = string.split("\\s+");
	    String initialWord = "";
	    String comparedWord = "";
	    int counter = 1;

	    Map<String, Integer> ans = new HashMap<String, Integer>();
	    
	    for (int k = 0 ;  k < words.length - 1 ; k++ ) {
	      System.out.println("==============");
	      System.out.println("starting index :" + k);
	      initialWord = words[k];
	      if (words.length == 1) {
	          initialWord = initialWord.valueOf(0);
	          System.out.println(initialWord);
	          return ans.put(initialWord, counter);
	      } else {
	        comparedWord = words[ k + 1];
	          if (initialWord.contains(comparedWord)) {
	            counter++;
	            return ans.put(initialWord, counter);
	          }
	      }
	    }  
	  }
	}
	
	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	
}

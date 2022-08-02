package telran.words.model;

import java.util.*;

public class Anagram {
	public static boolean isAnagram(String word, String part) {
		Map<Character,Integer>wordMap = new TreeMap<>();
		Map<Character,Integer>partMap = new TreeMap<>();
		if( part == null || part.equals("")|| word.length()< part.length())
			return false;
		for (int i = 0; i < word.length(); i++) {
			wordMap.merge(Character.toLowerCase(word.charAt(i)),1,(oldVal,val)-> oldVal + 1);
			if(i < part.length())
				partMap.merge(Character.toLowerCase( part.charAt(i)),1,(oldVal,val)-> oldVal + 1);
		}
		for (Character key : partMap.keySet()){
			if(!wordMap.containsKey(key) || partMap.get(key) > wordMap.get(key))
				return false;
		}
		return true;
	}
}

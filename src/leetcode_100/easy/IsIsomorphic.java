package leetcode_100.easy;

import java.util.*;
public class IsIsomorphic {
	
	public boolean isIsomorphic(String s, String t) {
	    
	    HashMap<Character, Character> s2t = new HashMap<Character, Character>();
	    HashMap<Character, Character> t2s = new HashMap<Character, Character>();
	    int n = s.length();
	    for(int i = 0; i < n; i++) {
	    	char x = s.charAt(i);
	    	char y = t.charAt(i);
	    	
	    	if(s2t.containsKey(x) && s2t.get(x) != y || t2s.containsKey(y) && t2s.get(y) != x){
	    		return false;
	    	}
	    	s2t.put(x, y);
	    	t2s.put(y, x);
	    }
	    return true;	
    }
}

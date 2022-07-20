package test.set;

import java.util.HashSet;
import java.util.Set;

public class SetEqualsTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<>();
		set.add(5);
		set.add(0);
		set.add(10);
		
		Set<Integer> set2 = new HashSet<>();
		set2.add(10);
		set2.add(5);
		set2.add(0);
		
		System.out.println("set and set2 equals? " + set.equals(set2));
	}

}

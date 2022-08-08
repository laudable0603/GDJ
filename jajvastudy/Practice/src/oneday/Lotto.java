package oneday;

import java.util.HashSet;

import java.util.Set;

public class Lotto {
public static void main(String[] args) {
		int cnt = 6;
		
		int[] arr = new int[cnt];
		
		Set<Integer> set = new HashSet<Integer>();
		
		while(set.size() < 6) {
			set.add((int)(Math.random() * 45 + 1 ));
		}
		int idx = 0;
		for(Integer n : set) {
			arr[idx++] = n;
		}
		for(int i = 0; i < set.size(); i++) {
			System.out.print(arr[i] + " ");
		}
		
		
	}
	
}

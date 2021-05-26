import java.util.*;
public class List1 {
	public static void main(String[] args) {
		//creating a list
		List<Integer> l1 = new ArrayList<Integer>();
		//add 1 at 0 index
		l1.add(0, 1);
		//add 2 at 1 index
		l1.add(1, 2);
		System.out.println(l1);
		//creating another list
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(1);
		l2.add(2);
		l2.add(3);
		// will add list l2 from index 1 at l1
		l1.addAll(1,l2);
		System.out.println(l1);
		//remove element from index 1
		l1.remove(1);
		System.out.println(l1);
		//print element from index 3
		System.out.println(l1.get(3));
		//replace 0th element with 5
		l1.set(0, 5);
		System.out.println(l1);
		
		List<String> a1 = new ArrayList<>();
		
		a1.add("List");
		a1.add("and algorithm");
		a1.add(1,"DataStructures");
		
		System.out.println(a1);
		
		a1.set(0, "Coding");
		System.out.println(a1);
		
		a1.remove(1);
		
		a1.add("Microsoft");
		a1.remove("and algorithm");
		
		System.out.println(a1);
		
		a1.add("Google");
		a1.add("Amazon");
		a1.add("Apple");
		System.out.println(a1);
		for(int i=0;i<a1.size();i++) {
			System.out.print(a1.get(i) + " ");
		}
		System.out.println();
		for(String str: a1)
			System.out.print(str + " ");
		
	}

}

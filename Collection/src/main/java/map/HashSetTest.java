package map;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		
		set.add("A");
		set.add("A");
		set.add("B");
		
		System.out.println(set.size());
	
		Employee emp0 = new Employee(123);
		Employee emp1 = new Employee(123);
		Employee emp2 = new Employee(123);
		Employee emp3 = new Employee(123);
		Employee emp4 = new Employee(121);
		
		Employee[] empArray = new Employee[5];
		empArray[0]= emp0;
		empArray[1]=emp1;
		empArray[2]=emp2;
		empArray[3]=emp3;
		empArray[4]=emp4;
		Set<Employee> set2 = new HashSet<Employee>();
	
		int count = 0 ;
		for(int i = 0 ; i < empArray.length ; i++) {
			if(set2.add(empArray[i])) {
				
			}else {
				count++;
				System.out.println(count + " : Duplicates employee found");
			}
		}
		System.out.println(set2.size());
		
		
		
		
		

	}

}

package map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String,Integer>();
		
		map.put("A", 26);
		map.put("A", 56);
		map.put("A",26);
		map.put("A",29);
		
		System.out.println(map.size());
		System.out.println(map);
		
		Employee empid1 = new Employee(123);
		Employee empid2 = new Employee(123);
		Employee empid3 = new Employee(1234);
		
		System.out.println(empid1==empid2);
		
		Map<Employee, String> mapId = new HashMap<Employee, String>();
		mapId.put(empid1, "vivek");
		mapId.put(empid2, "kartic"); /// here call the custome equals and hascode() method 
		mapId.put(empid3, "E");
		
		System.out.println(mapId.size());
		System.out.println(mapId);
		
		
	}

}

package map;

public class Employee {
	
	int empId;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Employee(int empId) {
		super();
		this.empId = empId;
	}

	public Employee() {
	 
	}
	
	// implements for custome hascode and equesls method to remove the duplicat entry in the map 
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return empId;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Employee emp = (Employee)obj;
		if(empId == emp.empId) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " "+empId; 
	}
	
	

}


public class Employee {
	private int idemployee;
	private String name;
	private String department;
	private int salary;

	public Employee(){
		salary=-1;
	}
	public int getIdemployee() {
		return idemployee;
	}

	public void setIdemployee(int idemployee) {
		this.idemployee = idemployee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [idemployee=" + idemployee + ", name=" + name
				+ ", department=" + department + ", salary=" + salary + "]";
	}

	
}



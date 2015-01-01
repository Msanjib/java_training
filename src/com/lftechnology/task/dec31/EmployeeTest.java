package com.lftechnology.task.dec31;

/**
 * Q.5. Create a class called Employee that includes three pieces of information
 * as instance variables a first name (type String), a last name (type String)
 * and a monthly salary (double). Your class should have a constructor that
 * initializes the three instance variables. Provide a set and a get method for
 * each instance variable. Write a test application named EmployeeTest that
 * demonstrates class Employee's capabilities. Create two Employee objects and
 * display each object's yearly salary. Then give each Employee a 10% raise and
 * display each Employee's yearly salary again.
 * 
 * @author Sanjib Maharjan
 * 
 */
public class EmployeeTest {
	public static void main(String[] args) {
		Employee employee1 = new Employee("Ajit", "Bhakta", 10000);
		Employee employee2 = new Employee("Bjit", "Atreya", 15000);
		listAllEmployee(new Employee[] { employee1, employee2 });

	}

	/**
	 * 
	 * This method lists the arrays of employee objects{@link Employee} and
	 * displays their info.
	 * 
	 * @param employees
	 *            an array of employee object{@link Employee}
	 * @see Employee
	 */
	public static void listAllEmployee(Employee[] employees) {
		int numEmployees = employees.length;
		System.out.println("Employee Information");
		for (int i = 0; i < numEmployees; i++) {
			System.out.println("Employee " + (i + 1) + "\nName:"
					+ employees[i].getFirstName() + " "
					+ employees[i].getLastName() + "\tMonthly Salary:Rs."
					+ employees[i].getMonthlySalary());
			employees[i]
					.setMonthlySalary(employees[i].getMonthlySalary() * 1.1);
			System.out.println("Salary after 10% increase:Rs."
					+ employees[i].getMonthlySalary());
		}

	}
}

/**
 * This stores ths employee blueprints for storing firstname, lastname and
 * monthly salary
 * 
 * @author Sanjib Maharjan
 */
class Employee {
	private String firstName;
	private String lastName;
	private double monthlySalary;

	public Employee(String firstName, String lastName, double monthlySalary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.monthlySalary = monthlySalary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

}

package com.lftechnology.task.dec31;

/**
 * Write a program that calculates percentage and GPA of 5 students. Each of the
 * students has following attributes: name, class, rollnum, and marks obtained
 * in 5 subjects.
 * 
 * @author My Snjb
 * 
 */
public class StudentScore {
	public static void main(String[] args) {
		// Adding students Information manually
		Student student1 = new Student("Aakash", 5, 1, new float[] { 96, 90,
				70, 92, 86 });
		Student student2 = new Student("Bikash", 5, 2, new float[] { 88, 89,
				69, 88, 77 });
		Student student3 = new Student("Ciraj", 5, 3, new float[] { 93, 88, 62,
				75, 89 });
		Student student4 = new Student("Dijna", 5, 4, new float[] { 91, 70, 88,
				66, 80 });
		Student student5 = new Student("Elea", 5, 5, new float[] { 90, 89, 67,
				71, 66 });
		listAllStudents(new Student[] { student1, student2, student3, student4,
				student5 });
	}

	public static void listAllStudents(Student[] students) {
		int numStudents = students.length;
		for (int i = 0; i < numStudents; i++) {
			students[i].displayStudentInfo();
		}

	}
}

/**
 * This stores ths simple blueprints for storing student information of name,
 * class, roll and obtained marks.
 * 
 * @author Sanjib Maharjan
 */
class Student {
	private String name;
	private int currentClass;
	private int roll;
	private float marks[];

	public Student(String name, int currentClass, int roll, float marks[]) {
		this.name = name;
		this.currentClass = currentClass;
		this.roll = roll;
		this.marks = marks;
	}

	public void displayStudentInfo() {
		System.out.println("Name:" + name + " Class:" + currentClass + " Roll:"
				+ roll + "\nPercentage:" + getMarksInPercentage() + "\tGpa:"
				+ getMarksInGpa());
	}

	public String getMarksInPercentage() {

		return 100 * getTotalMarks() / getFullMarks() + "%";
	}

	public String getMarksInGpa() {
		float gpa = 4 * getTotalMarks() / getFullMarks();
		String gpaScore = "";
		if (gpa > 3.5) {
			gpaScore = "A";
		} else if (gpa > 3) {
			gpaScore = "B";
		} else if (gpa > 2.5) {
			gpaScore = "C";
		} else if (gpa > 2) {
			gpaScore = "D";
		} else {
			gpaScore = "E";
		}
		return gpa + "(" + gpaScore + ")";
	}

	/**
	 * Sums up the total value in the array of marks obtained by the Student
	 * {@link Student}
	 * 
	 * @return the total marks obtained by the Students.
	 */
	public float getTotalMarks() {
		float total = 0;
		int numSubjects = marks.length;
		for (int i = 0; i < numSubjects; i++) {
			total += marks[i];
		}
		return total;
	}

	/**
	 * <b>Note:</b> Full marks of a subject is assumed 100.
	 * 
	 * @return the full marks.
	 */
	public int getFullMarks() {
		return marks.length * 100;
	}
}
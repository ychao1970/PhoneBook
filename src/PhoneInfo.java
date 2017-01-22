
import java.io.*;

/*
 * this class is used to define required phoneInfo class
 * attribute, show info method etc
 *
 * 
 * @author  YueYang Yu  (EARL MARCH PUBLIC SCHOOL)
 * @version 1.0
 * @since   2017-01-22
 *  
 */

class PhoneInfo implements Serializable {
	/**
	 * define phoneInfo class attribute
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String phoneNumber;
	String school;
	String grade;
	String age;
	String type;

	/* init class PhoneInfo attribute */
	public PhoneInfo(String name, String num, String school, String grade, String age, String type) {
		this.name = name;
		this.phoneNumber = num;
		this.school = school;
		this.grade = grade;
		this.age = age;
		this.type = type;
	}

	/* method is used to show phone info */
	public void showPhoneInfo() {
		System.out.println("name: " + name);
		System.out.println("phone: " + phoneNumber);
		System.out.println("school: " + school);
		System.out.println("grade: " + grade);
		System.out.println("age: " + age);
		System.out.println("type: " + type);
	}

	/* toString() to search out result */
	public String toString() {
		return "name: " + name + '\n' + "phone: " + phoneNumber + '\n' + "school: " + school + '\n' + "grade: " + grade
				+ '\n' + "age: " + age + '\n' + "type: " + type + '\n';
	}

	/* method to do hash code */
	public int hashCode() {
		return name.hashCode();
	}

	/* judge are both hash be integrated */
	public boolean equals(Object obj) {
		PhoneInfo cmp = (PhoneInfo) obj;
		if (name.compareTo(cmp.name) == 0)
			return true;
		else
			return false;
	}
}

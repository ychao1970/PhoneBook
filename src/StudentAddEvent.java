
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

/*
 * this class is for mouse click event to add student entry into database
 * verify input data valid or not
 * send proper error message to info textArea when invalid data input
 * add input data into database after verify all input data is valid
 * 
 * @author  YueYang Yu  (EARL MARCH PUBLIC SCHOOL)
 * @version 1.0
 * @since   2017-01-22
 *  
 */
class StudentAddEvent extends MouseAdapter {
	JTextField nameField;
	JTextField gradeField;
	JTextField ageField;
	JTextField schoolField;
	JTextField phoneField;
	JTextArea textArea;

	/* Initialize class attribute */
	public StudentAddEvent(JTextField name, JTextField school, JTextField grade, JTextField age, JTextField phone) {
		nameField = name;
		schoolField = school;
		ageField = age;
		gradeField = grade;
		phoneField = phone;

	}

	/* Override mouse click event */
	@Override
	public void mouseClicked(MouseEvent e) {
		boolean isAdded = false;
		boolean dataValid = true;
		PhoneInfo info;
		String name = nameField.getText();
		String school = schoolField.getText();
		String grade = gradeField.getText();
		String phone = phoneField.getText();
		String age = ageField.getText();
		String type = "student";

		/* create phone book manager object */
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		StringBuilder infoBoard = new StringBuilder("you have add ");

		/* verify input name is valid or not */
		if (name.length() > 30 || name.length() <= 0) {
			infoBoard.append("you input student name " + name + " is too long, longer than 30 or is null \n");
			PhoneBook.infoTextArea.append(infoBoard.toString());
			PhoneBook.infoTextArea.append("\n");
			dataValid = false;
		}
		/* verify school name is valid or not */
		if (school.length() > 30 || school.length() <= 0) {
			infoBoard.append("you input student school name " + school + " is too long, longer than 30 or is null \n");
			PhoneBook.infoTextArea.append(infoBoard.toString());
			PhoneBook.infoTextArea.append("\n");
			dataValid = false;
		}

		/* verify input grade is valid or not */
		try {
			if (Integer.parseInt(grade) > 18 || Integer.parseInt(grade) <= 0) {
				infoBoard.append("you input student grade " + grade + " is invalid \n");
				PhoneBook.infoTextArea.append(infoBoard.toString());
				PhoneBook.infoTextArea.append("\n");
				dataValid = false;
			}
		} catch (NumberFormatException e1) {
			infoBoard.append("you input student grade " + grade + " is invalid \n");
			PhoneBook.infoTextArea.append(infoBoard.toString());
			PhoneBook.infoTextArea.append("\n");
			System.out.println("input age is not valid interger");
			dataValid = false;
		}

		/* verify input phone number is valid or not */
		if (phone.length() > 20 || phone.length() <= 0) {
			infoBoard.append("you input student phone number " + phone + " is too long, longer than 12 or is null\n");
			PhoneBook.infoTextArea.append(infoBoard.toString());
			PhoneBook.infoTextArea.append("\n");
			dataValid = false;
		}

		/* verify input age is valid or not */
		try {
			if (Integer.parseInt(age) <= 0 || Integer.parseInt(age) > 22) {
				infoBoard.append("you input student age " + age + " is invalid \n");
				PhoneBook.infoTextArea.append(infoBoard.toString());
				PhoneBook.infoTextArea.append("\n");
				dataValid = false;
			}
		} catch (NumberFormatException e1) {
			infoBoard.append("you input student age " + age + " is invalid \n");
			PhoneBook.infoTextArea.append(infoBoard.toString());
			PhoneBook.infoTextArea.append("\n");
			System.out.println("input age is not valid interger");
			dataValid = false;
		}

		/*
		 * check if the name already in database show error message in infoBoard
		 * if name already in database, and set dataValid to false
		 */
		if (manager.searchData(name) != null) {
			infoBoard.append("already have this name " + name + " please input another name info \n");
			PhoneBook.infoTextArea.append(infoBoard.toString());
			PhoneBook.infoTextArea.append("\n");
			dataValid = false;
		}

		/* process input data if all are valid */
		if (dataValid) {
			info = new PhoneInfo(name, phone, school, age, grade, type);
			isAdded = manager.infoStorage.add(info);
			PhoneBook.infoTextArea.append("student Entry Add Completed.\n");
			StringBuilder dataInput = new StringBuilder("input data is: \n");
			dataInput.append("student name is: " + name + "\n");
			dataInput.append("student school is: " + school + "\n");
			dataInput.append("student Phone is: " + phone + "\n");
			dataInput.append("student grade is: " + grade + "\n");
			dataInput.append("student age is: " + age + "\n");
			PhoneBook.infoTextArea.append(dataInput.toString());
			PhoneBook.infoTextArea.append("\n");

		} else {
			PhoneBook.infoTextArea.append("input data has invalid enter, please change and add again\n");
			PhoneBook.infoTextArea.append("\n");
		}

		/* Send proper message to info text area after add data */
		if (isAdded) {
			PhoneBook.infoTextArea.append("input data has been added successfully\n");
			try {
				manager.printInfoStorage();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		} else {
			PhoneBook.infoTextArea.append("input data has not been added, Failed");
			PhoneBook.infoTextArea.append("\n");
		}

	}
}


import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

/*
 * this class is for mouse click event to update teacher entry into database
 * verify input data valid or not
 * send proper error message to info textArea when invalid data input
 * add input data into database after verify all input data is valid
 * 
 * @author  YueYang Yu  (EARL MARCH PUBLIC SCHOOL)
 * @version 1.0
 * @since   2017-01-22
 *  
 */
class TeacherUpdateEvent extends MouseAdapter {
	JTextField nameField;
	JTextField majorField;
	JTextField ageField;
	JTextField schoolField;
	JTextField phoneField;
	JTextArea textArea;

	/* Initialize class attribute */
	public TeacherUpdateEvent(JTextField name, JTextField school, JTextField grade, JTextField age, JTextField phone) {
		nameField = name;
		schoolField = school;
		ageField = age;
		majorField = grade;
		phoneField = phone;

	}

	/* Override mouse click event */
	@Override
	public void mouseClicked(MouseEvent e) {
		boolean isUpdate = false;
		boolean isDeleted = false;
		boolean dataValid = true;
		PhoneInfo info;
		String name = nameField.getText();
		String school = schoolField.getText();
		String grade = majorField.getText();
		String phone = phoneField.getText();
		String age = ageField.getText();
		String type = "teacher";

		/* create phone book manager object */
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		StringBuilder infoBoard = new StringBuilder("you have add ");

		/* verify input name is valid or not */
		if (name.length() > 30 || name.length() <= 0) {
			infoBoard.append("you input teacher name " + name + " is too long, longer than 30 or is null \n");
			PhoneBook.infoTextArea.append(infoBoard.toString());
			PhoneBook.infoTextArea.append("\n");
			dataValid = false;
		}

		/* verify input school name is valid or not */
		if (school.length() > 30 || school.length() <= 0) {
			infoBoard.append("you input teacher school name " + school + " is too long, longer than 30 or is null \n");
			PhoneBook.infoTextArea.append(infoBoard.toString());
			PhoneBook.infoTextArea.append("\n");
			dataValid = false;
		}

		/* verify input grade is valid or not */
		try {
			if (Integer.parseInt(grade) > 18 || Integer.parseInt(grade) <= 0) {
				infoBoard.append("you input grade " + grade + " is invalid \n");
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
			infoBoard.append("you input teacher phone number " + phone + " is too long, longer than 12 or is null\n");
			PhoneBook.infoTextArea.append(infoBoard.toString());
			PhoneBook.infoTextArea.append("\n");
			dataValid = false;
		}

		/* verify input age is valid or not */
		try {
			if (Integer.parseInt(age) < 18 || Integer.parseInt(age) > 100) {
				infoBoard.append("you input teacher age " + age + " is invalid \n");
				PhoneBook.infoTextArea.append(infoBoard.toString());
				PhoneBook.infoTextArea.append("\n");
				dataValid = false;
			}
		} catch (NumberFormatException e1) {
			infoBoard.append("you input teacher age " + age + " is invalid \n");
			PhoneBook.infoTextArea.append(infoBoard.toString());
			PhoneBook.infoTextArea.append("\n");
			System.out.println("input age is not valid interger");
			dataValid = false;
		}

		/*
		 * check if the name already in database show error message in infoBoard
		 * if name already in database, and set dataValid to false
		 */
		if (manager.searchData(name) == null) {
			infoBoard.append(
					"database does not have this teacher name " + name + " please use add funtion to add it \n");
			PhoneBook.infoTextArea.append(infoBoard.toString());
			PhoneBook.infoTextArea.append("\n");
			dataValid = false;
		}

		/* process input data if all are valid */
		if (dataValid) {
			info = new PhoneInfo(name, phone, school, grade, age, type);
			/*
			 * delete existing entry before add new == update entry
			 */
			isDeleted = manager.deleteData(name);
			isUpdate = manager.infoStorage.add(info);

			if (isDeleted == true && isUpdate == true) {
				PhoneBook.infoTextArea.append("Teacher Entry Add Completed.\n");
				StringBuilder dataInput = new StringBuilder("input data is: \n");
				dataInput.append("Teacher name is: " + name + "\n");
				dataInput.append("Teacher school is: " + school + "\n");
				dataInput.append("Teacher Phone is: " + phone + "\n");
				dataInput.append("Teacher grade is: " + grade + "\n");
				dataInput.append("Teacher age is: " + age + "\n");
				PhoneBook.infoTextArea.append(dataInput.toString());
				PhoneBook.infoTextArea.append("\n");
			} else {
				PhoneBook.infoTextArea.append("either remove entry or add new entry failed, please check!!!! \n");
				PhoneBook.infoTextArea.append("\n");
			}

		} else {
			PhoneBook.infoTextArea.append("input data has invalid enter, please change and add again\n");
			PhoneBook.infoTextArea.append("\n");
		}

		/* Send proper message to info text area after update data */
		if (isUpdate) {
			PhoneBook.infoTextArea.append("input data has been updated successfully\n");
			try {
				manager.printInfoStorage();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		} else {
			PhoneBook.infoTextArea.append("input data has not been updated, Failed");
			PhoneBook.infoTextArea.append("\n");
		}

	}
}


import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;


class StudentUpdateEvent extends MouseAdapter {
	JTextField nameField;
	JTextField gradeField;
	JTextField ageField;
	JTextField schoolField;
	JTextField phoneField;
	JTextArea textArea;

	public StudentUpdateEvent(JTextField name, JTextField school,JTextField grade,JTextField age,JTextField phone) {
		nameField = name;
		schoolField = school;
		ageField = age;
		gradeField = grade;
		phoneField = phone;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		boolean isUpdate = false;	
		boolean isDeleted = false;
		boolean dataValid = true;
		PhoneInfo info;
		String name = nameField.getText();
		String school = schoolField.getText();
		String grade = gradeField.getText();
		String phone = phoneField.getText();
		String age = ageField.getText();
		String type = "student";
		
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		StringBuilder infoBoard = new StringBuilder("you have add ");
		
		if (name.length() > 30 || name.length() <= 0) {
			infoBoard.append("you input student name " + name + " is too long, longer than 30 or is null \n");
			PhoneBook.infoTextArea.append(infoBoard.toString());
			PhoneBook.infoTextArea.append("\n");
			dataValid = false;
		}
		if (school.length() > 30 || school.length() <= 0) {
			infoBoard.append("you input student school name " + school + " is too long, longer than 30 or is null \n");
			PhoneBook.infoTextArea.append(infoBoard.toString());
			PhoneBook.infoTextArea.append("\n");
			dataValid = false;
		}
		try {
		    if (Integer.parseInt(grade) > 18 || Integer.parseInt(grade) <=0) {
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
		if (phone.length() > 12 || phone.length() <= 0) {
			infoBoard.append("you input student phone number " + phone + " is too long, longer than 12 or is null\n");
			PhoneBook.infoTextArea.append(infoBoard.toString());
			PhoneBook.infoTextArea.append("\n");
			dataValid = false;
		}
		try {
		    if (Integer.parseInt(age) <= 0 || Integer.parseInt(age) >22) {
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

		/* check if the name already in database
		 * show error message in infoBoard if name already in database, and set dataValid to false
		 */
		if (manager.searchData(name) == null) {
			infoBoard.append("database does not have this student name " +name + " please use add funtion to add it \n");
			PhoneBook.infoTextArea.append(infoBoard.toString());
			PhoneBook.infoTextArea.append("\n");
			dataValid = false;
		}
		
		
		if(dataValid)
		{					
			info = new PhoneInfoStudent(name, phone, school, Integer.parseInt(age),Integer.parseInt(grade), type);
			/* 
			 * delete existing entry before add new == update entry
			 */
			isDeleted = manager.deleteData(name);
			isUpdate = manager.infoStorage.add(info);
			
			if (isDeleted == true && isUpdate == true ) {
				PhoneBook.infoTextArea.append("student Entry Update Completed.\n");
				StringBuilder dataInput = new StringBuilder("input data is: \n");
				dataInput.append("student name is: " + name + "\n");
				dataInput.append("student school is: " + school + "\n");
				dataInput.append("student Phone is: " + phone + "\n");
				dataInput.append("student grade is: " + grade + "\n");
				dataInput.append("student age is: " + age + "\n");
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
		
		if(isUpdate)
		{
			PhoneBook.infoTextArea.append("input data has been added successfully\n");
			try {
				manager.printInfoStorage();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		} 
		else 
		{
			PhoneBook.infoTextArea.append("input data has not been added, Failed");
			PhoneBook.infoTextArea.append("\n");
		}
		
	}
}

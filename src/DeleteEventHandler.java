
import javax.swing.*;
import java.awt.event.*;

/*
 * this class is listening delete button click
 * when delete button is clicked, get delete name from deleteName text field
 * call deleteData method to delete entry which has that name
 * 
 * @author  YueYang Yu  (EARL MARCH PUBLIC SCHOOL)
 * @version 1.0
 * @since   2017-01-22
 *  
 */
class DeleteEventHandler extends MouseAdapter {
	JTextField delField;
	JTextArea textArea;

	public DeleteEventHandler(JTextField field, JTextArea area) {
		delField = field;
		textArea = area;
	}

	/*
	 * mouse click listening event delete data entry base on input from delete
	 * text field
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		String name = delField.getText();
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		/* call deleteData method to delete the entry with that name */
		boolean isDeleted = manager.deleteData(name);
		if (isDeleted) {
			PhoneBook.infoTextArea.append("entry name " + name + " has been removed successfully\n");
		} else {
			PhoneBook.infoTextArea.append("entry name " + name + " Remove Failed: the name does not exist.\n");
		}
	}
}

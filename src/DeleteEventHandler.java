
import javax.swing.*;
import java.awt.event.*;

class DeleteEventHandler extends MouseAdapter {
	JTextField delField;
	JTextArea textArea;

	public DeleteEventHandler(JTextField field, JTextArea area) {
		delField = field;
		textArea = area;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String name = delField.getText();
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		boolean isDeleted = manager.deleteData(name);
		if (isDeleted) {
			PhoneBook.infoTextArea.append("entry name " + name + " has been removed successfully\n");
			// textArea.append("entry name " + name + " has been removed
			// successfully\n");
		} else {
			PhoneBook.infoTextArea.append("entry name " + name + " Remove Failed: the name does not exist.\n");
		}
	}
}

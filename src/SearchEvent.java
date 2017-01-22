
import javax.swing.*;
import java.awt.event.*;

class SearchEvent extends MouseAdapter {
	JTextField textName;
	JTextArea textArea;

	public SearchEvent(JTextField txtName, JTextArea area) {
		textName = txtName;
		textArea = area;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String name = textName.getText();
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		String srchResult = manager.searchData(name);
		if (srchResult == null) {
			PhoneBook.infoTextArea.append("Search Failed: info does not exist.\n");
		} else {
			PhoneBook.infoTextArea.append("Search by Name Completed:\n");
			PhoneBook.infoTextArea.append(srchResult);
			PhoneBook.infoTextArea.append("\n");
		}
	}
}

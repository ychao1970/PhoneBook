
import javax.swing.*;
import java.awt.event.*;

/*
 * this class for search data base on name only, it's replaced by searchAny
 * 
 * @author  YueYang Yu  (EARL MARCH PUBLIC SCHOOL)
 * @version 1.0
 * @since   2017-01-22
 *  
 */
class SearchEvent extends MouseAdapter {
	JTextField textName;
	JTextArea textArea;

	public SearchEvent(JTextField txtName, JTextArea area) {
		textName = txtName;
		textArea = area;
	}

	/*
	 * mouse click event to trigger search data base on name
	 * 
	 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		String name = textName.getText();
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		/* call searchData to search base on name */
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


import javax.swing.*;
import java.awt.event.*;
import java.util.HashSet;

/*
 * this class is used to search required data from infoStorage 
 * search can support base on name, school name, teacher or student 
 * 
 * @author  YueYang Yu  (EARL MARCH PUBLIC SCHOOL)
 * @version 1.0
 * @since   2017-01-22
 *  
 */

class SearchAnyEvent extends MouseAdapter {
	JTextField textSearch;
	JTextArea textArea;
	String srcType;

	/* class constructor with parameter */
	public SearchAnyEvent(JTextField search, JTextArea area, String type) {
		textSearch = search;
		textArea = area;
		srcType = type;
	}

	/*
	 * mouse click event to trigger search data function, and create table with
	 * research result
	 * 
	 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		String searchString = textSearch.getText();
		System.out.println(searchString);
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		/* call searchAny method to search data */
		HashSet<PhoneInfo> srchResult = manager.searchAny(searchString, srcType);

		if (srchResult == null) {
			PhoneBook.infoTextArea.append("Search Failed: info does not exist.\n");
		} else {
			PhoneBook.infoTextArea.append("Search Completed:\n");
			PhoneBook.infoTextArea.append(srchResult.toString());
			PhoneBook.infoTextArea.append("\n");
			PrintPhoneBook frame = new PrintPhoneBook(srchResult);
			frame.setVisible(true);
		}
	}
}

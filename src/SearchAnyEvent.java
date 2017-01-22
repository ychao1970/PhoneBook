
import javax.swing.*;
import java.awt.event.*;
import java.util.HashSet;

class SearchAnyEvent extends MouseAdapter {
	JTextField textSearch;
	JTextArea textArea;
	String srcType;

	public SearchAnyEvent(JTextField search, JTextArea area, String type) {
		textSearch = search;
		textArea = area;
		srcType = type;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String searchString = textSearch.getText();
		System.out.println(searchString);
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
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

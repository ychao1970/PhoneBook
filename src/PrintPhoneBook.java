

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class PrintPhoneBook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ArrayList<String[]> arrayList = new ArrayList<String[]>();


	HashSet<PhoneInfo> infoStorage = new HashSet<PhoneInfo>();

	public PrintPhoneBook(HashSet<PhoneInfo> infoStorage) {
		Iterator<PhoneInfo> itr=infoStorage.iterator();
		while(itr.hasNext()) {
			PhoneInfo curInfo=itr.next();
			String[] a = {curInfo.name, curInfo.type, curInfo.school,curInfo.grade,curInfo.age,curInfo.phoneNumber};
			arrayList.add(a);
			
		}
		String[][] phoneBookList = (String [][])arrayList.toArray(new String[0][0]);
		PrintPhoneBookJtable(phoneBookList);
	}
	/**
	 * Create the table frame.
	 * @return 
	 */
	public void PrintPhoneBookJtable(String[][] phoneBookList) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		scrollPane.setBounds(0, 0, 732, 515);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(20);
		table.setGridColor(new Color(0, 0, 0));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setForeground(new Color(0, 0, 255));
		table.setBackground(new Color(220, 220, 220));
		table.setModel(new DefaultTableModel(
			phoneBookList,
			new String[] {
				"Name", "Type", "School", "Grade", "Age","phone number"
			}
		));
		scrollPane.setViewportView(table);
		

	}
}

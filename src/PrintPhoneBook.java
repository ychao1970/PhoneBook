
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

/*
 * this class is used to print phone book into Jtable
 * include print whole table, print search result table
 *
 * 
 * @author  YueYang Yu  (EARL MARCH PUBLIC SCHOOL)
 * @version 1.0
 * @since   2017-01-22
 *  
 */

public class PrintPhoneBook extends JFrame {

	/* define variable, arraylist for print Jtable */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ArrayList<String[]> arrayList = new ArrayList<String[]>();

	HashSet<PhoneInfo> infoStorage = new HashSet<PhoneInfo>();

	/*
	 * print infoStorage into Jtable iterate scan infoStorage, assign the value
	 * into string arrayList sort string arrayList to make the table content
	 * show up with sequence pass arrayList to PrintPhoneBookJtable to pint out
	 * table
	 * 
	 * @parameter: HashSet<PhoneInfo> infoStorage
	 * 
	 * @return
	 * 
	 */
	public PrintPhoneBook(HashSet<PhoneInfo> infoStorage) {
		Iterator<PhoneInfo> itr = infoStorage.iterator();
		while (itr.hasNext()) {
			PhoneInfo curInfo = itr.next();
			String[] a = { curInfo.name, curInfo.type, curInfo.school, curInfo.grade, curInfo.age,
					curInfo.phoneNumber };
			arrayList.add(a);

		}
		String[][] phoneBookList = (String[][]) arrayList.toArray(new String[0][0]);
		/* sort arrayList */
		Arrays.sort(phoneBookList,
				new ColumnComparator(2)); /* Sort phoneBookList */
		PrintPhoneBookJtable(phoneBookList);
	}

	/*
	 * Class that extends Comparator
	 * 
	 * @return: sorted string list
	 * 
	 **/
	public class ColumnComparator implements Comparator<Object> {
		int columnToSort;

		ColumnComparator(int columnToSort) {
			this.columnToSort = columnToSort;
		}

		/* overriding compare method */
		public int compare(Object o1, Object o2) {
			String[] row1 = (String[]) o1;
			String[] row2 = (String[]) o2;
			/* compare the columns to sort */
			return row1[columnToSort].compareTo(row2[columnToSort]);
		}
	}

	/**
	 * Create the table frame.
	 * 
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
		/* create table in GUI window */
		table.setModel(new DefaultTableModel(phoneBookList,
				new String[] { "Name", "Type", "School", "Grade", "Age", "phone number" }));
		scrollPane.setViewportView(table);

	}
}

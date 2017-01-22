package org.eclipse.wb.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class testTable extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testTable frame = new testTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			new Object[][] {
				{"Yu1", "student", "Earl March", null,"10","10", "12345"},
				{"Yu2", "student", "Earl March", null,"10","11","12345"},
				{"Yu3", "student", "Earl March", null,"10","12","12345"},
				{"Yu4", "student", "Earl March", null,"10","13","12345"},
				{"Yu5", "student", "Earl March", null,"10","14","12345"},
				{"Yu1", "student", "Earl March", null,"10","10","12345"},
				{"Yu2", "student", "Earl March", null,"10","11","12345"},
				{"Yu3", "student", "Earl March", null,"10","12","12345"},
				{"Yu4", "student", "Earl March", null,"10","13","12345"},
				{"Yu5", "student", "Earl March", null,"10","14","12345"},
				{"Yu1", "student", "Earl March", null,"10","10","12345"},
				{"Yu1", "student", "Earl March", "computer",null,"35","12345"},
				{"Yu2", "teacher", "Earl March", null,"10","11", "12345"},
				{"Yu3", "student", "Earl March", null,"10","12"},
				{"Yu4", "student", "Earl March", null,"10","13"},
				{"Yu5", "student", "Earl March", null,"10","14"},
				{"Yu1", "student", "Earl March", null,"10","10"},
				{"Yu2", "student", "Earl March", null,"10","11"},
				{"Yu3", "student", "Earl March", null,"10","12"},
				{"Yu4", "student", "Earl March", null,"10","13"},
				{"Yu5", "student", "Earl March", null,"10","14"},
				{"Yu1", "student", "Earl March", null,"10","10", "12345"},
				{"Yu2", "student", "Earl March", null,"10","11","12345"},
				{"Yu3", "student", "Earl March", null,"10","12","12345"},
				{"Yu4", "student", "Earl March", null,"10","13","12345"},
				{"Yu5", "student", "Earl March", null,"10","14","12345"},
				{"Yu1", "student", "Earl March", null,"10","10","12345"},
				{"Yu2", "student", "Earl March", null,"10","11","12345"},
				{"Yu3", "student", "Earl March", null,"10","12","12345"},
				{"Yu4", "student", "Earl March", null,"10","13","12345"},
				{"Yu5", "student", "Earl March", null,"10","14","12345"},
				{"Yu1", "student", "Earl March", null,"10","10","12345"},
				{"Yu1", "student", "Earl March", "computer",null,"35","12345"},
				{"Yu2", "teacher", "Earl March", null,"10","11", "12345"},
				{"Yu3", "student", "Earl March", null,"10","12"},
				{"Yu4", "student", "Earl March", null,"10","13"},
				{"Yu5", "student", "Earl March", null,"10","14"},
				{"Yu1", "student", "Earl March", null,"10","10"},
				{"Yu2", "student", "Earl March", null,"10","11"},
				{"Yu3", "student", "Earl March", null,"10","12"},
				{"Yu4", "student", "Earl March", null,"10","13"},
				{"Yu5", "student", "Earl March", null,"10","14"},
				{"Yu1", "student", "Earl March", null,"10","10", "12345"},
				{"Yu2", "student", "Earl March", null,"10","11","12345"},
				{"Yu3", "student", "Earl March", null,"10","12","12345"},
				{"Yu4", "student", "Earl March", null,"10","13","12345"},
				{"Yu5", "student", "Earl March", null,"10","14","12345"},
				{"Yu1", "student", "Earl March", null,"10","10","12345"},
				{"Yu2", "student", "Earl March", null,"10","11","12345"},
				{"Yu3", "student", "Earl March", null,"10","12","12345"},
				{"Yu4", "student", "Earl March", null,"10","13","12345"},
				{"Yu5", "student", "Earl March", null,"10","14","12345"},
				{"Yu1", "student", "Earl March", null,"10","10","12345"},
				{"Yu1", "student", "Earl March", "computer",null,"35","12345"},
				{"Yu2", "teacher", "Earl March", null,"10","11", "12345"},
				{"Yu3", "student", "Earl March", null,"10","12"},
				{"Yu4", "student", "Earl March", null,"10","13"},
				{"Yu5", "student", "Earl March", null,"10","14"},
				{"Yu1", "student", "Earl March", null,"10","10"},
				{"Yu2", "student", "Earl March", null,"10","11"},
				{"Yu3", "student", "Earl March", null,"10","12"},
				{"Yu4", "student", "Earl March", null,"10","13"},
				{"Yu5", "student", "Earl March", null,"10","14"},
			},
			new String[] {
				"Name", "Type", "School", "Major", "Grade", "Age","phone number"
			}
		));
		scrollPane.setViewportView(table);
	}
}

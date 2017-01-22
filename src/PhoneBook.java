import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class PhoneBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField textPhone;
	private JTextField deleteNameTextField;
	private JTable table;
	private JTextField teacherNameTextField;
	private JTextField teacherSchoolTextField;
	private JTextField teacherPhoneTextField;
	private JTextField teacherMajorTextField;
	private JTextField studentNameTextField;
	private JTextField studentSchoolTextField;
	private JTextField studentPhoneTextField;
	private JTextField studentGradeTextField;
	public static JTextArea infoTextArea;
	private JTextField teacherAgeTextField;
	private JTextField studentAgeTextField;
	private JScrollPane infoPanel;
	private JLabel teacherAgeLabel;



	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhoneBook frame = new PhoneBook();
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
	public PhoneBook() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(11, 11, 420, 116);
		searchPanel.setBackground(new Color(30, 144, 255));
		searchPanel.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), 
				"SEARCH", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "SEARCH", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel addPanel = new JPanel();
		addPanel.setBounds(11, 139, 420, 224);
		addPanel.setBackground(new Color(255, 255, 0));
		addPanel.setBorder(new TitledBorder(null, "ADD/UPDATE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel deletePanel = new JPanel();
		deletePanel.setBounds(11, 369, 420, 63);
		deletePanel.setBackground(new Color(255, 182, 193));
		deletePanel.setBorder(new TitledBorder(null, "DELETE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		infoPanel = new JScrollPane();
		infoPanel.setBounds(449, 5, 403, 336);
		infoPanel.setName("NAME");
		infoPanel.setBackground(Color.LIGHT_GRAY);
		infoPanel.setViewportBorder(new TitledBorder(null, "INFOMRATION BOARD", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel exportPanel = new JPanel();
		exportPanel.setBounds(449, 347, 408, 105);
		exportPanel.setBackground(new Color(245, 222, 179));
		exportPanel.setBorder(new TitledBorder(null, "IMPORT/EXPORT", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane tablePanel = new JScrollPane();
		tablePanel.setBounds(11, 458, 846, 103);
		tablePanel.setBackground(new Color(143, 188, 143));
		tablePanel.setViewportBorder(new TitledBorder(null, "PhoneBook Print Table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		table = new JTable();
		tablePanel.setViewportView(table);
		
		JButton exportDataButton = new JButton("EXPORT DATA TO FILE");
		exportDataButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PhoneBookManager manager = PhoneBookManager.createManagerInst();
				manager.storeToFile();
			}
		});
		exportDataButton.setOpaque(true);
		exportDataButton.setBackground(new Color(106, 90, 205));
		exportDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton importDataButton = new JButton("IMPORT DATA FROM FILE");
		importDataButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PhoneBookManager manager = PhoneBookManager.createManagerInst();
				manager.readFromFile();
			}
		});
		importDataButton.setOpaque(true);
		importDataButton.setBackground(new Color(106, 90, 205));
		GroupLayout gl_exportPanel = new GroupLayout(exportPanel);
		gl_exportPanel.setHorizontalGroup(
			gl_exportPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_exportPanel.createSequentialGroup()
					.addGap(98)
					.addGroup(gl_exportPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_exportPanel.createSequentialGroup()
							.addGap(6)
							.addComponent(exportDataButton))
						.addComponent(importDataButton))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		gl_exportPanel.setVerticalGroup(
			gl_exportPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_exportPanel.createSequentialGroup()
					.addGap(11)
					.addComponent(importDataButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(exportDataButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		exportPanel.setLayout(gl_exportPanel);
		
		JLabel deleteNameLabel = new JLabel("NAME");
		deletePanel.add(deleteNameLabel);
		
		deleteNameTextField = new JTextField();
		deletePanel.add(deleteNameTextField);
		deleteNameTextField.setColumns(10);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addMouseListener((new DeleteEventHandler(deleteNameTextField, infoTextArea)));

		btnDelete.setOpaque(true);
		btnDelete.setBackground(new Color(255, 0, 0));
		deletePanel.add(btnDelete);
		addPanel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 408, 212);
		addPanel.add(tabbedPane);
		
		JPanel teacherPanel = new JPanel();
		tabbedPane.addTab("teacher", null, teacherPanel, null);
		teacherPanel.setLayout(null);
		
		JLabel teacherNamePanel = new JLabel("NAME");
		teacherNamePanel.setBounds(28, 10, 37, 16);
		teacherPanel.add(teacherNamePanel);
		
		teacherAgeTextField = new JTextField();
		teacherAgeTextField.setBounds(94, 121, 130, 26);
		teacherPanel.add(teacherAgeTextField);
		teacherAgeTextField.setColumns(10);
		
		teacherNameTextField = new JTextField();
		teacherNameTextField.setBounds(94, 5, 130, 26);
		teacherNameTextField.setColumns(10);
		teacherPanel.add(teacherNameTextField);
		
		JLabel teacherSchoolLabel = new JLabel("SCHOOL");
		teacherSchoolLabel.setBounds(28, 38, 53, 16);
		teacherPanel.add(teacherSchoolLabel);
		
		JLabel teacherPhoneLabel = new JLabel("PHONE ");
		teacherPhoneLabel.setBounds(28, 97, 48, 16);
		teacherPanel.add(teacherPhoneLabel);
		
		JLabel teacherMajorLabel = new JLabel("GRADE");
		teacherMajorLabel.setBounds(28, 66, 43, 16);
		teacherPanel.add(teacherMajorLabel);
		
		teacherAgeLabel = new JLabel("AGE");
		teacherAgeLabel.setBounds(28, 125, 52, 16);
		teacherPanel.add(teacherAgeLabel);
		
		teacherSchoolTextField = new JTextField();
		teacherSchoolTextField.setBounds(94, 36, 130, 26);
		teacherSchoolTextField.setColumns(10);
		teacherPanel.add(teacherSchoolTextField);
		
		teacherPhoneTextField = new JTextField();
		teacherPhoneTextField.setBounds(94, 93, 130, 26);
		teacherPhoneTextField.setColumns(10);
		teacherPanel.add(teacherPhoneTextField);
		
		teacherMajorTextField = new JTextField();
		teacherMajorTextField.setBounds(94, 61, 130, 26);
		teacherMajorTextField.setColumns(10);
		teacherPanel.add(teacherMajorTextField);
		
		JButton buttonAddTeacher = new JButton("ADD");
		buttonAddTeacher.addMouseListener((new TeacherAddEvent(teacherNameTextField,teacherSchoolTextField,
				teacherMajorTextField,teacherAgeTextField,teacherPhoneTextField)));
		
		buttonAddTeacher.setBounds(270, 33, 75, 29);
		buttonAddTeacher.setOpaque(true);
		buttonAddTeacher.setBackground(new Color(0, 128, 0));
		teacherPanel.add(buttonAddTeacher);
		
		JButton buttonUpdateTeacher = new JButton("UPDATE");
		buttonUpdateTeacher.setBounds(263, 74, 94, 29);
		buttonUpdateTeacher.setOpaque(true);
		buttonUpdateTeacher.setBackground(new Color(0, 128, 0));
		teacherPanel.add(buttonUpdateTeacher);

		buttonUpdateTeacher.addMouseListener((new TeacherUpdateEvent(teacherNameTextField,teacherSchoolTextField,
				teacherMajorTextField,teacherAgeTextField,teacherPhoneTextField)));

		
		JButton buttonClear = new JButton("CLEAR");
		buttonClear.setOpaque(true);
		buttonClear.setBackground(new Color(0, 0, 255));
		buttonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherNameTextField.setText("");
				teacherSchoolTextField.setText("");
				teacherPhoneTextField.setText("");
				teacherMajorTextField.setText("");
				teacherAgeTextField.setText("");
			}
		});
		buttonClear.setBounds(251, 121, 117, 29);
		teacherPanel.add(buttonClear);

		
		JPanel StudentPanel = new JPanel();
		tabbedPane.addTab("Student", null, StudentPanel, null);
		StudentPanel.setLayout(null);
		
		JLabel studentNameLabel = new JLabel("NAME");
		studentNameLabel.setBounds(31, 11, 37, 16);
		StudentPanel.add(studentNameLabel);
		
		studentNameTextField = new JTextField();
		studentNameTextField.setColumns(10);
		studentNameTextField.setBounds(97, 6, 130, 26);
		StudentPanel.add(studentNameTextField);
		
		JLabel studentSchoolLabel = new JLabel("SCHOOL");
		studentSchoolLabel.setBounds(31, 39, 53, 16);
		StudentPanel.add(studentSchoolLabel);
		
		JLabel studentPhoneLabel = new JLabel("PHONE ");
		studentPhoneLabel.setBounds(31, 98, 48, 16);
		StudentPanel.add(studentPhoneLabel);
		
		JLabel studentGradeLabel = new JLabel("GRADE");
		studentGradeLabel.setBounds(31, 70, 43, 16);
		StudentPanel.add(studentGradeLabel);
		
		JLabel studentAgeLabel = new JLabel("AGE");
		studentAgeLabel.setBounds(32, 127, 52, 16);
		StudentPanel.add(studentAgeLabel);
		
		studentSchoolTextField = new JTextField();
		studentSchoolTextField.setColumns(10);
		studentSchoolTextField.setBounds(97, 37, 130, 26);
		StudentPanel.add(studentSchoolTextField);
		
		studentPhoneTextField = new JTextField();
		studentPhoneTextField.setColumns(10);
		studentPhoneTextField.setBounds(97, 94, 130, 26);
		StudentPanel.add(studentPhoneTextField);
		
		studentGradeTextField = new JTextField();
		studentGradeTextField.setColumns(10);
		studentGradeTextField.setBounds(97, 62, 130, 26);
		StudentPanel.add(studentGradeTextField);
		
		studentAgeTextField = new JTextField();
		studentAgeTextField.setBounds(97, 127, 130, 26);
		StudentPanel.add(studentAgeTextField);
		studentAgeTextField.setColumns(10);
		
		JButton buttonAddStudent = new JButton("ADD");
		buttonAddStudent.addMouseListener((new StudentAddEvent(studentNameTextField,studentSchoolTextField,
				studentGradeTextField,studentAgeTextField,studentPhoneTextField)));

		buttonAddStudent.setOpaque(true);
		buttonAddStudent.setBackground(new Color(0, 128, 0));
		buttonAddStudent.setBounds(273, 34, 75, 29);
		StudentPanel.add(buttonAddStudent);
		
		JButton buttonUpdateStudent = new JButton("UPDATE");
		buttonUpdateStudent.addMouseListener((new StudentUpdateEvent(studentNameTextField,studentSchoolTextField,
				studentGradeTextField,studentAgeTextField,studentPhoneTextField)));

		buttonUpdateStudent.setOpaque(true);
		buttonUpdateStudent.setBackground(new Color(0, 128, 0));
		buttonUpdateStudent.setBounds(266, 75, 94, 29);
		StudentPanel.add(buttonUpdateStudent);
		
		JButton buttonClearStudent = new JButton("CLEAR");
		buttonClearStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				studentNameTextField.setText("");
				studentSchoolTextField.setText("");
				studentPhoneTextField.setText("");
				studentGradeTextField.setText("");
			}
		});
		buttonClearStudent.setOpaque(true);
		buttonClearStudent.setBackground(Color.BLUE);
		buttonClearStudent.setBounds(252, 122, 117, 29);
		StudentPanel.add(buttonClearStudent);
		
		txtName = new JTextField();
		txtName.setBounds(66, 29, 101, 26);
		txtName.setName("Name");
		txtName.setInheritsPopupMenu(true);
		txtName.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setBounds(66, 66, 101, 26);
		textPhone.setName("Phone");
		textPhone.setInheritsPopupMenu(true);
		textPhone.setColumns(10);
		
		JButton btnSearchName = new JButton("Search by Name");
		btnSearchName.addMouseListener((new SearchEvent(txtName, infoTextArea)));

		btnSearchName.setBounds(179, 29, 128, 29);
		btnSearchName.setOpaque(true);
		btnSearchName.setBackground(new Color(0, 128, 0));
		searchPanel.setLayout(null);
		
		JLabel nameLabel = new JLabel("NAME");
		nameLabel.setBounds(17, 34, 37, 16);
		searchPanel.add(nameLabel);
		searchPanel.add(textPhone);
		searchPanel.add(txtName);
		searchPanel.add(btnSearchName);
		
		JLabel phoneLabel = new JLabel("PHONE");
		phoneLabel.setBounds(17, 71, 61, 16);
		searchPanel.add(phoneLabel);
		
		JLabel yueyangPictureLabel = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/yueyangyu2.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));

		yueyangPictureLabel.setIcon(imageIcon);
		yueyangPictureLabel.setBounds(328, 24, 86, 79);
		searchPanel.add(yueyangPictureLabel);
		contentPane.setLayout(null);
		contentPane.add(tablePanel);
		contentPane.add(deletePanel);
		contentPane.add(addPanel);
		contentPane.add(searchPanel);
		
		JButton btnSearchByPhone = new JButton("Search by Phone");
		btnSearchByPhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String phone = textPhone.getText();
				PhoneBookManager manager=PhoneBookManager.createManagerInst();
				String srchResult = manager.searchPhone(phone);
				if(srchResult == null)
				{
					infoTextArea.append("Search Failed: info does not exist.\n");
				}
				else
				{
					infoTextArea.append("Search by Phone Completed:\n");
					infoTextArea.append(srchResult);
					infoTextArea.append("\n");
				}
			}
		});
		btnSearchByPhone.setOpaque(true);
		btnSearchByPhone.setBackground(new Color(0, 128, 0));
		btnSearchByPhone.setBounds(179, 66, 128, 29);
		searchPanel.add(btnSearchByPhone);
		searchPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtName}));
		contentPane.add(infoPanel);
		
		infoTextArea = new JTextArea();
		infoPanel.setViewportView(infoTextArea);
		contentPane.add(exportPanel);
		
		JButton btnPrintOutPhone = new JButton("Print Out Phone Book");
		btnPrintOutPhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PhoneBookManager manager=PhoneBookManager.createManagerInst();
				try {
	//				manager.printInfoStorage();
					manager.printPhoneBookTable();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPrintOutPhone.setBounds(6, 431, 188, 29);
		contentPane.add(btnPrintOutPhone);
	}
}

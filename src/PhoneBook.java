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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Font;

/*
 * this class is mainFrame GUI for phoneBookManagement, GUI is created using windowsbulider plugin in Eclipse.
 * Event listening and process is written by java 
 * 
 * @author  YueYang Yu  (EARL MARCH PUBLIC SCHOOL)
 * @version 1.0
 * @since   2017-01-22
 *  
 */

public class PhoneBook extends JFrame {

	/**
	 * define private variable in this class
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField textSchool;
	private JTextField deleteNameTextField;
	private JTextField teacherNameTextField;
	private JTextField teacherSchoolTextField;
	private JTextField teacherPhoneTextField;
	private JTextField teacherMajorTextField;
	private JTextField studentNameTextField;
	private JTextField studentSchoolTextField;
	private JTextField studentPhoneTextField;
	private JTextField studentGradeTextField;
	public static JTextArea infoTextArea; /* define class attribute */
	private JTextField teacherAgeTextField;
	private JTextField studentAgeTextField;
	private JScrollPane infoPanel;
	private JLabel teacherAgeLabel;
	private JTextField textType;

	/**
	 * Constructor to create the frame with designed model
	 */
	public PhoneBook() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(11, 5, 420, 139);
		searchPanel.setBackground(new Color(30, 144, 255));
		searchPanel.setBorder(new TitledBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "SEARCH", TitledBorder.LEADING,
						TitledBorder.TOP, null, new Color(0, 0, 0)),
				"SEARCH", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel addPanel = new JPanel();
		addPanel.setBounds(11, 162, 420, 219);
		addPanel.setBackground(new Color(255, 255, 0));
		addPanel.setBorder(new TitledBorder(null, "ADD/UPDATE", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel deletePanel = new JPanel();
		deletePanel.setBounds(11, 393, 420, 79);
		deletePanel.setBackground(new Color(255, 182, 193));
		deletePanel.setBorder(new TitledBorder(null, "DELETE", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		infoPanel = new JScrollPane();
		infoPanel.setBounds(449, 5, 403, 344);
		infoPanel.setName("NAME");
		infoPanel.setBackground(Color.LIGHT_GRAY);
		infoPanel.setViewportBorder(
				new TitledBorder(null, "INFOMRATION BOARD", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel exportPanel = new JPanel();
		exportPanel.setBounds(444, 383, 408, 89);
		exportPanel.setBackground(new Color(245, 222, 179));
		exportPanel
				.setBorder(new TitledBorder(null, "IMPORT/EXPORT", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JButton exportDataButton = new JButton("EXPORT DATA TO FILE");
		exportDataButton.setToolTipText("click to export infoStorage into output file");
		/* Mouse listening event to export data into output data file */
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
		importDataButton.setToolTipText("click to import data from input datafile into infoStroge");

		/* Mouse listening event to import data from input data file */
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
		gl_exportPanel.setHorizontalGroup(gl_exportPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_exportPanel
				.createSequentialGroup().addGap(98)
				.addGroup(gl_exportPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_exportPanel.createSequentialGroup().addGap(6).addComponent(exportDataButton))
						.addComponent(importDataButton))
				.addContainerGap(97, Short.MAX_VALUE)));
		gl_exportPanel.setVerticalGroup(gl_exportPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_exportPanel.createSequentialGroup().addComponent(importDataButton)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(exportDataButton).addContainerGap(23,
								Short.MAX_VALUE)));
		exportPanel.setLayout(gl_exportPanel);

		JLabel deleteNameLabel = new JLabel("NAME");
		deletePanel.add(deleteNameLabel);

		deleteNameTextField = new JTextField();
		deleteNameTextField.setToolTipText("enter name will be deleted");
		deletePanel.add(deleteNameTextField);
		deleteNameTextField.setColumns(10);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.RED);
		btnDelete.setToolTipText("delete entry base on name");

		/* Mouse listening event to delete entry which has the name */
		btnDelete.addMouseListener((new DeleteEventHandler(deleteNameTextField, infoTextArea)));

		btnDelete.setOpaque(true);
		btnDelete.setBackground(new Color(255, 0, 0));
		deletePanel.add(btnDelete);
		addPanel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 408, 212);
		addPanel.add(tabbedPane);

		JPanel teacherPanel = new JPanel();
		tabbedPane.addTab("Teacher", null, teacherPanel, null);
		teacherPanel.setLayout(null);

		JLabel teacherNamePanel = new JLabel("NAME");
		teacherNamePanel.setBounds(28, 10, 37, 16);
		teacherPanel.add(teacherNamePanel);

		teacherAgeTextField = new JTextField();
		teacherAgeTextField.setToolTipText("teacher age interger (24-99)");
		teacherAgeTextField.setBounds(94, 121, 130, 26);
		teacherPanel.add(teacherAgeTextField);
		teacherAgeTextField.setColumns(10);

		teacherNameTextField = new JTextField();
		teacherNameTextField.setToolTipText("teacher name String < 30 byte");
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
		teacherSchoolTextField.setToolTipText("school name String < 30 byte");
		teacherSchoolTextField.setBounds(94, 36, 130, 26);
		teacherSchoolTextField.setColumns(10);
		teacherPanel.add(teacherSchoolTextField);

		teacherPhoneTextField = new JTextField();
		teacherPhoneTextField.setToolTipText("phone number string < 20 byte");
		teacherPhoneTextField.setBounds(94, 93, 130, 26);
		teacherPhoneTextField.setColumns(10);
		teacherPanel.add(teacherPhoneTextField);

		teacherMajorTextField = new JTextField();
		teacherMajorTextField.setToolTipText("grade interger (1-12)");
		teacherMajorTextField.setBounds(94, 61, 130, 26);
		teacherMajorTextField.setColumns(10);
		teacherPanel.add(teacherMajorTextField);

		JButton buttonAddTeacher = new JButton("ADD");
		buttonAddTeacher.setToolTipText("add tearcher entry");

		/* Mouse listening event to add teacher entry */
		buttonAddTeacher.addMouseListener((new TeacherAddEvent(teacherNameTextField, teacherSchoolTextField,
				teacherMajorTextField, teacherAgeTextField, teacherPhoneTextField)));

		buttonAddTeacher.setBounds(270, 33, 75, 29);
		buttonAddTeacher.setOpaque(true);
		buttonAddTeacher.setBackground(new Color(0, 128, 0));
		teacherPanel.add(buttonAddTeacher);

		JButton buttonUpdateTeacher = new JButton("UPDATE");
		buttonUpdateTeacher.setToolTipText("update existing teacher entry");
		buttonUpdateTeacher.setBounds(263, 74, 94, 29);
		buttonUpdateTeacher.setOpaque(true);
		buttonUpdateTeacher.setBackground(new Color(0, 128, 0));
		teacherPanel.add(buttonUpdateTeacher);

		/* Mouse listening event to update teacher entry */
		buttonUpdateTeacher.addMouseListener((new TeacherUpdateEvent(teacherNameTextField, teacherSchoolTextField,
				teacherMajorTextField, teacherAgeTextField, teacherPhoneTextField)));

		JButton buttonClear = new JButton("CLEAR");
		buttonClear.setToolTipText("clear input in GUI");
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
		studentNameTextField.setToolTipText("student name < 30 bytes");
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
		studentSchoolTextField.setToolTipText("school name String < 30 bytes");
		studentSchoolTextField.setColumns(10);
		studentSchoolTextField.setBounds(97, 37, 130, 26);
		StudentPanel.add(studentSchoolTextField);

		studentPhoneTextField = new JTextField();
		studentPhoneTextField.setToolTipText("phone number String <20 byte");
		studentPhoneTextField.setColumns(10);
		studentPhoneTextField.setBounds(97, 94, 130, 26);
		StudentPanel.add(studentPhoneTextField);

		studentGradeTextField = new JTextField();
		studentGradeTextField.setToolTipText("grade integer (1-12)");
		studentGradeTextField.setColumns(10);
		studentGradeTextField.setBounds(97, 62, 130, 26);
		StudentPanel.add(studentGradeTextField);

		studentAgeTextField = new JTextField();
		studentAgeTextField.setToolTipText("student age integer < 22");
		studentAgeTextField.setBounds(97, 127, 130, 26);
		StudentPanel.add(studentAgeTextField);
		studentAgeTextField.setColumns(10);

		JButton buttonAddStudent = new JButton("ADD");
		buttonAddStudent.setToolTipText("add student entry");

		/* Mouse listening event to add student entry */
		buttonAddStudent.addMouseListener((new StudentAddEvent(studentNameTextField, studentSchoolTextField,
				studentGradeTextField, studentAgeTextField, studentPhoneTextField)));

		buttonAddStudent.setOpaque(true);
		buttonAddStudent.setBackground(new Color(0, 128, 0));
		buttonAddStudent.setBounds(273, 34, 75, 29);
		StudentPanel.add(buttonAddStudent);

		JButton buttonUpdateStudent = new JButton("UPDATE");
		buttonUpdateStudent.setToolTipText("update existing student entry");

		/* Mouse listening event to update teacher entry */
		buttonUpdateStudent.addMouseListener((new StudentUpdateEvent(studentNameTextField, studentSchoolTextField,
				studentGradeTextField, studentAgeTextField, studentPhoneTextField)));

		buttonUpdateStudent.setOpaque(true);
		buttonUpdateStudent.setBackground(new Color(0, 128, 0));
		buttonUpdateStudent.setBounds(266, 75, 94, 29);
		StudentPanel.add(buttonUpdateStudent);

		JButton buttonClearStudent = new JButton("CLEAR");
		buttonClearStudent.setToolTipText("clear current GUI input");

		/* Mouse listening event to clear student input in textField */
		buttonClearStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				studentNameTextField.setText("");
				studentSchoolTextField.setText("");
				studentPhoneTextField.setText("");
				studentGradeTextField.setText("");
				studentAgeTextField.setText("");
			}
		});
		buttonClearStudent.setOpaque(true);
		buttonClearStudent.setBackground(Color.BLUE);
		buttonClearStudent.setBounds(252, 122, 117, 29);
		StudentPanel.add(buttonClearStudent);

		txtName = new JTextField();
		txtName.setToolTipText("enter name to search");
		txtName.setBounds(66, 29, 101, 26);
		txtName.setName("Name");
		txtName.setInheritsPopupMenu(true);
		txtName.setColumns(10);

		textSchool = new JTextField();
		textSchool.setToolTipText("key in school name to search");
		textSchool.setBounds(66, 66, 101, 26);
		textSchool.setName("Phone");
		textSchool.setInheritsPopupMenu(true);
		textSchool.setColumns(10);

		JButton btnSearchName = new JButton("Search by Name");
		btnSearchName.setToolTipText("search entry by name");

		/* Mouse listening event to search by Name */
		btnSearchName.addMouseListener((new SearchAnyEvent(txtName, infoTextArea, "name")));

		btnSearchName.setBounds(179, 29, 128, 29);
		btnSearchName.setOpaque(true);
		btnSearchName.setBackground(new Color(0, 128, 0));
		searchPanel.setLayout(null);

		JLabel nameLabel = new JLabel("NAME");
		nameLabel.setBounds(17, 34, 37, 16);
		searchPanel.add(nameLabel);
		searchPanel.add(textSchool);
		searchPanel.add(txtName);
		searchPanel.add(btnSearchName);

		JLabel schoolLabel = new JLabel("SCHOOL");
		schoolLabel.setBounds(6, 71, 61, 16);
		searchPanel.add(schoolLabel);

		JLabel yueyangPictureLabel = new JLabel("");

		/* show up imgae on the GUI */
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon("src/yueyangyu2.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));

		yueyangPictureLabel.setIcon(imageIcon);
		yueyangPictureLabel.setBounds(328, 24, 86, 79);
		searchPanel.add(yueyangPictureLabel);
		contentPane.setLayout(null);
		contentPane.add(deletePanel);
		contentPane.add(addPanel);
		contentPane.add(searchPanel);

		JButton btnSearchBySchool = new JButton("Search by School");
		btnSearchBySchool.setToolTipText("search entry by school name");

		/* Mouse listening event to search by school name */
		btnSearchBySchool.addMouseListener((new SearchAnyEvent(textSchool, infoTextArea, "school")));

		btnSearchBySchool.setOpaque(true);
		btnSearchBySchool.setBackground(new Color(0, 128, 0));
		btnSearchBySchool.setBounds(179, 66, 137, 29);
		searchPanel.add(btnSearchBySchool);

		JLabel lblType = new JLabel("TYPE");
		lblType.setBounds(17, 104, 61, 16);
		searchPanel.add(lblType);

		textType = new JTextField();
		textType.setToolTipText("key in student or teacher to search");
		textType.setName("Type");
		textType.setInheritsPopupMenu(true);
		textType.setColumns(10);
		textType.setBounds(66, 99, 101, 26);
		searchPanel.add(textType);

		JButton btnSearchBytype = new JButton("Search by Type");

		/* Mouse listening event to search by type, teacher or student */
		btnSearchBytype.addMouseListener((new SearchAnyEvent(textType, infoTextArea, "type")));

		btnSearchBytype.setToolTipText("search entry by type");
		btnSearchBytype.setOpaque(true);
		btnSearchBytype.setBackground(new Color(0, 128, 0));
		btnSearchBytype.setBounds(179, 99, 128, 29);
		searchPanel.add(btnSearchBytype);
		contentPane.add(infoPanel);

		infoTextArea = new JTextArea();
		infoTextArea.setBackground(new Color(224, 255, 255));
		infoPanel.setViewportView(infoTextArea);
		contentPane.add(exportPanel);

		JButton btnPrintOutPhone = new JButton("Print Out Phone Book");
		btnPrintOutPhone.setToolTipText("click to print out whole phone book list in Jtable");
		btnPrintOutPhone.setForeground(new Color(0, 0, 255));
		btnPrintOutPhone.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnPrintOutPhone.setOpaque(true);
		btnPrintOutPhone.setBackground(new Color(0, 128, 0));

		/* Mouse listening event to print whole database into table */
		btnPrintOutPhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PhoneBookManager manager = PhoneBookManager.createManagerInst();
				try {
					manager.printPhoneBookTable();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPrintOutPhone.setBounds(329, 495, 200, 44);
		contentPane.add(btnPrintOutPhone);

		JButton btnClearInformationBoard = new JButton("CLEAR INFORMATION BOARD");

		/*
		 * Mouse listening event to clear information board once the button is
		 * clicked
		 */
		btnClearInformationBoard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				infoTextArea.setText("");
			}
		});
		btnClearInformationBoard.setOpaque(true);
		btnClearInformationBoard.setForeground(Color.RED);
		btnClearInformationBoard.setBackground(Color.ORANGE);
		btnClearInformationBoard.setBounds(625, 346, 227, 29);
		contentPane.add(btnClearInformationBoard);
	}
}

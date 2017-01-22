
import java.util.Scanner;
import java.util.Vector;
import java.util.HashSet;
import java.util.Iterator;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;


class MainFrame extends JFrame
{
	private JTextField srchField = new JTextField(15);
	private JButton srchBtn = new JButton("SEARCH");
	
	private JButton addBtn = new JButton("ADD");
	private JButton updateBtn = new JButton("UPDATE");
	private JRadioButton rbtn1 = new JRadioButton("General");
	private JRadioButton rbtn2 = new JRadioButton("School");
	private ButtonGroup buttonGroup = new ButtonGroup();
	
	private JLabel nameLabel = new JLabel("NAME");
	private JTextField nameField = new JTextField(15);
	private JLabel phoneLabel = new JLabel("PHONE NUMBER");
	private JTextField phoneField = new JTextField(15);
	private JLabel schoolLabel = new JLabel("SCHOOL");
	private JTextField schoolField = new JTextField(15);
	private JLabel yearLabel = new JLabel("YEAR");
	private JTextField yearField = new JTextField(15);
		
	private JTextField delField = new JTextField(15);
	private JButton delBtn = new JButton("DEL");
	
	private JTextArea textArea = new JTextArea(10, 25);

	public MainFrame(String title)
	{
		super(title);
		setBounds(100, 200, 330, 450);
		setSize(730,350);
		setLayout(new GridLayout(0,2,0,0));
		Border border = BorderFactory.createEtchedBorder();
		
		Border srchBorder = BorderFactory.createTitledBorder(border, "Search");
		JPanel srchPanel = new JPanel();
		srchPanel.setBorder(srchBorder);
		srchPanel.setLayout(new FlowLayout());
		srchPanel.add(srchField);
		srchPanel.add(srchBtn);
		
		Border addBorder=BorderFactory.createTitledBorder(border, "Add");
		JPanel addPanel = new JPanel();
		addPanel.setBorder(addBorder);
		addPanel.setLayout(new FlowLayout());
		
		JPanel addInputPanel = new JPanel();
		addInputPanel.setLayout(new GridLayout(0,2,5,5));
		
		buttonGroup.add(rbtn1);
		buttonGroup.add(rbtn2);
		
		addPanel.add(rbtn1);
		addPanel.add(rbtn2);
		addPanel.add(addBtn);
		addPanel.add(updateBtn);
		
		addInputPanel.add(nameLabel);
		addInputPanel.add(nameField);
		addInputPanel.add(phoneLabel);
		addInputPanel.add(phoneField);
		addInputPanel.add(schoolLabel);
		addInputPanel.add(schoolField);
		addInputPanel.add(yearLabel);
		addInputPanel.add(yearField);
		
		schoolLabel.setVisible(false);
		schoolField.setVisible(false);
		yearLabel.setVisible(false);
		yearField.setVisible(false);
		
		rbtn1.setSelected(true);
		addPanel.add(addInputPanel);
		
		rbtn1.addItemListener(
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent e)
					{
						if(e.getStateChange() == ItemEvent.SELECTED)
						{
							schoolLabel.setVisible(false);
							schoolField.setVisible(false);
							yearLabel.setVisible(false);
							yearField.setVisible(false);			
							schoolField.setText("");
							yearField.setText("");
						}
					}
				}
		);
		
		rbtn2.addItemListener(
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent e)
					{
						if(e.getStateChange() == ItemEvent.SELECTED)
						{
							schoolLabel.setVisible(true);
							schoolLabel.setText("SCHOOL");
							schoolField.setVisible(true);
							yearLabel.setVisible(true);
							yearField.setVisible(true);
						}
					}
				}
		);
		
		
		Border delBorder = BorderFactory.createTitledBorder(border, "Delete");
		JPanel delPanel = new JPanel();
		delPanel.setBorder(delBorder);
		delPanel.setLayout(new FlowLayout());
		delPanel.add(delField);
		delPanel.add(delBtn);
		
		JScrollPane scrollTextArea = new JScrollPane(textArea);	
		Border textBorder=BorderFactory.createTitledBorder(border, "Infomation Board");
		scrollTextArea.setBorder(textBorder);
		
		JPanel actionPanel = new JPanel();
		actionPanel.setLayout(new BorderLayout());
		actionPanel.add(srchPanel, BorderLayout.NORTH);
		actionPanel.add(addPanel, BorderLayout.CENTER);
		actionPanel.add(delPanel, BorderLayout.SOUTH);
		
		add(actionPanel);
		add(scrollTextArea);
		
		srchBtn.addActionListener(new SearchEventHandler(srchField, textArea));
		addBtn.addActionListener(new AddEventHandler(nameField, phoneField, schoolField, yearField, textArea));
//		delBtn.addActionListener(new DeleteEventHandler(delField, textArea));
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);	
	}
}


import java.util.Scanner;
import java.util.Vector;
import java.util.HashSet;
import java.util.Iterator;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;


class UpdateEventHandler implements ActionListener
{
	JTextField name;
	JTextField phone;
	JTextField school;
	JTextField year;
	JTextArea text;
	Vector<String> inputList = new Vector<String>();
	
	boolean isUpdated;
	
	PhoneInfo info;
	public UpdateEventHandler(JTextField nameField, JTextField phoneField, JTextField schoolField, JTextField yearField, JTextArea textArea)
	{
		name = nameField;
		phone = phoneField;
		school = schoolField;
		year = yearField;
		text = textArea;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		if(school.getText().equals("") == false && year.getText().equals("") == false)
		{
			info = new PhoneInfoSchool(name.getText(), phone.getText(), school.getText(), Integer.parseInt(year.getText()));
			isUpdated = manager.infoStorage.add(info);
		}
		else
		{
			info = new PhoneInfo(name.getText(), phone.getText());
			isUpdated = manager.infoStorage.add(info);
		}
		
		if(isUpdated)
		{
			text.append("Update Completed.\n");
		}
		else
		{
			text.append("Update Failed: info already exist.\n");
		}
	}
}

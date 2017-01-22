

import java.util.Scanner;
import java.util.Vector;
import java.util.HashSet;
import java.util.Iterator;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;



class PhoneInfoStudent extends PhoneInfo
{
	String school;
	int age;
	int grade;
	String type = "student";
	
	public PhoneInfoStudent(String name, String num, String school, int age, int grade, String type)
	{
		super(name, num);
		this.school=school;
		this.age=age;
		this.grade = grade;
		this.type = type;
	}
	
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("schoolName: "+school);
		System.out.println("age: "+ age);
		System.out.println("type: "+ type);
		System.out.println("grade: "+ grade);
	}
	
	public String toString()
	{
		return super.toString()
		    +"SchoolName: "+ school +'\n'+"age: " + age + '\n' + "grade: " + grade + '\n' + "type: " + type + '\n';
	}
}

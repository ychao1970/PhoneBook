

import java.util.Scanner;
import java.util.Vector;
import java.util.HashSet;
import java.util.Iterator;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;



class PhoneInfoTeacher extends PhoneInfo
{
	String school;
	int age;
	String major;
	String type = "teacher";
	
	public PhoneInfoTeacher(String name, String num, String school, int age, String major, String type)
	{
		super(name, num);
		this.school=school;
		this.age=age;
		this.major = major;
		this.type = type;
	}
	
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("schoolName: "+school);
		System.out.println("age: "+ age);
		System.out.println("type: "+ type);
		System.out.println("major: "+ major);
	}
	
	public String toString()
	{
		return super.toString()
		    +"SchoolName: "+ school +'\n'+"age: " + age + '\n' + "major: " + major + '\n' + "type: " + type + '\n';
	}
}

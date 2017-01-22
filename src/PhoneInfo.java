

import java.util.Scanner;
import java.util.Vector;
import java.util.HashSet;
import java.util.Iterator;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;


class PhoneInfo implements Serializable
{
	String name;
	String phoneNumber;
	String school;
	String grade;
	String age;
	String type;
	
	
	public PhoneInfo(String name, String num,String school,String grade, String age, String type)
	{
		this.name = name;
		this.phoneNumber = num;
		this.school = school;
		this.grade = grade;
		this.age = age;
		this.type = type;
	}
	
	public void showPhoneInfo()
	{
		System.out.println("name: "+name);
		System.out.println("phone: "+phoneNumber);
		System.out.println("school: "+school);
		System.out.println("grade: "+grade);
		System.out.println("age: "+age);
		System.out.println("type: "+type);
	}
	
	public String toString()
	{
		return "name: "+name+'\n'+"phone: "+phoneNumber+'\n' +"school: "+school+'\n' +"grade: "+grade+'\n' 
				+"age: "+age+'\n' +"type: "+type+'\n';
	}
	
	public int hashCode()
	{
		return name.hashCode();
	}
	
	public boolean equals(Object obj)
	{
		PhoneInfo cmp = (PhoneInfo)obj;
		if(name.compareTo(cmp.name) == 0)
			return true;
		else
			return false;
	}
}


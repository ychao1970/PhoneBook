

import java.util.Scanner;
import java.util.Vector;
import java.util.HashSet;
import java.util.Iterator;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;



class PhoneInfoSchool extends PhoneInfo
{
	String school;
	int year;	
	
	public PhoneInfoSchool(String name, String num, String school, int year)
	{
		super(name, num);
		this.school=school;
		this.year=year;
	}
	
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("schoolName: "+school);
		System.out.println("year: "+year);
	}
	
	public String toString()
	{
		return super.toString()
		    +"SchoolName: "+ school +'\n'+"year: "+year+'\n';
	}
}

package com.springHibernate.beans;

import beans.Student;
import context.ContextProvider;
import dao.StudentDao;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

public class App {
	public static void main(String[] args) {
		
		ApplicationContext ctx= ContextProvider.provideContext();
		StudentDao studentDao=ctx.getBean("stDao",StudentDao.class);
		int choice=-1;
		 do {	 
		      Scanner sc=new Scanner(System.in);
	    	  System.out.println("1.Insert");
	    	  System.out.println("2.update");
	    	  System.out.println("3.Select by Id");
	    	  System.out.println("4.Select All");
	    	  System.out.println("5.Delete");
	    	  System.out.println("6.Exit");
	    	  choice=sc.nextInt();
	   switch(choice) {
	   case 1:
		// insert
		System.out.println("Enter no.of Entries");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
		System.out.println("Enter id");
		int id=sc.nextInt();
		System.out.println("Enter Name");
		String name=sc.next();
		Student s=new Student(id,name);
		studentDao.insert(s);
		}
		break;
	   case 2:
		// update
		System.out.println("Enter no.of Entries");
		int n2=sc.nextInt();
		for(int i=0;i<n2;i++) {
		System.out.println("Enter id");
		int id=sc.nextInt();
		System.out.println("Enter Name");
		String name=sc.next();
        Student s=studentDao.getStudent(id);
        s.setName(name);
        studentDao.update(s);
		}	
		break;
		
	   case 3:
		
		//Get Id
		   System.out.println("Enter no.of Entries");
			int n3=sc.nextInt();
		for(int i=0;i<n3;i++) {
		System.out.println("Enter id");
		int id=sc.nextInt();
		Student s=studentDao.getStudent(id);
        System.out.println(s);
		}
		break;
		
	   case 4:
		//Select All
		List<Student> students=studentDao.getAllStudents();
        for(Student s:students)
        {
            System.out.println(s);
        }
        break;
        
	   case 5:
        // delete
		System.out.println("Enter no.of Entries");
		int n5=sc.nextInt();
        for(int i=0;i<n5;i++) {
    	System.out.println("Enter id");
    	int id=sc.nextInt();
        studentDao.delete(id);
        System.out.println("---->Deleted<----");
        }
        break;
	   }
    }
	     while(choice!=7);
}
}

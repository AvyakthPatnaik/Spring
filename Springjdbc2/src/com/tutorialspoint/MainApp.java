package com.tutorialspoint;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
	   Scanner sc=new Scanner(System.in);
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      StudentJDBCTemplate studentJDBCTemplate = 
         (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
      int choice=-1;
      do {
    	  System.out.println("1.Insert");
    	  System.out.println("2.Select");
    	  System.out.println("3.Select for Id");
    	  System.out.println("4.Update");
    	  System.out.println("5.Delete");
    	  System.out.println("6.Exit");
    	  choice=sc.nextInt();
   switch(choice) {
   
      case 1:
    	  System.out.println("------Records Creation--------" );
    	  System.out.println("Enter no.of Inserted");
          int n=sc.nextInt();
       	for(int i=0;i<n;i++) {
  			System.out.println("Enter the name");
  			String name=sc.nextLine();
  			sc.nextLine();
  			System.out.println("Enter the age");
  			int age=sc.nextInt();
  			sc.nextLine();
  			studentJDBCTemplate.create(name,age);
  			}
          break;
          
      case 2:
          System.out.println("------Listing Multiple Records--------" );
          List<Student> students = studentJDBCTemplate.listStudents();
           for (Student record : students) {
           System.out.print("ID : " + record.getId() );
           System.out.print(", Name : " + record.getName() );
           System.out.println(", Age : " + record.getAge());
        }
           break;
           
      case 3:
        System.out.println("----Listing Record with ID = ? -----" );
        System.out.println("SELECT record From ID");
        int id1=sc.nextInt();
        Student student = studentJDBCTemplate.getStudent(id1);
        System.out.print("ID : " + student.getId() );
        System.out.print(", Name : " + student.getName() );
        System.out.println(", Age : " + student.getAge());
        break;
      case 4:
        System.out.println("----Updating Record with ID = ? -----" );
        System.out.println("Enter no of operation");
        int n11=sc.nextInt();
        for(int i=0;i<n11;i++) {
        System.out.println("Enter id");
        int id=sc.nextInt();
        System.out.println("Enter name");
        String name=sc.next();
        System.out.println("Enter age");
        int age=sc.nextInt();
        sc.nextLine();
        studentJDBCTemplate.update(id, name,age);
        }
        break;
      case 5:
        System.out.println("----Deleting Record with ID = ? -----" );
        System.out.println("Enter no of operation");
        int n1=sc.nextInt();
        for(int i=0;i<n1;i++) {
      	  sc.nextLine();
        System.out.println("Enter id to delete...");
        int id11=sc.nextInt();
        studentJDBCTemplate.delete(id11);;
        }
        System.out.println("Delete success....");
        break;
      case 6:
    	  System.out.println("Exit");
   default:
	   break;
   }
     }
      while(choice!=7); 
   }
}
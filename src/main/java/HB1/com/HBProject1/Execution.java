package HB1.com.HBProject1;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Execution {

	public static void main(String[] args) {
		//hello
		Scanner sc=new Scanner(System.in);
	
		/*	ORM -> Hibernate
		 * Mapping file
		 * Configuration file ->SF(DB) XML/JAVA
		 * Configaration
		 * SessionFactory -> DB deatails
		 * Session
		 */
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		
		System.out.println("Click 1 for Create & Insert");
		System.out.println("Click 2 for Update");
		System.out.println("Click 3 for Delete");
		System.out.println("Click 4 for Fetch/View");
		
		Integer req=sc.nextInt();
		switch (req) {
		case 1:{
			System.out.println("Enter E Id: ");
			Integer eid=sc.nextInt();
			System.out.println("Enter E Name: ");
			String ename=sc.next();
			System.out.println("Enter E Sal: ");
			Float esal=sc.nextFloat();
			
			Employee e1=new Employee(eid, ename, esal);
			
			Session ses=sf.openSession();
			Transaction tx=ses.beginTransaction();
			ses.save(e1);
			tx.commit();
			ses.clear();
			break;
		}
		case 2:{
			System.out.println("Enter E Id: ");
			Integer eid=sc.nextInt();
			System.out.println("Enter E Name: ");
			String ename=sc.next();
			System.out.println("Enter E Salary: ");
			Float esal=sc.nextFloat();
			Employee e2=new Employee();
			e2.setEid(eid);
			e2.setEname(ename);
			e2.setEsal(esal);
			Session ses=sf.openSession();
			Transaction tx=ses.beginTransaction();
			ses.saveOrUpdate(e2);
			tx.commit();
			ses.clear();
			break;
		}	
		case 3:{
			System.out.println("Enter E Id: ");
			Integer eid=sc.nextInt();
			
			Employee e3=new Employee();
			e3.setEid(eid);
			
			Session ses=sf.openSession();
			Transaction tx=ses.beginTransaction();
			ses.delete(e3);
			tx.commit();
			ses.clear();
			
			break;
		}
		case 4:{
			System.out.println("Enter E Id: ");
			Integer eid=sc.nextInt();
			
			
			Session ses=sf.openSession();
			
			Employee e4=ses.get(Employee.class, eid);
			System.out.println("Employee ID: "+ e4.getEid());
			System.out.println("Employee Name: "+ e4.getEname());
			System.out.println("Employee Salart: "+ e4.getEsal());
			
			System.out.println("***********************");
			Employee e5=ses.load(Employee.class, eid);
			System.out.println("Employee ID: "+ e5.getEid());
			System.out.println("Employee Name: "+ e5.getEname());
			System.out.println("Employee Salart: "+ e5.getEsal());
			ses.clear();
			
			break;
		}
		

		default:{
			break;
		}
			
		}
		
		Session ses=sf.openSession();
		
	}

}

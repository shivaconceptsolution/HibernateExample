package scs;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentInfo {

	Configuration cfg;
	SessionFactory sf;
	Session s;
	void configure()
	{
		cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sf= cfg.buildSessionFactory();
		s= sf.openSession();
	}
	void addStudent(int rno,String sname,String branch,int fees)
	{
		
		Transaction tx = s.beginTransaction();
		Student stu = new Student();
		stu.setRno(rno);
		stu.setSname(sname);
		stu.setBranch(branch);
		stu.setFees(fees);
		s.save(stu);
		tx.commit();
		s.close();
	}
	void updateStudent(int rno,String sname,String branch,int fees)
	{
		
		Transaction tx = s.beginTransaction();
		Student stu =(Student)s.load(Student.class, rno);
		stu.setSname(sname);
		stu.setBranch(branch);
		stu.setFees(fees);
		s.update(stu);
		tx.commit();
		s.close();
	}
	void deleteStudent(int rno)
	{
		
		Transaction tx = s.beginTransaction();
		Student stu =(Student)s.load(Student.class, rno);
		s.delete(stu);
		tx.commit();
		s.close();
	}
	void viewStudent()
	{
		
		Query q = s.createQuery("from Student s");
		List lst=q.list();
		Iterator it = lst.iterator();
		while(it.hasNext())
		{
			Student s1 = (Student)it.next();
			System.out.println(s1.getRno()+" "+s1.getSname()+" "+s1.getBranch()+" "+s1.getFees());
		}
		s.close();
		
	}
	public static void main(String[] args) {
		StudentInfo obj = new StudentInfo();
		obj.configure();
		//obj.addStudent(1003, "KKK", "CS", 34000);
		//obj.updateStudent(1003, "RRR", "IT", 45000);
		//obj.deleteStudent(1003);
		obj.viewStudent();

	}

}

package scs;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hello
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Student stu = new Student();
		stu.setRno(1001);
		stu.setSname("XYZ");
		stu.setBranch("CS");
		stu.setFees(12000);
		s.save(stu);
		tx.commit();
		s.close();
		
		
		

	}

}

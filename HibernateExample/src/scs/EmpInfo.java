package scs;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpInfo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();;
		Employee e = new Employee();
		e.setEmpid(1001);
		e.setEmpname("xyz");
		e.setJob("Manager");
		e.setSal(12000);
		
		s.save(e);
	    tx.commit();
	    s.close();
		

	}

}

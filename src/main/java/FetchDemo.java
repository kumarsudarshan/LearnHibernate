import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Student student = (Student) session.load(Student.class, 101);
        Student student1 = (Student) session.load(Student.class, 101);
//        Address address = (Address) session.get(Address.class, 1);
//        Address address1 = (Address) session.get(Address.class, 1);

//        System.out.println(address);
//        System.out.println(address1);
        System.out.println(student);
        System.out.println(student1);
    }
}

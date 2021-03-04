package save;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Project Started ...");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Student student = new Student(101, "Kumar", "Bangalore");
        System.out.println(student.toString());

        Address address = new Address();
        address.setCity("BANGALORE");
        address.setStreet("MARATHAHALLI");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(1234.56789);

        FileInputStream fis = new FileInputStream("src/main/resources/pic.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        address.setImage(data);

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        session.save(student);
        session.save(address);

        tx.commit();

        session.close();
        factory.close();
    }
}

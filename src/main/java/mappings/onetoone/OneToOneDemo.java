package mappings.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

public class OneToOneDemo {

    public static void main(String[] args) throws IOException {
        System.out.println("Project Started ...");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Answer answer = new Answer(11, "Java is OOP Language.");
        Question question = new Question(1,"What is Java?", answer);


        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        session.save(question); // if giving error - in hibernate.cfg.xml  <property name="hbm2ddl.auto">create</property>
        session.save(answer);

        tx.commit();

        Question ques = (Question) session.load(Question.class, 1);
        Answer ans = (Answer) session.get(Answer.class, 11);

        System.out.println(ques);
        System.out.println(ans);

        session.close();
        factory.close();
    }

}

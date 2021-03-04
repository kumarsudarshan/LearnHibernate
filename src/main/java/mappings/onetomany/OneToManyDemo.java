package mappings.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OneToManyDemo {

    public static void main(String[] args) throws IOException {
        System.out.println("Project Started ...");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Answer answer1 = new Answer(11, "Java is Programming Language.");
        Answer answer2 = new Answer(12, "Java is OOP Language.");
        Answer answer3 = new Answer(13, "Java is Platform Independent.");

        List<Answer>  answers = new ArrayList<Answer>();
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        Question question = new Question(1,"What is Java?", answers);


        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        session.save(answer1);// if giving error - in hibernate.cfg.xml  <property name="hbm2ddl.auto">create</property>
        session.save(answer2);
        session.save(answer3);
        session.save(question);


        tx.commit();

        Question ques = (Question) session.load(Question.class, 1);

        System.out.println(ques);

        session.close();
        factory.close();
    }
}

package mappings.onetomany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {

    @Id
    private int id;
    private String qname;

    @OneToMany(mappedBy = "id")
    private List<Answer> answers;

    public Question(){

    }

    public Question(int id, String qname, List<Answer> answers) {
        this.id = id;
        this.qname = qname;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", qname='" + qname + '\'' +
                ", answers=" + answers +
                '}';
    }
}
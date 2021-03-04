package mappings.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Answer {

    @Id
    private int id;
    private String answer;

    public Answer(){

    }

    public Answer(int id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                '}';
    }
}

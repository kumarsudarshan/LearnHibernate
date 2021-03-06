package save;

import embeddable.Certificate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private int Id;
    private String name;
    private String city;
    private Certificate certificate; // check in DB wheater 2 column under Certificate (course and duration) created or not.

    public Student() {
    }

    public Student(int id, String name, String city) {
        Id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "save.Student{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", certificate=" + certificate +
                '}';
    }
}

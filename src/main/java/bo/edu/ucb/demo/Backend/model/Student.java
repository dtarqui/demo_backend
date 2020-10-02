package bo.edu.ucb.demo.Backend.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
    @Column(name = "student_id")
    @Basic(optional = false)
    private Integer contactId;
    @Column(name = "full_name")
    @Basic(optional = false)
    private String fullName;

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "contactId=" + contactId +
                ", fullName='" + fullName + '\'' +
                '}';
    }

}

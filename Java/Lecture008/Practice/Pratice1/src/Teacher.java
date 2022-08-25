import java.time.LocalDate;

public class Teacher extends Person{
    private String subject;
    private long salary;

    public Teacher(int id, String name, LocalDate date, String subject, long salary) {
        super(id, name, date);
        this.subject = subject;
        this.salary = salary;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return super.toString()+" - "+subject+" - "+salary;
    }
}

import java.text.DecimalFormat;

public class Waiter extends Employee{

    private long compensate;

    public Waiter(int id, String name, int age, long basicSalary, long compensate) {
        super(id, name, age, basicSalary);
        this.compensate = compensate;
    }

    public long getCompensate() {
        return compensate;
    }

    public void setCompensate(long compensate) {
        this.compensate = compensate;
    }

    DecimalFormat dcf=new DecimalFormat("###,###,###");

    @Override
    public String toString() {
        return super.toString()+" - "+dcf.format(compensate)+" (Waiter)";
    }

    @Override
    public long calculatorSalary() {
        return (compensate+getBasicSalary());
    }
}

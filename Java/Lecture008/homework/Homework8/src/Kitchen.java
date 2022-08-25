import java.text.DecimalFormat;

public class Kitchen extends Employee{
    private long serviceCharge;

    public Kitchen(int id, String name, int age, long basicSalary, long serviceCharge) {
        super(id, name, age, basicSalary);
        this.serviceCharge = serviceCharge;
    }

    public long getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(long serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    DecimalFormat dcf=new DecimalFormat("###,###,###");

    @Override
    public String toString() {
        return super.toString()+" - "+dcf.format(serviceCharge)+" (Kitchen)";
    }

    @Override
    public long calculatorSalary() {
        return serviceCharge+getBasicSalary();
    }
}

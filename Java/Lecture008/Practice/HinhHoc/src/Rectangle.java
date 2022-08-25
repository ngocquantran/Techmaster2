public class Rectangle extends HinhHoc{

    private double edge1;
    private double edge2;


    public Rectangle(String shapeType, double edge1, double edge2) {
        super(shapeType);
        this.edge1 = edge1;
        this.edge2 = edge2;
    }

    public double getEdge1() {
        return edge1;
    }

    public void setEdge1(double edge1) {
        this.edge1 = edge1;
    }

    public double getEdge2() {
        return edge2;
    }

    public void setEdge2(double edge2) {
        this.edge2 = edge2;
    }

    @Override
    public String toString() {
        return super.toString()+" - Cạnh 1: "+edge1+" - Cạnh 2: "+edge2;
    }

    @Override
    public double getArea() {
        return edge1*edge2;
    }

    @Override
    public double getPerimeter() {
        return edge1*2+edge2*2;
    }
}

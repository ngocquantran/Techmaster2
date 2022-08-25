public class Circle extends HinhHoc{
  private double radius;



    public Circle(String shapeType, double radius) {
        super(shapeType);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return super.toString()+" - Bán kính: "+radius;
    }

    @Override
    public double getArea() {
        return (radius*radius*3.14);
    }

    @Override
    public double getPerimeter() {
        return (radius*2*3.14);
    }
}

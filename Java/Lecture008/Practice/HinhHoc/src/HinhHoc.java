public abstract class HinhHoc {

    private String shapeType;

    public HinhHoc(String shapeType) {
        this.shapeType = shapeType;
    }

    public String getShapeType() {
        return shapeType;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }

    @Override
    public String toString() {
        return shapeType + " - Diện tích "+getArea()+" - Chu vi "+getPerimeter() ;
    }

    public abstract double getArea();
    public abstract double getPerimeter();


}

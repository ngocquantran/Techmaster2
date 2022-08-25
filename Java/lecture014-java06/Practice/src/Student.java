public class Student {
    public int id;
    public String name;
    public double diemLyThuyet;
    public double diemThucHanh;
    public String truong;

    public Student(int id, String name, double diemLyThuyet, double diemThucHanh, String truong) {
        this.id = id;
        this.name = name;
        this.diemLyThuyet = diemLyThuyet;
        this.diemThucHanh = diemThucHanh;
        this.truong = truong;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", diemLyThuyet=" + diemLyThuyet +
                ", diemThucHanh=" + diemThucHanh +
                ", truong=" + truong +
                '}';
    }
}

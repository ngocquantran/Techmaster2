public class Animal {

    private String name;
    private int leg;
    private String color;

    public Animal(String name, int leg, String color) {
        this.name = name;
        this.leg = leg;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeg() {
        return leg;
    }

    public void setLeg(int leg) {
        this.leg = leg;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return name+" - "+leg+" - "+color;
    }
}

package info.md7.java.homeworks.hw_1;

public class Man {

    private String fullname;
    private int age;
    // in kilograms
    private double weight;
    // in centimeters
    private double height;
    private Sex sex;
    private String hairColor;
    private String eyeColor;
    private Nationality nationality;
    // in millimeters
    private int hairLength;

    public Man() {
        this.nationality = Nationality.RUSSIAN;
        this.eyeColor = "brown";
        this.hairColor = "blond";
    }

    public Man(String fullname, int age, double weight, double height, Sex sex, String hairColor, String eyeColor, Nationality nationality, int hairLength) {
        this.fullname = fullname;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.nationality = nationality;
        this.hairLength = hairLength;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public int getHairLength() {
        return hairLength;
    }

    public void setHairLength(int hairLength) {
        this.hairLength = hairLength;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Man{" +
                "fullname='" + fullname + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", sex=" + sex +
                ", hairColor='" + hairColor + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", nationality=" + nationality +
                '}';
    }
}

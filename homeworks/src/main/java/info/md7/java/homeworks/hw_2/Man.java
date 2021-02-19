package info.md7.java.homeworks.hw_2;

public class Man {

    private String fullname;
    private int age;
    // in kilograms
    private double weight;
    // in centimeters
    private double height;
    // Body Mass Index
    private double bmi;
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
        this.bmi = bmiCalculation(height, weight);
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

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
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

    /**
     * Method calculates BMI
     * @param height double in cm
     * @param weight double in kg
     * @return double Body Mass Index
     */
    public static double bmiCalculation(double height, double weight) {
        double heightInMeters = height / 100;
        return (weight / Math.pow(heightInMeters, 2));
    }

    /**
     * Method returns BMI Result based on index
     * @param bmi Body Mass Index
     * @return String
     */
    public static String getBmiCalculationResult(double bmi) {

        if (bmi <= 18.5) {
            return "Underweight";
        } else if (bmi >= 18.6 && bmi <= 24.9) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Overweight";
        } else if (bmi >= 30) {
            return "Obese";
        } else {
            return "";
        }

    }

    // Calculate Hair Growth Rate For a Selected Period (in days) & depending on gender
    public static double calculateHairGrowthRateForPeriod(int days, Sex sex) {
        double hairGrowthPerDay;
        if (sex == Sex.MEN) {
            hairGrowthPerDay = 0.05;
            return hairGrowthPerDay * days;
        } else {
            hairGrowthPerDay = 0.07;
            return hairGrowthPerDay * days;
        }
    }

    @Override
    public String toString() {
        return "Man{" +
                "fullname='" + fullname + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", bmi=" + bmi +
                ", sex=" + sex +
                ", hairColor='" + hairColor + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", nationality=" + nationality +
                '}';
    }
}

package info.md7.java.homeworks.hw_1;

public class Main {

    public static void main(String[] args) {

        Man roman = new Man();
        String romanInfo = String.format(" Short info about Roman: \n Nationality: %s \n Eye color: %s \n Hair color: %s \n", roman.getNationality(), roman.getEyeColor(), roman.getHairColor());
        System.out.println(romanInfo);

        roman.setFullname("Roman");
        roman.setAge(20);
        roman.setWeight(80.0);
        roman.setHeight(180);
        roman.setSex(Sex.MEN);
        roman.setHairLength(5);
        System.out.println( "Full info about Roman: \n" + roman.toString() + "\n");

        Man elena = new Man("Elena", 20, 50.0, 170, Sex.WOMAN, "black", "blue", Nationality.RUSSIAN, 200);
        System.out.println( "Full info about Elena: \n" + elena.toString() + "\n");
    }

}

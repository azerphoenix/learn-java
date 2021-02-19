package info.md7.java.homeworks.hw_2;

public class Main {

    public static void main(String[] args) {

        // Task 1
        Man roman = new Man();
        String romanInfo = String.format(" Short info about Roman: \n Nationality: %s \n Eye color: %s \n Hair color: %s \n", roman.getNationality(), roman.getEyeColor(), roman.getHairColor());
        System.out.println(romanInfo);

        roman.setFullname("Roman");
        roman.setAge(20);
        roman.setWeight(80.0);
        roman.setHeight(180);
        roman.setSex(Sex.MEN);
        roman.setBmi(21.0f);
        roman.setHairLength(5);
        System.out.println( "Full info about Roman: \n" + roman.toString() + "\n");

        Man elena = new Man("Elena", 20, 50.0, 170, Sex.WOMAN, "black", "blue", Nationality.RUSSIAN, 200);
        System.out.println( "Full info about Elena: \n" + elena.toString() + "\n");

        // Task 2

        // If Else usage (see getBmiCalculationResult() method )
        System.out.println(
                String.format(" Roman's BMI equals: %s. And the result is: %s \n", roman.getBmi(), Man.getBmiCalculationResult(roman.getBmi()))
        );

        System.out.println(
                String.format(" Elena's BMI equals: %s. And the result is: %s \n", elena.getBmi(), Man.getBmiCalculationResult(elena.getBmi()))
        );

        // Ternary operator usage
        System.out.println(
                roman.getAge() > elena.getAge() ? " Roman elder than Elena" : " Roman younger than Elena"
        );

        // Switch Case usage
        switch (roman.getNationality()) {
            case CHINESE:
                System.out.println(Nationality.CHINESE.name());
                break;
            case ROMANIAN:
                System.out.println(Nationality.ROMANIAN.name());
                break;
            case RUSSIAN:
                System.out.println(Nationality.RUSSIAN.name());
                break;
            default:
                System.out.println(Nationality.UNDEFINED.name());
        }

        // Hair Growth Calculation
        double romansHairLengthIn30Days = Man.calculateHairGrowthRateForPeriod(30, Sex.MEN);
        System.out.println("Roman's total hair length: " + (roman.getHairLength() + romansHairLengthIn30Days) + " millimeters");

        double elenasHairLengthIn30Days = Man.calculateHairGrowthRateForPeriod(30, Sex.WOMAN);
        System.out.println("Elena's total hair length: " + (elena.getHairLength() + elenasHairLengthIn30Days) + " millimeters");


    }

}

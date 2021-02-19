package info.md7.java.homeworks.hw_3;


import info.md7.java.homeworks.hw_3.pojo.Car;
import info.md7.java.homeworks.hw_3.pojo.CarBrand;
import info.md7.java.homeworks.hw_3.pojo.Passenger;
import info.md7.java.homeworks.hw_3.tools.AgeComparator;
import info.md7.java.homeworks.hw_3.tools.BubbleSort;
import info.md7.java.homeworks.hw_3.tools.ChineseCalendar;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Car car = new Car();
        car.setCarBrand(CarBrand.TOYOTA);
        car.setCarModel("Corolla");
        Passenger[] passengers = new Passenger[4];
        passengers[0] = new Passenger("John", 20);
        passengers[1] = new Passenger("Sarah", 30);
        passengers[2] = new Passenger("Jimmy", 25);
        passengers[3] = new Passenger("Deborah", 34);
        car.setPassengers(passengers);
        car.setGasolineAmount(1000);
        car.setCarDistance(0);
        car.setSpeed(0);

        /*
            Cannot assign a value to final variable mileage
            car.mileage = 100L;
         */

        System.out.println("Пример цикла for: ");
        car.printPassengersList();
        System.out.println("------");

        System.out.println("Пример цикла for each: ");
        for (Passenger passenger : passengers) {
            System.out.println(passenger.toString());
        }
        System.out.println("------");

        System.out.println("Сортируем пассажиров по возрасту при помощи пузырьковой сортировки:");
        BubbleSort.sortPassengersByAge(passengers);
        Arrays.stream(passengers).forEach(System.out::println);
        System.out.println("------");

        System.out.println("Сортируем пассажиров по возрасту при помощи Arrays.sort():");
        Arrays.sort(passengers, new AgeComparator());
        System.out.println(Arrays.toString(passengers));
        System.out.println("------");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Пройденное расстояние автомобиля: \n");
        long carDistance = car.carDistanceCalc(car.getSpeed());
        stringBuilder.append(carDistance);
        stringBuilder.append("\n");
        stringBuilder.append("Затрачиваемое время: \n");
        stringBuilder.append(car.timeCalculation(120,carDistance ));
        stringBuilder.append("\n");
        stringBuilder.append("------\n");
        System.out.println(stringBuilder);

        System.out.println("Пример двумерного массива: \nВ примере показан один из народных методов определения пола будущего ребенка.");
        System.out.println("Пол будущего ребенка: " + ChineseCalendar.calculate(30, 10));
        System.out.println("Пол будущего ребенка: " + ChineseCalendar.calculate(25, 12));


        System.out.println("Примеры различных массивов:");
        int[] intArr = new int[4];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = new Random().nextInt(99);
        }
        Arrays.stream(intArr).forEach(System.out::println);
        System.out.println("------");

        char[] charArr = {'a', 'k', 'b', 'd', 'm', 'o'};
        Arrays.sort(charArr);
        System.out.println(Arrays.toString(charArr));
        System.out.println("------");

        System.out.println("Примеры использования циклов while & do while:");
        int total = 10;

        System.out.println("Код будет выполнен пока выполняется условие: ");
        while (total > 0) {
            System.out.println(UUID.randomUUID().toString());
            total--;
        }
        System.out.println("------");

        System.out.println("Код будет выполнен как минимум один раз (несмотря на то, что условие не выполняется): ");
        do {
            System.out.println(UUID.randomUUID().toString());
            total--;
        } while (total > 0);

    }

}

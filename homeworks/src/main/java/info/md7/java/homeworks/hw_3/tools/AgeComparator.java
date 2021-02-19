package info.md7.java.homeworks.hw_3.tools;


import info.md7.java.homeworks.hw_3.pojo.Passenger;
import java.util.Comparator;

public class AgeComparator implements Comparator<Passenger> {

    /**
     * Сравнивает возраст пассажиров
     * @param a возраст первого пассажира
     * @param b возраст второго пассажира
     * @return int
     */
    public int compare(Passenger a, Passenger b) {
        if ( a.getAge() < b.getAge() ) return -1;
        else if ( a.getAge() == b.getAge() ) return 0;
        else return 1;
    }

}

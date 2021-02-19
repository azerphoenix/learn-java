package info.md7.java.homeworks.hw_3.tools;


import info.md7.java.homeworks.hw_3.pojo.Passenger;

public class BubbleSort {

    public static void sortPassengersByAge(Passenger[] passengers) {
        if(passengers != null && passengers.length != 0) {
            for (int i = 0, size = passengers.length; i < size - 1; i++) {
                for(int j = 0; j < size - 1 - i; j++) {
                    if(passengers[j].getAge() > passengers[j+1].getAge()) {
                        Passenger tmp = passengers[j];
                        passengers[j] = passengers[j+1];
                        passengers[j+1] = tmp;
                    }
                }
            }
        }
    }

}

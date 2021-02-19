package info.md7.java.homeworks.hw_3.pojo;

public class Car {

    private CarBrand carBrand;
    private String carModel;
    private Passenger[] passengers;
    private float gasolineAmount;
    private int speed;
    public final long mileage = 10_000L;
    private long carDistance;

    public Car() {}

    /**
     * Расчет пройденного расстояния в зависимости от объема бензина в баке
     * @param speed скорость автомобиля
     * @return
     */
    public long carDistanceCalc(int speed) {
        while (gasolineAmount != 0) {
            gasolineAmount -= 10;
            carDistance += 20;
        }

        return carDistance;
    }

    /**
     * Расчет затрачиваемого времени в зависимости от пройденного расстояния и скорости
     * @param speed скорость автомобиля
     * @param carDistance расстояние пройденное автомобилем
     * @return
     */
    public long timeCalculation (int speed, long carDistance) {
        return carDistance / speed;
    }

    /**
     * Расспечатать список пассажиров
     */
    public void printPassengersList() {
        for (int i = 0; i < passengers.length; i++) {
            System.out.println(passengers[i].toString());
        }
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getGasolineAmount() {
        return gasolineAmount;
    }

    public void setGasolineAmount(float gasolineAmount) {
        this.gasolineAmount = gasolineAmount;
    }

    public long getCarDistance() {
        return carDistance;
    }

    public void setCarDistance(long carDistance) {
        this.carDistance = carDistance;
    }

}

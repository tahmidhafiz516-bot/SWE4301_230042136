public class ElectricCar extends Vehicle implements Chargeable {

    private static final int BATTERY_FULL = 100;
    private int batteryLevel = 0;

    @Override
    public void chargeBattery() {
        this.batteryLevel = BATTERY_FULL;
    }

    public int batteryLevel() {
        return batteryLevel;
    }
}
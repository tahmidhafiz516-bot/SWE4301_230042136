public class FillingStation {

    public void refuel(Refuelable vehicle) {
        vehicle.fillUpWithFuel();
    }

    public void charge(Chargeable vehicle) {
        vehicle.chargeBattery();
    }

    public static void main(String[] args) {

        FillingStation station = new FillingStation();

        PetrolCar petrolCar = new PetrolCar();
        ElectricCar electricCar = new ElectricCar();

        station.refuel(petrolCar);
        station.charge(electricCar);

        System.out.println("Petrol car fuel level: " + petrolCar.fuelTankLevel());
        System.out.println("Electric car battery level: " + electricCar.batteryLevel());

        petrolCar.startEngine();
        electricCar.startEngine();

        System.out.println("Petrol car engine started: " + petrolCar.engineIsStarted());
        System.out.println("Electric car engine started: " + electricCar.engineIsStarted());
    }
}
public class Dog implements Animal, Barkable {

    @Override
    public void run() {
        System.out.println("Dog is running");
    }

    @Override
    public void bark() {
        System.out.println("Dog is barking");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();

        dog.run();
        dog.bark();
    }
}
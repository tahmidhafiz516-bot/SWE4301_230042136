public class Bird implements Animal, Flyable {

    @Override
    public void run() {
        System.out.println("Bird is running");
    }

    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }

    public static void main(String[] args) {
        Bird bird = new Bird();

        bird.run();
        bird.fly();
    }
}
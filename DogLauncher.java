public class DogLauncher {
    public static void main(String[] args) {
        Dog d = new Dog(15);
        Dog d2 = new Dog(100);

        //Dog bigger = Dog.maxDog(d, d2);
        Dog bigger = d.maxDog(d2);
        bigger.makeNoise();

        System.out.println(Dog.binomen);
        d.makeNoise();
    }
}
/*
public class DogArrayDemo {
    public static void main(String[] args) {
        Create an array of two dogs.
        Dog[] dogs = new Dog[2];
        dogs[0] = new Dog(8);
        dogs[1] = new Dog(20);

        //Yipping will result, since dogs[0] has weight 8
        dogs[0].makeNoise();
    }
}
*/
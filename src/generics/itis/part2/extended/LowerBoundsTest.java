package generics.itis.part2.extended;

import java.util.Arrays;
import java.util.List;

public class LowerBoundsTest {

    // super Wolf - передать можно любого предка
    public static void lowerBounds(List<? super Wolf> list) {
        for (int i = 0; i < list.size(); i++) {
            // не может получить ничего кроме Object, т.к. мы не знаем, что там внутри, т.к. передать туда любого предка
            Object obj = list.get(i);
//            Wolf wolf = list.get(i);
//            Animal animal = list.get(i);
//            Dog dog = list.get(i);
        }

        // можем добавлять только потомком Wolf
        list.add(new Wolf());
        list.add(new Dog());
        list.add(new GoodBoy());
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Tiger tiger = new Tiger();
        Wolf wolf = new Wolf();
        Dog dog = new Dog();
        GoodBoy goodBoy = new GoodBoy();

        List<Animal> animals = Arrays.asList(animal, tiger, wolf, dog, goodBoy);
        List<Tiger> tigers = Arrays.asList(tiger);
        List<Wolf> wolves = Arrays.asList(wolf, dog);
        List<Dog> dogs = Arrays.asList(dog, goodBoy);
        List<GoodBoy> goodBoys = Arrays.asList(goodBoy);


        lowerBounds(animals);
        lowerBounds(wolves);
        lowerBounds(Arrays.asList(new Object(), new Object(), new Object()));
    }
}

package generics.itis.part2.extended;

import java.util.Arrays;
import java.util.List;

public class UpperBoundsTest {

    /*
    в этот список можно положить всех потомков Dog
    принимает список потомков и самого класса Dog
    */
    public static void upperBounds(List<? extends Dog> dogs) {
        /*
        можно получить Dog т.к. гарантируется, что в списке либо Dog либо его потомки, поэтому сработает
        восходящее преобразование
         */
        for (int i = 0; i < dogs.size(); i++) {
            Dog dog = dogs.get(i);
            dog.who();
        }

        // но положить в этот списко ничего нельзя, это может нарушить список
//        dogs.add(new Dog());
//        dogs.add(new GoodBoy());
//        dogs.add(new Wolf());
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


        upperBounds(dogs);
        upperBounds(goodBoys);
        //upperBounds(wolves); // - нельзя передать, т.к. это предок, я не потомок
    }
}

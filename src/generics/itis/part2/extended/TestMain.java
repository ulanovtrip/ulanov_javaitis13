package generics.itis.part2.extended;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestMain {

    // List list - параметризированный тип, используемый без реального параметра типа
    // можно передать что угодно, но мы не знаем какого раельно там типа объекты
    public static void rawList(List list) {
        for (int i = 0; i < list.size(); i++) {
            Object object = list.get(i);
            Animal animal = (Animal) object;
            animal.who();
        }
    }

    /*
    Несмотря на то, что Object предок всех классов, в обобщённый им тип нельзя передать обобщения в качестве
    параметра которых указыны его потомки
     */
    public static void objectsList(List<Object> objects) {
        for (int i = 0; i < objects.size(); i++) {
            Object object = objects.get(i);
            Animal animal = (Animal) object;
            animal.who();
        }
    }

    public static void animalsList(List<Animal> animals) {
        for (int i = 0; i < animals.size(); i++) {
            Object object = animals.get(i);
            Animal animal = (Animal) object;
            animal.who();
        }
    }

    // List<?> - аналогичен List, предок всех списков
    // и это является неизменяемым списком, можно только прочитать
    public static void wildcardList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            Object object = list.get(i);
            System.out.println(object);
        }
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

        rawList(animals);
        rawList(tigers);
        rawList(wolves);
        rawList(dogs);
        rawList(goodBoys);

        // ClassCastException
        List<Scanner> scanners = new ArrayList<>();
        scanners.add(new Scanner(System.in));
        //rawList(scanners);


        // test objects list
        //objectsList(animals); // not compile
        //objectsList(Arrays.asList(new Object(), new Object(), new Object())); // - комилится, но ломает программу

        //test animalsList
        animalsList(animals);
        // хотя wolf дочерним классом, нельзя передать его тип вместо Animal
        //animalsList(wolf); // not compile

        //testing wildcard
        wildcardList(animals);
        wildcardList(tigers);
        wildcardList(wolves);

        // не компилируется, т.к. повреждает целостность списка
        //wildcardList(new Animal());
        //wildcardList(new Wolf());
        //wildcardList(new Scanner(System.in));
    }
}

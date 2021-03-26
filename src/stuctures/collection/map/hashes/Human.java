package stuctures.collection.map.hashes;

import java.util.Objects;

public class Human {
    private String firstName;
    private int age;
    private boolean isWorker;
    private double height;

    Human(String firstName, int age, boolean isWorker, double height) {
        this.firstName = firstName;
        this.age = age;
        this.isWorker = isWorker;
        this.height = height;
    }

    // own version
    @Override
    public int hashCode() {
        int hash1 = firstName.hashCode();
        int hash2 = Integer.hashCode(age);
        int hash3 = Boolean.hashCode(isWorker);
        int hash4 = Double.hashCode(height);

        int[] hashes = {hash1, hash2, hash3, hash4};

        int hash = 1;
        for (int i = 0; i < hashes.length; i++) {
            hash = 31 * hash + hashes[i];
        }
        return hash;
    }

    // IDEA ver.
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Human human = (Human) o;
//        return age == human.age && isWorker ==
//                human.isWorker && Double.compare(human.height, height) ==
//                0 && Objects.equals(firstName, human.firstName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(firstName, age, isWorker, height);
//    }
}

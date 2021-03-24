package ObjectAndString.object;

import java.util.Objects;

public class Human {
    private String firstName;
    private String lastName;
    private int age;
    private double height;

    public Human(String firstName, String lastName, int age, double height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Human{" + "age=" + age + "; height=" + height + "; firstName=" + firstName + "; lastName=" + lastName + "}";
    }

    @Override
    public boolean equals(Object object) {
        // проверка на null
        if (object == null) {
            return false;
        }
        // сначала сравним с самим собой
        if (this == object) {
            return true;
        }

        // является ли обктом данного класса
        if (!(object instanceof Human)) {
            return false;
        }

        // выпполняем преобразование перед сравнением
        Human that = (Human) object;// явное низходящее преобразование чтобы можно было вызвать методы Human
        return this.firstName.equals(that.firstName)
                && this.lastName.equals(that.lastName)
                && this.age == that.age
                && this.height == that.height;
    }

// версию от IDE
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Human human = (Human) o;
//        return age == human.age && Double.compare(human.height, height) == 0 && Objects.equals(firstName, human.firstName) && Objects.equals(lastName, human.lastName);
//    }
}

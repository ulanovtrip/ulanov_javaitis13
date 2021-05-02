package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClientMain {
    public static void main(String[] args) {

        HumanReflection humanReflection = new HumanReflection();
        //humanReflection.age = 25;
        humanReflection.height = 1.82;

        humanReflection.grow(0.2);
        humanReflection.grow(0.2);
        System.out.println(humanReflection.height);
        humanReflection.printAge();

        try {

            // эта конструкция загружает класс с JVM, т.к. forName возвращает Class<?> можно получить описание класса
            Class<?> aClass = Class.forName("reflection.HumanReflection");

            // получим имя класса
            String className = aClass.getName();
            System.out.println("Class name: " + className);
            System.out.println("------------------------------------");

            // получим массив полей
            Field[] fields = aClass.getDeclaredFields();
            //распечатаем их
            for (Field field : fields) {
                System.out.println("field name: " + field.getName());
                System.out.println("field type: " + field.getType());
                System.out.println("modifiers: " + field.getModifiers());
                System.out.println("------------------------------------");
            }

            // дргуой объект
            HumanReflection human2 = new HumanReflection();

            // для этого делаем поле видимым
            Field field = aClass.getDeclaredField("age");
            // делаем его доступным для модификации
            field.setAccessible(true);
            field.set(human2, 33);
            System.out.print("Age of human2: ");
            human2.printAge();
            System.out.println("------------------------------------");

            // Так же можно получить методы класса
            Method[] methods = aClass.getMethods();
            // достанем информацию по методам
            for (Method method : methods) {
                System.out.print(method.getName() + " " + method.getReturnType() + " " + method.hashCode() + " " + method.getParameters() + "\n");
                System.out.println("------------------------------------");
            }

            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("now with getDeclaredMethods()!!!");
            System.out.println();
            //Чтобы увидеть приватный метод, нужно использовать метод getDeclaredMethods()
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (method.getName().equals("simplePrivate")) {
                    System.out.print("It's a private method: ");
                    System.out.print(method.getName() + " " + method.getReturnType() + " " + method.hashCode() + " " + method.getParameters() + "\n");
                    System.out.println("------------------------------------");
                }
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

            HumanReflection human3 = new HumanReflection();

            // можно вызвать метод с помощью рефлексии
            Method methodGrow = aClass.getDeclaredMethod("grow"); // получили метод
            // далее вызываем его у объекта human3
            methodGrow.invoke(human3);
            System.out.println("Height of human3: " + human3.height);
            System.out.println("------------------------------------");
            // если нужно вызвать другой перегруженный метод grow(double value)
            Method reloadGrow = aClass.getDeclaredMethod("grow", Double.TYPE);
            reloadGrow.invoke(human3, 1.0);
            System.out.println("Height of human3: " + human3.height);

            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

            // вызов метода с рузультатом
            Method methodWithResult = aClass.getDeclaredMethod("simplePrivate");
            methodWithResult.setAccessible(true);
            Object resultObj = methodWithResult.invoke(human3);
            System.out.println("Current height in human3:" + resultObj);

            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

            // можно создать экземпляр класса
            HumanReflection human = (HumanReflection) aClass.newInstance();


            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            // кейс, когда конструктор приватный и нужно создать объект.

            // сначала обязательно нужно объявить перемунную нужного типа
            HumanPrivate humanPrivate;

            // потом загрузить класс в jvm
            Class<?> privatClass = Class.forName("reflection.HumanPrivate"); // загрузим новое имя класса
            // берём класс Constructor
            Constructor constructor = privatClass.getDeclaredConstructor();
            // делаем его изменяемым
            constructor.setAccessible(true);
            // после этого можно создать объект с приватным конструктором
            humanPrivate = (HumanPrivate) constructor.newInstance();
            // смотрим содержимое
            humanPrivate.show();

            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////


        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}

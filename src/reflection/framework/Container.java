package reflection.framework;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Container {

    // компоненты, которые есть в системе
    Map<String, Object> components;

    Map<String, String> propertyValues;

    public void initialize() {
        propertyValues = new HashMap<>();
        components = new HashMap<>();
        loadProperties();
        loadComponents();
        injecting();
    }

    private void injecting() {
        for (Map.Entry<String, String> property : propertyValues.entrySet()) {
            if (property.getKey().startsWith("dependency")) {
                String[] split = property.getKey().split("\\.");
                String firstComponentName = split[1];
                String secondComponentName = split[2];
                Object firstComponent = components.get(firstComponentName);
                Object secondComponent = components.get(secondComponentName);

                // теперь нужно компонент second вствить в first, чтобы второй стал первым
                try {
                    // получили поле
                    Field field = firstComponent.getClass().getDeclaredField(secondComponentName);
                    field.setAccessible(true);
                    field.set(firstComponent, secondComponent);

                } catch (NoSuchFieldException e) {
                    throw new IllegalArgumentException(e);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void loadComponents() {
        for (Map.Entry<String, String> property : propertyValues.entrySet()) {
            if (property.getKey().contains(".impl")) {
                // номер символа до .impl
                int nameEndPosition = property.getKey().lastIndexOf(".impl");
                // вывод подстроки о начала до .impl
                String componentName = property.getKey().substring(0, nameEndPosition);

                try {
                    // получаем название класса
                    Class componentClass = Class.forName(property.getValue());
                    // и создаём его экземляр
                    Object componentInstance = componentClass.newInstance();
                    components.put(componentName, componentInstance);


                } catch (ClassNotFoundException e) {
                    throw new IllegalArgumentException(e);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void loadProperties() {
        // объект класс для получения войств из файла
        Properties properties = new Properties();

        try {
            // получаем доступ к файлу context.properties
            // загрузили пропертиз из файла
            FileReader fileReader = new FileReader("src/context.properties");
            properties.load(fileReader);

            Set<String> propertyNames = properties.stringPropertyNames();

            for (String property : propertyNames) {
                propertyValues.put(property, properties.getProperty(property));
            }

            System.out.println();

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public Object getComponent(String componentName) {
        return components.get(componentName);
    }
}

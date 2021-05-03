package annotations.runtime;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class SqlTablesGenerator {

    private final static Map<String, String> SQL_TYPES = new HashMap<>();

    private Connection dataSource;

    static {
        SQL_TYPES.put("Integer", "integer");
        SQL_TYPES.put("Boolean", "boolean");
        SQL_TYPES.put("Long", "bigint");
    }

    public SqlTablesGenerator(Connection dataSource) {
        this.dataSource = dataSource;
    }

    // обёртка над generateSQL0, т.к. он приватный
    public <T> void generateSQL(Class<T> modelClass) {
        try {
            generateSQL0(modelClass);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    // метод генерирует sql для конкретного класса
    private <T> void generateSQL0(Class<T> modelClass) throws Exception {
        // сначала узнаем аннотацию класса и запишем в массив с помощью рефлексии
        Model modelAnnotation = modelClass.getAnnotation(Model.class);
        // вытаскиваем название таблицы
        String tableName = modelAnnotation.tableName();

        Map<String, String> columns = new HashMap<>();


        for (Field field : modelClass.getDeclaredFields()) {

            String fieldType = field.getType().getSimpleName();

            // если нужно получить инфо об аннотации @Id например
            Id idFieldAnnotation = field.getAnnotation(Id.class);


            if (idFieldAnnotation != null) {
                if (fieldType.equals("Long")) {
                    columns.put("id", "bigserial primary key");
                } else if (fieldType.equals("Integer")) {
                    columns.put("id", "serial_primary_key");
                }
            } else {
                // если это не Long и не Integer
                ColumnTable columnTableAnnotation = field.getAnnotation(ColumnTable.class);

                // если тип строка
                if (fieldType.equals("String")) {
                    String name = columnTableAnnotation.name();
                    int length = columnTableAnnotation.length();
                    columns.put(name, "varchar(" + length + ")");
                } else {
                    // если не строка, то вытащим тип из совпадений в мапе
                    columns.put(columnTableAnnotation.name(), SQL_TYPES.get(fieldType));
                }
            }
        }

        System.out.println(columns);

        // теперь сгенерируем с рантайме sql

        // получаем соединение
        Connection connection = dataSource;

        // получаем стейтмент
        Statement statement = connection.createStatement();

        // теперь нужно собрать сам стейтмент
        StringBuilder query = new StringBuilder();

        query.append("create table ")
                .append(tableName)
                .append("( \n");

        // теперь нужно добавить все типы, просмотрим все пары из мапы columns
        for (Map.Entry<String, String> column : columns.entrySet()) {
            query.append(column.getKey())
                    .append(" ")
                    .append(column.getValue())
                    .append(", \n");
        }

        // убрать последнюю запятую
        query.deleteCharAt(query.toString().lastIndexOf(","));
        query.append(" );");

        System.out.println(query);

        // далее выполняем запрос в БД
        statement.execute(query.toString());

        // закрываем
        statement.close();
        connection.close();
    }
}

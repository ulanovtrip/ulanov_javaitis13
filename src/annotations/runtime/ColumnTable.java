package annotations.runtime;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // значит, что аннотацию Model можно вешать только на поля
@Retention(RetentionPolicy.RUNTIME) // анализ во время запуска
public @interface ColumnTable {

    int length() default 255;

    String name();
}
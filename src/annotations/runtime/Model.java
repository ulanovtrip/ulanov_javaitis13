package annotations.runtime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // значит, что аннотацию Model можно вешать только на тип
@Retention(RetentionPolicy.RUNTIME) // анализ во время запуска
// аналог Entity в hibernate
public @interface Model {
    String tableName();
}

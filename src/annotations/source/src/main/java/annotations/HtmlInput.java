package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // только к полям
@Retention(RetentionPolicy.SOURCE) // видно только в момент компиляции
public @interface HtmlInput {
    String type() default "text";
    String name() default "";
    String placeholder() default "";
}

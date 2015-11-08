package javase02.t07;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
public @interface Info {
    String author();
    String date();
}
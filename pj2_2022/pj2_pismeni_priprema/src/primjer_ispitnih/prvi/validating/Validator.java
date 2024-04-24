package primjer_ispitnih.prvi.validating;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Validator {
    public static <T> boolean validate(Iterable<Predicate<T>> conditions, T item) {
        boolean isOk = true;

        for (Predicate<T> cond : conditions)
            isOk = isOk && cond.test(item);

        return isOk;
    }
}

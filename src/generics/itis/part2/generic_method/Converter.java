package generics.itis.part2.generic_method;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    // параметризованный метод
    public <X, Y> List<Y> convert(List<X> elements, ConvertFunction<Y, X> convertFunction) {
        List<Y> result = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            X element = elements.get(i);
            Y convertedElement = convertFunction.convert(element);
            result.add(convertedElement);
        }
        return result;
    }
}

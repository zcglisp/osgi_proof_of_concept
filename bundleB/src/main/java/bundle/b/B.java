package bundle.b;

import java.util.function.Function;

public class B implements Function {
    @Override
    public Object apply(Object o) {
        return "Hello " + o + " ! (from class B)";
    }
}

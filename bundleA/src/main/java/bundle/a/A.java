package bundle.a;

import java.util.function.Function;

public class A implements Function {
    @Override
    public Object apply(Object o) {
        return "Hello " + o + " ! (from class A)";
    }

}

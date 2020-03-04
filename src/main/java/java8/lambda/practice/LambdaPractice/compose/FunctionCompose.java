package java8.lambda.practice.LambdaPractice.compose;

import java.util.function.Function;

/**
 * 函数复合的例子
 */
public class FunctionCompose {
    public static void main(String[] args) {
        Function<Integer,Integer> addFunction = x->x+1;
        Function<Integer,Integer> timeFunction = x->x*2;
        Function<Integer,Integer> subFunction = x->x-1;

        Function<Integer,Integer> composeFunction1 = addFunction.compose(timeFunction);
        Function<Integer,Integer> composeFunction2 = timeFunction.compose(subFunction).compose(addFunction);

        System.out.println(composeFunction1.apply(1));
        System.out.println(composeFunction2.apply(2));
    }
}

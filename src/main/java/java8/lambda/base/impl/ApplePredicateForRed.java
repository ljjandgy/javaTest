package java8.lambda.base.impl;

import java8.lambda.base.Apple;
import java8.lambda.base.ApplePredicate;

public class ApplePredicateForRed implements ApplePredicate {
    @Override
    public boolean appleTest(Apple apple) {
        return "red".equals(apple.getColor());
    }
}

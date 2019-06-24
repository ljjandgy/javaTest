package java8.lambda.base.impl;

import java8.lambda.base.Apple;
import java8.lambda.base.ApplePredicate;

public class ApplePredicateForColorAndHeavy implements ApplePredicate {
    @Override
    public boolean appleTest(Apple apple) {
        return "green".equals(apple.getColor())&&apple.getWeight()>300;
    }
}

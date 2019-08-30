package com.fangxp.netty.decorator;

public class Test {

    public static void main(String[] args) {

        Component component = new DecoratorComponent2(new DecoratorComponent1(new ConcreteComponent()));
        component.doSomething();
    }

}

package com.fangxp.netty.decorator;

public class DecoratorComponent1 extends DecoratorComponent {


    public DecoratorComponent1(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        System.out.println("功能B");
    }
}

package com.fangxp.netty.decorator;

public class DecoratorComponent2 extends DecoratorComponent {


    public DecoratorComponent2(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        System.out.println("功能C");
    }
}

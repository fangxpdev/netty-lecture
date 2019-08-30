package com.fangxp.netty.decorator;

/**
 * 装饰模式：
 * 1、实现或继承组件
 * 2、持有组件引用
 */
public abstract class DecoratorComponent implements Component {

    protected Component component;

    public DecoratorComponent(Component component) {
        this.component = component;
    }

    @Override
    public void doSomething() {
        component.doSomething();
    }
}

package com.fangxp.netty.decorator;

public class ConcreteComponent implements Component {


    @Override
    public void doSomething() {
        System.out.println("功能A");

    }
}

package com.fangxp.netty.bytebuf;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class AtomicUpdatorTest {


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        Person person = new Person();


//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(() ->{
//
//                try {
//                    Thread.sleep(20);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println(person.age++);
//            });
//
//            thread.start();
//
//        }
//
//        Thread.sleep(100);
//
//        System.out.println("age:"+person.age);


        AtomicIntegerFieldUpdater updater = AtomicIntegerFieldUpdater.newUpdater(Person.class, "age");

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(updater.getAndIncrement(person));

            }).start();
        }

        Thread.sleep(100);
        System.out.println("age:" + person.age);
    }


}

class Person {

    volatile int age = 1;

}

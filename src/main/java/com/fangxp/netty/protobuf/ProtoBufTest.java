package com.fangxp.netty.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtoBufTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {

        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("beidou").setAge(18).setAddress("杭州").build();

        byte[] bytes = student.toByteArray();

        DataInfo.Student student1 = DataInfo.Student.parseFrom(bytes);

        System.out.println(student1);
        System.out.println(student1.getName());
        System.out.println(student1.getAge());
        System.out.println(student1.getAddress());

    }


}

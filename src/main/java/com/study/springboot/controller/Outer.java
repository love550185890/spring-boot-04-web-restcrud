package com.study.springboot.controller;

public class Outer {
    private  Integer i = 0;
    public Outer(){

    }
    public class Inner{
        private Integer i2 = 1;
        public void print(){
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        Inner inner = new Outer().new Inner();
        System.out.printf("i2="+inner.i2+";"+new Outer().i+";\n");
        inner.print();
    }
}

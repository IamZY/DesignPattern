# 设计模式

![image](https://github.com/IamZY/DesignPattern/blob/master/images/1574924172659.png)

## 单一职责原则

对类来说，一个类就是只负责一件事情

降低类的复杂性

降低变更引起的风险

通常情况下 我们应该遵守单一职责原则 只有逻辑足够简单 才能在方法中违反单一指责原则

```java
package com.ntuzy.principle.singleresonsibilty;

public class SingleResponsibility3 {

    public static void main(String[] args){
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.run("摩托车");
        vehicle2.run("汽车");
        vehicle2.runAir("飞机");
    }

}

//
// 交通工具类
// 方式3
// 没有在类这个级别上遵守单一指责原则 但是在方法级别上
class Vehicle2 {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上跑");
    }


    public void runAir(String vehicle) {
        System.out.println(vehicle + "在天上上跑");

    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + "在水上跑");
    }

}
```

## 接口隔离原则

客户端不应该依赖它不需要的接口，即一个类对另一个类的依赖应该建立在最小的接口上

对传统方法问题和使用接口隔离原则改进

```java
package com.ntuzy.principle.segregation.improve;

public class Segregation {
    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());

    }
}

interface Interface1 {
    public void operation1();
}

interface Interface2 {
    public void operation2();

    public void operation3();
}

interface Interface3 {
    public void operation4();

    public void operation5();
}


class B implements Interface1, Interface2 {
    @Override
    public void operation1() {
        System.out.println("B 实现了 operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B 实现了 operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B 实现了 operation3");
    }
}


class D implements Interface1, Interface3 {

    @Override
    public void operation1() {
        System.out.println("D 实现了 operation1");
    }

    @Override
    public void operation4() {
        System.out.println("D 实现了 operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D 实现了 operation5");
    }
}


class A {
    public void depend1(Interface1 interface1) {
        interface1.operation1();
    }

    public void depend2(Interface2 interface2) {
        interface2.operation2();
    }

    public void depend3(Interface2 interface2) {
        interface2.operation3();
    }
}


class C {
    public void depend1(Interface1 interface1) {
        interface1.operation1();
    }

    public void depend2(Interface3 interface3) {
        interface3.operation4();
    }

    public void depend3(Interface3 interface3) {
        interface3.operation5();
    }
}
```

## 依赖倒转原则

高层模块蹦年以来底层模块 二者都应该依赖抽象

抽象不依赖细节，细节应该依赖抽象

依赖倒转（倒置）的中心思想是面向接口编程

抽象指的是接口或者抽象类

```java
package com.ntuzy.principle.inversion.improve;

/*
// 接口
// 构造方法
// setter method
*/
public class DependencyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeiXin());
    }
}

interface IReceiver {
    public String getInfo();
}

class Email implements IReceiver {
    @Override
    public String getInfo() {
        return "电子邮件信息: hello world";
    }
}


class WeiXin implements IReceiver {
    @Override
    public String getInfo() {
        return "微信消息：hello ok";
    }
}


// 完成Person接受消息的功能
// 方式2
class Person {
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}

```
p13

## 里氏替换原则

## 开闭原则

## 迪米特原则

一个对象应该对其他对象保持最少的了解

类与类关系越密切。耦合度越大

最少知道原则

只与直接朋友通信（直接朋友：成员变量、方法参数、方法返回值中的类）

## 合成复用原则

尽量使用合成/聚合的方式而不是使用继承

+ 找出应用中可能需要变化你的地方，把他们独立出来，不要和那些不需要变化的代码混在一起
+ 针对接口编程，而不是针对实现编程
+ 为了交互对象之间的松耦合设计而努力

## UML类图

依赖、泛化（继承）、实现、关联、聚合与组合





























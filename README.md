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

# 设计模式

- 创建型模式

- 结构型模式

- 行为型模式

## 单例模式

采取一定的方法保证整个软件系统中对某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法。

需要频繁使用和销毁对象

创建对象耗时

工具类对象

频繁使用数据库或者文件的对象

### 饿汉式

+ 构造器私有化

+ 类的内部创建对象

+ 向外暴露一个静态的公共方法

  ```java
  package com.ntuzy.singleton.type1;
  
  public class SingletonTest01 {
      public static void main(String[] args){
          Singleton singleton1 = Singleton.getInstance();
          Singleton singleton2 = Singleton.getInstance();
          System.out.println(singleton1 == singleton2);
          System.out.println(singleton1.hashCode());
          System.out.println(singleton2.hashCode());
      }
  }
  
  class Singleton {
      // 构造器私有化
      private Singleton() {
  
      }
  
      // 奔雷内部创建对象实例
      private final static Singleton instance = new Singleton();
  
      public static Singleton getInstance() {
          return instance;
      }
  }
  ```

  ```java
  package com.ntuzy.singleton.type2;
  
  public class SingletonTest02 {
  
      public static void main(String[] args) {
          Singleton singleton1 = Singleton.getInstance();
          Singleton singleton2 = Singleton.getInstance();
          System.out.println(singleton1 == singleton2);
          System.out.println(singleton1.hashCode());
          System.out.println(singleton2.hashCode());
      }
  
  }
  
  class Singleton {
      // 构造器私有化
      private Singleton() {
      }
  
      static {
          // 在静态代码块中创建单例对象
          instance = new Singleton();
      }
  
  
      // 奔雷内部创建对象实例
      private static Singleton instance;
  
      public static Singleton getInstance() {
          return instance;
      }
  
      //
  }
  ```

### 懒汉式

```java
package com.ntuzy.singleton.type3;

/**
 * 线程不安全
 * 但是只能在单线程的状态下使用
 * 在实际开发中不能使用
 */
public class SingletonTest03 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}


class Singleton {
    private Singleton() {

    }

    private static Singleton instance;


    // 提供一个静态的共有方法 当使用到该方法的时候 才去创建instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

}
```

```java
package com.ntuzy.singleton.type4;

/**
 * 不推荐 效率低
 */
public class SingletonTest04 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}


class Singleton {
    private Singleton() {

    }

    private static Singleton instance;


    // 提供一个静态的共有方法 当使用到该方法的时候 才去创建instance
    // 加入同步处理的代码块 解决线程安全问题
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

}
```

### 双重检查

```java
package com.ntuzy.singleton.type6;

/**
 * 双重检查 推荐
 */
public class SingletonTest06 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}

class Singleton {
    private Singleton() {

    }

    private volatile static Singleton instance;

    // 加入双重检查的代码块 解决线程安全问题 解决懒加载的问题
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

}
```

### 静态内部类

```java
package com.ntuzy.singleton.type7;

import java.security.PrivateKey;

/**
 * 静态内部类 推荐
 * 保证类装载机制来保证初始化实例的时候只有一个线程
 * 静态内部类方式在Singleton类被装载是并不会立即实例化  类的静态属性只会在第一次加载类的是红初始化 JVM帮助我们保证线程安全
 */
public class SingletonTest07 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }

}


class Singleton {
    private Singleton() {

    }

    // 静态内部类 该类中有静态属性SingletonInstance
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    // 提供静态的共有方法 直接返回SingletonInstance.INSTANCE
    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
```

### 枚举

不仅避免多线程 还可以禁止反序列化

```java
package com.ntuzy.singleton.type8;

/*
* 推荐
*/
public class SingletonTest08 {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());

        instance1.sayOK();

    }
}

enum Singleton {
    INSTANCE;

    public void sayOK() {
        System.out.println("ok");
    }
}
```



























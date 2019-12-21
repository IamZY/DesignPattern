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

## 简单工厂模式

简单工厂模式式属于创建型模式，是工厂模式中的一种，简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例，简单工厂模式家族中最简单实用的模式

定义了一个创建对象的类，由这个类来封装实例化对象的行为 

+ OrderPizza

```java
package com.ntuzy.factory.simplefactory.pizzastore.order;

import com.ntuzy.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.ntuzy.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.ntuzy.factory.simplefactory.pizzastore.pizza.PepperPizza;
import com.ntuzy.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    // 构造器
    // 定义简单工厂对象
    private SimpleFactory simpleFactory;
    private Pizza pizza = null;

    // 构造器
    public OrderPizza(SimpleFactory simpleFactory) {
        setFactory(simpleFactory);
    }

    public void setFactory(SimpleFactory simpleFactory) {
        String orderType = ""; // 用户输入
        this.simpleFactory = simpleFactory;  // 设置一个工厂对象

        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);
            // 输出pizza一些信息
            if (pizza != null) {
                // 订购成功
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购失败");
                break;
            }
        } while (true);

    }


    // 写一个方法 可以获取客户希望订购Pizza种类
    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


}

```

+ SimpleFactory

  ```java
  package com.ntuzy.factory.simplefactory.pizzastore.order;
  
  import com.ntuzy.factory.simplefactory.pizzastore.pizza.CheesePizza;
  import com.ntuzy.factory.simplefactory.pizzastore.pizza.GreekPizza;
  import com.ntuzy.factory.simplefactory.pizzastore.pizza.PepperPizza;
  import com.ntuzy.factory.simplefactory.pizzastore.pizza.Pizza;
  
  // 简单工厂类
  public class SimpleFactory {
  
      // 根据type 返回Pizza对象
      public Pizza createPizza(String orderType) {
          Pizza pizza = null;
          System.out.println("使用简单工厂模式");
          if (orderType.equals("greek")) {
              pizza = new GreekPizza();
              pizza.setName("希腊Pizza");
          } else if (orderType.equals("cheese")) {
              pizza = new CheesePizza();
              pizza.setName("奶酪Pizza");
          } else if (orderType.equals("pepper")) {
              pizza = new PepperPizza();
              pizza.setName("胡椒Pizza");
          }
  
          return pizza;
      }
  
      // 简单工厂模式 也将静态工厂模式
      public static Pizza createPizza2(String orderType) {
          Pizza pizza = null;
          System.out.println("使用简单工厂模式");
          if (orderType.equals("greek")) {
              pizza = new GreekPizza();
              pizza.setName("希腊Pizza");
          } else if (orderType.equals("cheese")) {
              pizza = new CheesePizza();
              pizza.setName("奶酪Pizza");
          } else if (orderType.equals("pepper")) {
              pizza = new PepperPizza();
              pizza.setName("胡椒Pizza");
          }
  
          return pizza;
      }
  }
  
  ```

## 工厂方法模式

+ OrderPizza

  ```java
  package com.ntuzy.factory.factorymethod.pizzastore.order;
  
  import com.ntuzy.factory.factorymethod.pizzastore.pizza.Pizza;
  
  import java.io.BufferedReader;
  import java.io.IOException;
  import java.io.InputStreamReader;
  
  public abstract class OrderPizza {
      // 构造器
      public OrderPizza() {
          Pizza pizza = null;
          String orderType = "";
  
          do {
              orderType = getType();
              pizza = createPizza(orderType);  // 抽象的方法  由工厂子类完成
  
              pizza.prepare();
              pizza.bake();
              pizza.cut();
              pizza.box();
  
          } while (true);
  
      }
  
      // 定义一个抽象方法 createPizza 让各个工厂子类自己实现
      abstract Pizza createPizza(String orderType);
  
      // 写一个方法 可以获取客户希望订购Pizza种类
      private String getType() {
          try {
              BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
              System.out.println("input pizza 种类:");
              String str = strin.readLine();
              return str;
          } catch (IOException e) {
              e.printStackTrace();
              return "";
          }
      }
  
  }
  ```

+ BJOrderPizza

  ```java
  package com.ntuzy.factory.factorymethod.pizzastore.order;
  
  import com.ntuzy.factory.factorymethod.pizzastore.pizza.BJCheesePizza;
  import com.ntuzy.factory.factorymethod.pizzastore.pizza.BJPepperPizza;
  import com.ntuzy.factory.factorymethod.pizzastore.pizza.Pizza;
  
  public class BJOrderPizza extends OrderPizza {
      @Override
      Pizza createPizza(String orderType) {
          Pizza pizza = null;
  
          if (orderType.equals("cheese")) {
              pizza = new BJCheesePizza();
              pizza.setName("北京的奶酪口味");
          } else if (orderType.equals("pepper")) {
              pizza = new BJPepperPizza();
              pizza.setName("北京的胡椒口味");
          }
  
          return pizza;
      }
  }
  
  ```

+ LDOrderPizza

  ```java
  package com.ntuzy.factory.factorymethod.pizzastore.order;
  
  import com.ntuzy.factory.factorymethod.pizzastore.pizza.*;
  
  public class LDOrderPizza extends OrderPizza {
      @Override
      Pizza createPizza(String orderType) {
          Pizza pizza = null;
  
          if (orderType.equals("cheese")) {
              pizza = new LDCheesePizza();
              pizza.setName("伦敦的奶酪Pizza");
          } else if (orderType.equals("pepper")) {
              pizza = new LDPepperPizza();
              pizza.setName("伦敦的胡椒Pizza");
          }
  
          return pizza;
      }
  }
  
  ```

+ PizzaStore

  ```java
  package com.ntuzy.factory.factorymethod.pizzastore.order;
  
  public class PizzaStore {
      public static void main(String[] args){
          // 创建北京口味的各种Pizza
          new BJOrderPizza();
      }
  }
  ```

## 抽象工厂模式

定义了一个interface用于创建相关或有依赖关系的对象族，而无需指明具体的类

抽象工厂模式可以将简单工厂模式和工厂方法模式进行i整合

从设计层面上看，抽象工厂模式就是对简单工厂模式的改进，或者称为进一步的抽象

将工厂抽象成两层，抽象工厂和具体实现的工厂子类

+ AbsFactory

  ```java
  package com.ntuzy.factory.absfactory.pizzastore.order;
  
  import com.ntuzy.factory.absfactory.pizzastore.pizza.Pizza;
  
  // 抽象工厂模式的抽象层
  public interface AbsFactory {
      // 让下面的工厂子类具体实现
      public Pizza createPizza(String orderType);
  }
  
  ```

+ OrderPizza

  ```java
  package com.ntuzy.factory.absfactory.pizzastore.order;
  
  import com.ntuzy.factory.absfactory.pizzastore.pizza.Pizza;
  
  import java.io.BufferedReader;
  import java.io.IOException;
  import java.io.InputStreamReader;
  
  public class OrderPizza {
  
      private AbsFactory absFactory;
  
      private void setAbsFactory(AbsFactory absFactory) {
          Pizza pizza = null;
          String orderType = "";
          this.absFactory = absFactory;
  
          do {
              orderType = getType();
              pizza = absFactory.createPizza(orderType);
  
              if (pizza != null) {
                  pizza.prepare();
                  pizza.bake();
                  pizza.cut();
                  pizza.box();
              } else {
                  System.out.println("订购失败");
                  break;
              }
  
          } while (true);
  
      }
  
      public OrderPizza (AbsFactory absFactory) {
          setAbsFactory(absFactory);
      }
  
      // 写一个方法 可以获取客户希望订购Pizza种类
      private String getType() {
          try {
              BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
              System.out.println("input pizza 种类:");
              String str = strin.readLine();
              return str;
          } catch (IOException e) {
              e.printStackTrace();
              return "";
          }
      }
  
  }
  ```

+ PizzaStore

  ```java
  package com.ntuzy.factory.absfactory.pizzastore.order;
  
  public class PizzaStore {
      public static void main(String[] args){
          new OrderPizza(new BJFactory());
      }
  }
  ```

+ BJFactory

  ```java
  package com.ntuzy.factory.absfactory.pizzastore.order;
  
  import com.ntuzy.factory.absfactory.pizzastore.pizza.BJCheesePizza;
  import com.ntuzy.factory.absfactory.pizzastore.pizza.BJPepperPizza;
  import com.ntuzy.factory.absfactory.pizzastore.pizza.Pizza;
  
  // 工厂子类
  public class BJFactory implements AbsFactory {
      @Override
      public Pizza createPizza(String orderType) {
          Pizza pizza = null;
          System.out.println("抽象工厂模式...");
          if (orderType.equals("cheese")) {
              pizza = new BJCheesePizza();
              pizza.setName("北京奶酪口味");
          } else if (orderType.equals("pepper")) {
              pizza = new BJPepperPizza();
              pizza.setName("北京胡椒口味");
          }
          return pizza;
      }
  }
  ```

## 原型模式

用原型实例指定创建对象的种类，通过拷贝这些模型，创建新的对象

允许对象再创建另外一个可定制的对象，无需知道如果创建的细节

JDK中bean运用到了原型模式

+ Sheep

  ```java
  package com.ntuzy.protoptype.improve;
  
  public class Sheep implements Cloneable {
      private String name;
      private int age;
      private String color;
  
      public Sheep(String name, int age, String color) {
          this.name = name;
          this.age = age;
          this.color = color;
      }
  
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public int getAge() {
          return age;
      }
  
      public void setAge(int age) {
          this.age = age;
      }
  
      public String getColor() {
          return color;
      }
  
      public void setColor(String color) {
          this.color = color;
      }
  
  
      @Override
      public String toString() {
          return "Sheep{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  ", color='" + color + '\'' +
                  '}';
      }
  
      // 克隆该实例 使用默认的克隆方法来完成
      @Override
      protected Object clone() {
          Sheep sheep = null;
          try {
              sheep = (Sheep) super.clone();
          } catch (CloneNotSupportedException e) {
              e.printStackTrace();
          }
          return sheep;
      }
  
  }
  
  ```

+ client

  ```java
  package com.ntuzy.protoptype.improve;
  
  public class Client {
      public static void main(String[] args){
          Sheep sheep = new Sheep("tom",1,"白色");
          Sheep sheep2 = (Sheep) sheep.clone();
          Sheep sheep3 = (Sheep) sheep.clone();
          Sheep sheep4 = (Sheep) sheep.clone();
          Sheep sheep5 = (Sheep) sheep.clone();
  
          System.out.println(sheep);
          System.out.println(sheep2);
  
      }
  }
  
  ```

### 浅拷贝

+ 对于数类型是基本数据类型的成员变量，浅拷贝会直接进行值传递，也就是将该属性复制一份给新的对象
+ 对于数据类型是因哟昂数据类型的成员变量，比如说是成员变量是某个数组、某个类的对象等，那么浅拷贝会进行引用传递，也就是将该成员变量的引用值复制一份给新的对象。因为实际上两个对象的该成员的变量都指向同一个实例，在这种情况下，一个对象中修改该成员便改良会影响到另一个对象的该变量的值。
+ Sheep = (Sheep) super.clone();

### 深拷贝

+ 复制对象的所有基本数据类型的成员变量值

+ 为所有引用数据类型的成员变量申请存储空间，并复制每个引用数据类型成员变量所引用的对象，直到该对象可达到的所有对象。也就是说，对象进行深拷贝要对整个对象进行拷贝。

+ 两种方式

  + 重写Clone方法
  + 实现序列化

  ```java
  package com.ntuzy.protoptype.deepclone;
  
  import java.io.*;
  
  public class DeepProtoType implements Serializable, Cloneable {
  
      public String name;
      public DeepCloneableTarget deepCloneableTarget;  // 引用类型的属性
  
  
      public DeepProtoType() {
  
      }
  
  
      // 深拷贝  1 方式1 使用clone方法
      @Override
      protected Object clone() throws CloneNotSupportedException {
          Object deep = null;
          // 完成对基本数据类型（属性）和String的clone
          deep = super.clone();
  
          // 对引用类型属性进行单独处理
          DeepProtoType deepProtoType = (DeepProtoType) deep;
          deepProtoType.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();
  
          return deep;
      }
  
  
      // 方式2 对象序列化进行深拷贝 推荐使用
      public Object deepClone() {
          // 创建流对象
          ByteArrayOutputStream bos = null;
          ObjectOutputStream oos = null;
          ByteArrayInputStream bis = null;
          ObjectInputStream ois = null;
  
          try {
              // 序列化
              bos = new ByteArrayOutputStream();
              oos = new ObjectOutputStream(bos);
              oos.writeObject(this); // 当前这个对象以对象流的形式输出
  
              // 反序列化
              bis = new ByteArrayInputStream(bos.toByteArray());
              ois = new ObjectInputStream(bis);
  
              DeepProtoType copyObj = (DeepProtoType) ois.readObject();
  
  
              return copyObj;
          } catch (Exception e) {
              e.printStackTrace();
              return null;
          } finally {
              // 关闭流
              try {
                  bos.close();
                  oos.close();
                  bis.close();
                  ois.close();
              } catch (Exception e) {
                  e.printStackTrace();
              }
  
          }
  
      }
  
  
  }
  
  ```

  ```java
  package com.ntuzy.protoptype.deepclone;
  
  public class Client {
      public static void main(String[] args) throws CloneNotSupportedException {
          DeepProtoType p = new DeepProtoType();
          p.name = "松江";
          p.deepCloneableTarget = new DeepCloneableTarget("大牛", "大牛的类");
  
          // 方式1 进行深拷贝
          //DeepProtoType p2 = (DeepProtoType) p.clone();
          //System.out.println(p);
          //System.out.println(p2);
          
          DeepProtoType p2 = (DeepProtoType) p.deepClone();
          System.out.println(p);
          System.out.println(p2);
  
      }
  }
  ```

## 建造者模式

生成器模式，是一种对象构建模式，可以将复杂对象的建造过程抽象出来，使这个抽象过程的不同实现方法可以构造出不同的表现的对象。

+ Product
+ Builder
+ ConcreteBuilder
+ Director

![image](https://github.com/IamZY/DesignPattern/blob/master/images/1575273622009.png)

## 适配器模式

+ 将某个类的接口转换成客户端期望的另一个接口表示，主要的目的就是兼容性，让原本因接口不匹配不能在一起工作的两个类可以协同工作。

+ 适配器模式属于结构型模式
+ 类适配器模式、对象适配器模式、接口适配器模式

### 类适配器模式

```java
// 适配器类
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
        // 获取220v的电压
        int srcV = output220V();
        int dstV = srcV / 44;   // 转成5v

        return dstV;
    }
}

```

### 对象适配器模式

解决类适配器继承src类的问题

```java
package com.ntuzy.adapter.objectadapter;

// 适配器类
public class VoltageAdapter implements IVoltage5V {

    private Voltage220V voltage220V; // 关联关系中的聚和

    // 通过构造器传入220v的实例
    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }


    @Override
    public int output5V() {
        // 获取220v的电压
        int dst = 0;

        if (null != voltage220V) {
            int src = voltage220V.output220V();  // 获取220v电压
            System.out.println("使用对象适配器，进行适配");
            dst = src/44;
            System.out.println("转换过的电压=" + dst);
        }
        return dst;
    }
}
```

### 接口适配器模式

```java
package com.ntuzy.adapter.interfaceadapter;

public abstract class AbsAdapter implements Interface4 {

    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }

    @Override
    public void m4() {

    }
}

```

+ client

  ```java
  package com.ntuzy.adapter.interfaceadapter;
  
  public class Client {
      public static void main(String[] args) {
          AbsAdapter absAdapter = new AbsAdapter() {
              @Override
              public void m1() {
                  super.m1();
              }
          };
  
          absAdapter.m2();
  
      }
  }
  
  ```

## 桥接模式

桥接模式(Bridge Pattern)：将抽象部分与它的实现部分分离，使它们都可以独立地变化。它是一种对象结构型模式，又称为柄体(Handle and Body)模式或接口(Interface)模式。

![image](https://github.com/IamZY/DesignPattern/blob/master/images/image-20191203104921211.png)

## 装饰者模式

+ 定义

  在不改变原有对象的基础之上，将功能附加到对象上。提供了比继承更有弹性的替代方案（扩展原有对象功能）

+ 类型

  结构型

+ 适用场景

1. 扩展一个类的功能或者给一个类添加附加职责
2. 给一个对象动态的添加功能，或动态撤销功能。

+ 优点

1. 继承的有力补充，比继承灵活，不改变原有对象的情况下给一个对象扩展功能。（继承在扩展功能是静态的，必须在编译时就确定好，而使用装饰者可以在运行时决定，装饰者也建立在继承的基础之上的）
2. 通过使用不同装饰类以及这些类的排列组合，可以实现不同的效果。
3. 符合开闭原则

+ 缺点

1. 会出现更多的代码，更多的类，增加程序的复杂性。
2. 动态装饰时，多层装饰时会更复杂。（使用继承来拓展功能会增加类的数量，使用装饰者模式不会像继承那样增加那么多类的数量但是会增加对象的数量，当对象的数量增加到一定的级别时，无疑会大大增加我们代码调试的难度）

## 组合模式

 部分整体模式，他创建了对象组的树形结构，将对象组和成在树状结构以表示"整体-部分"

```java
package com.ntuzy.composite;

public class Client {
    public static void main(String[] args){
        // 从大到小创建对象
        OrganizationComponent university = new University("清华大学", "中国顶级大学");

        //
        OrganizationComponent college1 = new College("计算机学院", "计算机学院");
        OrganizationComponent college2 = new College("信息工程学院", "信息工程学院");

        // 创建各个学院下面的系
        college1.add(new Department("软件工程","软件工程"));
        college1.add(new Department("网络工程","网络工程"));
        college1.add(new Department("计算机科学与技术","计算机科学与技术"));

        //
        college2.add(new Department("通信工程","通信工程"));
        college2.add(new Department("信息工程","信息工程"));

        university.add(college1);
        university.add(college2);

        university.print();
        college1.print();

    }
}
```

## 外观模式

+ 外观类：为调用端提供统一的调用接口，外观类知道哪些子系统负责处理请求。从而将调用端的请求代理给适当子系统对象

+ 调用者：外观接口的调用者
+ 子系统的解和：指模块或者子系统，处理Facade对象指派的任务，他是功能的实际提供者

+ HomeThreaterFacade

  ```java
  package com.ntuzy.facade;
  
  public class HomeTheaterFacade {
  
      // 定义各个子系统的对象
      private TheaherLight theaherLight;
      private Popcorn popcorn;
      private Stereo stereo;
      private Projector projector;
      private Screen screen;
      private DVDPlayer dvdPlayer;
  
  
      public HomeTheaterFacade() {
          this.theaherLight = TheaherLight.getInstance();
          this.popcorn = Popcorn.getInstance();
          this.stereo = Stereo.getInstance();
          this.projector = Projector.getInstance();
          this.screen = Screen.getInstance();
          this.dvdPlayer = DVDPlayer.getInstance();
      }
  
      public void ready() {
          popcorn.on();
          popcorn.pop();
          screen.down();
          projector.on();
          stereo.on();
          dvdPlayer.on();
          theaherLight.dim();
      }
  
      public void play() {
          dvdPlayer.play();
      }
  
      public void pause() {
          dvdPlayer.pause();
      }
  
      public void end() {
          popcorn.off();
          theaherLight.bright();
          screen.up();
          projector.off();
          stereo.off();
          dvdPlayer.off();
      }
  
  
      public static void main(String[] args) {
  
      }
  }
  ```

+ Client

  ```java
  package com.ntuzy.facade;
  
  public class Client {
      public static void main(String[] args){
          HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
          homeTheaterFacade.ready();
          homeTheaterFacade.play();
      }
  }
  ```

+ 

## 享元模式

主要用于减少创建对象的数量，以减少内存占用和提高性能。这种类型的设计模式属于结构型模式，它提供了减少对象数量从而改善应用所需的对象结构的方式。

享元模式尝试重用现有的同类对象，如果未找到匹配的对象，则创建新对象。

```java
package com.ntuzy.flyweight;

import java.util.HashMap;

// 网站工厂类 根据需求返回一个网站
public class WebSiteFactory {

    // 集合 充当池的形式
    private HashMap<String, ConcreteWebSite> pool = new HashMap<>();

    // 根据网站的类型 返回一个网站 如果没有就创建一个网站并放入到池中
    public WebSite getWebSiteCategory(String type) {
        if (!pool.containsKey(type)) {
            // 就创建一个网站
            pool.put(type, new ConcreteWebSite(type));
        }

        return (WebSite) pool.get(type);
    }

    // 获取网站分类的总数,池中有多少实际的网站
    public int getWebSiteCount() {
        return pool.size();
    }

}
```

## 代理模式

### 静态代理

在不修改目标对象的功能的前提下 能通过代理对象对目标功能进行扩展

```java
package com.ntuzy.proxy.staticproxy;

public class Client {
    public static void main(String[] args){
        // 创建目标对象 被代理对象
        TeacherDao teacherDao = new TeacherDao();

        // 创建代理对象 同时将被代理对象传递给代理对象
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);

        // 通过代理对象 调用到被代理对象的方法
        // 执行的是代理对象的方法 代理对象再去调用目标对象的方法
        teacherDaoProxy.teach();

    }
}

```

### 动态代理

```java
package com.ntuzy.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    // 维护一个目标对象
    private Object target;


    // 构造器 对target进行初始化
    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 给目标对象生成一个代理对象
    public Object getProxyInstance() {
        // loader 当前目标对象使用的类加载器 获取加载器的方法固定
        // interface 目标对象实现的接口类型 使用泛型的方式确认类型
        // InvocationHandler 事情处理 执行目标对象的方法时 会触发事情处理器方法 会把当前执行目标对象方法
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("jdk代理开始");
                        // 通过反射机制调用目标对象的方法
                        Object returnVal = method.invoke(target, args);
                        return returnVal;
                    }
                });
    }

}

```

### Cglib代理

```java
package com.ntuzy.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

    private Object target;

    // 传入一个被代理的对象
    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 返回一个代理对象 是target对象的代理对象
    public Object getProxyInstance() {
        // 创建工具类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调函数
        enhancer.setCallback(this);
        // 创建子类对象 即代理对象
        return enhancer.create();
    }


    // 重写intercept方法 会调用目标对象的方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib代理模式开始");
        Object returnVal = method.invoke(target, objects);
        System.out.println("Cglib代理模式提交");
        return returnVal;
    }
}

```

## 模板模式

在一个抽象类公开定义了执行它方法的模板，它的子类可以按照需要重写方法实现，但调用将以抽象类中的定义的方式进行。

```java
package com.ntuzy.template.improve;

public abstract class SoyaMilk {


    // 模板方法 make 模板方法可以做成final  不让子类覆盖
    final void make() {
        select();
        if (customerWantCondiments()) {
            addCondiments();
        }
        soak();
        beat();
    }

    void select() {
        System.out.println("选择好的新鲜的黄豆");
    }

    // 添加不同的配料
    abstract void addCondiments();


    // 浸泡
    void soak() {
        System.out.println("黄豆配料开始浸泡，需要三小时");
    }

    void beat() {
        System.out.println("黄豆配料放到豆浆机打碎");
    }

    // 钩子方法 决定是否需要添加配料
    boolean customerWantCondiments() {
        return true;
    }
}
```

## 命令模式

定义：将“请求”封装成对象，以便使用不同的请求、队列或者日志来参数化其他对象。命令模式也支持撤销的操作。

包括三个核心对象：

1、调用者（Invoker）：持有一个命令对象，并在某个时间点调用命令对象的execute()方法。

2、命令对象（Command）：持有一个接收者，和一个execute()方法，在execute中执行接收者的动作。

3、接收者（Receiver）：动作的执行者。

jdbcTemplate

```java
package com.ntuzy.command;

public class RemoteController {
    // 开按钮的命令数组
    Command[] onCommands;
    Command[] offCommands;

    // 执行撤销命令
    Command undoCommand;

    // 构造器 完成对按钮的初始化
    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];

        for(int i = 0;i < 5;i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }

    }

    // 给按钮设置你需要的命令即可
    public void setCommand(int no,Command onCommand,Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    // 按下开按钮
    public void onButtonWasPushed(int no) {
        // 找到按下开的按钮  并调用对应的方法
        onCommands[no].execute();
        // 记录最后这次的操作 用于撤销
        undoCommand = onCommands[no];
    }

    // 按下关按钮
    public void offButtonWasPushed(int no) {
        // 找到按下开的按钮  并调用对应的方法
        offCommands[no].execute();
        // 记录最后这次的操作 用于撤销
        undoCommand = offCommands[no];
    }

    // 按下撤销按钮
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

}

```

## 访问者模式

封装一些作用于某种数据结构的各元素的操作，他可以在不改变数据结构的前提下定义作用于这些元素的新的操作

+ Visitor是抽象的访问者，为该对象结构中的ConcreteElement的每个类生命一个visit操作
+ ConcreteVisitor 是每个具体访问值，实现每个有Visitor声明的操作，是每个操作的实现部分
+ ObjectStructure 能枚举他的元素，可以提供一个高层接口，用来允许访问者访问元素
+ Element 定义一个accept方法，接受一个访问者对象
+ ConcreteElement 为具体元素，实现了accept方法

## 迭代器模式

+ `iterator` 迭代器接口，是系统提供的含义 hasNext next remove
+ `ConcreteIterator` 具体的迭代器 管理迭代
+ `Aggregate` 一个统一的聚合接口 将客户端和具体的聚合解耦
+ `ConcreteAggreage` 具体的聚合持有对象集合并提供一个方法 返回一个迭代器，改迭代器可以正确遍历集合
+ Client 客户端 通过Iterator和Aggregate依赖子类

### 代码

+ ComputerCollege

  ```java
  package com.ntuzy.iterator;
  
  import java.util.Iterator;
  
  public class ComputerCollege implements College {
  
      Department[] departments;
      int numOfDepartments = 0; // 保存当前数组对象个数
  
      public ComputerCollege() {
          departments = new Department[5];
          addDepartment("Java","Java");
          addDepartment("Php","Php");
          addDepartment("大数据","大数据");
      }
  
      @Override
      public String getName() {
          return "计算机学院";
      }
  
      @Override
      public void addDepartment(String name, String desc) {
  //        departments = new Department[5];
          Department department = new Department(name, desc);
          departments[numOfDepartments] = department;
          numOfDepartments++;
      }
  
      @Override
      public Iterator createIterator() {
          return new ComputerCollegeIterator(departments);
      }
  }
  
  ```

+ ComputerCollegeIterator

  ```java
  package com.ntuzy.iterator;
  
  import java.util.Iterator;
  
  public class ComputerCollegeIterator implements Iterator {
  
      // 这里我们需要知道Department是怎样存放的
      Department[] departments;
      int position = 0;  // 遍历的位置
  
  
      public ComputerCollegeIterator(Department[] departments) {
          this.departments = departments;
      }
  
      // 判断是否还有下一个元素
      @Override
      public boolean hasNext() {
          if (position >= departments.length || departments[position] == null) {
              return false;
          }
  
          return true;
      }
  
  
      @Override
      public Object next() {
          Department department = departments[position];
          position++;
          return department;
      }
  
      // 删除的方法默认空实现
      public void remove() {
  
      }
  
  }
  ```













































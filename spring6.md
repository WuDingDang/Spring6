Spring6

jdk17

maven

![image-20231114214606128](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231114214606128.png)



# 1.启示录

## 1.1 OCP原则

OCP是软件七大开发原则中最基本的原则：开闭原则

对扩展开放

对修改关闭

OCP开闭原则核心：在扩展系统功能时，没有修改以前写好的代码，就符合OCP原则



## 1.2 依赖倒置原则（DIP原则）

![image-20231114220511971](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231114220511971.png)

什么是依赖倒置原则？

​	面向接口编程，面向抽象编程，不要面向具体编程

依赖倒置原则的目的？

​	降低程序耦合度，提高扩展力

什么是违背依赖倒置原则？

​	上 依赖 下，就是违背（只要 下 一改动，上 就受到牵连）



## 1.3 控制反转（IoC）  

控制反转IoC（Inversion of Control）

![image-20231114221258522](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231114221258522.png)

控制反转是一种编程思想，或者是一种新型的设计模式



## 1.4 Spring框架

Spring框架实现了控制反转的思想/Spring是一个实现了IoC的容器

​	Spring框架可以帮你new对象

​	Spring框架可以帮你维护对象和对象之间的关系



控制反转的实现方式有多种，其中比较重要的一种叫：依赖注入DI（Dependency Injection）

控制反转是思想，依赖注入是这种思想的具体实现

依赖注入DI，又包括常见的两种方式：

- set注入（执行set方法给属性赋值）
- 构造方法注入（执行构造方法给属性赋值）



依赖（A对象和B对象的关系）注入（一种手段，通过这种手段，可以让A对象和B对象产生关系）

依赖注入：A对象和B对象的关系靠注入手段维护，而注入包括set注入和构造方法注入



## 1.5 面试常问

控制反转解决什么问题？ 符合OCP,DIP原则

什么是控制反转？  反转的两件事

什么是Spring框架？  实现控制反转思想

控制反转怎么实现？ 依赖注入（两种实现：set注入，构造方法注入）



# 2. Spring概述

Spring是一个轻量级的控制反转（IoC）和面向切面（AOP）的容器框架

## 2.1 Spring 8大模块

![image-20231115204802409](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231115204802409.png)

## 2.2 Spring 特点

- 轻量，非侵入式的（Spring应用中的对象不依赖于Spring的特定类）

- 控制反转

- 面向切面

- 容器

  Spring可以帮我们创建对象，每一个被Spring管理的对象在Spring中叫bean。Spring管理对象

  Spring包含并管理应用对象的配置和生命周期，在这个意义上它是一个容器

- 框架

![image-20231115205538642](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231115205538642.png)



# 3. Spring入门程序

## 3.1 spring 的 jar包

- spring-bean
- spring-core
- spring-context
- spring-aop
- spring-aspects



## 3.2 第一个程序

- 创建module

- pom文件

![image-20231115213431307](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231115213431307.png)

- 创建一个bean

![image-20231115214251198](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231115214251198.png)

- spring配置文件

![image-20231115213604930](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231115213604930.png)

![image-20231115213836564](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231115213836564.png)

![image-20231115214301763](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231115214301763.png)

- 测试类

```java
@Test
public void testFirstSpringCode(){
    //第一步：获取Spring容器对象
    //ApplicationContext 翻译为应用上下文，其实就是Spring容器
    //ApplicationContext是一个接口，有很多实现类，其中有一个实现类叫ClassPathXmlApplicationContext
    //ClassPathXmlApplicationContext  专门从类路径当中加载Spring配置文件 的一个Spring上下文对象
    //这行代码只要执行，就相当于启动了Spring容器，解析spring.xml文件，并且实例化所有bean对象，放到容器当中
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    //第二步：根据bean的id从spring容器中获取对象
    Object userBean = applicationContext.getBean("userBean");
    System.out.println(userBean);
}
```

### 细节

- spring配置文件中 bean标签的id不能重复

- spring是怎么实例化对象的？

​	默认情况下，spring会通过反射机制，调用类的无参构造方法实例化对象

实现原理如下代码

```java
Class clazz = Class.forName("com.wdd.spring6.bean.User");
clazz.newInstance();
```

- 创建好的对象存储到什么样的数据结构中？

  存到map中

![image-20231115215908871](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231115215908871.png)

- spring配置文件可以有多个

  ![image-20231115220125937](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231115220125937.png)

![image-20231115220213672](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231115220213672.png)

- 配置文件中配置的类可以是JDK中的类

![image-20231115220328132](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231115220328132.png)

- bean的id如果不存在，不会返回null，而是出现异常
- getBean()方法返回的类型是Object，如果访问子类特有属性和方法时，还需要向下转型，有其他办法可以解决嘛

```java
//  Date nowtime = (Date)applicationContext.getBean("nowtime");
  //不想强制类型转换，可以使用以下代码(通过第二个参数，指定返回的bean类型)
  Date nowtime = applicationContext.getBean("nowtime", Date.class);
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
  String stringNoeTime = sdf.format(nowtime);
  System.out.println(stringNoeTime);
```

- ClassPathXmlApplicationContext是从类的根路径加载配置文件，如果配置文件不在类的根路径，如何加载？

![image-20231115221607721](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231115221607721.png)



- BeanFactory
![image-20231115221810445](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231115221810445.png)



- ![image-20231115222009409](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231115222009409.png)



## 3.3 spring启用Log4j2日志框架

第一步：引入依赖

```xml
<!-- log4j2依赖 -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.19.0</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-slf4j2-impl</artifactId>
    <version>2.19.0</version>
</dependency>
```

第二步：在类的根路径下提供配置文件log4j2.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <loggers>
        <!--
            level指定日志级别 从高到低优先级：
            ALL <TRACE <DEBUG<INFO<WARN<ERROR<FATAL<OFF
        -->
        <root level="DEBUG">
            <appender-ref ref="spring6log"/>
        </root>
    </loggers>

    <appenders>
        <!--输出日志信息到控制台-->
        <console name="spring6log" target="SYSTEM_OUT">
            <!--控制日志输出格式-->
            <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-3level %logger{1024} - %msg%n"/>
        </console>
    </appenders>
</configuration>
```

第三步

```java
//自己如何使用log4j2记录日志信息
//第一步：创建日志记录器对象
//获取FirstSpringTest类的日志记录器对象
Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);
//第二步：记录日志 根据不同日志级别输出日志
logger.info("信息info");
logger.debug("信息debug");
logger.error("信息error");
```

![image-20231115223615258](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231115223615258.png)

![image-20231115223634326](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231115223634326.png)



# 4.Spring对IoC的实现（*）

## 4.1 IoC控制反转

- 控制反转是一种思想
- 控制反转为了降低程序耦合度，提高程序扩展里，达到OCP原则，达到DIP原则
- 控制反转，反转的是什么？
  - 将对象的创建权利交出去，交给第三方容器负责
  - 将对象和对象之间关系的维护权交出去，交给第三方容器负责
- 如何实现？
  - DI：依赖注入



## 4.2 依赖注入

依赖注入实现控制反转的思想

**Spring通过依赖注入的方式来完成Bean管理**

**Bean管理：Bean对象的创建，以及Bean对象中属性的赋值（或者叫做Bean对象之间关系的维护）**

依赖注入：

- 依赖：对象和对象之间的关联关系
- 注入：一种数据传递行为，通过注入的行为让对象和对象产生关系

依赖注入常见的两种实现方式：

- set注入
- 构造注入





### 4.2.1 set注入

Dao：

```java
public class UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public void insert(){
        //System.out.println("数据库正在保存用户信息。。。");
        logger.info("数据库正在保存用户信息。。。");
    }
}
```

```java
public class VipDao {
    private static final Logger logger = LoggerFactory.getLogger(VipDao.class);
    public void insert(){
        logger.info("正在保存vip信息！！！");
    }
}
```

Service：

```java
public class UserService {
    private UserDao userDao;
    //set注入，必须提供一个set方法
    //spring容器会调用这个set方法，给UserDao属性赋值

    //这个set方法是IDEA工具生成的，符合javabean规范
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //不使用IDEA自动生成，自己写set方法
    //方法必须以set开头，不能随便写
//    public void setMySQLUserDao(UserDao xyz){
//        this.userDao = xyz;
//    }

    private VipDao vipDao;

    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    public void saveUser(){
        //保存用户信息到数据库
        userDao.insert();
        vipDao.insert();
    }

}
```

spring.xml:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!-- 配置dao -->
    <bean id="userDaoBean" class="com.wdd.spring6.dao.UserDao"/>

    <!-- 配置service -->
    <bean id="userServiceBean" class="com.wdd.spring6.service.UserService">
        <!-- 想让Spring调用对应的set方法，需要配置property标签 -->
        <!-- name属性怎么指定值：set方法的方法名，去掉set，然后把剩下的单词首字母变小写 -->
        <!-- ref：翻译为引用，指定的是要注入的bean的id -->
        <!--<property name="mySQLUserDao" ref="userDaoBean"/>-->
        <property name="userDao" ref="userDaoBean"/>
        <property name="vipDao" ref="vipDaoBean"/>
    </bean>

    <bean id="vipDaoBean" class="com.wdd.spring6.dao.VipDao"/>
</beans>
```

Test：

```java
@Test
public void testSetDI(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    UserService userService = applicationContext.getBean("userServiceBean", UserService.class);
    userService.saveUser();
}
```

![image-20231118190752969](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231118190752969.png)



### 4.2.2 构造注入

核心原理：通过构造方法来给属性赋值

Service：

```java
public class CustomerService {
    private UserDao userDao;
    private VipDao vipDao;

    public CustomerService(UserDao userDao, VipDao vipDao) {
        this.userDao = userDao;
        this.vipDao = vipDao;
    }

    public void save(){
        userDao.insert();
        vipDao.insert();
    }
}
```

配置文件：

```xml
<bean id="userDaoBean" class="com.wdd.spring6.dao.UserDao"/>
<bean id="vipDaoBean" class="com.wdd.spring6.dao.VipDao"/>

<!-- 方法一 -->
<bean id="csDaoBean" class="com.wdd.spring6.service.CustomerService">
    <!-- 构造注入 -->
    <!--
        index属性指定参数下标，第一个参数是0，第二个参数是1，第三个参数是2，依次类推
        ref属性用来指定注入的bean的id
     -->
    <!-- 指定构造方法的第一个参数，下标是0 -->
    <constructor-arg index="0" ref="userDaoBean"/>
    <!-- 指定构造方法的第二个参数，下标是1 -->
    <constructor-arg index="1" ref="vipDaoBean"/>
</bean>
<!-- 方法二 -->
<bean id="csDaoBean2" class="com.wdd.spring6.service.CustomerService">
    <!-- 根据构造方法的参数名字进行注入 -->
    <constructor-arg name="userDao" ref="userDaoBean"/>
    <constructor-arg name="vipDao" ref="vipDaoBean"/>
</bean>

<!-- 方法三 -->
<bean id="csDaoBean3" class="com.wdd.spring6.service.CustomerService">
    <!-- 不指定下标，也不指定参数名，让spring自己做类型匹配 -->
    <!-- 这种方式实际上是根据类型进行注入的 -->
    <constructor-arg ref="vipDaoBean"/>
    <constructor-arg ref="userDaoBean"/>
</bean>
```

test：

```java
@Test
public void testConstructorDI(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    CustomerService customerService = applicationContext.getBean("csDaoBean", CustomerService.class);
    customerService.save();

    CustomerService customerService2 = applicationContext.getBean("csDaoBean2", CustomerService.class);
    customerService2.save();

    CustomerService csDaoBean3 = applicationContext.getBean("csDaoBean3", CustomerService.class);
    csDaoBean3.save();
}
```



## 4.3 set注入专题

### 4.3.1 外部Bean和内部Bean

Dao：

```java
public class OrderDao {
    private static final Logger logger = LoggerFactory.getLogger(OrderDao.class);
    public void insert(){
        logger.info("订单正在生成。。。");
    }
}
```

Service:

```java
public class OrderService {
    private OrderDao orderDao;

    /**
     * 通过set方法给属性赋值
     * @param orderDao
     */
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    /**
     * 生成订单的业务方法
     */
    public void generate(){
        orderDao.insert();
    }
}
```

配置文件：

```xml
<!-- 声明/定义Bean -->
<bean id="orderDaoBean" class="com.wdd.spring6.dao.OrderDao"/>

<bean id="orderServiceBean" class="com.wdd.spring6.service.OrderService">
    <!-- 使用ref属性来引入，这就是注入外部Bean -->
    <property name="orderDao" ref="orderDaoBean"/>
</bean>

<bean id="orderServiceBean2" class="com.wdd.spring6.service.OrderService">
   <property name="orderDao">
       <!-- 在property标签中使用嵌套的bean标签，这就是内部bean -->
       <bean class="com.wdd.spring6.dao.OrderDao"></bean>
   </property>
</bean>
```

test：

```java
@Test
public void testSetDI2(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
    OrderService orderService = applicationContext.getBean("orderServiceBean", OrderService.class);
    orderService.generate();

    OrderService orderServiceBean2 = applicationContext.getBean("orderServiceBean2", OrderService.class);
    orderServiceBean2.generate();
}
```



### 4.3.2 注入简单类型

bean：

```java
public class User {
    private String username;   //String是简单类型
    private String password;
    private int age;   //int是简单类型

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
```

配置文件：

```xml
<!-- 注入简单类型 -->
<bean id="userBean" class="com.wdd.spring6.bean.User">
    <!-- 重点：如果是简单类型赋值，不能使用ref，需要使用value -->
    <property name="username" value="张三"/>
    <property name="age" value="21"/>
    <property name="password" value="123456"/>
</bean>
```

test：

```java
@Test
public void testSimpleTypeSet(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
    User user = applicationContext.getBean("userBean", User.class);
    System.out.println(user);
}
```

![image-20231118194950762](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231118194950762.png)



简单类型有哪些？

![image-20231118195255446](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231118195255446.png)

Temporal是Java8提供的时间和时区类型

Locale是语言类

测试简单类型

```java
public class SimpleValueType {
    private int age;
    private Integer age2;

    private boolean flag;
    private boolean flag2;

    private char c;
    private Character c2;

    private Season season;
    private String username;
    private Class clazz;

    private Date birth;
```

```xml
 <!-- 测试哪些类型是简单类型 -->
    <bean id="svt" class="com.wdd.spring6.bean.SimpleValueType">
        <property name="age" value="21"/>
        <property name="age2" value="24"/>
        <property name="flag" value="false"/>
        <property name="flag2" value="true"/>
        <property name="username" value="zhangsan"/>
        <property name="c" value="男"/>
        <property name="c2" value="女"/>
        <property name="clazz" value="java.lang.String"/>
        <property name="season" value="SPTING"/>
        <!-- 报错 1999-07-27字符串无法转换成java.util.Date类型 -->
        <!--<property name="birth" value="1999-07-27"/>-->
        <!-- 要把Date当作简单类型，使用value赋值，对日期字符串格式有要求 Sat Nov 18 20:06:58 CST 2023 -->
<!--        <property name="birth" value="Sat Nov 18 20:06:58 CST 2023"/>-->
        <!-- 实际开发中，一般不会把Date当作简单类型，虽然他是简单类型，一般会采用ref -->
    </bean>
```

```java
@Test
public void testSimpleTypeSet2(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
    SimpleValueType simpleValueType = applicationContext.getBean("svt", SimpleValueType.class);
    System.out.println(simpleValueType);
}
```

![image-20231118201017668](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231118201017668.png)





简单类型注入的经典应用（注入数据源）

```java
/**
 * 所有的数据源都要实现java规范：javax.sql.DataSource
 * 什么是数据源？能够给你提供Connection对象的都是数据源
 */
public class MyDataSource implements DataSource {    //可以把数据源交给spring容器管理
    private String driver;
    private String url;
    private String username;
    private String password;
```

```xml
<bean id="myDataSource" class="com.wdd.spring6.jdbc.MyDataSource">
    <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/spring6"/>
    <property name="username" value="root"/>
    <property name="password" value="123456"/>
</bean>
```

```java
@Test
public void testMyDataSource(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
    MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
    System.out.println(myDataSource);
}
```

![image-20231120204418470](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231120204418470.png)





### 4.3.3 级联属性赋值（了解）

```java
public class Clazz {
    //班级名称
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

```java
public class Student {
    //学生名称
    private String name;
    private Clazz clazz;

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    //使用级联属性赋值，需要get方法
    public Clazz getClazz() {
        return clazz;
    }

    public void setName(String name) {
        this.name = name;
    }
```

```xml
<!--
    使用级联属性赋值注意：
    1.配置顺序不能颠倒，必须如下顺序
    2.clazz必须提供get方法
-->
<bean id="studentBean" class="com.wdd.spring6.bean.Student">
    <!-- 简单类型使用value -->
    <property name="name" value="张三"/>
    <!-- 不是简单类型，使用ref -->
    <property name="clazz" ref="clazzBean"/>
    <!-- 级联属性赋值 -->
    <property name="clazz.name" value="高三二班"/>
</bean>
<bean id="clazzBean" class="com.wdd.spring6.bean.Clazz"/>
<!--
 <bean id="clazzBean" class="com.wdd.spring6.bean.Clazz">
    <property name="name" value="高三一班"/>
</bean>
-->
```

```java
@Test
public void testCascade(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cascade.xml");
    Student student = applicationContext.getBean("studentBean", Student.class);
    Clazz clazz = applicationContext.getBean("clazzBean", Clazz.class);
    System.out.println(student);
    System.out.println(clazz);
}
```



### 4.3.4 注入数组

```java
public class QianDaYe {
    private String[] aiHaos;

    private Woman[] womens;

    public void setWomens(Woman[] womens) {
        this.womens = womens;
    }

    public void setAiHaos(String[] aiHaos) {
        this.aiHaos = aiHaos;
    }
```

```java
public class Woman {
    private String name;

    public void setName(String name) {
        this.name = name;
    }
```

```xml
<bean id="w1" class="com.wdd.spring6.bean.Woman">
    <property name="name" value="小花"/>
</bean>
<bean id="w2" class="com.wdd.spring6.bean.Woman">
    <property name="name" value="小红"/>
</bean>
<bean id="w3" class="com.wdd.spring6.bean.Woman">
    <property name="name" value="小丽"/>
</bean>
<bean id="yuQian" class="com.wdd.spring6.bean.QianDaYe">
    <!-- 数组中的元素是简单类型 -->
    <property name="aiHaos">
        <array>
            <value>抽烟</value>
            <value>喝酒</value>
            <value>烫头</value>
        </array>
    </property>
    <!-- 数组中的元素不是简单类型 -->
    <property name="womens">
        <array>
            <ref bean="w1"/>
            <ref bean="w2"/>
            <ref bean="w3"/>
        </array>
    </property>
</bean>
```

```java
@Test
public void testArray(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
    QianDaYe yuQian = applicationContext.getBean("yuQian", QianDaYe.class);
    System.out.println(yuQian);
}
```

![image-20231120210920019](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231120210920019.png)





### 4.3.5 注入List和Set集合

```java
public class Person {
    //注入list集合
    private List<String> names;
    //注入set集合
    private Set<String> addrs;

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setAddrs(Set<String> addrs) {
        this.addrs = addrs;
    }
```

```xml
<bean id="personBean" class="com.wdd.spring6.bean.Person">
    <property name="names">
        <!-- list集合有序可重复 -->
        <list>
            <value>张胜男</value>
            <value>李四</value>
            <value>李四</value>
        </list>
    </property>
    <property name="addrs">
        <!-- set集合无序不重复 -->
        <set>
            <value>北京大兴区</value>
            <value>北京海淀区</value>
            <value>北京大兴区</value>
            <value>北京大兴区</value>
        </set>
    </property>
</bean>
```

```java
@Test
public void testCollection(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-collection.xml");
    Person person = applicationContext.getBean("personBean", Person.class);
    System.out.println(person);
}
```

![image-20231120211625952](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231120211625952.png)



### 4.3.6 注入Map集合

```java
//注入Map集合
private Map<Integer,String> phones;
//注入属性类对象
//Properties本质上也是Map集合
//Properties的父类是HashTable，HashTable实现了Map接口
//Properties的key和value只能是String类型
private Properties properties;
```

```xml
<property name="phones">
    <map>
        <!-- 如果key和value不是简单类型加-ref -->
        <!--  <entry key-ref="" value-ref=""/>-->
        <entry key="1" value="110"/>
        <entry key="2" value="120"/>
        <entry key="3" value="119"/>
        <entry key="4" value="12315"/>
    </map>
</property>
<property name="properties">
    <!-- 注入properties属性类对象 -->
    <props>
        <prop key="driver">com.mysql.cj.jdbc.Driver</prop>
        <prop key="url">jdbc:mysql://localhost:3306/spring6</prop>
        <prop key="username">root</prop>
        <prop key="password">123456</prop>
    </props>
</property>
```

![image-20231120215602385](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231120215602385.png)





### 4.3.7 注入null和空字符串

```java
public class Cat {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
```

```xml
 <bean id="catBean" class="com.wdd.spring6.bean.Cat">
        <!-- 不给属性注入，属性的默认值就是null -->
<!--        <property name="name" value="tom"/>-->
        <!-- 手动注入null -->
        <property name="name">
            <null/>
        </property>
        <!-- 注入空字符串 方法一 -->
<!--        <property name="name" value=""/>-->
        
        <!-- 注入空字符串 方法二 -->
        <!--
        <property name="name">
            <value/>
        </property>
        -->
        <property name="age" value="3"/>
    </bean>
```

```java
@Test
public void testNull(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
    Cat cat = applicationContext.getBean("catBean", Cat.class);
    System.out.println(cat);
}
```

![image-20231120220148296](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231120220148296.png)



### 4.3.8 注入的值含有特殊符号

xml中5个特殊符号： <  >  '  "  &

![image-20231120220755142](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231120220755142.png)

解决方法：

- 方法一：特殊符号使用转义字符代替
- 方法二：将含有特殊符号的字符串放到 <![CDATA[]]> 中，因为放在CDATA区中的数据不会被XML文件解析

```java
public class MathBean {
    private String result;

    public void setResult(String result) {
        this.result = result;
    }
```

```xml
<bean id="mathBean" class="com.wdd.spring6.bean.MathBean">
        <!-- 方法一：使用实体符号代替特殊符号 -->
<!--        <property name="result" value="2 &lt; 3"/>-->
        <!-- 方法二：使用<![CDATA[]]> -->
        <property name="result">
            <!-- 只能使用value标签 -->
            <value><![CDATA[2<3]]></value>
        </property>
    </bean>
```

```java
@Test
public void testSpecial(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
    MathBean mathBean = applicationContext.getBean("mathBean", MathBean.class);
    System.out.println(mathBean);
}
```

![image-20231120221210406](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231120221210406.png)





## 4.4 p命名空间注入

目的：简化配置

p命名空间注入 底层还是set注入

```java
public class Dog {
    //简单类型
    private String name;
    private int age;
    //非简单类型
    private Date birth;
```

```xml
<!--
第一步：在spring配置文件头部添加p命名空间  xmlns:p="http://www.springframework.org/schema/p
第二步：使用 p:属性名="属性值"

-->
 <bean id="dogBean" class="com.wdd.spring6.bean.Dog" p:name="小白" p:age="3" p:birth-ref="birthBean"></bean>
 <!-- 获取当前时间 -->
 <bean id="birthBean" class="java.util.Date"/>
```

```java
@Test
public void testP(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
    Dog dog = applicationContext.getBean("dogBean", Dog.class);
    System.out.println(dog);
}
```

![image-20231120222008473](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231120222008473.png)

![image-20231120222017139](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231120222017139.png)



## 4.5 c命名空间

目的：简化构造方法

c命名空间注入是基于构造方法的

```java
public class People {
    private String name;
    private int age;
    private boolean sex;

    public People(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
```

```xml
 <!--
        第一步：在spring配置文件头部添加  xmlns:c="http://www.springframework.org/schema/c"
        第二步：使用
        c:_0  下标方式
        c:name  参数名
    -->
<!--    <bean id="peopleBean" class="com.wdd.spring6.bean.People" c:_0="小小" c:_1="11" c:_2="true"></bean>-->
    <bean id="peopleBean" class="com.wdd.spring6.bean.People" c:name="hhh" c:age="22" c:sex="true"></bean>
```

![image-20231120223452984](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231120223452984.png)





## 4.6 util命名空间

目的：可以让配置复用

```java
public class MyDataSource1 implements DataSource {    //可以把数据源交给spring容器管理
//    private String driver;
//    private String url;
//    private String username;
//    private String password;

    //Properties属性类对象，是一个Map集合
    private Properties properties;
```

```java
public class MyDataSource2 implements DataSource {    //可以把数据源交给spring容器管理


    //Properties属性类对象，是一个Map集合
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                            http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd">

    <!--
     引入util命名空间：
     在spring配置文件头部添加
      xmlns:util="http://www.springframework.org/schema/util"

       http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd
    -->
    <util:properties id="prop">
        <prop key="driver">com.mysql.cj.jdbc.Driver</prop>
        <prop key="url">jdbc:mysql://localhost:3306/spring6</prop>
        <prop key="username">root</prop>
        <prop key="password">123456</prop>
    </util:properties>
    <bean id="ds1" class="com.wdd.spring6.jdbc.MyDataSource1">
        <property name="properties" ref="prop"/>
    </bean>
    <bean id="ds2" class="com.wdd.spring6.jdbc.MyDataSource2">
        <property name="properties" ref="prop"/>
    </bean>
    <!--
    <bean id="ds1" class="com.wdd.spring6.jdbc.MyDataSource1">
        <property name="properties">
            <props>
                <prop key="driver">com.mysql.cj.jdbc.Driver</prop>
                <prop key="url">jdbc:mysql://localhost:3306/spring6</prop>
                <prop key="username">root</prop>
                <prop key="password">123456</prop>
            </props>
        </property>
    </bean>

    <bean id="ds2" class="com.wdd.spring6.jdbc.MyDataSource2">
        <property name="properties">
            <props>
                <prop key="driver">com.mysql.cj.jdbc.Driver</prop>
                <prop key="url">jdbc:mysql://localhost:3306/spring6</prop>
                <prop key="username">root</prop>
                <prop key="password">123456</prop>
            </props>
        </property>
    </bean>
    -->
</beans>
```

![image-20231120224600208](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231120224600208.png)

```java
@Test
public void testUtil(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-util.xml");
    MyDataSource1 ds1 = applicationContext.getBean("ds1", MyDataSource1.class);
    System.out.println(ds1);
    MyDataSource2 ds2 = applicationContext.getBean("ds2", MyDataSource2.class);
    System.out.println(ds2);
}
```

![image-20231120224614134](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231120224614134.png)





## 4.7 基于XML的自动装配

可以根据名字装配，也可以根据类型装配

**自动装配也是基于set注入实现的**

### 4.7.1 根据名字自动装配

```xml
<!-- 根据名字自动装配 -->
<bean id="orderService" class="com.wdd.spring6.service.OrderService" autowire="byName"></bean>
<!-- id一般也叫bean的名称  -->
<!--根据名字自动装配,被注入的对象的bean的id不能随便写，set方法名去掉set后的单词首字母变成小写放到这-->
<bean id="orderDao" class="com.wdd.spring6.dao.OrderDao"/>
```



### 4.7.2 根据类型自动装配

```xml
<!-- 根据类型自动装配 -->
<!-- 根据类型自动装配时，在有效的配置文件中，某种类型的实例只能有一个 -->
<bean class="com.wdd.spring6.dao.UserDao"></bean>
<bean class="com.wdd.spring6.dao.VipDao"></bean>
<bean id="cs" class="com.wdd.spring6.service.CustomerService" autowire="byType"></bean>
```



## 4.8 引入外部属性配置文件

```xml
<!--引入外部properties文件
    第一步：引入context命名空间
    第二步：使用标签 context:property-placeholder 的location属性来指定属性配置文件的路径
        location默认从类的根路径加载资源
    第三步：取值 ${key}
-->
<context:property-placeholder location="jdbc.properties"/>

<!-- 配置数据源 -->
<bean id="ds" class="com.wdd.spring6.jdbc.MyDataSource">
    <property name="driver" value="${driverClass}"/>
    <property name="url" value="${url}"/>
    <property name="username" value="${username}"/>
    <property name="password" value="${password}"/>
</bean>
```

![image-20231121205933001](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231121205933001.png)

![image-20231121205940893](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231121205940893.png)

![image-20231121210024867](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231121210024867.png)





# 5. Bean的作用域

## 5.1 单例和多例

```java
public class SpringBean {
    public SpringBean() {
        System.out.println("SpringBean无参构造");
    }
}
```

```xml
<!--
scope属性的两个值：
singleton 单例（默认）
prototype 原型/多例
-->
<bean id="sb" class="com.wdd.spring6.bean.SpringBean" scope="singleton"></bean>
```

```java
@Test
public void testBeanScope(){
    /**
     * 1.Spring默认情况下如何管理bean
     *      默认情况下Bean是单例的 singleton
     *      在Spring上下文初始化的时候实例化
     *      每一次调用getBean方法的时候，都返回的是单例对象
     * 2.当将bean的scope属性设置为prototype时：
     *      bean是多例的
     *      spring上下文初始化的时候不会初始化这些prototype的bean
     *      每一次调用getBean方法的时候，实例化该bean对象
     *      prototype （原型）
     */
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
    SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
    System.out.println(sb);
    SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
    System.out.println(sb2);
}
```

![image-20231121211608009](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231121211608009.png)

![image-20231121211634834](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231121211634834.png)



其他scope（request，session）

request：一次请求一个bean

session：一次会话一个bean

需引入web框架

![image-20231121211752846](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231121211752846.png)

![image-20231121211905259](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231121211905259.png)



## 5.2 自定义scope（了解）

一个线程一个bean

- 自定义Scope（实现Scope接口）

  spring内置了线程范围的类，可直接使用

- 将自定义Scope注册到Spring容器中

```xml
<bean id="sb" class="com.wdd.spring6.bean.SpringBean" scope="threadScope"></bean>

<!--配置自定义的作用域-->
<bean class="org.springframework.beans.factory.config.CustomScopeConfigurer">
    <property name="scopes">
        <map>
            <entry key="threadScope">
                <!--这个Scope接口的实现类使用的是spring框架内置的，也可以自定义-->
                <bean class="org.springframework.context.support.SimpleThreadScope"/>
            </entry>
        </map>
    </property>
</bean>
```

```java
@Test
public void testThreadScope(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
    SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
    System.out.println(sb);
    SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
    System.out.println(sb1);
    //启动一个新的线程
    new Thread(new Runnable() {
        @Override
        public void run() {
            SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
            System.out.println(sb2);
            SpringBean sb3 = applicationContext.getBean("sb", SpringBean.class);
            System.out.println(sb3);
        }
    }).start();
}
```

![image-20231121212954726](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231121212954726.png)





# 6.GoF工厂模式

设计模式：一种可以被重复利用的解决方案

除了GoF 23种设计模式，还有其他设计模式，如JavaEE设计模式（DAO模式，MVC模式）

GoF 23种设计模式分为三大类：

- 创建型（5个）：解决对象创建问题
  - 单例模式
  - 工厂方法模式
  - 抽象工厂模式
  - 建造者模式
  - 原型模式
- 结构型（7个）：一些类或对象组合在一起的经典结构
  - 代理模式
  - 装饰模式
  - 适配器模式
  - 组合模式
  - 享元模式
  - 外观模式
  - 桥接模式
- 行为型（11个）：解决类或对象之间的交互问题
  - 策略模式
  - 模板方法模式
  - 责任链模式
  - 观察者模式
  - 迭代子模式
  - 命令模式
  - 备忘录模式
  - 状态模式
  - 访问者模式
  - 中介者模式
  - 解释器模式



工厂模式三种形态：

- 简单工厂模式（静态工厂方法模式）：不属于23种设计模式，是工厂方法模式的一种特殊实现
- 工厂方法模式：属于23种设计模式之一
- 抽象工厂模式：属于23种设计模式之一



## 6.1 简单工厂模式

简单工厂模式的角色：

- 抽象产品角色
- 具体产品角色
- 工厂类角色



简单工厂模式解决什么问题？

对象创建问题，客户端程序不需要关心对象的创建细节，需要哪个对象时，只需要向工厂索要即可，初步实现了责任的分离

客户端只负责消费，工厂负责生产，生产和消费分离



简单工厂模式的缺点

- 扩展新产品，工厂类代码需要修改，违背OCP原则
- 工厂类的责任重大，不能出现任何问题，因为这个工厂负责所有产品的生产，成为全能类/上帝类，一旦工厂出问题，整个系统会瘫痪



```java
/**
 * 抽象产品角色
 */
public abstract class Weapon {
    /**
     * 所有武器都可以攻击
     */
    public abstract void attack();
}
```

```java
/**
 * 具体产品角色
 */
public class Tank extends Weapon{
    @Override
    public void attack() {
        System.out.println("Tank 开炮");
    }
}
```

```java
/**
 * 具体产品角色
 */
public class Dagger extends Weapon{
    @Override
    public void attack() {
        System.out.println("Dagger!!!");
    }
}
```

```java
/**
 * 具体产品角色
 */
public class Fighter extends Weapon{
    @Override
    public void attack() {
        System.out.println("Fighter 发射");
    }
}
```

```java
/**
 * 工厂类角色
 */
public class WeaponFactory {
    /**
     * 静态方法，要获取什么产品？看传的参数
     * 简单工厂模式种有一个静态方法，所以被称为静态工厂方法模式
     * @param weaponType
     * @return
     */
    public static Weapon get(String weaponType){
        if("TANK".equals(weaponType)){
            return new Tank();
        }else if("DAGGER".equals(weaponType)){
            return new Dagger();
        }else if("Fighter".equals(weaponType)){
            return new Fighter();
        }else {
            throw new RuntimeException("不支持该武器的生产");
        }
    }
}
```

```java
/**
 * 客户端程序
 */
public class Test {
    public static void main(String[] args) {
        //需要坦克
        //对于客户端来说，坦克的生产细节，不需要关心，只需要向工厂索要即可
        //简单工厂模式达到职责分离，客户端不需要关心产品的生产信息，只消费，工厂类只生产
        //一个负责生产，一个负责消费，生产者和消费者分离了，就是简单工厂的作用
        Weapon tank = WeaponFactory.get("TANK");
        tank.attack();
        Weapon dagger = WeaponFactory.get("DAGGER");
        dagger.attack();
        Weapon fighter = WeaponFactory.get("Fighter");
        fighter.attack();
    }
}
```

![image-20231121220141615](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231121220141615.png)





## 6.2 工厂方法模式

工厂方法模式可以解决简单工厂模式中的OCP问题

如何解决？ 一个工厂对应生产一种产品



工厂模式中的角色：

- 抽象产品角色
- 具体产品角色
- 抽象工厂角色
- 具体工厂角色



工厂方法模式优点：

扩展产品时，符合OCP原则，因为只需要添加两个类（1.具体产品类 2.具体工厂类）



缺点：每次增加一个产品时，都需要增加一个具体类和对象实现工厂，使系统中的类的个数成倍增加

在一定程序上增加了系统的复杂度，同时也增加系统具体类的依赖





# 7. Bean的实例化方式

- 构造方法实例化
- 简单工厂模式实例化
- factory-bean实例化
- FactoryBean接口实例化



## 7.1 构造方法实例化

```java
public class SpringBean {
    public SpringBean() {
        System.out.println("无参构造");
    }
}
```

```xml
<!-- spring提供的实例化方式 第一种：在spring配置文件中直接配置类全路径，spring会自动调用该类的无参构造方法来实例化bean-->
<bean id="sb" class="com.wdd.spring6.bean.SpringBean"/>
```

```java
@Test
public void testInstantiation1(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
    System.out.println(sb);
}
```

![image-20231121222532671](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231121222532671.png)



## 7.2 简单工厂模式实例化

```java
/**
 * 明星类(bean)
 */
public class Star {
    public Star() {
        System.out.println("star 的无参构造");
    }
}
```

```java
/**
 * 简单工厂模式中的工厂类角色
 */
public class StarFactory {
    //工厂类中有一个静态方法
    //简单工厂模式又叫静态工厂方法模式
    public static Star get(){
        //这个Star对象最终实际上创建的时候还是我们负责new的对象
        return new Star();
    }
}
```

```xml
<!-- spring提供的实例化方式 第二种：通过简单工厂模式，在spring配置文件中需要告诉spring框架，调用哪个类的哪个方法获取bean -->
<!-- factory-method 属性指定的是工厂类中的静态方法，也就是告诉spring框架，调用这个方法可以获取bean -->
<bean id="starBean" class="com.wdd.spring6.bean.StarFactory" factory-method="get"/>
```

```java
@Test
public void testInstantiation2(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    Star star = applicationContext.getBean("starBean", Star.class);
    System.out.println(star);
}
```

![image-20231122160555321](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231122160555321.png)





## 7.3 factory-bean实例化

```java
/**
 * 工厂方法模式中：具体产品角色
 */
public class Gun {
    public Gun() {
        System.out.println("GUN 无参构造");
    }
}
```

```java
/**
 * 工厂方法模式中：具体工厂角色
 */
public class GunFactory {
    //工厂模式中的具体工厂角色中的方法是实例方法
    public Gun get(){
        //实际上new这个对象还是我们自己new的
        return new Gun();
    }
}
```

```xml
<!-- spring提供的实例化方式 第三种：通过工厂方法模式，通过factory-bean属性+factory-method属性来共同完成 -->
<!-- 告诉spring框架，调用哪个对象的哪个方法来获取bean -->
<bean id="gunFactory" class="com.wdd.spring6.bean.GunFactory"/>
<!-- factory-bean属性告诉spring调用哪个对象，factory-method告诉spring调用该对象的哪个方法 -->
<bean id="gun" factory-bean="gunFactory" factory-method="get"/>
```

```java
@Test
public void testInstantiation3(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    Gun gun = applicationContext.getBean("gun", Gun.class);
    System.out.println(gun);
}
```





## 7.4 FactoryBean接口实例化

以上第三种方式中，factory-bean是我们自定义的，factory-method也是我们自定义的

在spring中，当编写的类直接实现了 FactoryBean接口后，factory-bean和factory-method都不需要指定了

factory-bean会自动指向实现了FactoryBean接口的类，factory-method会自动指向getObject()方法

```java
/**
 * Bean
 */
public class Person {
    public Person() {
        System.out.println("Person无参构造");
    }
}
```

```java
public class PersonFactoryBean implements FactoryBean<Person>{
    //PersonFactoryBean也是一个Bean，只是这个Bean比较特殊，叫做工厂Bean
    //通过工厂Bean这个特殊的Bean可以获取一个普通的Bean

    @Override
    public Person getObject() throws Exception {
        //最终这个Bean还是我们自己new的
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    //这个方法在接口中有默认实现
    //默认返回true，表示单例的
    //如果想多例，直接修改为return false
    @Override
    public boolean isSingleton() {
        return true;
    }
}
```

```xml
<!-- spring提供的实例化方式 第四种：通过FactoryBean接口实现 -->
<!-- 这种方式实际就是第三种方式的简化 -->
<!-- 通过一个特殊的Bean：工厂Bean，来返回一个普通的Bean -->
 <!-- 通过FactoryBean这个工厂Bean主要是想对普通Bean进行加工处理  -->
<bean id="person" class="com.wdd.spring6.bean.PersonFactoryBean"/>
```

```java
@Test
public void testInstantiation4(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    Person person = applicationContext.getBean("person", Person.class);
    System.out.println(person);
}
```





## 7.5 BeanFactory和FactoryBean的区别

- BeanFactory：SpringIoC容器的顶级对象，是Bean工厂，负责创建Bean对象，BeanFactory是工厂
- FactoryBean：是一个Bean，能够辅助Spring实例化其他Bean对象的一个Bean



Spring种，Bean分为两类：

- 普通Bean
- 工厂Bean





## 7.6 注入Date

```java
public class Student {
    private Date birth;

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "birth=" + birth +
                '}';
    }
}
```

```java
public class DateFactoryBean implements FactoryBean {
    //DateFactoryBean这个工厂Bean协助我们Spring创建这个普通的Bean
    private String strDate;

    public DateFactoryBean(String strDate) {
        this.strDate = strDate;
    }

    @Override
    public Object getObject() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(strDate);
        return date;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
```

```xml
<bean id="nowtime" class="java.util.Date"/>

<bean id="student" class="com.wdd.spring6.bean.Student">
    <property name="birth" ref="nowtime"/>
</bean>

<bean id="date" class="com.wdd.spring6.bean.DateFactoryBean">
    <constructor-arg index="0" value="1999-07-27"/>
</bean>

<bean id="student2" class="com.wdd.spring6.bean.Student">
    <property name="birth" ref="date"/>
</bean>
```

```java
@Test
public void testDate(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    Student studnet = applicationContext.getBean("student2", Student.class);
    System.out.println(studnet);
}
```





# 8. Bean的生命周期

## 8.1 Bean生命周期可以粗略的划分为5大步：

- 实例化Bean（调用无参构造方法）

- Bean属性赋值（调用set方法）

- 初始化Bean（调用Bean的init方法，这个方法需要自己写，自己配）

- 使用Bean

- 销毁Bean（调用Bean的destroy方法，这个方法需要自己写，自己配）

  

```java
public class User {
    private String name;

    public void setName(String name) {
        System.out.println("第二步：给对象属性赋值");
        this.name = name;
    }

    public User() {
        System.out.println("第一步：无参构造方法执行");
    }

    public void initBean(){
        System.out.println("第三步：初始化Bean");
    }

    public void destroyBean(){
        System.out.println("第五步：销毁Bean");
    }
}
```

```xml
<!--需要手动指定初始化方法和销毁方法-->
<bean id="user" class="com.wdd.spring6.bean.User" init-method="initBean" destroy-method="destroyBean">
    <property name="name" value="zhangsan"/>
</bean>
```

```java
@Test
public void testBeanLifeCycleFive(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    User user = applicationContext.getBean("user", User.class);
    System.out.println("第四步：使用bean");
    //注意：必须手动关闭spring容器，这样spring容器才会销毁bean
    ClassPathXmlApplicationContext classPathXmlApplicationContext = (ClassPathXmlApplicationContext) applicationContext;
    classPathXmlApplicationContext.close();

}
```

![image-20231123220837567](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231123220837567.png)





## 8.2 Bean生命周期之7步

**初始化bean前后**添加代码，可以加入“bean后处理器”

编写一个类实现BeanPostProcessor类，并重写before和after方法

- 实例化Bean（调用无参构造方法）
- Bean属性赋值（调用set方法）
- 执行“Bean后处理器”的before方法
- 初始化Bean（调用Bean的init方法，这个方法需要自己写，自己配）
- 执行“Bean后处理器”的after方法
- 使用Bean
- 销毁Bean（调用Bean的destroy方法，这个方法需要自己写，自己配）

```java
/**
 * 日志Bean后处理器
 */
public class LogBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行Bean后处理器的before方法");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    /*
    方法有两个参数： bean：刚创建的bean对象  beanName：bean的名字
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行Bean后处理器的before方法");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
```

```xml
<!--配置Bean后处理器-->
<!-- 注意：这个Bean后处理器将作用于整个配置文件中的所有bean -->
<bean class="com.wdd.spring6.bean.LogBeanPostProcessor"/>

<!--需要手动指定初始化方法和销毁方法-->
<bean id="user" class="com.wdd.spring6.bean.User" init-method="initBean" destroy-method="destroyBean">
    <property name="name" value="zhangsan"/>
</bean>
```

![image-20231123221919730](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231123221919730.png)





## 8.3 	Bean生命周期之10步

![image-20231123222915599](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231123222915599.png)

**在Bean后处理器before前后，以及使用bean之后（销毁bean之前）**

- 点位1：在“Bean后处理器”的before前

  检查Bean是否实现Aware相关接口，如果实现了接口则调用接口中的方法

  调用这些方法的目的是为了传递一些数据

- 点位2：在“Bean后处理器”的before后

  检查Bean是否实现InitiallizingBean相关接口，如果实现了接口则调用接口中的方法

- 点位3：使用bean之后，或者销毁bean之前

  检查Bean是否实现DisposableBean相关接口，如果实现了接口则调用接口中的方法

添加的三个点位的共同特点：检查bean是否实现某个特定的接口，如果实现了，spring容器会调用这个接口的方法

Aware相关接口包括：BeanNameAware，BeanClassLoaderAware，BeanFactoryAware



```java
public class User implements BeanNameAware,BeanClassLoaderAware,BeanFactoryAware, InitializingBean,DisposableBean {
    private String name;

    public void setName(String name) {
        System.out.println("第二步：给对象属性赋值");
        this.name = name;
    }

    public User() {
        System.out.println("第一步：无参构造方法执行");
    }

    public void initBean(){
        System.out.println("第四步：初始化Bean");
    }

    public void destroyBean(){
        System.out.println("第七步：销毁Bean");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Bean的这个类的加载器是"+classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("生产这个Bean的工厂对象是"+beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("这个bean的名字是"+name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 的 afterPropertiesSet执行");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean 的 destroy执行");
    }
}
```

![image-20231123223917320](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231123223917320.png)





## 8.4 Bean的作用域不同，管理方式不同

spring容器只对singleton的bean进行完整的生命周期管理

如果是prototype作用域的bean，spring容器只负责将bean初始化完毕，等客户端程序一旦获取到该bean之后，spring容器就不再管理该对象的生命周期了

![image-20231123224259487](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231123224259487.png)





## 8.5 自己new的对象如何被spring管理

```java
@Test
public void testRegisterBean(){
    //自己new的对象
    Student student = new Student();
    System.out.println(student);
    //将自己new的对象纳入spring管理
    DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
    factory.registerSingleton("student",student);
    //从spring容器中获取bean
    Student student1 = factory.getBean("student", Student.class);
    System.out.println(student1);
}
```

![image-20231123224737365](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231123224737365.png)





# 9. Bean的循环依赖问题

什么是bean的循环依赖？

A对象中有B属性,B对象中有A属性



## 9.1 singleton下的set注入产生的循环依赖

```java
/**
 * 丈夫类
 */
public class Husband {
    private String name;
    private Wife wife;

    public void setName(String name) {
        this.name = name;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "name='" + name + '\'' +
                ", wife=" + wife.getName() +
                '}';
    }
}
```

```java
/**
 * 妻子类
 */
public class Wife {
    private String name;
    private Husband husband;

    public void setName(String name) {
        this.name = name;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", husband=" + husband.getName() +
                '}';
    }
}
```

```xml
<!-- singleton+setter模式下的循环依赖 没有问题 -->
<!-- singleton 表示在整个spring容器中是单例的，独一无二的对象-->
<!--
    在singleton+setter 模式下，为什么循环依赖不会出现问题？
        在这种模式下，spring对bean的管理，主要清晰的分为两个阶段：
            第一个阶段：在spring容器加载的时候，实例化bean，只要其中任意一个bean实例化之后，马上进行“曝光”【不等属性赋值就曝光】
            第二个阶段：bean曝光之后，再进行属性赋值（调用set方法）
         核心解决方案：实例化对象和对象的属性赋值分为两个阶段完成
-->
<bean id="husbandBean" class="com.wdd.spring6.bean.Husband" scope="singleton">
        <property name="name" value="张三"/>
        <property name="wife" ref="wifeBean"/>
</bean>

<bean id="wifeBean" class="com.wdd.spring6.bean.Wife" scope="singleton">
    <property name="name" value="小花"/>
    <property name="husband" ref="husbandBean"/>
</bean>
```

```java
@Test
public void testCD(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    Husband husband = applicationContext.getBean("husbandBean", Husband.class);
    System.out.println(husband);
    Wife wife = applicationContext.getBean("wifeBean", Wife.class);
    System.out.println(wife);
}
```

![image-20231124211435013](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231124211435013.png)





**注意：只有scope是singleton的情况下，Bean才会采取提前“曝光”的措施



**三级缓存**





## 9.2 prototype下的set注入产生的循环依赖

当两个bean的scope都是prototype的时候，才会出现异常，其中任意一个是singleton，就不会出现异常

```java
<!-- prototype+setter模式下的循环依赖 存在问题，会出现异常 -->
<!-- BeanCurrentlyInCreationException 当前的Bean正在处于创建中异常 -->
<!-- 注意：当两个bean的scope都是prototype的时候，才会出现异常，其中任意一个是singleton，就不会出现异常 -->
<bean id="husbandBean" class="com.wdd.spring6.bean.Husband" scope="prototype">
    <property name="name" value="张三"/>
    <property name="wife" ref="wifeBean"/>
</bean>

<bean id="wifeBean" class="com.wdd.spring6.bean.Wife" scope="prototype">
    <property name="name" value="小花"/>
    <property name="husband" ref="husbandBean"/>
</bean>
```

![image-20231124212812678](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231124212812678.png)





## 9.3 构造注入下的循环依赖

会有异常

```java
/**
 * 丈夫类
 */
public class Husband {
    private String name;
    private Wife wife;

    public Husband(String name, Wife wife) {
        this.name = name;
        this.wife = wife;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "name='" + name + '\'' +
                ", wife=" + wife.getName() +
                '}';
    }
}
```

```java
/**
 * 妻子类
 */
public class Wife {
    private String name;
    private Husband husband;

    public Wife(String name, Husband husband) {
        this.name = name;
        this.husband = husband;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", husband=" + husband.getName() +
                '}';
    }
}
```

```xml
<!-- 构造注入，这种循环依赖有没有问题？ -->
<!-- 注意：基于构造注入的方式下产生的循环依赖也是无法解决的 -->
<bean id="h" class="com.wdd.spring6.bean2.Husband">
    <constructor-arg index="0" value="张三"/>
    <constructor-arg index="1" ref="w"/>
</bean>

<bean id="w" class="com.wdd.spring6.bean2.Wife">
    <constructor-arg index="0" value="小花"/>
    <constructor-arg index="1" ref="h"/>
</bean>
```

```java
@Test
public void testCD2(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
    Husband husband = applicationContext.getBean("h", Husband.class);
    System.out.println(husband);
    Wife wife = applicationContext.getBean("w", Wife.class);
    System.out.println(wife);
}
```

![image-20231124213846580](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231124213846580.png)





## 9.4 spring解决循环依赖的机理（*）

![image-20231124213945726](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20231124213945726.png)



源码：

![image-20231124214657794](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231124214657794.png)

![image-20231124215016754](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231124215016754.png)

![image-20231124215032955](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231124215032955.png)

![image-20231124215100249](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231124215100249.png)

![image-20231124215227037](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231124215227037.png)

![image-20231124215244531](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231124215244531.png)





DefaultSingletonBeanRegistry类中有三个重要的缓存：

private final Map<String, Object> singletonObjects：一级缓存
private final Map<String, ObjectFactory<?>> singletonFactories：二级缓存
private final Map<String, Object> earlySingletonObjects：三级缓存

这三个缓存都是Map集合

Map集合的key存储的都是bean的name（bean id）



一级缓存存储：单例Bean对象。完整的单例Bean对象，也就是说这个缓存中的Bean对象的属性都已经赋值了，是一个完整的Bean对象

二级缓存存储：早期的单例Bean对象。这个缓存中单例Bean对象的属性没有赋值，只是一个早期的实例对象

三级缓存存储：单例工厂对象。存储大量工厂，每一个单例Bean对象都会对应一个单例工厂对象，这个集合中存储的是创建该单例对象时对应的那个单例工厂对象



![image-20231124220126779](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231124220126779.png)

![image-20231124220428426](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231124220428426.png)





# 10. 反射机制

```java
public class SomeService {
    public void doSome(){
        System.out.println("dosome()...");
    }

    public String doSome(String s){
        System.out.println("doSome(String s)...");
        return s;
    }
    public String doSome(String s,int i){
        System.out.println("dosome(String s,int i)...");
        return s+i;
    }
}
```

不使用反射机制，调用方法

```java
public class Test {
    public static void main(String[] args) {
        //不使用反射机制，调用方法
        /**
         * 分析：调用一个方法，有几要素？
         * 1.调用哪个对象
         * 2.调用哪个方法
         * 3.调用方法的时候传什么参数
         * 4.方法执行结束后的返回结果
         */
        SomeService someService = new SomeService();
        someService.doSome();
        String s1 = someService.doSome("张三");
        String s2 = someService.doSome("李四", 250);
    }
}
```

使用反射机制，调用方法

```java
public static void main(String[] args) throws Exception{
    //使用反射机制
    //1.获取类
    Class<?> aClass = Class.forName("com.wdd.reflect.SomeService");
    //获取方法
    Method doSomeMethod = aClass.getDeclaredMethod("doSome", String.class, int.class);
    //调用方法
    //4要素：哪个对象？哪个方法？传什么参数？返回什么值？
    //obj:哪个对象
    //doSomeMethod:哪个方法
    //"李四", 250 :传什么参数
    //reValue:返回什么值
    Object obj = aClass.newInstance();
    Object reValue = doSomeMethod.invoke(obj, "李四", 250);
    System.out.println(reValue);
}
```





## Spring DI核心实现

```java
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

```java
public static void main(String[] args) throws Exception{
    /*
    需求：
    已知：
    1.有一个类，类名：com.wdd.reflect.User
    2.这个类符合javabean规范。属性私有化，对外提供公开的setter和getter
    3.还知道这个类中有一个属性age
    4.属性age的类型时int

    使用反射机制调用相关方法，给User对象的age属性赋值
     */
    String className = "com.wdd.reflect.User";
    String propertyName = "age";

    //通过反射机制调用setAge(int)方法
    //获取类
    Class<?> aClass = Class.forName(className);
    //获取方法名
    String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
    //根据属性名获取属性类型
    Field declaredField = aClass.getDeclaredField(propertyName);
    //获取方法
    Method setMethod = aClass.getDeclaredMethod(setMethodName, declaredField.getType());
    Object obj = aClass.newInstance();
    setMethod.invoke(obj,30);
    System.out.println(obj);
}
```

![image-20231124223738152](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231124223738152.png)





# 11. 手写Spring框架





# 12. Spring IoC注解式开发

## 12.1 回顾注解

![image-20231124224811952](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231124224811952.png)





使用反射机制获取类上的注解

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    String value();
}
```

```java
//@Component(value="userbean")
//如果属性名是value，value可以省略
@Component("userbean")
public class User {
    //编译器报错，只能在类上
//    @Component(value="test")
//    private String name;
}
```

```java
public static void main(String[] args) throws Exception{
    //通过反射机制读取注解
    //获取类
    Class<?> aClass = Class.forName("com.wdd.bean.User");
    //判断类上面有没有这个注解
    if(aClass.isAnnotationPresent(Component.class)){
        //获取类上的注解
        Component annotation = aClass.getAnnotation(Component.class);
        //访问注解属性
        System.out.println(annotation.value());
    }
}
```

![image-20231125200650258](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231125200650258.png)





只知道一个包的名字，扫描这个包下所有的类，当这个类上有@Component注解的时候，实例化该对象，然后放到Map集合中

![image-20231125204220665](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231125204220665.png)

```java
public static void main(String[] args){
    Map<String,Object> beanMap = new HashMap<>();
    //只知道一个包的名字，扫描这个包下所有的类，当这个类上有@Component注解的时候，实例化该对象，然后放到Map集合中
    String packageName = "com.wdd.bean";
    //开始写扫描程序
    //   . 在正则表达式中代表任意字符，这里的 "." 必须是一个普通的字符，不能是正则表达式中的点
    // 使用\.  代表一个普通的.
    String packagePath = packageName.replaceAll("\\.", "/");
    System.out.println(packagePath);
    //com是在类的根路径下的目录
    URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
    String path = url.getPath();    //绝对路径
    System.out.println(path);
    //获取一个绝对路径下的所有文件
    File file = new File(path);
    File[] files = file.listFiles();   //获取所有子文件
    Arrays.stream(files).forEach(f -> {
        try{
            // System.out.println(f.getName());   //文件名
            // System.out.println(f.getName().split("\\.")[0]);    //类名
            String className = packageName + "." + f.getName().split("\\.")[0];
            System.out.println(className);
            //通过反射机制解析注解
            Class<?> aClass = Class.forName(className);
            //判断类上是否有注解
            if(aClass.isAnnotationPresent(Component.class)){
                //获取注解
                Component annotation = aClass.getAnnotation(Component.class);
                String id = annotation.value();
                //有这个注解的都要创建对象
                Object obj = aClass.newInstance();
                beanMap.put(id,obj);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    });
    System.out.println(beanMap);
}
```

![image-20231125204321515](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231125204321515.png)





## 12.2 声明Bean的注解

负责声明Bean的注解，常见包括4个：

- @Component
- @Controller
- @Service
- @Repository

分成四个是增强程序的可读性,下面三个都是Component的别名



## 12.3 Spring 注解的使用

- 第一步：加入aop依赖

![image-20231125205253321](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231125205253321.png)

- 第二步：在配置文件中添加context命名空间

![image-20231125205457292](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231125205457292.png) 

- 第三步：在配置文件中指定扫描的包

![image-20231125205707666](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231125205707666.png)

- 第四步：在Bean类上使用注解

![image-20231125210408611](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231125210408611.png)





## 12.4 解决多个包扫描问题

![image-20231125210947798](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231125210947798.png)

- 方法一：在配置文件中指定多个包，用 "," 隔开

```xml
<context:component-scan base-package="com.wdd.spring6.bean,com.wdd.spring6.dao"/>
```

- 方法二：指定多个包的共同父包

```xml
<context:component-scan base-package="com.wdd.spring6"/>
```





## 12.5 选择性实例化Bean

假设在某个包下有很多Bean，有的Bean上标注Component，有的标注Controller，有的标注Service，有的标注Repository，现在由于某种特殊业务的需要，只允许其中所有的Controller参与Bean的管理，其他的都不实例化，如何解决？

```java
@Component
public class A {
    public A() {
        System.out.println("A的无参构造");
    }
}

@Controller
class B{
    public B() {
        System.out.println("B的无参构造");
    }
}
@Service
class C{
    public C() {
        System.out.println("C的无参构造");
    }
}
@Repository
class D{
    public D() {
        System.out.println("D的无参构造");
    }
}
@Controller
class E{
    public E() {
        System.out.println("E的无参构造");
    }
}
```

```xml
<!--
    方法一：
    use-default-filters="false"
    属性是false，表示com.wdd.spring6.bean2包下所有带有声明Bean的注解全部失效
-->
<context:component-scan base-package="com.wdd.spring6.bean2" use-default-filters="false">
    <!--只有@Repository注解生效-->
    <context:include-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
</context:component-scan>
```

```java
@Test
public void testChoose(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-choose.xml");
}
```

![image-20231126110302501](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126110302501.png)

```xml
<!--
    方法二：
    use-default-filters="true"
    属性是true，表示com.wdd.spring6.bean2包下所有带有声明Bean的注解全部生效
-->
<context:component-scan base-package="com.wdd.spring6.bean2" use-default-filters="true">
    <!--@Repository注解失效-->
    <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
</context:component-scan>
```

![image-20231126110527454](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126110527454.png)





## 12.6 负责注入的注解

给Bean赋值的注解：

- @Value
- @Autowired
- @Qualifier
- @Resource



### 12.6.1 @Value

用来注入简单类型

@Value 可以用在**属性**上，**setter方法**上，**构造方法的形参**上





```java
@Component
public class MyDataSource implements DataSource {
    @Value(value = "com.mysql.cj.jdbc.Driver")
    private String driver;
    @Value("jdbc:mysql://localhost:3306/spring6")
    private String url;
    @Value("root")
    private String username;
    @Value("123456")
    private String password;

    //使用@Value注解，可以用在属性上，并且可以不提供setter方法
    /*
    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     */

    @Override
    public String toString() {
        return "MyDataSource{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
```

```java
@Component
public class Product {
    /*
    @Value("hhh")
    private String name;
    @Value("30")
    private int age;
     */
    private String name;
    private int age;

    /*
    // @Value也可以使用在方法上
    @Value("kkk")
    public void setName(String name) {
        this.name = name;
    }
    @Value("11")
    public void setAge(int age) {
        this.age = age;
    }

     */

    public Product(@Value("lll") String name, @Value("88") int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

![image-20231126112641085](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126112641085.png)

```java
@Test
public void testDIByAnnotation(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-di-annotation.xml");
    MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
    System.out.println(myDataSource);
    Product product = applicationContext.getBean("product", Product.class);
    System.out.println(product);
}
```

![image-20231126112656621](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126112656621.png)





## 12.6.2 @Autowired 和 @Qualifier

@Autowired 可以注入非简单类型

如果单独使用@Autowired注解，默认根据类型装配

![image-20231126163707683](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126163707683.png)

@Autowired可以出现在构造方法，方法，参数，属性，注解上





```java
public interface OrderDao {
    void insert();
}
```

```java
@Repository
public class OrderDaoImplForMysql implements OrderDao {
    @Override
    public void insert() {
        System.out.println("mysql正在保存订单信息，，，");
    }
}
```

```java
@Service
public class OrderService {
    //@Autowired 注解使用时，不需要指定任何属性，直接使用
    //@Autowired的作用：根据类型进行自动装配
//    @Autowired
//    private OrderDao orderDao;

    @Autowired
    @Qualifier("orderDaoImplForOracle")
    private OrderDao orderDao;
    public void generate(){
        orderDao.insert();
    }
}
```

```java
@Repository
public class OrderDaoImplForOracle implements OrderDao {

    @Override
    public void insert() {
        System.out.println("oracle正在保存订单信息，，，");
    }
}
```

![image-20231126165631836](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126165631836.png)

```java
@Test
public void testAutowired(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowired.xml");
    OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
    orderService.generate();
}
```

![image-20231126165643928](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126165643928.png)





如果接口下只有一个实现类，可以根据类型自动装配

![image-20231126165724844](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126165724844.png)

如果接口下有多个实现类，只能根据名字自动装配

![image-20231126165754114](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126165754114.png)

![image-20231126165808467](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126165808467.png)







如果一个类种构造方法只有一个，并且构造方法上的参数和属性能够对应上，@Autowired注解可以省略





### 12.6.3 @Resource注解

@Resource可以完成非简单类型的注入

![image-20231126170424733](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126170424733.png)

![image-20231126170556893](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126170556893.png)

![image-20231126170734744](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126170734744.png)



```java
public interface StudentDao {
    void deleteById();
}
```

```java
@Repository
public class StudentDaoImplForMysql implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("mysql正在删除学生信息。。。");
    }
}
```

```java
@Service
public class StudentService {
    @Resource(name = "studentDaoImplForMysql")
    private StudentDao studentDao;


//    @Resource(name = "studentDaoImplForMysql")
//    public void setStudentDao(StudentDao studentDao) {
//        this.studentDao = studentDao;
//    }

    public void deleteStudent(){
        studentDao.deleteById();
    }
}
```

![image-20231126172018321](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126172018321.png)

```java
@Test
public void testResource(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(" spring-resouce.xml");
    StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
    studentService.deleteStudent();
}
```

![image-20231126172028963](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126172028963.png)





## 12.7 全注解开发

写一个配置类代替配置文件

```java
/**
 * 编写一个类，代替spring框架的配置文件
 */
@Configuration
@ComponentScan({"cn.wdd.dao","cn.wdd.service"})
public class Spring6Config {
}
```

```java
@Test
public void testNoXml(){
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
    StudentService studentService = context.getBean("studentService", StudentService.class);
    studentService.deleteStudent();
}
```

![image-20231126173517476](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126173517476.png)





# 13. JdbcTemplate



# 14. Gof 之代理模式

![image-20231126175341524](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126175341524.png)

![image-20231126175539885](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126175539885.png)





代理模式是GoF23种设计模式之一，属于结构型设计模式

![image-20231126175703956](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231126175703956.png)



代理模式在代码实现上，有两种形式：

- 静态代理
- 动态代理



## 14.1 静态代理

![image-20231127200235460](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231127200235460.png)

代理对象和目标对象的公共接口

```java
/**
 * 订单业务接口
 */
public interface OrderService {     //代理对象和目标对象的公共接口
    /**
     * 生成订单
     */
    void generate();

    /**
     * 修改订单
     */
    void modify();

    /**
     * 查看订单详情
     */
    void detail();
}
```

目标对象

```java
public class OrderServiceImpl implements OrderService{    //目标对象
    @Override
    public void generate() {   //目标方法
        //模拟生成订单的耗时
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已生成");
    }

    @Override
    public void modify() {       //目标方法
        //模拟生成订单的耗时
        try {
            Thread.sleep(456);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已修改");
    }

    @Override
    public void detail() {       //目标方法
        //模拟生成订单的耗时
        try {
            Thread.sleep(111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("请查看订单详情");
    }
}
```

代理对象

```java
public class OrderServiceProxy implements OrderService{    //代理对象
    //将目标对象作为代理对象的一个属性，这种关系是关联关系，比继承关系的耦合度低
    //代理对象中含有目标对象的引用。 关联关系 has a
    //注意：这里要写一个公共接口类型，因为公共接口耦合度低
    private OrderService target;      //这就是目标对象，目标对象一定是实现了OrderService接口的

    //创建代理对象的时候，传一个目标对象给代理对象
    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }

    @Override
    public void generate() {   //代理方法
        //增强
        long begin = System.currentTimeMillis();
        //调用目标对象的目标方法
        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end - begin) + "毫秒");

    }

    @Override
    public void modify() {   //代理方法
        //增强
        long begin = System.currentTimeMillis();
        //调用目标对象的目标方法
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end - begin) + "毫秒");
    }

    @Override
    public void detail() {   //代理方法
        //增强
        long begin = System.currentTimeMillis();
        //调用目标对象的目标方法
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end - begin) + "毫秒");
    }
}
```

```java
public class Test {
    public static void main(String[] args) {
        /*
        OrderService orderService = new OrderServiceImpl();
        orderService.generate();
        orderService.modify();
        orderService.detail();

         */

        //创建目标对象
        OrderService target = new OrderServiceImpl();
        //创建代理对象
        OrderService proxy = new OrderServiceProxy(target);
        //调用代理对象的代理方法
        proxy.generate();
        proxy.modify();
        proxy.detail();
    }
}
```

![image-20231127200400158](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231127200400158.png)



## 14.2 动态代理

在程序运行阶段，在内存中动态生成代理类，被称为动态代理

目的:减少代理类的数量，解决代码复用问题

![image-20231127200624161](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231127200624161.png)



jdk动态代理和CGLIB动态代理区别：

- jdk动态代理：只能代理接口，底层实现接口实现
- CGLIB动态代理：可以代理接口，也可以代理类，底层采用继承方式实现，功能更强大，效率更高，代理的目标类不能被final修饰

### 14.2.1 JDK动态代理

![image-20231127203617386](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231127203617386.png)

```java
/**
 * 订单业务接口
 */
public interface OrderService {     //代理对象和目标对象的公共接口
    /**
     * 生成订单
     */
    void generate();

    /**
     * 修改订单
     */
    void modify();

    /**
     * 查看订单详情
     */
    void detail();

    String getName();
}
```

```java
public class OrderServiceImpl implements OrderService{    //目标对象
    @Override
    public void generate() {   //目标方法
        //模拟生成订单的耗时
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已生成");
    }

    @Override
    public void modify() {       //目标方法
        //模拟生成订单的耗时
        try {
            Thread.sleep(456);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已修改");
    }

    @Override
    public void detail() {       //目标方法
        //模拟生成订单的耗时
        try {
            Thread.sleep(111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("请查看订单详情");
    }

    @Override
    public String getName() {
        System.out.println("getName...");
        return "zhangsan";
    }


}
```

```java
/**
 * 专门负责计时的调用处理器对象
 * 在这个调用处理器中编写计时相关的增强代码
 */
public class TimeerInvocationHandler implements InvocationHandler {
    //目标对象
    private Object target;

    public TimeerInvocationHandler(Object target) {
        this.target = target;
    }

    /*
        invoke方法是JDK负责调用的，所以JDK调用这个方法时会自动传这三个参数
        可以在invoke方法里直接使用
        Object proxy：代理对象的引用，使用较少
        Method method：目标对象的目标方法
        Object[] args：目标方法上的实参

        在invoke方法执行过程中，使用method调用目标对象的目标方法
         */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke()....");
        long begin = System.currentTimeMillis();
        //调用目标对象的目标方法
        //方法四要素：哪个对象？哪个方法？传什么参数？返回什么值？
        Object retValue = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end - begin) + "毫秒");
        //注意：如果代理对象调用代理方法后，需要返回结果，invoke方法必须将目标对象的目标方法执行结果继续返回
        return retValue;
    }
}
```

```java
//客户端程序
public static void main(String[] args) {
    //创建目标对象
    OrderService target = new OrderServiceImpl();
    //创建代理对象
    /*
    1.newProxyInstance :新建代理对象
        通过调用这个方法可以创建代理对象
        本质上，这个newProxyInstance执行，做了两件事：
            第一件事：在内存中动态生成了一个代理类的字节码class
            第二件事：new对象了。通过内存中生成的代理类这个代码，实例化了代理对象
    2.newProxyInstance的三个重要参数
      1）ClassLoader loader
        类加载器
        作用：在内存中生成的字节码也是class文件，要执行也得先加载到内存中。加载类就需要类加载器，所以这里需要指定类加载器
            并且JDK要求，目标类的类加载器必须和代理类的类加载器使用同一个
      2）Class<?>[] interfaces
        代理类要实现的接口
        代理类和目标类要实现同一个接口或同一些接口，
        在内存中生成代理类的时候，代理类需要知道实现哪些接口
      3）InvocationHandler h
        调用处理器，是一个接口
        在调用处理器接口中编写的是增强的代码

        注意：代理对象和目标对象实现的接口一样，所以可以向下转型
     */
    OrderService proxy = (OrderService)Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new TimeerInvocationHandler(target));
    //调用代理对象的代理方法
    proxy.generate();
    String name = proxy.getName();
    System.out.println(name);
}
```





封装

```java
public class ProxyUtil {
    /**
     * 封装一个工具方法，可以通过这个方法获取代理对象
     */
    public static Object newProxyInstance(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new TimeerInvocationHandler(target));
    }
}
```





### 14.2.2 CGLIB动态代理





# 15. 面向切面编程AOP

## 15.1 介绍

**AOP：和业务逻辑没有关系的代码单独提取出来，形成一个独立的组件，然后以横向交叉的方式应用到业务流程中的过程**

![image-20231127211242125](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231127211242125.png)

![image-20231127210929837](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231127210929837.png) 

![image-20231127211536188](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231127211536188.png)





## 15.2 七大术语

- 连接点Joinpoint

  在程序的整个执行流程中，可以织入切面的位置。（连接点描述的是位置）

- 切点Pointcut

  在程序执行流程中，真正织入切面的方法（一个切点对应多个连接点）

  切点本质上就是方法（真正织入切面的那个方法叫做切点）

- 通知Advice（描述的是代码）

  通知又叫增强，具体要织入的代码、

  - 前置通知
  - 后置通知
  - 环绕通知
  - 异常通知
  - 最终通知

![image-20231127212523247](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231127212523247.png)

- 切面Aspect

  切点+通知

- 织入Weaving

  把通知应用到目标对象上的过程

- 代理对象Proxy

  一个目标对象被织入通知后产生的新对象

- 目标对象Target

  被织入通知的对象 

![image-20231127212820975](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231127212820975.png)





## 15.3 切点表达式

切点表达式用来定义通知（Advice）往哪些方法上切入

execution([访问控制权限修饰符] 返回值类型 [全限定类名]方法名(形式参数列表) [异常])

- 返回值类型 
  - 必填
  - “*”表示返回值类型任意
- 全限定类型
  - 可选
  - “..” 代表当前包以及子包下的所有类
  - 省略时表示所有类
- 方法名
  - 必填
  - “*”表示所有方法
  - set* 表示所有set方法
- 形式参数列表
  - 必填
  - ()表示没有参数的方法
  - (..)表示参数类型和个数随意的方法
  - (*)表示只有一个参数的方法
  - (*,String)第一个参数类型随意，第二个参数类型是String
- 异常
  - 可选
  - 省略时表示任意异常类型

![image-20231128210908321](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231128210908321.png)



## 15.4 使用Spring的AOP

Spring对AOP的实现包括三种：

- **Spring框架结合AspectJ框架实现的AOP，基于注解方式**（常用）
- **Spring框架结合AspectJ框架实现的AOP，基于XML方式**
- Spring框架自己实现的AOP，基于XML配置方式（使用较少）



### 15.4.1 步骤

引入依赖

![image-20231128212124283](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231128212124283.png)



配置文件

![image-20231128212149858](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231128212149858.png)





目标对象

```java
@Service
public class UserService {  //目标类
    public void login(){   //目标方法
        System.out.println("系统正在进行身份认证...");
    }
}
```

切面

```java
@Component
@Aspect   //切面类需要使用@Aspect注解进行标注
public class LogAspect {   //切面 = 通知+切点
    //通知就是增强，就是具体要编写的代码
    //这里通知Advice以方法的形式出现，因为方法中可以写代码
    //@Before(切点表达式)注解标注的方法就是前置通知
    @Before("execution(* com.wdd.spring6.service.UserService.*(..))")
    public  void 增强(){
        System.out.println("我是一个通知，我是一段增强代码...");
    }
}
```

```xml
<!--组件扫描-->
<context:component-scan base-package="com.wdd.spring6.service"/>
<!--开启aspectj的自动代理-->
<!--spring容器在扫描类的时候，查看该类上是否有@Aspect 注解，如果有，则给这个类生成代理对象-->
<!--proxy-target-class"true"   表示强制使用CGLIB动态代理
proxy-target-class"false"     默认，表示接口使用JDK动态代理，反正使用CGLIB
-->
<aop:aspectj-autoproxy proxy-target-class="true"/>
```

```java
@Test
public void testBefore(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    UserService userService = applicationContext.getBean("userService", UserService.class);
    userService.login();
}
```

![image-20231128213924248](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231128213924248.png)





```java
@Service
public class OrderService {  //目标方法
    public void generate(){   //目标方法
        System.out.println("生成订单...");
    }
}
```

![image-20231128214542569](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231128214542569.png)



### 15.4.2 通知类型

- 前置通知：@Before 目标方法执行之前通知
- 后置通知：@AfterReturning 目标方法执行之后通知
- 环绕通知：@Around 目标方法执行之前和之后通知
- 异常通知：@AfterThrowing 发生异常之后执行的通知
- 最终通知：@After 放在finally语句块中的通知





```java
@Component
@Aspect   //切面类需要使用@Aspect注解进行标注
public class LogAspect {   //切面 = 通知+切点
    //通知就是增强，就是具体要编写的代码
    //这里通知Advice以方法的形式出现，因为方法中可以写代码
    //前置通知
    //@Before(切点表达式)注解标注的方法就是前置通知
    @Before("execution(* com.wdd.spring6.service..*(..))")
    public  void beforeAdvice(){
        System.out.println("前置通知");
    }

    //后置通知
    @AfterReturning("execution(* com.wdd.spring6.service..*(..))")
    public void afterReturningAdvice(){
        System.out.println("后置通知");
    }
    //环绕通知 ：在前置通知之前，在后置通知之后
    @Around("execution(* com.wdd.spring6.service..*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前环绕");
        //执行目标
        joinPoint.proceed();   //执行目标
        System.out.println("后环绕");
    }
    //异常通知
    @AfterThrowing ("execution(* com.wdd.spring6.service..*(..))")
    public void afterThrowingAdvice(){
        System.out.println("异常通知");
    }
    //最终通知
    @After("execution(* com.wdd.spring6.service..*(..))")
    public void afterAdvice(){
        System.out.println("最终通知");
    }
}
```

![image-20231128215848068](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231128215848068.png)

![](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231128215929448.png)





### 15.4.3 切面的先后顺序

![](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231128220730182.png)

![image-20231128220757931](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231128220757931.png)

![image-20231128220740137](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231128220740137.png)





### 15.4.4 通用切点

![image-20231128221140332](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231128221140332.png)

![image-20231128221156371](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231128221156371.png)





### 15.4.5 连接点

![image-20231128222042568](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231128222042568.png)

joinPoint，在spring容器调用这个方法的时候自动传过来

```java
Signature signature = joinPoint.getSignature();    //获取目标方法的签名
```

![image-20231128221729486](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231128221729486.png)

通过方法的签名可以获取到一个方法的具体信息

![image-20231128222101756](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231128222101756.png)





## 15.5 全注解开发

```java 
@Configuration   //代替spring.xml文件
@ComponentScan({"com.wdd.spring6.service"})    //组件扫描
@EnableAspectJAutoProxy(proxyTargetClass = true)    //开启aspectj的自动代理
public class Spring6Config {
}
```



 

```java
@Test
public void testNoXml(){
    ApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
    OrderService orderService = context.getBean("orderService", OrderService.class);
    orderService.generate();
}
```





## 15.6 基于XML配置方式的AOP（了解）

```java
public class UserService {   //目标对象
    public void logout(){  //目标方法
        System.out.println("系统正在退出...");
    }
}
```

```java
public class TimerAspect {
    //通知
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        //前环绕
        long begin = System.currentTimeMillis();
        //目标
        joinPoint.proceed();
        //后环绕
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end-begin)+"毫秒");
    }
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                            http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
                            http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd">

    <!--纳入spring ioc-->
    <bean id="userService" class="com.wdd.spring6.service.UserService"/>
    <bean id="timerAspect" class="com.wdd.spring6.service.TimerAspect"/>

    <!--aop配置-->
    <aop:config>
        <!--切点表达式-->
        <aop:pointcut id="mypointcut" expression="execution(* com.wdd.spring6.service..*(..))"/>
        <!--切面：通知+切点-->
        <aop:aspect ref="timerAspect">
            <aop:around method="aroundAdvice" pointcut-ref="mypointcut"/>
        </aop:aspect>
    </aop:config>

</beans>
```

```java
@Test
public void testXML(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    UserService userService = applicationContext.getBean("userService", UserService.class);
    userService.logout();
}
```

![image-20231128223941635](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231128223941635.png)







## 15.7 实际案例

### 15.7.1 事务处理

```java
@Service
public class AccountService {   //目标对象
    //转账业务方法
    public void transfer(){    //目标方法
        System.out.println("银行账户正在完成转账操作。。。");
    }

    //取款业务方法
    public void withdraw(){    //目标方法
        System.out.println("正在取款，请稍后。。。");
    }
}
```

```java
@Service
public class OrderService {   //目标对象
    //生成订单的业务方法
    public void generate(){    //目标方法
        System.out.println("正在生成订单。。。");
    }
    //取消订单业务方法
    public void cancel(){    //目标方法
        System.out.println("订单已取消。。。");
    }
}
```

```java
@Component
@Aspect
public class TransactionAspect {
    //编程式事务解决方案
    @Around("execution(* com.wdd.spring6.service..*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint){
        try {
            //前环绕
            System.out.println("开启事务");
            joinPoint.proceed();   //执行目标
            //后环绕
            System.out.println("提交事务");
        } catch (Throwable e) {
            System.out.println("回滚事务");
            e.printStackTrace();
        }
    }
}
```

![image-20231129201650914](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231129201650914.png)

```java
@Test
public void testTransaction(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
    OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
    accountService.transfer();
    accountService.withdraw();
    orderService.generate();
    orderService.cancel();
}
```

![image-20231129201702327](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231129201702327.png)







### 15.7.2 安全日志

```java
@Service
public class UserService {
    public void saveUser(){
        System.out.println("新增用户信息");
    }
    public void deleteUser(){
        System.out.println("删除用户信息");
    }
    public void modifyUser(){
        System.out.println("修改用户信息");
    }
    public void getUser(){
        System.out.println("获取用户信息");
    }
}
```

```java
@Service
public class VipService {
    public void saveVip(){
        System.out.println("新增Vip信息");
    }
    public void deleteVip(){
        System.out.println("删除Vip信息");
    }
    public void modifyVip(){
        System.out.println("修改Vip信息");
    }
    public void getVip(){
        System.out.println("获取Vip信息");
    }
}
```

```java
@Component
@Aspect
public class SecurityLogAspect {

    @Pointcut("execution(* com.wdd.spring6.biz..save*(..))")
    public void savePointcut(){

    }

    @Pointcut("execution(* com.wdd.spring6.biz..delete*(..))")
    public void deletePointcut(){

    }

    @Pointcut("execution(* com.wdd.spring6.biz..modify*(..))")
    public void modifyPointcut(){

    }

    @Before("savePointcut() || deletePointcut() || modifyPointcut()")
    public void beforeAdvice(JoinPoint joinPoint){
        //系统时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(new Date());
        //输出日志信息
        System.out.println(nowTime + "张三:" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }
}
```

![image-20231129202833229](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231129202833229.png)

```java
@Test
public void testSecurityLog(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    UserService userService = applicationContext.getBean("userService", UserService.class);
    VipService vipService = applicationContext.getBean("vipService", VipService.class);
    userService.saveUser();
    userService.deleteUser();
    userService.modifyUser();
    userService.getUser();
    vipService.saveVip();
    vipService.deleteVip();
    vipService.modifyVip();
    vipService.getVip();
}
```

![image-20231129202845597](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231129202845597.png)







# 16. Spring对事务的支持

## 16.1 介绍

事务的四个处理过程

- 开启事务
- 执行核心业务代码
- 提交事务（执行核心业务过程中没有出现异常）
- 回滚事务（执行核心业务过程中出现异常）



事务四特性

- 原子性
- 隔离性
- 一致性
- 持久性



![image-20231129203504575](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231129203504575.png)



## 16.2 准备

- 引入依赖

```xml
<dependencies>
    <!-- spring context-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>6.1.0-M2</version>
    </dependency>

    <!--spring jdbc-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>6.1.0-M2</version>
    </dependency>

    <!--mysql驱动-->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.2.0</version>
    </dependency>
    <!--德鲁伊连接池-->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>1.2.13</version>
    </dependency>

    <!--@Resource注解-->
    <dependency>
        <groupId>jakarta.annotation</groupId>
        <artifactId>jakarta.annotation-api</artifactId>
        <version>2.1.1</version>
    </dependency>
    <!--spring aspects-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-aspects</artifactId>
        <version>6.1.0-M2</version>
    </dependency>
    <!--junit-->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```



- 创建数据库表

![image-20231129205011454](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231129205011454.png)

![image-20231129205023458](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231129205023458.png)



- 包结构

![image-20231129205051520](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231129205051520.png)



- POJO类

```java
/**
 * 银行账户
 */
public class Account {
    private String actno;
    private double balance;

    public Account() {
    }

    public Account(String actno, double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "actno='" + actno + '\'' +
                ", balance=" + balance +
                '}';
    }
}
```



- dao

```java
/**
 * 专门负责账户信息的CRUD操作
 * DAO中只执行SQL语句，没有业务逻辑
 *
 */
public interface AccountDao {
    /**
     * 根据账号查询账户信息
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 更新账户信息
     * @param act
     * @return
     */
    int update(Account act);
}
```



- daoimpl

```java
@Repository("accountDao")
public class AccountDaoImpl  implements AccountDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account selectByActno(String actno) {
        String sql = "select actno,balance from t_act where actno=?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), actno);
        return account;
    }

    @Override
    public int update(Account act) {
        String sql = "update t_act set balance = ? where act = ?";
        int count = jdbcTemplate.update(sql, act.getBalance(), act.getActno());
        return count;
    }
}
```

- service

```java
/**
 * 业务接口
 * 事务就是在这个接口下控制的
 */
public interface AccountService {
    /**
     * 转账业务方法
     * @param fromActno  从这个账户转出
     * @param toActno   转入这个账户
     * @param money    转账金额
     */
    void transfer(String fromActno,String toActno,double money);
}
```

- serviceimpl

```java
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    //控制事务，因为在这个方法里要完成所有的转账业务
    @Override
    public void transfer(String fromActno, String toActno, double money) {
        //查询转出账户的余额是否充足
        Account fromAct = accountDao.selectByActno(fromActno);
        if(fromAct.getBalance() < money){
            throw new RuntimeException("余额不足");
        }
        //余额充足
        Account toAct = accountDao.selectByActno(toActno);
        //将内存中两个对象的余额先修改
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        //数据库更新
        int count = accountDao.update(fromAct);
        count += accountDao.update(toAct);
        if(count != 2){
            throw new RuntimeException("转账失败，联系银行！");
        }

    }
}
```

- 配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                            http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
    <context:component-scan base-package="com.wdd.bank"/>

    <!--配置数据源-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/springdb"/>
        <property name="username" value="root"/>
        <property name="password" value="123456"/>
    </bean>

    <!--配置JdbcTemplate-->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"/>
    </bean>

</beans>
```

```java
@Test
public void testSpringTx(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    AccountService accountService = applicationContext.getBean("accountService", AccountService.class);

    try{
        accountService.transfer("act-001","act-002",10000);
    }catch (Exception e){
        e.printStackTrace();
    }
}
```

![image-20231129212741120](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231129212741120.png)



- 模拟异常

![image-20231129212917566](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231129212917566.png)

![image-20231129212947261](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231129212947261.png)

act-001少了10000，但act-002没有多10000





## 16.3 Spring实现事务的两种方式

- 编程式事务

  通过编写代码实现事务管理

- 声明式事务

  - 基于注解
  - 基于XML



spring事务管理API

![image-20231129215424578](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231129215424578.png)



### 16.3.1 声明事务之注解实现方式

配置文件中添加

```xml
<!--配置事务管理器-->
<bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
</bean>

<!--开启事务注解驱动器,告诉spring框架，采用注解方式控制事务-->
<tx:annotation-driven transaction-manager="txManager"/>
```

命名空间

![image-20231129220001794](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231129220001794.png)



### 16.3.2 @Transactional属性

### 事务的传播行为propagation

![image-20231129220635613](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231129220635613.png)

![image-20231129220716884](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231129220716884.png)

![image-20231129220937412](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231129220937412.png)





![image-20231130204843480](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231130204843480.png)

AccountServiceImpl实现类实现save，在save中调用AccountServiceImpl2的save

![image-20231130204957889](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231130204957889.png)

添加AccountServiceImpl2实现类

![image-20231130205013260](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231130205013260.png)

```java
@Test
public void testPropagation(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
    Account account = new Account("act-003",1000.0);
    accountService.save(account);
}
```

![image-20231130205112315](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231130205112315.png)

![image-20231130205138615](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231130205138615.png)



两个实现类都是REQUIRED，AccountServiceImpl2模拟异常后捕不捕捉都会回滚，都不生成账户信息

![image-20231130210231392](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231130210231392.png)

AccountServiceImpl是REQUIRED，AccountServiceImpl2是REQUIRES_NEW，如果AccountServiceImpl中捕捉异常，则只有AccountServiceImpl2的事务会回滚，act-003生成，act-004不生成；如果AccountServiceImpl不捕捉异常，都会回滚

![image-20231130205950301](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231130205950301.png)





### 事务的隔离级别isolation

![image-20231130210409638](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231130210409638.png)

![image-20231130210900531](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231130210900531.png)

mysql默认：REPEATABLE_READ

oracl默认：READ_COMMITTED



只要是事务并发，一定会出现幻读

脏读：读到缓存的数据





测试读未提交

```java
@Service("i1")
public class IsolationService1 {

    @Resource(name = "accountDao")
    AccountDao accountDao;

    //负责查询
    //当前事务可以读取到别的事务没有提交的数据
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void getByActno(String actno){
        Account account = accountDao.selectByActno(actno);
        System.out.println("查询到的账户信息:"+account);
    }
}
```

```java
@Service("i2")
public class IsolationService2 {

    @Resource(name = "accountDao")
    AccountDao accountDao;

    //负责插入
    @Transactional
    public void save(Account act){
        accountDao.insert(act);
        //睡眠一会 20s后才提交事务
        try {
            Thread.sleep(1000*20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

```java
@Test
public void testIsolation1(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    IsolationService1 i1 = applicationContext.getBean("i1", IsolationService1.class);
    i1.getByActno("act-004");
}

@Test
public void testIsolation2(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    IsolationService2 i2 = applicationContext.getBean("i2", IsolationService2.class);
    Account account = new Account("act-004",1000.0);
    i2.save(account);
}
```

先执行testIsolation2，然后立刻执行testIsolation1，testIsolation1会查到数据![image-20231130213532556](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231130213532556.png)

，但是执行前20s数据库里还没有这条信息







### 事务超时timeout

![image-20231130213622669](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231130213622669.png)

![image-20231130213946159](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231130213946159.png)

注意：所有DML语句指最后一条DML执行完的时间





### 只读事务readOnly

![image-20231130214330779](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231130214330779.png)





### 设置哪些异常回滚事务



![image-20231130214451981](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231130214451981.png)

### 设置哪些异常不回滚事务

![image-20231130214457555](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231130214457555.png)





## 16.4 事务的全注解式开发

```java
@Configuration    //代替spring.xml配置文件
@ComponentScan("com.wdd.bank")   //组件扫描
@EnableTransactionManagement   //开启事务注解
public class Spring6Config {
    //Spring框架看到@Bean注解，会调用这个被标注的方法，这个方法的返回值是一个java对象，这个java对象会自动纳入IoC容器
    //返回的对象就是spring容器中的bean
    //并且bean的名字是”dataSource“
    @Bean(name = "dataSource")
    public DruidDataSource getDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/springdb");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
        return druidDataSource;
    }
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){   //spring在调用这个方法时，会自动传递一个DataSource对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
    @Bean(name = "txManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager tx = new DataSourceTransactionManager();
        tx.setDataSource(dataSource);
        return tx;
    }
}
```

```java
@Test
public void testNoXml(){
    ApplicationContext applicationContext= new AnnotationConfigApplicationContext(Spring6Config.class);
    AccountService accountService = applicationContext.getBean("accountService", AccountService.class);

    try{
        accountService.transfer("act-001","act-002",10000);
    }catch (Exception e){
        e.printStackTrace();
    }
}
```





### 16.5  声明事务之XML实现方式

配置步骤：

- 配置事务管理器
- 配置通知
- 配置切面

![image-20231202140228317](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231202140228317.png)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                            http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
                            http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd
                             http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd">
    <context:component-scan base-package="com.wdd.bank"/>

    <!--配置数据源-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/springdb"/>
        <property name="username" value="root"/>
        <property name="password" value="123456"/>
    </bean>

    <!--配置JdbcTemplate-->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!--配置事务管理器-->
    <bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!--配置通知，具体的增强代码-->
    <!--在通知中关联事务管理器-->
    <tx:advice id="txAdvice" transaction-manager="txManager">
        <!--配置通知的相关属性-->
        <tx:attributes>
            <!--之前所有的事务属性都可以在以下标签中配置-->
            <tx:method name="transfer" propagation="REQUIRED" rollback-for="java.lang.Throwable"/>
            <tx:method name="save*" propagation="REQUIRED" rollback-for="java.lang.Throwable"/>
            <tx:method name="delete*" propagation="REQUIRED" rollback-for="java.lang.Throwable"/>
            <tx:method name="update*" propagation="REQUIRED" rollback-for="java.lang.Throwable"/>
        </tx:attributes>
    </tx:advice>

    <!--配置切面-->
    <aop:config>
        <!--切点-->
        <aop:pointcut id="txPointcut" expression="execution(* com.wdd.bank.service..*(..))"/>
        <!--切面=通知+切点-->
        <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointcut"/>
    </aop:config>


</beans>
```

```java
@Test
public void testNoAnnotation(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
    try{
        accountService.transfer("act-001","act-002",10000);
        System.out.println("转账成功");
    }catch (Exception e){
        e.printStackTrace();
    }

}
```





# 17. Spring6整合Junit5

```xml
<!--spring对junit支持的依赖-->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>6.1.0-M2</version>
</dependency>
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                            http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
    <context:component-scan base-package="com.wdd.spring6.bean"/>
</beans>
```

```java
@Component
public class User {
    @Value("张三")
    private String name;
```



## 17.1 spring对Junit4支持

```xml
<!--junit4-->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
```

![image-20231202151913813](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231202151913813.png)



## 17.2 spring对Junit5支持

```xml
<!--junit5-->
<dependency>
    <groupId>org.junit-jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.0</version>
    <scope>test</scope>
</dependency>
```

![image-20231202152519471](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231202152519471.png)





# 18.Spring6集成Mybatis3.5

## 18.1 实现步骤

1.准备数据库

2.引入依赖

- spring-context
- spring-jdbc
- mysql驱动
- mybatis
- mybatis-spring  mybatis提供的与spring集成的依赖
- 德鲁伊连接池
- junit

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>6.1.0-M2</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>6.1.0-M2</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.30</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.14</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>2.0.7</version>
    </dependency>
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>1.2.13</version>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

3.基于三层架构实现，准备好包

- com.wdd.bank.mapper
- com.wdd.bank.service
- com.wdd.bank.service.impl
- com.wdd.bank.pojo

![image-20231202171118607](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231202171118607.png)

4.编写pojo Account

```java
public class Account {
    private String actno;
    private Double balance;
```

5.编写mapper接口  AccountMapper

```java
public interface AccountMapper {   //该接口的实现类不需要写，是mybatis通过动态代理机制生成的实现类

    /**
     * 新增账户
     * @param account
     * @return
     */
    int insert(Account account);

    /**
     * 根据账号删除账户
     * @param actno
     * @return
     */
    int deleteByActno(String actno);

    /**
     * 修改账户
     * @param account
     * @return
     */
    int update(Account account);

    /**
     * 根据账号查询账户
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 查询所有账户
     * @return
     */
    List<Account> selectAll();
}
```

6.编写Mapper配置文件

```xml
<insert id="insert">
    insert into t_act values(#{actno},#{balance})
</insert>

<delete id="deleteByActno">
    delete from t_act where actno =#{actno}
</delete>

<update id="update">
    update t_act set balance = #{balance}  where actno =#{actno}
</update>

<select id="selectByActno" resultType="com.wdd.bank.pojo.Account">
    select * from t_act where actno =#{actno}
</select>

<select id="selectAll" resultType="Account">
    select * from t_act
</select>
```

7.编写service接口和service实现类

```java
public interface AccountService {
    /**
     * 开户
     * @param act
     * @return
     */
    int save(Account act);

    /**
     * 销户
     * @param actno
     * @return
     */
    int deleteByActno(String actno);

    /**
     * 修改账户
     * @param account
     * @return
     */
    int modify(Account account);

    /**
     * 查询账户
     * @param actno
     * @return
     */
    Account getByActno(String actno);

    /**
     * 查询所有账户
     * @return
     */
    List<Account> getAll();

    /**
     * 转账
     * @param fromActno
     * @param toActno
     * @param money
     */
    void transfer(String fromActno,String toActno,double money);
}
```

```java
@Transactional
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    @Override
    public int save(Account act) {
        return accountMapper.insert(act);
    }

    @Override
    public int deleteByActno(String actno) {
       return accountMapper.deleteByActno(actno);
    }

    @Override
    public int modify(Account account) {
        return accountMapper.update(account);
    }

    @Override
    public Account getByActno(String actno) {
        return accountMapper.selectByActno(actno);
    }

    @Override
    public List<Account> getAll() {
        return accountMapper.selectAll();
    }

    @Override
    public void transfer(String fromActno, String toActno, double money) {
        Account fromAct = accountMapper.selectByActno(fromActno);
        if(fromAct.getBalance() < money){
            throw new RuntimeException("余额不足");
        }
        Account toAct = accountMapper.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        int count = accountMapper.update(fromAct);
        count += accountMapper.update(toAct);
        if(count != 2){
            throw new RuntimeException("转账失败");
        }
    }
}
```

8.编写jdbc.properties配置文件   ： 数据库连接池相关信息

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/springdb
jdbc.username=root
jdbc.password=123456
```

9.编写mybatis-config.xml

​	该文件可以没有，大部分配置可以转移到spring配置文件中

​	若遇到mybatis相关的系统级配置，需要这个文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    
    <settings>
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    </settings>
</configuration>
```

10.编写spring.xml

- 组件扫描
- 引入外部的属性文件
- 数据源
- SqlSessionFactoryBean配置
  - 注入mybatis核心配置文件路径
  - 指定别名包
  - 注入数据源
- Mapper扫描配置器
  - 指定扫描的包
- 事务管理器DataSourceTransactionManager
  - 注入数据源
- 启用事务注解
  - 注入事务管理器



```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd">

    <!--组件扫描-->
    <context:component-scan base-package="com.wdd.bank"/>
    <!--引入外部属性配置文件-->
    <context:property-placeholder location="jdbc.properties"/>
    <!--数据源-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}"/>
        <property name="url" value="${jdbc.url}"/>
            <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>
    <!--配置SqlSessionFactoryBean-->
    <bean class="org.mybatis.spring.SqlSessionFactoryBean">
        <!--注入数据源-->
        <property name="dataSource" ref="dataSource"/>
        <!--指定mybatis核心配置文件-->
        <property name="configLocation" value="mybatis-config.xml"/>
        <!--指定别名的包-->
        <property name="typeAliasesPackage" value="com.wdd.bank.pojo"/>
    </bean>

    <!--Mapper扫描配置器，主要扫描Mapper接口，生成代理类-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.wdd.bank.mapper"/>
    </bean>
    <!--事务管理器-->
    <bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>
    <!--启用事务注解-->
    <tx:annotation-driven transaction-manager="txManager"/>

</beans>
```

11.编写测试程序

```java
@Test
public void testSM(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
    try{
        accountService.transfer("act-001","act-002",10000);
        System.out.println("转账成功");
    }catch (Exception e){
        e.printStackTrace();
    }
}
```





## 18.2 在spring主配置文件中引入子配置文件

![image-20231202214804526](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231202214804526.png)

![image-20231202214727199](E:\SSM_Study\code\spring\spring6\spring6.assets\image-20231202214727199.png)







# 19.Spring八大设计模式


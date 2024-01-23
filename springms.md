1.什么是Spring

Spring是一个轻量级的IoC和AOP容器框架。是为Java应用程序提供基础性服务的一套框架，目的是用于简化企业应用程序的开发，它使得开发者只需要关心业务需求

2.spring的优点

- 轻量级，非入侵式的 ， 核心容器只包含少量的类和接口
- 依赖注入（DI）， Spring 框架通过依赖注入（DI）来管理组件之间的关系，降低组件的耦合度
- 面向切面编程（AOP），可以将横切关注点（比如安全、日志、事务等）与业务逻辑代码分离  （把应用业务逻辑和系统服务分开）
- 集成 ，Spring 框架提供了对其他（主流）框架的集成支持，比如与 Hibernate、MyBatis、Struts 等框架的集成
- 容器 ， Spring 框架提供了一个容器，用于管理应用程序的对象和依赖关系，并提供了一些可重用的核心组件，
  如 BeanFactory、ApplicationContext 等，这些对象可以是 Spring Bean、JDBC 连接、JMS 连接、Servlet 等
- 事务管理 ， Spring 框架提供了声明式事务管理的支持，使得开发者可以很容易地进行事务管理

3.控制反转（IoC）

是一种编程思想，一种新型的设计模式

反转两件事：

- 不在程序中采用硬编码的方式new对象，交给第三方容器负责
- 不在程序中采用硬编码的方式维护对象的关系

Spring框架实现了控制反转的思想（Spring是一个实现了IoC的容器）

- Spring可以new对象
- Spring可以维护对象之间的关系

控制反转解决了什么问题？ 符合OCP,DIP原则

spring的IoC指：将对象的控制权交给spring框架，由spring框架负责控制对象的生命周期和对象之间的依赖关系

IoC的实现原理：工厂模式 + 反射机制



4.Spring中IOC容器有哪些实现？

- BeanFactory：spring框架最基本的IOC容器，提供最基本的IOC功能，可延迟加载bean
- ApplicationContext：BeanFactory的扩展



4.控制反转的实现方式：依赖注入（DI）

依赖注入常见的两种方式：

- set注入（执行set方法给属性赋值）
- 构造方法注入（执行构造方法给属性赋值）



5.依赖注入（DI）

是控制反转的一种实现方式，通过将对象的依赖关系注⼊到对象中，实现对象之间的松耦合和可测试性。

spring中的DI：可以使用构造函数注入、set注入、接口注入实现，通过配置文件或者注解说明bean之间的依赖关系，IoC容器负责动态将依赖对象注入到指定地方，实现对象之间的解耦和组装



6.spring中的bean

​	bean是由spring容器管理的对象

5.spring通过依赖注入的方式完成bean管理

bean管理：bean对象的创建，bean对象中属性的赋值（bean对象之间关系的维护）

依赖注入：

- 依赖：对象和对象之间的关联关系
- 注入：一种数据传递行为，通过注入的行为让对象和对象产生关系

依赖注入常见的两种实现方式：

- set注入
- 构造注入



5.Spring八大模块

- Spring Core：核心类库，所有功能都依赖于该类库，提供IOC和DI服务
- Spring Context：提供框架式的Bean访问方式，以及企业级功能
- Spring AOP：AOP服务
- Spring Web：支持继承常见的Web框架
- Spring MVC：提供一套MVC框架
- Spring Dao：对JDBC的抽象封装，简化了数据访问异常的处理，并能统一管理JDBC事务
- Spring ORM：对现有的ORM框架的支持
- Spring Webflux：提供响应式web框架



6.Spring特点

- 轻量，非侵入式的（Spring应用中的对象不依赖于Spring的特定类）

- 控制反转

- 面向切面

- 容器

  Spring可以帮我们创建对象，每一个被Spring管理的对象在Spring中叫bean。Spring管理对象

  Spring包含并管理应用对象的配置和生命周期，在这个意义上它是一个容器

- 框架



7.Spring怎么实例化对象

默认通过反射机制，调用类的无参构造方法实例化对象

原理：

```java
Class clazz = Class.forName("com.wdd.spring6.bean.User");
clazz.newInstnce();
```

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
    Object userBean = applicationContext.getBean("userBean",User.class);
    System.out.println(userBean);
}
```



9.set 注入：要有set方法

10.外部bean和内部bean

- 外部bean：

```xml
<!-- 声明/定义Bean -->
<bean id="orderDaoBean" class="com.wdd.spring6.dao.OrderDao"/>

<bean id="orderServiceBean" class="com.wdd.spring6.service.OrderService">
    <!-- 使用ref属性来引入，这就是注入外部Bean -->
    <property name="orderDao" ref="orderDaoBean"/>
</bean>
```

- 内部bean：

```xml
<bean id="orderServiceBean2" class="com.wdd.spring6.service.OrderService">
   <property name="orderDao">
       <!-- 在property标签中使用嵌套的bean标签，这就是内部bean -->
       <bean class="com.wdd.spring6.dao.OrderDao"></bean>
   </property>
</bean>
```



11.bean的作用域

- singleton：默认作用域，单例bean，每个容器中只有一个bean的实例。在spring上下文初始化的时候实例化，每次调用getBean方法的时候，都返回的是单例对象

- prototype：spring上下文初始化的时候不会初始化这些prototype的bean，每一次调用getBean方法的时候，实例化该bean对象（都是新的）

- request：一次request请求创建一个实例Bean，在请求完成以后，bean会失效并被垃圾回收器回收。仅限WEB应用中使用

- session：一次session会话创建一个实例Bean。仅限WEB应用中使用

- global-session：全局作用域，所有会话共享一个实例。如果想要声明让所有会话共享的存储变量的话，那么这全局变量需要存储在global-session中。portlet应用专用。每个全局HTTP会话都会创建一个新的实例bean
- application：一个应用对应一个Bean。仅限WEB应用中使用
- websocket：一个websocket生命周期对应一个Bean。仅限WEB应用中使用



12.简单工厂

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

13.工厂方法模式

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



15.bean的实例化方式

- 构造方法实例化
- 简单工厂实例化
- 工厂方法模式 factory-bean实例化
- FactoryBean接口实例化



16.BeanFacory和FactoryBean的区别

- BeanFactory：SpringIoC容器的顶级对象，是Bean工厂，负责创建Bean对象，BeanFactory是工厂
- FactoryBean：是一个Bean，能够辅助Spring实例化其他Bean对象的一个Bean

Spring中，Bean分为两类：

- 普通Bean
- 工厂Bean



17.bean的生命周期

1）实例化bean

2）bean属性赋值

3）检查bean是否实现了Aware接口，如果实现则调用相关方法

​	  Aware相关接口包括：BeanNameAware，BeanClassLoaderAware，BeanFactoryAware

4）bean后处理器before执行

5）检查bean是否实现了InitializingBean接口，如果实现则调用相关方法

6）初始化bean

7）bean后处理器after执行

8）使用bean

9）检查bean是否实现了DisposableBean接口，如果实现则调用相关方法

10）销毁bean

Bean的作用域不同，管理方式不同：

spring容器只对singleton的bean进行完整的生命周期管理

如果是prototype作用域的bean，spring容器只负责将bean初始化完毕，等客户端程序一旦获取到该bean之后，spring容器就不再管理该对象的生命周期了



18.自己new的对象如何被spring管理

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



19.Bean的循环依赖问题

什么是bean的循环依赖？

A对象中有B属性,B对象中有A属性



singleton+setter模式下的循环依赖 没有问题 ，为什么？

 在这种模式下，spring对bean的管理，主要清晰的分为两个阶段：
            第一个阶段：在spring容器加载的时候，实例化bean，只要其中任意一个bean实例化之后，马上进行“曝光”【不等属性赋值就曝光】
            第二个阶段：bean曝光之后，再进行属性赋值（调用set方法）
         核心解决方案：实例化对象和对象的属性赋值分为两个阶段完成

**注意**：只有scope是singleton的情况下，Bean才会采取提前“曝光”的措施



当两个bean的scope都是prototype的时候，才会出现异常（每一次getBean()时，都会产生一个新的Bean，如此反复下去就会有无穷无尽的Bean产生了，最终就会导致OOM问题的出现。）。其中任意一个是singleton，就不会出现异常

注意：基于构造注入的方式下产生的循环依赖也是无法解决的（new对象的时候堵住）



20.spring解决循环依赖的机理

实例化bean和给bean赋值分开完成

实例化bean的时候，调用无参构造方法完成，不等属性赋值，提前将bean对象**曝光**给外界

给bean属性赋值的时候，调用setter方法完成



一级缓存存储：单例Bean对象。完整的单例Bean对象，也就是说这个缓存中的Bean对象的属性都已经赋值了，是一个完整的Bean对象

二级缓存存储：早期的单例Bean对象。这个缓存中单例Bean对象的属性没有赋值，只是一个早期的实例对象

三级缓存存储：单例工厂对象。存储大量工厂，每一个单例Bean对象都会对应一个单例工厂对象，这个集合中存储的是创建该单例对象时对应的那个单例工厂对象



21.声明bean的注解

- @Component
- @Controller
- @Service
- @Repository



22.给bean赋值的注解

- @Value  :  注入简单类型 ，可以用在 属性、setter方法、构造方法的形参上
- @Autowired : 默认根据类型自动装配 ，可以出现在构造方法，方法，参数，属性，注解上
- @Qualifier ： 如果接口下有多个实现类，只能根据名字自动装配
- @Resource：可以完成非简单类型注入

@Autowired 和 @Resource 区别：

@Resource 默认根据名称自动装配，找不到name会自动根据类型装配

@Autowired 默认根据类型自动装配，想要根据名称自动装配，需要和@Qualifier一起使用



23.什么是bean的自动装配？

spring框架根据依赖关系自动将bean注入到其他bean中的一种方式，通过自动装配，spring根据一定的规则，自动解析和解决bean之间的依赖关系，无需显式配置依赖关系

- 使用xml配置
- 使用注解



23.代理模式

作用：

- 对象需要受到保护
- 对某个对象的功能进行增强
- A对象和B对象无法直接交互



代理模式中的三角色

- 目标对象
- 代理对象
- 目标对象和代理对象的公共接口



动态代理：在内存中动态生成字节码代理类的技术	（减少代理类的数量，解决代码复用）

jdk动态代理和CGLIB动态代理区别：

- jdk动态代理：只能代理接口，底层实现接口实现
- CGLIB动态代理：可以代理接口，也可以代理类，底层采用继承方式实现，功能更强大，效率更高，代理的目标类不能被final修饰



24.AOP（面向切面编程）

什么是AOP？

将横切关注点（日志、事务）与业务逻辑分离，提高代码复用性和模块性；和业务逻辑没有关系的代码单独提取出来，形成一个独立的组件，然后以横向交叉的方式应用到业务流程中的过程

如何实现？

代理模式，当一个bean被AOP代理时，spring使用代理对象包装原始对象，并将切面逻辑织入到方法调用中

spring提供两种AOP代理类型：

- JDK动态代理：用于实现接口的bean
- CGILB动态代理：用于没有实现接口的bean





底层：使用动态代理

优点：

- 代码复用性增强
- 代码易维护
- 开发者更加关注业务逻辑





25.spring实现事务的两种方式

- 编程式事务 使用TransactionTemplate
- 声明式事务 ：其本质是通过AOP功能，对方法前后进行拦截，将事务处理的功能编织到拦截的方法中，也就是在目标方法开始之前启动一个事务，在执行完目标方法之后根据执行情况提交或者回滚事务
  - 基于注解
  - 基于XML



26.事务的传播机制（传播行为）propagation

什么是事务的传播行为？

a和b方法上有事务，a方法执行时调用了b方法，事务是如何传递的

- REQUIRED：调用者有事务，当前方法加入到调用者事务中运行，没有则开启一个新的事务
- SUPPORTS：调用者有事务，当前方法加入到调用者事务中运行，没有则以非事务方式执行
- MANDATORY：当前方法必须在调用者事务中运行，没有事务则抛出异常
- REQUIRES_NEW：调用者有事务，调用者事务被挂起，当前方法开启一个新的事务
- NOT_SUPPORTED：调用者有事务，调用者事务被挂起，当前方法以非事务方式执行
- NEVER：调用者有事务，则抛出异常，没有则以非事务方式执行
- NESTED：调用者有事务，则当前方法以“嵌套事务”的形式加入到调用者事务中运行，没有则当前方法自己新开启一个事务运行



27.数据库中三大读问题

- 脏读：读取到没有提交到数据库的数据
- 不可重复读：同一个事务中，第一次和第二次读的数据不一样
- 幻读：读到的数据是假的



27.事务的隔离级别

- 读未提交（READ_UNCOMMITED)：存在脏读问题
- 读提交（READ_COMMITED）：解决脏读，但存在不可重复读问题
- 可重复读（REPEATED_READ）：解决不可重复读，但存在幻读
- 序列化（SERIALIZABLE）：解决幻读，事务排队执行，不支持并发

mysql默认：REPEATABLE_READ

oracl默认：READ_COMMITTED

只要是事务并发，一定会出现幻读

脏读：读到缓存的数据
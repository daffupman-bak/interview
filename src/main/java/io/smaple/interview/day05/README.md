# 面试题收纳（五）

1、在项目中使用到的设计模式

1.1、单例设计模式

项目中使用@Controller、@Service等标注的类以单例的形式存入spring容器中。数据库连接池，线程池的获取也是单例。

1.2、桥接模式

UserService和UserServiceImpl

1.3、装饰者设计模式

扩展类和接口的功能，BufferRead

1.4、工厂设计模式

mybatis

1.5、代理模式

mybatis

2、项目中使用到的多线程？

在获取详情页面的时候，需要远程获取多个微服务的数据，使用了【异步编排 + 线程池】进行优化。

3、ThreadLocal

线程副本：每个线程中都保存一份共享数据的副本，各个线程对副本的操作不会影响到其他线程的副本。
# 面试题收纳（三）

1、简述Spring MVC执行流程

![Spring MVC执行流程](https://raw.githubusercontent.com/daffupman/markdown-img/master/20191205153529.png)

- DispatcherServlet
- HandlerMapping
- HandlerAdapter
- Handler
- ViewResolver

2、SimpleDateFormat是线程安全的吗？

SimpleDateFormat继承DateFormat类，DateFormat类中维护一个Calendar对象，该对象是用来计算日期时间的，既用于`parse()`也用于`format()`。因此使用SimpleDateFormat转换日期实际上是通过`Calendar`对象来操作的。在`parse()`方法的最后会调用 `Calendar#establish(Calendar cal)`,入参为Calendar实例。在 `establish()` 方法中会先调用Calendar实例的`clear()`方法,该方法会清空用于计算的日期时间，然后再设置新的时间日期。那么在多线程的情况下，A线程中执行了`clear()`方法,但是还没来得及设置新值，B线程执行了format方法，此时出现线程安全问题。
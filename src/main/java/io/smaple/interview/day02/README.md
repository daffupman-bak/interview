# 面试题收纳（一）

1、int和Integer的比较

int是基本数据类型，Integer是int的包装类，是引用类型。int默认值为0，Integer默认为null。两者可以通过的装箱和拆箱机制相互转换。

- 使用 `new` 关键字创建的两个Integer对象，存储于堆中，两者不等
- Integer变量和使用 `new` 创建的Integer对象，也是不同的对象，前者位于缓存中，后者位于堆中。
- 两个Integer变量比较，如果值位于[-128,127],那么二者相等，否则不等。
- int与Integer变量/new Integer(),会通过自动拆箱，再判断两者是否相等。

2、线程中的状态

2.1、线程创建的方式

- 继承Thread类
- 实现Runnable接口
- 实现Callable接口
- 使用线程池

前两种方式不能获取线程执行的结果，后两者可以。

2.2、守护线程

为守护普通线程而创建的线程，普通线程执行结束，相应的守护线程也结束。

2.3、wait和sleep方法的区别

Thread类的sleep方法执行时不会释放CPU资源，而Object类的sleep方法会释放CPU资源。

2.4 线程的生命周期

![](https://raw.githubusercontent.com/daffupman/markdown-img/master/20191205104402.png)
# 面试题收纳（一）

## 一、JVM

1、JVM调优为什么把-Xms和-Xmx设置成一样的值？

JVM中-Xms的默认值为总内存大小的`1/64`,-Xmx默认为内存的`1/4`。当起始分配大小和最大分配设置成一样大的时候，一旦JVM的内存使用量到达到起始分配大小。此时不会触发堆内存的调整，而是直接开始gc。这样就避免了调整堆带来的压力。

2、JVM的组成

![JVM体系结构概览](https://raw.githubusercontent.com/daffupman/markdown-img/master/20191015134605.png)
- 堆负责存储，栈负责运行；
- 方法区和堆属于共享区域，可以调优
- 而java栈，native栈和程序计数器为线程私有内容

当在程序中new一个对象时，会在堆中新生区下的伊甸区创建对象。当发生gc后，该对象存活下来的话，会被放入s0区，也就是from区。第二次gc后，eden区和from区内的对象都可能被回收，而那些没有被回收的对象存入s1区（此时为To区）。接着s0和s1职责互换，也就是s0为To区，s1为From区。如果这个对象能经历这样的过程超过15次，那么将被送入old区。old区会发生Full GC，如果Full GC之后容量还是不够新对象使用，那么抛出OOM。

3、手写一个线程通信的例子
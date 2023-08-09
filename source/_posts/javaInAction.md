---
title: javaInAction总结
---

```
参考内容 
java8实战
https://github.com/winterbe/java8-tutorial.git
https://github.com/java8/Java8InAction.git
```

[TOC]



# 1 基础知识 1-3 

### 1.1 基础知识

| 概念              |                                                              |
| ----------------- | ------------------------------------------------------------ |
| 内部类/匿名类     | 1 代码长 2容易造成误解 this super                            |
| lambda            | 简洁                                                         |
| Lambda表达式      |                                                              |
| 方法引用          |                                                              |
| 流                |                                                              |
| 默认方法          |                                                              |
| 行为参数化        |                                                              |
| 谓词（predicate） | 在数学上常常用来代表一个类似函数的东西，它接受一个参数值，并返回true或false |
|                   |                                                              |

Scala的语法expr match就对应于Java中的switch (expr



1.2 匿名类的缺点- 代码含义模糊不清

1.3 基于函数编程对苹果对象过滤

# 2函数式数据处理4-7

#### 2.4

#### flatMap和map的区别

```
https://www.techiedelight.com/zh/difference-map-flatmap-java/
```

##### reduce的作用

#### 2.5创建stream的方式

- Stream.of("Java 8", "Lambdas", "In", "Action");
- Stream.empty();
- Arrays.stream(numbers) 构造函数
- Stream.iterate(0, n -> n + 2) ， eg 实现斐波那契额序列  Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1],t[0] + t[1]})  s
- Stream.generate(Math::random)
- IntStream.generate(() -> 1) //传递函数 

2.2 Stream Api

1. filter()   接受一个方法 返回值必须是boolean
2. finding  anyMatch allMatch noneMatch findAny   ？这四者有啥区别
3. laziness 
4. mapping  map 接受一个方法 ，返回一个对选哪个 。  flatMap ？
5.  NumericStreams
6. Reducing 

#### 2.6 stram收集器

1. PartitionPrimeNumbers 类 
2. groupingBy
3. partitioningBy
4.  maxBy
5. collectingAndThen

#### 2.7 比较forkjoin和并行流

# 3高效Java 8编程8-12

# 4超越Java 8 13-16



### 1  第一部分

第一章 

```
Lambda表达式、方法引用？、流和默认方法？
方法引用eg：File::isHidden
默认方法：目的 了支持库设计师，让他们能够写出更容易改进的接口

内部迭代-流  外部迭代-for-each
C++中臭名昭著的菱形继承问题
泛型（比如Consumer<T>中的T）只能绑定到引用类型。这是由泛型内部的实现方式造成的
IntPredicate

java 8的函数接口

Predicate<T> T->boolean IntPredicate,LongPredicate, DoublePredicate 
Consumer<T> T->void IntConsumer,LongConsumer, DoubleConsumer 
Function<T,R>
Supplier<T> ()->T BooleanSupplier,IntSupplier, LongSupplier, 
DoubleSupplier 
UnaryOperator<T> T->T IntUnaryOperator, 
LongUnaryOperator, 
DoubleUnaryOperator 
BinaryOperator<T> (T,T)->T IntBinaryOperator, 
LongBinaryOperator, 
DoubleBinaryOperator 
BiPredicate<L,R> (L,R)->boolean 
BiConsumer<T,U> (T,U)->void ObjIntConsumer<T>, 
ObjLongConsumer<T>, 
ObjDoubleConsumer<T> 
BiFunction<T,U,R> (T,U)->R ToIntBiFunction<T,U>, 
ToLongBiFunction<T,U>, 
ToDoubleBiFunction<T,U>

结论
布尔表达式 (List<String> list) -> list.isEmpty() Predicate<List<String>> 
创建对象 () -> new Apple(10) Supplier<Apple> 
消费一个对象 (Apple a) -> 
System.out.println(a.getWeight()) 
Consumer<Apple> 
从一个对象中
选择/提取
(String s) -> s.length() Function<String, Integer>或
ToIntFunction<String> 
合并两个值 (int a, int b) -> a * b IntBinaryOperator 
比较两个对象 (Apple a1, Apple a2) -> 
a1.getWeight().compareTo(a2.getWeight()) Comparator<Apple>或
BiFunction<Apple, Apple, Integer>
或 ToIntBiFunction<Apple, Apple>


java1.0内存模型
java5 线程池和并发集合
Java 7添加了分支/合并（fork/join）框架
```

第二章 

```
行为参数化
```

第三章 

```
Lambda表达式和方法引用
```






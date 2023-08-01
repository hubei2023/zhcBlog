---
title: javaInAction总结
---

```
参考内容 
java8实战
https://github.com/winterbe/java8-tutorial.git
https://github.com/java8/Java8InAction.git
```



# 1 基础知识 1-3 

## 1.1 基础知识

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



##### 1.2 匿名类的缺点- 代码含义模糊不清

##### 1.3 基于函数编程对苹果对象过滤

# 2函数式数据处理4-7

#### flatMap和map的区别

```
https://www.techiedelight.com/zh/difference-map-flatmap-java/
```

##### reduce的作用

## 2.5创建stream的方式

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

 



# 3高效Java 8编程8-12

# 4超越Java 8 13-16
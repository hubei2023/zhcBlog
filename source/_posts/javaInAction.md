---
title: javaInAction总结
---



# 1 基础知识 1-3 

```

```



## 1.1 基础知识

| 概念              |                                                              |
| ----------------- | ------------------------------------------------------------ |
| 内部类            | 1 代码长 2容易造成误解                                       |
| lambda            | 简洁                                                         |
| Lambda表达式      |                                                              |
| 方法引用          |                                                              |
| 流                |                                                              |
| 默认方法          |                                                              |
| 行为参数化        |                                                              |
| 谓词（predicate） | 在数学上常常用来代表一个类似函数的东西，它接受一个参数值，并返回true或false |
|                   |                                                              |

Scala的语法expr match就对应于Java中的switch (expr



## 1.2 匿名类的缺点- 代码含义模糊不清

```java
public class MeaningOfThis
{
    public final int value = 4;
    public void doIt()
    {
        int value = 6;
        Runnable r = new Runnable(){
            public final int value = 5;
            public void run(){
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }
    public static void main(String...args)
    {
        MeaningOfThis m = new MeaningOfThis();
        m.doIt();
    }
}
```

## 1.3 基于函数编程对苹果对象过滤

```java
public class FilteringApples{

    public static void main(String ... args){

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                                              new Apple(155, "green"),
                                              new Apple(120, "red"));	

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);
        
        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);
        
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);
        
        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);
        
        // []
        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || 
                                                                       "brown".equals(a.getColor()));
        System.out.println(weirdApples);
    }

    
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor()); 
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }       

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                   "color='" + color + '\'' +
                   ", weight=" + weight +
                   '}';
        }
    }

}
```



# 2函数式数据处理4-7

## 2.1创建stream的方式

- Stream.of("Java 8", "Lambdas", "In", "Action");
- Stream.empty();
- Arrays.stream(numbers) 构造函数
- Stream.iterate(0, n -> n + 2) ， eg 实现斐波那契额序列  Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1],t[0] + t[1]})  s





# 3高效Java 8编程8-12

# 4超越Java 8 13-16
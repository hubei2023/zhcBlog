JDK 中使用了迭代器模式的地方也比较多，以下是一些常见的例子：

- **java.util.Collection**：Collection 接口使用了迭代器模式来实现。Collection 接口定义了 iterator() 方法，用于返回一个迭代器对象。
- **java.util.List**：List 接口使用了迭代器模式来实现。List 接口继承了 Collection 接口，并重写了 iterator() 方法。
- **java.util.Set**：Set 接口使用了迭代器模式来实现。Set 接口继承了 Collection 接口，并重写了 iterator() 方法。
- **java.util.Map**：Map 接口使用了迭代器模式来实现。Map 接口定义了 keySet()、values() 和 entrySet() 方法，用于返回三个迭代器对象。

除了这些常见的类之外，JDK 中还有很多其他类使用了迭代器模式。迭代器模式在 JDK 中被广泛使用，是因为它可以提供一种统一的方式来遍历集合。


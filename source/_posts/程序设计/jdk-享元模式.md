JDK 中使用了享元模式的地方也比较多，以下是一些常见的例子：

- **java.util.Hashtable**：Hashtable 类使用了享元模式来实现。Hashtable 类将重复的对象缓存起来，以减少创建对象的次数。
- **java.util.String**：String 类使用了享元模式来实现。String 类将相同的字符串缓存起来，以减少创建对象的次数。
- **java.util.Locale**：Locale 类使用了享元模式来实现。Locale 类将相同的区域信息缓存起来，以减少创建对象的次数。
- **java.util.ResourceBundle**：ResourceBundle 类使用了享元模式来实现。ResourceBundle 类将相同的资源文件缓存起来，以减少创建对象的次数。

除了这些常见的类之外，JDK 中还有很多其他类使用了享元模式。享元模式在 JDK 中被广泛使用，是因为它可以减少对象的创建次数，从而提高性能。
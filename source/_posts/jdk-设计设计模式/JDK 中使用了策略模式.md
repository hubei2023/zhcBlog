

JDK 中使用了策略模式的地方也比较多，以下是一些常见的例子：

- **java.util.Comparator**：Comparator 接口使用了策略模式来实现。Comparator 接口提供了一种比较对象的方法，可以通过实现不同的 Comparator 接口来实现不同的比较方式。
- **java.util.Formatter**：Formatter 类使用了策略模式来实现。Formatter 类提供了一种格式化文本的方法，可以通过实现不同的 Formatter 接口来实现不同的格式化方式。
- **java.util.Locale**：Locale 类使用了策略模式来实现。Locale 类提供了一种根据区域信息格式化文本的方法，可以通过实现不同的 Locale 接口来实现不同的格式化方式。
- **java.util.ResourceBundle**：ResourceBundle 类使用了策略模式来实现。ResourceBundle 类提供了一种根据区域信息获取资源文件的方法，可以通过实现不同的 ResourceBundle 接口来实现不同的获取方式。

除了这些常见的类之外，JDK 中还有很多其他类使用了策略模式。策略模式在 JDK 中被广泛使用，是因为它可以将算法的选择与算法的实现分离，使得可以根据需要灵活地选择算法。


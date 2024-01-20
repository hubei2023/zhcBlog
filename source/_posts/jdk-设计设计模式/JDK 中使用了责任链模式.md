JDK 中使用了责任链模式的地方也比较多，以下是一些常见的例子：

- **java.util.logging.Logger**：Logger 类使用了责任链模式来实现。Logger 类可以将日志级别与处理器链关联起来。
- **java.io.FilterInputStream**：FilterInputStream 类使用了责任链模式来实现。FilterInputStream 类可以将输入流与过滤器链关联起来。
- **java.net.ServerSocket**：ServerSocket 类使用了责任链模式来实现。ServerSocket 类可以将连接请求与处理器链关联起来。

除了这些常见的类之外，JDK 中还有很多其他类使用了责任链模式。责任链模式在 JDK 中被广泛使用，是因为它可以将请求从一个对象传递到另一个对象，直到找到合适的对象来处理请求。
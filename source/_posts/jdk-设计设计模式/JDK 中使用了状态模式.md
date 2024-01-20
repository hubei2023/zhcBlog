
JDK 中使用了状态模式的地方比较多，以下是一些常见的例子：

- **java.awt.event.FocusEvent**：FocusEvent 类使用了状态模式来实现。FocusEvent 类可以表示焦点的状态变化。
- **java.net.Socket**：Socket 类使用了状态模式来实现。Socket 类可以表示连接的状态。
- **java.util.concurrent.locks.Condition**：Condition 类使用了状态模式来实现。Condition 类可以表示锁的状态。

除了这些常见的类之外，JDK 中还有很多其他类使用了状态模式。状态模式在 JDK 中被广泛使用，是因为它可以将对象的状态和行为分离。
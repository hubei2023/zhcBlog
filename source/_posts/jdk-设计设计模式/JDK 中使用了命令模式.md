JDK 中使用了命令模式的地方也比较多，以下是一些常见的例子：

- **java.lang.Runnable**：Runnable 接口使用了命令模式来实现。Runnable 接口定义了 run() 方法，用于执行命令。
- **java.awt.event.ActionEvent**：ActionEvent 类使用了命令模式来实现。ActionEvent 类定义了 command 属性，用于存储命令对象。
- **java.awt.MenuBar**：MenuBar 类使用了命令模式来实现。MenuBar 类可以注册命令对象，当菜单项被点击时，会调用命令对象的 execute() 方法。

除了这些常见的类之外，JDK 中还有很多其他类使用了命令模式。命令模式在 JDK 中被广泛使用，是因为它可以将请求封装成对象，使得请求可以被传递、存储和撤销。
JDK 中使用了观察者模式的地方比较多，以下是一些常见的例子：

- **java.util.Observer**：Observer 接口是观察者接口，Subject 接口是被观察者接口。这两个接口使用了观察者模式来实现。Observer 接口定义了观察者需要实现的方法，Subject 接口定义了被观察者需要实现的方法。
- **java.util.EventListener**：EventListener 接口是观察者接口，EventObject 类是事件对象。这两个接口使用了观察者模式来实现。EventListener 接口定义了观察者需要实现的方法，EventObject 类定义了事件对象。
- **java.util.Timer**：Timer 类使用了观察者模式来实现。Timer 类可以注册观察者，当 Timer 触发时，会通知观察者。
- **java.util.Observable**：Observable 类是被观察者类，Observer 接口是观察者接口。这两个类使用了观察者模式来实现。Observable 类可以注册观察者，当 Observable 的状态发生变化时，会通知观察者。


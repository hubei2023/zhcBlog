JDK 中使用了组合模式的地方比较多，以下是一些常见的类：

- **java.util.AbstractList**：AbstractList 类是 List 接口的抽象实现类，它使用了组合模式来实现 List 接口。AbstractList 类的子类可以是叶子节点，也可以是树枝节点。
- **java.util.AbstractSet**：AbstractSet 类是 Set 接口的抽象实现类，它使用了组合模式来实现 Set 接口。AbstractSet 类的子类可以是叶子节点，也可以是树枝节点。
- **java.util.AbstractMap**：AbstractMap 类是 Map 接口的抽象实现类，它使用了组合模式来实现 Map 接口。AbstractMap 类的子类可以是叶子节点，也可以是树枝节点。
- **java.awt.Container**：Container 类是 AWT 中的容器类，它使用了组合模式来实现容器功能。Container 类的子类可以是叶子节点，也可以是树枝节点。
- **javax.swing.JComponent**：JComponent 类是 Swing 中的组件类，它使用了组合模式来实现组件功能。JComponent 类的子类可以是叶子节点，也可以是树枝节点。

除了这些常见的类之外，JDK 中还有很多其他类使用了组合模式。组合模式在 JDK 中被广泛使用，是因为它可以将对象组合成树形结构，使得可以统一地处理树形结构中的对象。                 


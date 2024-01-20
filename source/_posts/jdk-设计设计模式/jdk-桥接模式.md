
JDK 中使用了桥接模式的地方也比较多，以下是一些常见的例子：

- **JDBC 驱动**：JDBC 驱动使用了桥接模式来实现对不同数据库的支持。JDBC 驱动将数据库的实现细节与数据库的访问逻辑解耦，使得可以针对不同的数据库实现不同的数据库访问逻辑。
- **Abstract Window Toolkit (AWT)**：AWT 使用了桥接模式来实现对不同图形设备的支持。AWT 将图形设备的实现细节与图形绘制逻辑解耦，使得可以针对不同的图形设备实现不同的图形绘制逻辑。
- **JavaBeans**：JavaBeans 使用了桥接模式来实现对不同 UI 框架的支持。JavaBeans 将 UI 框架的实现细节与 UI 逻辑解耦，使得可以针对不同的 UI 框架实现不同的 UI 逻辑。

除了这些常见的例子之外，JDK 中还有很多其他地方使用了桥接模式。桥接模式在 JDK 中被广泛使用，是因为它可以将抽象与实现解耦，使得可以独立地扩展抽象和实现。

以下是 JDK 中桥接模式的一个具体例子：

```
// 抽象类
abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}

// 实现类
class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("画一个圆，颜色为：" + color);
    }
}

// 实现类
class Rectangle extends Shape {

    public Rectangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("画一个矩形，颜色为：" + color);
    }
}

// 客户端
public class Client {
    public static void main(String[] args) {
        // 创建圆形对象
        Shape circle = new Circle(Color.RED);
        circle.draw();

        // 创建矩形对象
        Shape rectangle = new Rectangle(Color.GREEN);
        rectangle.draw();
    }
}
```

在上述例子中，Shape 类是抽象类，Circle 类和 Rectangle 类是 Shape 类的子类，它们分别实现了画圆和画矩形的功能。Color 类表示颜色。

在 Client 类中，创建了 Circle 对象和 Rectangle 对象，并分别调用了它们的 draw() 方法。Circle 对象调用了 draw() 方法，会打印出 "画一个圆，颜色为：红色" 的字符串。Rectangle 对象调用了 draw() 方法，会打印出 "画一个矩形，颜色为：绿色" 的字符串。

在上述例子中，Shape 类是抽象类，它表示图形的抽象。Circle 类和 Rectangle 类是 Shape 类的子类，它们分别实现了画圆和画矩形的功能。Color 类表示颜色。

桥接模式将抽象与实现解耦，使得可以独立地扩展抽象和实现。在上述例子中，抽象类 Shape 只负责定义图形的抽象，而实现类 Circle 和 Rectangle 负责实现具体的画圆和画矩形的功能。颜色可以通过 Color 类来进行扩展。
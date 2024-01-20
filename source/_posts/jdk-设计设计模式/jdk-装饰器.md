JDK 中使用了装饰器模式的地方也比较多，以下是一些常见的例子：

- **java.io.InputStreamReader**：InputStreamReader 类是字节流到字符流的装饰器。它将字节流转换为字符流，以便可以使用字符流进行操作。
- **java.io.OutputStreamWriter**：OutputStreamWriter 类是字符流到字节流的装饰器。它将字符流转换为字节流，以便可以使用字节流进行操作。
- **java.io.BufferedReader**：BufferedReader 类是缓冲字符流的装饰器。它将字符流包装在一个缓冲区中，以提高读取效率。
- **java.io.BufferedWriter**：BufferedWriter 类是缓冲字符流的装饰器。它将字符流包装在一个缓冲区中，以提高写入效率。
- **java.util.concurrent.ExecutorService**：ExecutorService 类是线程池的装饰器。它提供了对线程池的抽象，使得可以对线程池进行统一的管理。
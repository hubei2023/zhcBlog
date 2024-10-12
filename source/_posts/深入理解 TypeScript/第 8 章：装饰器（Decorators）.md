第 8 章 **装饰器（Decorators）** 介绍了 TypeScript 中的装饰器这一高级特性。装饰器是 TypeScript 为类及其成员（如属性、方法、访问器等）提供的一种特殊语法，用于在不修改类的前提下，增强或改变类的行为。装饰器广泛用于元编程（metaprogramming），可以简化某些功能的实现，比如依赖注入、日志记录等，特别是在框架中（如 Angular）非常常见。

### 1. **装饰器的定义**
装饰器本质上是一个函数，它可以被应用到类、类的属性、方法、参数上，以动态修改或注入元数据。这一特性借鉴了其他面向对象语言中的装饰器模式，增强了类的灵活性。

装饰器在 TypeScript 中是实验性的，需要在 `tsconfig.json` 中开启：
```json
{
  "compilerOptions": {
    "experimentalDecorators": true
  }
}
```

### 2. **装饰器的类型**
TypeScript 中的装饰器可以应用于以下几种场景：

- **类装饰器**：用于修改类本身的行为。
- **方法装饰器**：用于增强或修改类的方法。
- **属性装饰器**：用于拦截和处理类的属性。
- **参数装饰器**：用于标记和处理方法参数。

#### 2.1 类装饰器
类装饰器应用于类的声明上，用来修改或替换类定义。

**类装饰器的示例：**
```typescript
function sealed(constructor: Function) {
  Object.seal(constructor);
  Object.seal(constructor.prototype);
}

@sealed
class Person {
  constructor(public name: string) {}
}

const person = new Person("Alice");
```
在这个示例中，`sealed` 是一个类装饰器，它使用 `Object.seal` 方法冻结了 `Person` 类及其原型，防止对类进行扩展或修改。

#### 2.2 方法装饰器
方法装饰器用于修改类的方法行为，装饰器函数接收三个参数：
1. 类的原型对象。
2. 方法的名称。
3. 方法的描述符（`PropertyDescriptor`）。

**方法装饰器的示例：**
```typescript
function log(target: any, propertyKey: string, descriptor: PropertyDescriptor) {
  const originalMethod = descriptor.value;

  descriptor.value = function(...args: any[]) {
    console.log(`Calling ${propertyKey} with arguments: ${args}`);
    return originalMethod.apply(this, args);
  };
}

class Calculator {
  @log
  add(a: number, b: number): number {
    return a + b;
  }
}

const calculator = new Calculator();
console.log(calculator.add(2, 3)); // 输出: Calling add with arguments: 2,3
                                   //      5
```
在此例中，`log` 方法装饰器拦截了对 `add` 方法的调用，在方法执行前打印日志信息。

#### 2.3 属性装饰器
属性装饰器用于处理类的属性，但无法直接访问该属性的值。装饰器函数接收两个参数：
1. 类的原型对象。
2. 属性的名称。

**属性装饰器的示例：**
```typescript
function readonly(target: any, key: string) {
  Object.defineProperty(target, key, {
    writable: false
  });
}

class Book {
  @readonly
  title: string = "TypeScript Handbook";
}

const book = new Book();
book.title = "New Title"; // 运行时会报错，因为 title 是只读的
```
在这个例子中，`readonly` 属性装饰器将 `title` 属性设为只读。

#### 2.4 参数装饰器
参数装饰器用于为方法的参数添加元数据，它接收三个参数：
1. 类的原型对象。
2. 方法的名称。
3. 参数的索引位置。

**参数装饰器的示例：**
```typescript
function logParam(target: any, propertyKey: string, parameterIndex: number) {
  console.log(`${propertyKey} 参数位置: ${parameterIndex}`);
}

class Example {
  greet(@logParam name: string): string {
    return `Hello, ${name}`;
  }
}

const example = new Example();
example.greet("Alice"); // 输出: greet 参数位置: 0
```
在这个例子中，`logParam` 参数装饰器记录了 `greet` 方法中参数的位置。

### 3. **装饰器工厂**
装饰器工厂是一种返回装饰器函数的函数，允许你在应用装饰器时传递参数，从而增强装饰器的灵活性。

**装饰器工厂的示例：**
```typescript
function logMessage(message: string) {
  return function(target: any, propertyKey: string, descriptor: PropertyDescriptor) {
    const originalMethod = descriptor.value;
    
    descriptor.value = function(...args: any[]) {
      console.log(message);
      return originalMethod.apply(this, args);
    };
  };
}

class Car {
  @logMessage("Starting engine...")
  start() {
    console.log("Engine started");
  }
}

const car = new Car();
car.start(); // 输出: Starting engine...
             //      Engine started
```
通过装饰器工厂 `logMessage`，我们可以为每个方法动态地传递不同的日志信息。

### 4. **组合装饰器**
多个装饰器可以应用于同一个目标，多个装饰器的执行顺序是从下到上（即靠近目标的装饰器先执行），返回结果会传递给上层装饰器。

**组合装饰器的示例：**
```typescript
function first() {
  return function(target: any, propertyKey: string, descriptor: PropertyDescriptor) {
    console.log("First decorator");
  };
}

function second() {
  return function(target: any, propertyKey: string, descriptor: PropertyDescriptor) {
    console.log("Second decorator");
  };
}

class Example {
  @first()
  @second()
  method() {}
}

// 输出:
// Second decorator
// First decorator
```
如上所示，`second` 装饰器先执行，`first` 装饰器后执行。

### 5. **装饰器的实际应用**
装饰器在许多场景中具有实际价值，特别是在现代框架中，如 Angular 大量使用装饰器来标记类、依赖注入、定义元数据等。例如：
- **依赖注入**：装饰器可以用来定义类的依赖项，并在运行时自动注入。
- **日志记录**：通过装饰器轻松实现方法调用的日志记录。
- **权限控制**：装饰器可以用于检查用户权限，确保用户具有适当的访问权限。

### 总结
第 8 章详细介绍了 TypeScript 中装饰器的功能、用法和应用场景。装饰器提供了一种声明式的编程方式，可以用来修改类的行为，特别是在框架中广泛使用。通过类装饰器、方法装饰器、属性装饰器和参数装饰器，开发者可以灵活地增强类的功能。在实际开发中，装饰器能够提高代码的可读性和可维护性，尤其在大型项目中，装饰器是极为实用的工具。
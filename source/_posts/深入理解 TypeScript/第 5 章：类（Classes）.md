---
title: "《深入理解 TypeScript》-第 5 章：类（Classes）"
date: 2024-10-12
tags: 
---
第 5 章 **类（Classes）** 详细介绍了 TypeScript 中类的概念及其在面向对象编程中的应用。TypeScript 对类的支持基于 ES6 的类机制，同时添加了类型检查和更强大的特性，进一步增强了 JavaScript 的面向对象能力。本章涵盖了类的定义、继承、多态、访问修饰符和抽象类等内容。

### 1. **类的定义**
   在 TypeScript 中，类是用 `class` 关键字定义的，并且可以包含属性、方法和构造函数。类的基本结构如下：

   ```typescript
   class Person {
     name: string;
     constructor(name: string) {
       this.name = name;
     }
     greet() {
       console.log(`Hello, ${this.name}`);
     }
   }

   let person = new Person("Alice");
   person.greet();  // 输出: Hello, Alice
   ```

   - **构造函数**：使用 `constructor` 关键字定义类的构造函数。当使用 `new` 关键字创建类实例时，构造函数会被调用，用于初始化对象。
   - **属性**：可以在类中定义属性，属性的类型必须声明。如果没有显式初始化属性，它们需要在构造函数中进行初始化。

### 2. **类的继承**
   TypeScript 支持**类的继承**，通过 `extends` 关键字实现类之间的继承，允许一个类继承另一个类的属性和方法。

   ```typescript
   class Animal {
     move(distance: number): void {
       console.log(`Animal moved ${distance} meters.`);
     }
   }

   class Dog extends Animal {
     bark(): void {
       console.log("Woof! Woof!");
     }
   }

   const dog = new Dog();
   dog.bark();          // 输出: Woof! Woof!
   dog.move(10);        // 输出: Animal moved 10 meters.
   ```

   - **继承**：`Dog` 类继承了 `Animal` 类，因此 `Dog` 类拥有了 `Animal` 类的 `move` 方法。
   - **方法重写**：子类可以重写父类中的方法，通过 `super` 关键字调用父类的方法，确保父类的逻辑可以被保留。

### 3. **访问修饰符**
   TypeScript 提供了访问修饰符（`public`、`private` 和 `protected`）来控制类成员的访问权限。

   - **`public`**（默认）：成员可以在任何地方访问。
   - **`private`**：成员只能在类内部访问，外部不能访问该成员。
   - **`protected`**：成员可以在当前类及其子类中访问，但不能在类的实例中访问。

   ```typescript
   class Person {
     public name: string;
     private age: number;

     constructor(name: string, age: number) {
       this.name = name;
       this.age = age;
     }

     getAge(): number {
       return this.age;
     }
   }

   const person = new Person("Alice", 30);
   console.log(person.name);  // 输出: Alice
   console.log(person.getAge());  // 输出: 30
   ```

   - `name` 是 `public` 的，因此可以直接访问。
   - `age` 是 `private` 的，因此只能通过类内部的方法 `getAge` 来访问。

### 4. **类的存取器（Getters 和 Setters）**
   TypeScript 允许通过存取器来控制对类属性的访问。通过 `get` 和 `set` 关键字定义存取器，允许在读取和设置属性时自定义行为。

   ```typescript
   class Employee {
     private _fullName: string = "";

     get fullName(): string {
       return this._fullName;
     }

     set fullName(newName: string) {
       if (newName) {
         this._fullName = newName;
       }
     }
   }

   const employee = new Employee();
   employee.fullName = "Alice Johnson";  // 调用 setter
   console.log(employee.fullName);  // 调用 getter, 输出: Alice Johnson
   ```

   - **Getter**：允许自定义属性读取的行为。
   - **Setter**：允许在设置属性值时进行额外的处理（如验证或格式化）。

### 5. **静态成员**
   - **静态属性和方法**：通过 `static` 关键字定义类的静态属性和方法。静态成员属于类本身，而不是某个实例，可以通过类名直接访问。

   ```typescript
   class Helper {
     static readonly version: string = "1.0";

     static log(message: string): void {
       console.log(`[Helper] ${message}`);
     }
   }

   console.log(Helper.version);  // 输出: 1.0
   Helper.log("This is a static method.");  // 输出: [Helper] This is a static method.
   ```

   - **静态属性**：如 `version`，它不能被实例访问。
   - **静态方法**：如 `log`，它同样不能被实例调用，必须通过类名来调用。

### 6. **抽象类（Abstract Classes）**
   - **抽象类** 是不能被实例化的类，只能被其他类继承。抽象类可以包含实现的成员，也可以包含抽象方法，抽象方法必须由子类实现。

   ```typescript
   abstract class Animal {
     abstract makeSound(): void;

     move(): void {
       console.log("Moving...");
     }
   }

   class Dog extends Animal {
     makeSound(): void {
       console.log("Woof! Woof!");
     }
   }

   const dog = new Dog();
   dog.makeSound();  // 输出: Woof! Woof!
   dog.move();       // 输出: Moving...
   ```

   - `Animal` 是一个抽象类，包含了一个抽象方法 `makeSound` 和一个实现方法 `move`。
   - `Dog` 类继承了 `Animal`，必须实现 `makeSound` 方法。

### 7. **类的高级用法**
   - **类与接口的结合**：类可以实现（`implements`）一个或多个接口，确保类实现接口中定义的属性和方法。
     ```typescript
     interface Drivable {
       startEngine(): void;
     }
     
     class Car implements Drivable {
       startEngine(): void {
         console.log("Engine started.");
       }
     }
     
     const car = new Car();
     car.startEngine();  // 输出: Engine started.
     ```

   - **类的构造函数参数简写**：TypeScript 提供了一种简洁的语法，可以在构造函数的参数列表中直接声明和初始化类的属性。
     ```typescript
     class User {
       constructor(public name: string, private age: number) {}
     }
     
     const user = new User("Alice", 30);
     console.log(user.name);  // 输出: Alice
     ```

### 总结：
第 5 章介绍了 TypeScript 中类的核心概念及其在面向对象编程中的应用。通过类的支持，开发者可以更好地构建结构化和可维护的代码。类的继承、封装（通过访问修饰符）、抽象和静态成员的特性使得 TypeScript 在处理复杂的应用程序时具有很大的优势。通过学习本章，开发者可以掌握类的基本用法，并理解如何将面向对象的编程理念应用于 TypeScript 项目中。

---
title: "《深入理解 TypeScript》-第 6 章：泛型（Generics）"
date: 2024-10-12
tags: 
---
第 6 章 **泛型（Generics）** 是 TypeScript 中一个重要的特性，它允许开发者编写更灵活、可重用的代码。泛型使得类型可以在函数、类或接口定义时保持灵活性，直到实际使用时再确定具体的类型。本章详细介绍了泛型的基础知识、在函数、类和接口中的使用，以及更高级的泛型功能。

### 1. **什么是泛型？**
泛型是 TypeScript 提供的一种工具，允许在定义时不确定具体的类型，而是在使用时指定具体类型。这种类型的灵活性使代码更加通用，减少了重复代码。

**泛型的基本语法：**
```typescript
function identity<T>(arg: T): T {
  return arg;
}

let output = identity<string>("Hello"); // 传入具体的类型
let output2 = identity<number>(42);     // 传入另一个具体的类型
```
在上面的例子中，`identity` 函数使用了泛型 `<T>`，可以接受任何类型的参数。具体的类型是在调用时传递的。

### 2. **泛型函数**
泛型函数允许你编写灵活的代码，这种代码能够处理多种类型，而不需要为每种类型重复编写逻辑。你可以为函数指定一个或多个类型参数。

**泛型函数的示例：**
```typescript
function getArray<T>(items: T[]): T[] {
  return new Array<T>().concat(items);
}

let numberArray = getArray<number>([1, 2, 3]);
let stringArray = getArray<string>(["a", "b", "c"]);
```
在这个例子中，函数 `getArray` 是泛型函数，它接受任何类型的数组，并返回相同类型的数组。

### 3. **泛型类**
TypeScript 允许类也可以使用泛型，使得类在处理不同的数据类型时更加灵活。

**泛型类的示例：**
```typescript
class Box<T> {
  contents: T;

  constructor(value: T) {
    this.contents = value;
  }

  getContents(): T {
    return this.contents;
  }
}

let box1 = new Box<number>(123);
let box2 = new Box<string>("hello");

console.log(box1.getContents());  // 输出: 123
console.log(box2.getContents());  // 输出: hello
```
`Box` 类是泛型类，它可以存储任意类型的数据。类中的属性 `contents` 的类型由泛型参数 `T` 决定，实际类型在实例化时确定。

### 4. **泛型接口**
泛型接口允许开发者定义更加灵活的接口，可以在接口中指定泛型参数。

**泛型接口的示例：**
```typescript
interface KeyValuePair<K, V> {
  key: K;
  value: V;
}

let kv1: KeyValuePair<number, string> = { key: 1, value: "apple" };
let kv2: KeyValuePair<string, string> = { key: "color", value: "blue" };
```
`KeyValuePair` 是一个泛型接口，接受两个类型参数 `K` 和 `V`，分别表示 `key` 和 `value` 的类型。

### 5. **泛型约束（Constraints）**
有时候，泛型的类型不能是任意的。你可以通过**泛型约束**来限制泛型类型必须满足某些条件。例如，要求泛型类型必须具有某些属性或实现某个接口。

**泛型约束的示例：**
```typescript
interface HasLength {
  length: number;
}

function logLength<T extends HasLength>(arg: T): void {
  console.log(arg.length);
}

logLength("Hello"); // 正确，字符串有 length 属性
logLength([1, 2, 3]); // 正确，数组有 length 属性
// logLength(42); // 错误，数字没有 length 属性
```
在这个例子中，泛型 `T` 被约束为必须具有 `length` 属性，因此只能传递具有该属性的类型。

### 6. **默认泛型类型**
TypeScript 允许为泛型参数提供默认值。如果调用时没有指定具体的泛型类型，TypeScript 会使用默认类型。

**默认泛型类型的示例：**
```typescript
function createBox<T = string>(value: T): T {
  return value;
}

let box1 = createBox("hello");  // 推断为 string 类型
let box2 = createBox<number>(123);  // 显式指定为 number 类型
```
这里的 `createBox` 函数使用了泛型，并且给泛型参数 `T` 提供了默认类型 `string`，如果调用时不传入类型参数，它会自动使用默认类型。

### 7. **泛型工具类型**
TypeScript 还提供了一些内置的**泛型工具类型**，用于在泛型基础上进行高级类型操作。这些工具类型常用于类型转换和条件类型判断。

- **`Partial<T>`**：将类型 `T` 中的所有属性变为可选。
- **`Readonly<T>`**：将类型 `T` 中的所有属性变为只读。
- **`Pick<T, K>`**：从类型 `T` 中挑选出某些属性。
- **`Record<K, T>`**：构造一个对象类型，其键 `K` 的类型和值 `T` 的类型。

```typescript
interface Person {
  name: string;
  age: number;
}

let partialPerson: Partial<Person> = { name: "Alice" };  // 可选属性
let readonlyPerson: Readonly<Person> = { name: "Alice", age: 30 };  // 只读属性
```

### 8. **泛型的好处**
- **代码重用**：泛型允许开发者编写一次代码，应用于多种不同的类型，提高代码的可重用性。
- **类型安全**：通过泛型，可以确保在编译时检查类型，避免运行时错误。
- **灵活性**：泛型让开发者可以更灵活地定义函数、类和接口，以适应不同的数据类型。

### 总结：
第 6 章深入探讨了 TypeScript 中泛型的各种应用，涵盖了泛型函数、泛型类、泛型接口以及泛型约束等概念。泛型是 TypeScript 强大类型系统的重要组成部分，能够提高代码的重用性和灵活性，同时保持类型安全。通过本章的学习，开发者可以理解如何在实际项目中使用泛型编写更加健壮、灵活的代码。

---
title: "《深入理解 TypeScript》-第 12 章：TypeScript 高级类型"
date: 2024-10-12
tags: 
---
第 12 章 **TypeScript 高级类型** 详细介绍了 TypeScript 中强大而灵活的高级类型。这些类型可以用来构建复杂的数据结构，并实现类型的强约束与推断能力。通过这些高级类型，开发者能够编写出更加抽象和可复用的代码。本章涵盖了类型推断、条件类型、映射类型、索引类型等核心概念，帮助开发者在项目中灵活运用 TypeScript 的类型系统。

### 1. **交叉类型（Intersection Types）**
交叉类型（`Intersection Types`）用于将多个类型合并为一个类型。它表示一个类型需要同时满足多个类型的要求，常用于将不同对象类型的属性组合在一起。

**示例：**
```typescript
interface Person {
  name: string;
}

interface Employee {
  employeeId: number;
}

type PersonEmployee = Person & Employee;

const john: PersonEmployee = {
  name: "John",
  employeeId: 1234
};
```
`PersonEmployee` 类型是 `Person` 和 `Employee` 的交集，因此需要同时包含 `name` 和 `employeeId` 属性。

### 2. **联合类型（Union Types）**
联合类型（`Union Types`）允许一个值可以是多个类型中的一种。它使用 `|` 符号定义，通常用于函数参数可以接受不同类型的值的场景。

**示例：**
```typescript
function printId(id: string | number) {
  if (typeof id === "string") {
    console.log(id.toUpperCase());
  } else {
    console.log(id);
  }
}
```
这里，`id` 可以是字符串或数字，函数根据 `typeof` 进行不同的处理。

### 3. **类型守卫（Type Guards）**
类型守卫是一种在运行时检查类型的技术，它可以通过不同的检查方式来缩小联合类型中的某个类型。

- **`typeof` 类型守卫**：用于检查原始类型。
- **`instanceof` 类型守卫**：用于检查对象是否是某个类的实例。
- **用户自定义类型守卫**：通过自定义函数来进行类型判断。

**示例：**
```typescript
function isString(value: any): value is string {
  return typeof value === "string";
}

function printValue(value: string | number) {
  if (isString(value)) {
    console.log(value.toUpperCase());
  } else {
    console.log(value);
  }
}
```
`isString` 是一个自定义类型守卫，用于判断 `value` 是否为字符串。

### 4. **索引类型（Index Types）**
索引类型允许开发者对对象类型的键和值进行抽象化操作。可以通过索引访问类型来获取对象类型中的某个属性类型。

- **`keyof` 操作符**：获取某个类型的键。
- **索引访问类型**：通过键来获取类型中属性的类型。

**示例：**
```typescript
interface Person {
  name: string;
  age: number;
}

type PersonKeys = keyof Person;  // "name" | "age"
let key: PersonKeys = "name";

type NameType = Person["name"];  // string
```
`keyof` 返回类型 `Person` 的键，`Person["name"]` 返回 `name` 属性的类型。

### 5. **映射类型（Mapped Types）**
映射类型是通过对已有类型进行变换而生成的新类型。通常用于对对象类型的所有属性进行批量操作。

- **`Partial<T>`**：将类型 `T` 的所有属性变为可选。
- **`Readonly<T>`**：将类型 `T` 的所有属性变为只读。
- **`Pick<T, K>`**：从类型 `T` 中挑选出某些属性。
- **`Record<K, T>`**：构造一个类型，其键为类型 `K`，值为类型 `T`。

**示例：**
```typescript
interface Person {
  name: string;
  age: number;
}

type PartialPerson = Partial<Person>;  // { name?: string; age?: number; }
type ReadonlyPerson = Readonly<Person>;  // { readonly name: string; readonly age: number; }
```
`Partial` 将 `Person` 类型的属性变为可选，`Readonly` 将所有属性变为只读。

### 6. **条件类型（Conditional Types）**
条件类型类似于三元表达式，它根据某个条件返回不同的类型结果。常用于根据类型参数的不同生成不同的类型。

**语法：**
```typescript
T extends U ? X : Y
```

**示例：**
```typescript
type IsString<T> = T extends string ? "Yes" : "No";

type A = IsString<string>;  // "Yes"
type B = IsString<number>;  // "No"
```
在这个例子中，`IsString` 是一个条件类型，它根据传入的类型是否为 `string` 返回不同的结果。

### 7. **分布式条件类型**
当条件类型应用于联合类型时，TypeScript 会自动对每个联合成员进行条件判断，这被称为**分布式条件类型**。

**示例：**
```typescript
type Exclude<T, U> = T extends U ? never : T;

type Result = Exclude<"a" | "b" | "c", "a">;  // "b" | "c"
```
`Exclude` 类型将 `T` 中属于 `U` 的部分移除，因此 `Result` 最终为 `"b" | "c"`。

### 8. **推断类型（Infer Types）**
`infer` 关键字用于在条件类型中声明一个待推断的类型变量。通常与条件类型结合使用，从复杂的类型结构中提取出某个部分。

**示例：**
```typescript
type ReturnType<T> = T extends (...args: any[]) => infer R ? R : any;

function example() {
  return "Hello";
}

type Result = ReturnType<typeof example>;  // string
```
在这个例子中，`ReturnType` 使用了 `infer` 关键字推断函数 `example` 的返回类型为 `string`。

### 9. **模板字面量类型（Template Literal Types）**
模板字面量类型允许通过模板字符串语法构建新的字符串类型。它与 JavaScript 的模板字符串类似，但用于类型构造。

**示例：**
```typescript
type Greeting = `Hello, ${string}`;

let greeting: Greeting = "Hello, Alice";  // 正确
```
模板字面量类型能够根据已有类型生成新的字符串类型。

### 10. **实用工具类型（Utility Types）**
TypeScript 提供了许多内置的实用工具类型，用于简化常见的类型转换操作。最常用的包括：
- **`Partial<T>`**：将类型 `T` 的所有属性变为可选。
- **`Required<T>`**：将类型 `T` 的所有属性变为必填。
- **`Readonly<T>`**：将类型 `T` 的所有属性变为只读。
- **`Pick<T, K>`**：从类型 `T` 中选取某些属性。
- **`Record<K, T>`**：构造一个对象类型，其键为类型 `K`，值为类型 `T`。

**示例：**
```typescript
type Person = {
  name: string;
  age: number;
};

type PartialPerson = Partial<Person>;  // { name?: string; age?: number; }
type ReadonlyPerson = Readonly<Person>;  // { readonly name: string; readonly age: number; }
```

### 总结
第 12 章深入探讨了 TypeScript 中的高级类型概念，包括交叉类型、联合类型、类型守卫、索引类型、映射类型、条件类型等。这些高级类型为开发者提供了强大的工具，可以处理复杂的类型约束，构建高度灵活且可维护的代码。通过合理使用这些类型特性，开发者可以提升代码的抽象能力，并实现更强的类型安全性。

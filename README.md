# Object-Oriented Programming Patterns

## Описание:

Шаблоны проектирования[^1] - это распространённые архитектурные подходы.

```text
|      Принципы программирования SOLID    |
|-------------|-------------|---------------|
| Порождающие | Структурные | Поведенческие |
```

---

## SOLID принципы

- [Принцип единственной ответственности](src/solid/README.md#srp)
- [Принцип открытости/закрытости](src/solid/README.md#ocp)
- [Принцип подстановки Лисков](src/solid/README.md#lsp)
- [Принцип разделения интерфейса](src/solid/README.md#isp)
- [Принцип инверсии зависимостей](src/solid/README.md#dip)

---

## Шаблоны

- Шаблоны проектирования обычно разделяют на три категории.
- Это категоризация Гаммы в честь Эриха Гаммы (член ["Банды четырех"](https://ru.wikipedia.org/wiki/Design_Patterns))

### 1. Порождающие

> - Помогают в создании (конструировании) объектов
> - Явно (конструктор) `vs` неявно (DI, рефлексия)
> - Одномоментно (за одно утверждение) `vs` по частям (пошагово)

- [Строитель](src/creational/builder/README.md)
- [Фабрики](src/creational/factories/README.md)
    - Абстрактная фабрика
    - Фабричный метод
- [Прототип](src/creational/prototype/README.md)
- [Одиночка](src/creational/singleton/README.md)

---

### 2. Структурные

> - Связаны с, собственно, структурой (напр. членам класса)
> - Многие шаблоны - обёртки, которые копируют интерфейс обёртываемого класса
> - Подчёркивают важность хорошего дизайна `API`

- [Адаптер](src/structural/adapter/README.md)
- [Мост](src/structural/bridge/README.md)
- [Компоновщик](src/structural/composite/README.md)
- [Декоратор](/src/structural/decorator/README.md)
- [Фасад](src/structural/facade/README.md)
- [Приспособленец](src/structural/flywieght/README.md)
- [Заместитель](src/structural/proxy/README.md)

---

### 3. Поведенческие

> - Все разные: нет единой темы
> - Решают задачи эффективного и безопасного взаимодействия между объектами программы.


- [Цепочка обязанностей](src/behavioral/chain_of_responsibility/README.md)
- [Команда](src/behavioral/command/README.md)
- [Интерпретатор](src/behavioral/interpreter/README.md)
- [Итератор](src/behavioral/iterator/README.md)
- Посредник
- Хранитель
- Наблюдатель
- Состояние
- Стратегия
- Шаблонный метод
- Посетитель

---

## Автор: [Shoxrux Yuldashov](https://github.com/shyuldashov)

[^1]: Source [Design Patterns](https://www.oodesign.com/)

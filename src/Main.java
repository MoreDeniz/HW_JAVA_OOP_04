// Реализовать класс для работы с одномерными динамическими массивами
// произвольных данных(произвольного типа).
// Класс будет иметь следующие конструкторы:
//1. Конструктор без параметров – конструктор по умолчанию,
//   проводяющий базовую иницаилизацию массива
//2. Конструктор с параметром T[] – конструктор, который проводит
//   инициализацию и заполняет массив данными, пришедшими из параметра

//Так же класс будет иметь следующие публичные методы:
//1. Вставка в массив
//2. Удаление элемента по индексу
//3. Удаление всех элементов с заданным значением
//4. Поиск минимума
//5. Поиск максимума
//6. Поиск суммы элементов массива
//7. Поиск произведения элементов массива
//8. Поиск индекса заданного элемента в массиве, если такого элемента в массиве нет то возвращать -1
//9. Проверка наличия элемента в массиве. Возвращает true, если элемент в массиве есть, false – нет.
//10. Пузырьковая сортировка
//11. Сортировка простыми вставками
//12. Сортировка простым выбором
//13. Получение элемента массива по индексу
//14. Задание значения элементу массива с заданным индексом
//15. Печать массива на экран
//16. Длинна массива
//Так же класс должен содержать следующие приватные поля:
//1. Сам массив произвольных данных.
//2. Длинну массива

//*Так же массив должен содержать следующие перегруженные операторы:
//1. Оператор, получающий элемент по заданному индексу
//2. Оператор, позволяющий установить значение элемента по заданному индексу
//*Так же в случае, если могут произойти ошибки или некорретная работа
// в конструкторах или методах, необходимо использовать механизм исключений
// для обработки возможных ошибок.

public class Main {
    public static void main(String[] args) {
        Integer[] val = {20, 10, 12, 3, 14, 5};
        Integer[] val1 = {22, 12, 11, 3, 14, 15};
        Integer[] val3 = {22, 12, 11, 3, 14, 15};
        Double[] val2 = {3.5, 7.2, 9.1, 2.4, 12.6, 7.3};
        DynamicArray<Integer> di = new DynamicArray<>(val);
        DynamicArray<Integer> dI = new DynamicArray<>(new Integer[]{4, 2, 3, 5, 3});
        System.out.println("arrayPrint");
        dI.arrayPrint(dI.getAnyArray());

        System.out.println("getSumma");
        System.out.println(dI.sum());

        System.out.println("----------------------------------------------------------");
        System.out.println("------INTEGER-------");
        System.out.println("----------------------------------------------------------");
        //1. Вставка в массив по индексу
        System.out.println("insertToArray");
        dI.arrayPrint(dI.insertToArray(1, dI.getAnyArray(), 333));
        //1. Вставка в массив
        System.out.println("arrayInsert");
        dI.arrayPrint(dI.arrayInsert(dI.getAnyArray(), 777));
        //2. Удаление элемента по индексу
        System.out.println("removeByIndex");
        dI.arrayPrint(dI.removeByIndex(dI.getAnyArray(), 1));
        //3. Удаление всех элементов с заданным значением
        System.out.println("removeByValue");
        dI.arrayPrint(dI.removeByValue(dI.getAnyArray(), 3));
        //4. Поиск минимума
        System.out.println("getMin");
        System.out.println(dI.getMin());
        //5. Поиск максимума
        System.out.println("getMax");
        System.out.println(dI.getMax());
        //6. Поиск суммы элементов массива
        System.out.println("getSumma");
        System.out.println(dI.sum());
        //7. Поиск произведения элементов массива
        System.out.println("multi");
        System.out.println(dI.multi());
        //8. Поиск индекса заданного элемента в массиве
        System.out.println("getIndex");
        System.out.println(dI.getIndex(dI.getAnyArray(), 2));
        //9. Проверка наличия элемента в массиве
        System.out.println("existElem");
        System.out.println(dI.existElem(dI.getAnyArray(), 2));
        System.out.println("----------------------------------------------------------");
        DynamicArray<Integer> myArray = new DynamicArray<>(val);
        //10. Пузырьковая сортировка
        myArray.print();
        System.out.println("bubbleSort");
        myArray.bubbleSort();
        myArray.print();
        System.out.println("----------------------------------------------------------");
        //11. Сортировка простыми вставками
        DynamicArray<Integer> myArray1 = new DynamicArray<>(val1);
        myArray1.print();
        System.out.println("insertionSort");
        myArray1.insertionSort();
        myArray1.print();
        System.out.println("----------------------------------------------------------");
        //12. Сортировка простым выбором
        DynamicArray<Integer> myArray2 = new DynamicArray<>(val3);
        myArray2.print();
        System.out.println("selectionSort");
        myArray2.selectionSort();
        myArray2.print();
        System.out.println("----------------------------------------------------------");
        //13. Получение элемента массива по индексу
        System.out.println("Получение элемента массива по индексу");
        di.print();
        di.getElem(di, 2);
        //14. Задание значения элементу массива с заданным индексом
        System.out.println("Задание значения элементу массива с заданным индексом");
        di.setElem(111, 1);
        di.print();
        //15. Печать массива на экран
//        dI.print();
        //16. Длинна массива
        System.out.println("Длинна массива:");
        di.getLength();

        System.out.println("----------------------------------------------------------");
        System.out.println("------STRING-------");
        System.out.println("----------------------------------------------------------");

        DynamicArray<String> dS = new DynamicArray<>(new String[]{"a", "b", "c"});
        System.out.println("arrayPrint");
        dS.arrayPrint(dS.getAnyArray());
        //6. Поиск суммы элементов массива
        System.out.println("getSumma");
        System.out.println(dS.sum());
        //8. Поиск индекса заданного элемента в массиве
        System.out.println("searchIndex");
        System.out.println(dS.getIndex(dS.getAnyArray(), "a"));

        System.out.println("----------------------------------------------------------");
        System.out.println("------DOUBLE-------");
        System.out.println("----------------------------------------------------------");
        DynamicArray<Double> dD = new DynamicArray<>(new Double[]{1.5, 2.5, 3.5});
        System.out.println("arrayPrint");
        dD.arrayPrint(dD.getAnyArray());
        //6. Поиск суммы элементов массива
        System.out.println("getSumma");
        System.out.println(dD.sum());
        //7. Поиск произведения элементов массива
        System.out.println("multi");
        System.out.println(dD.multi());
        //8. Поиск индекса заданного элемента в массиве
        System.out.println("searchIndex");
        System.out.println(dD.getIndex(dD.getAnyArray(), 2.5));
        //12. Сортировка простым выбором
        System.out.println("----------------------------------------------------------");
        DynamicArray<Double> myArray3 = new DynamicArray<>(val2);
        myArray3.print();
        System.out.println("selectionSort");
        myArray3.selectionSort();
        myArray3.print();
        System.out.println("----------------------------------------------------------");
    }
}
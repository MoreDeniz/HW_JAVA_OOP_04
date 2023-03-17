// Реализовать класс для работы с одномерными динамическими массивами
// произвольных данных(произвольного типа).
// Класс будет иметь следующие конструкторы:
//1. Конструктор без параметров – конструктор по умолчанию,
//   проводяющий базовую иницаилизацию массива
//2. Конструктор с параметром T[] – конструктор, который проводит
//   инициализацию и заполняет массив данными, пришедшими из параметра

//Так же класс должен содержать следующие приватные поля:
//1. Сам массив произвольных данных.
//2. Длинну массива

import java.util.Arrays;

public class DynamicArray<T extends Comparable<T>> {
    private T[] anyArray;
    private int length;

    public DynamicArray(T[] anyArray) {
        this.length = anyArray.length;
        this.anyArray = anyArray;
    }

    DynamicArray(){
        this.length = 0;
        this.anyArray = (T[]) new Comparable[length];
    }

    public T[] getAnyArray() {
        return anyArray;
    }

    //1. Вставка в массив
    public T[] arrayInsert(T[] arr, T elemToAdd){
        T[] newArr = Arrays.copyOf(arr, arr.length+1);

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[newArr.length - 1] = elemToAdd;
        return newArr;
    }

    //1.1. Вставка в массив по индексу
    public T[] insertToArray(int index, T[] arr, T elemToInsert) {
        T[] newArr = Arrays.copyOf(arr, arr.length+1);
        int j = 0;
        for (int i = 0; i < newArr.length-1; i++) {
            if(i == index){
                newArr[i] = elemToInsert;
            } else {
                newArr[i] = arr[j];
                j++;
            }
        }
        newArr[newArr.length-1] = arr[arr.length-1];
        return newArr;
    }

    //2. Удаление элемента по индексу
    public T[] removeByIndex(T[] arr, int index) {
        if (index < 0 || index > arr.length) {
            throw new IndexOutOfBoundsException("Индекс за пределами массива!");
        }
        T[] newArr = Arrays.copyOf(arr, arr.length-1);
        for (int i = 0; i < arr.length-1; i++) {
            if(i == index) {
                for (int j = 0; j < i; j++) {
                    newArr[i] = arr[i];
                }
                for (int j = i; j < arr.length-1; j++) {
                    newArr[j] = arr[j+1];
                }
            }
        }
        return newArr ;
    }

    //3. Удаление всех элементов с заданным значением
    public T[] removeByValue(T[] arr, T elemToDelete) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Массив пуст!");
        }
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(elemToDelete)) {
                count++;
            } else {
                arr[i-count] = arr[i];
                }
            }
        length -= count;
        arr = Arrays.copyOf(arr, length);
        return arr;
    }

    //4. Поиск минимума
    public T getMin() {
        if (length == 0) {
            throw new IllegalArgumentException("Массив пуст!");
        }
        T min = anyArray[0];
        for (int i = 0; i < length; i++) {
            if (this.anyArray[i].compareTo(min) < 0){
                min = anyArray[i];
            }
        }
        return min;
    }

    //5. Поиск максимума
    public T getMax() {
        if (length == 0) {
            throw new IllegalArgumentException("Массив пуст!");
        }
        T max = anyArray[0];
        for (int i = 0; i < length; i++) {
            if (this.anyArray[i].compareTo(max) > 0){
                max = anyArray[i];
            }
        }
        return max;
    }

    //6. Поиск суммы элементов массива
    public Object sum(){
        if (anyArray[0] instanceof Integer) {
            Number sum = 0;
            for (int i = 0; i < length; i++) {
                sum = sum.intValue() + ((Number) anyArray[i]).intValue();
            }
            return sum;
        } else if (anyArray[0] instanceof Double) {
            Number sum = 0;
            for (int i = 0; i < length; i++) {
                sum = sum.doubleValue() + ((Number) anyArray[i]).doubleValue();
            }
            return sum;
        } else if (anyArray[0] instanceof Float) {
            Number sum = 0;
            for (int i = 0; i < length; i++) {
                sum = sum.floatValue() + ((Number) anyArray[i]).floatValue();
            }
            return sum;
        } else if (anyArray[0] instanceof String) {
            StringBuilder sum = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sum.append((String) anyArray[i]);
            }
            return sum;
        }
        return sum();
    }

    //7. Поиск произведения элементов массива
    public Object multi(){
        if (anyArray[0] instanceof Integer) {
            Number multi = 1;
            for (int i = 0; i < length; i++) {
                multi = multi.intValue() * ((Number) anyArray[i]).intValue();
            }
            return multi;
        } else if (anyArray[0] instanceof Double) {
            Number multi = 1.0;
            for (int i = 0; i < length; i++) {
                multi = multi.doubleValue() * ((Number) anyArray[i]).doubleValue();
            }
            return multi;
        } else if (anyArray[0] instanceof Float) {
            Number multi = 1.0f;
            for (int i = 0; i < length; i++) {
                multi = multi.floatValue() * ((Number) anyArray[i]).floatValue();
            }
            return multi;
        }
        return null;
    }

    //8. Поиск индекса заданного элемента в массиве, если такого элемента в массиве нет то возвращать -1
    public int getIndex(T[] arr, T elemToSearch){
        if (arr.length == 0) {
            throw new IllegalArgumentException("Массив пуст!");
        }
        for (int i = 0; i < arr.length; i++) {
            if (this.anyArray[i].equals(elemToSearch)) {
                return i;
            }
        }
        return -1;
    }

    //9. Проверка наличия элемента в массиве. Возвращает true, если элемент в массиве есть, false – нет.
    public boolean existElem(T[] arr, T elemToSearch){
        if (arr.length == 0) {
            throw new IllegalArgumentException("Массив пуст!");
        }
        for (int i = 0; i < arr.length; i++) {
            if (this.anyArray[i].equals(elemToSearch)) {
                System.out.println("Элемент: " + elemToSearch + " в массиве есть");
                return true;
            }
        }
        System.out.println("Элемента: " + elemToSearch + " в массиве нет");
        return false;
    }

    //10. Пузырьковая сортировка
    public void bubbleSort (){
        for (int i = 0; i < this.anyArray.length; i++) {
            for (int j = 0; j < anyArray.length - i - 1; j++) {
                if (this.anyArray[j].compareTo(this.anyArray[j + 1]) > 0) {
                    T temp = anyArray[j];
                    anyArray[j] = anyArray[j + 1];
                    anyArray[j + 1] = temp;
                }
            }
        }
    }

    //11. Сортировка простыми вставками
    public void insertionSort(){
        for (int i = 1; i < length; i++) {
            T temp = anyArray[i];
            int j = i - 1;
            while (j >= 0 && anyArray[j].compareTo(temp) > 0){
                anyArray[j + 1] = anyArray[j];
                j--;
            }
            anyArray[j + 1] = temp;
        }
    }

    //12. Сортировка простым выбором
    public void selectionSort(){
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (anyArray[j].compareTo(anyArray[minIndex]) < 0){
                    minIndex = j;
                }
            }
            T temp = anyArray[minIndex];
            anyArray[minIndex] = anyArray[i];
            anyArray[i] = temp;
        }
    }

    //13. Получение элемента массива по индексу
    public T getElem(DynamicArray<Integer> array, int index){
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Индекс вне массива!");
        }
        System.out.printf("Индекс: " + index + ", элемент: " + this.anyArray[index] + "\n");
        return this.anyArray[index];
    }

    //14. Задание значения элементу массива с заданным индексом
    public void setElem(T value, int index){
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Индекс вне массива!");
        } else {
            System.out.println("Индекс: " + index + ", Элемент: " + value);
            this.anyArray[index] = value;
        }
    }

    //15. Печать массива на экран
    public void arrayPrint(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }
    public void print() {
        System.out.println(Arrays.toString(this.anyArray));
    }

    //16. Длинна массива
    public int getLength()
    {
        System.out.println(length);
        return length;
    }
}

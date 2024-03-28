package task1;

import java.util.List;

public class Main {
    /*
    Напишите программу, которая использует Stream API для обработки списка чисел.
     Программа должна вывести на экран среднее значение всех четных чисел в списке.
    */
    public static void main(String[] args) {

        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println((list.stream()
                .filter(i -> i % 2 == 0)
                .reduce(Integer::sum).get() / list.stream()
                                                  .filter(i -> i % 2 == 0)
                                                  .toList().size()));

    }
}

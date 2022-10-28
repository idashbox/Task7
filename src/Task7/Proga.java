package Task7;

import java.util.Scanner;

public class Proga {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runTest(Tests.test1, 18, 2);
        runTest(Tests.test2, 17, 1);
        runTest(Tests.test3, 11, 10);
        runTest(Tests.test4, 3, 5);
        runTest(Tests.test5, 1, 9);
        runTest(Tests.test6, 15, 16);
        runTest(Tests.test7, 14, 8);
        runTest(Tests.test8, 9, 10);
        runTest(Tests.test9, 14, 1);
        runTest(Tests.test10, 20, 10);
        getSolution(getArray());
    }

    static int[] solution(int[] array) {
        int index = 0;
        int sizeMax = 0;
        int size;
        int flag_e = 1;
        for (int i = 0; i < array.length; i++) {
            size = 1;
            int[] massive = new int[array.length];
            for (int b : massive) {
                massive[b] = -100000;
            }
            massive[0] = array[i];
            for (int j = i + 1; j < array.length; j++) {
                for (int e = 0; e < size; e++) {
                    if (array[j] == massive[e]) {
                        flag_e = 0;
                        break;
                    } else {
                        flag_e = 1;
                    }
                }
                if (size >= sizeMax) {
                    sizeMax = size;
                    index = i;
                }
                if (flag_e == 1) {
                    massive[j - i] = array[j];
                    size++;
                } else {
                    break;
                }
                if (size >= sizeMax) {
                    sizeMax = size;
                    index = i;
                }
            }
            if (sizeMax == 1) {
                index = array.length - 1;
            }
        }
        return new int[]{sizeMax, index};
    }

    static void getSolution(int[] array) {
        System.out.println("Самая длинная последовательность равна " + solution(array)[0]);
        System.out.println("Индекс её первого элемента - " + solution(array)[1]);
    }

    public static int[] getArray() {
        System.out.println("Введите длину массива:");
        int razmer;
        razmer = scanner.nextInt();
        int[] array;
        array = new int[razmer];
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.printf("Введите %s-й член массива: ", i);
            int num;
            num = scanner.nextInt();
            array[i] = num;
        }
        return array;
    }
    static void runTest(int[] array, int length, int index) {
        int testResultLength = solution(array)[0];
        int testResultIndex = solution(array)[1];
        if (length == testResultLength && index == testResultIndex) {
            System.out.println("Всё верно, ошибок нет.");
        } else if (length != testResultLength && index == testResultIndex) {
            System.out.printf("Индекс указан верно, однако длина %s не верная.", length);
            System.out.println();
        } else if (length == testResultLength && index != testResultIndex) {
            System.out.printf("Длина указан верно, однако индекс %s не верный.", index);
            System.out.println();
        } else {
            System.out.printf("Длина %s не верная и индекс %s не верный.", length, index);
            System.out.println();
        }
    }
}

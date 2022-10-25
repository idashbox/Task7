package Task7;


import java.util.*;


public class Prog {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        solution(Tests.test1);
        solution(Tests.test2);
        solution(Tests.test3);
        solution(Tests.test4);
        solution(Tests.test5);
        solution(Tests.test6);
        solution(Tests.test7);
        solution(Tests.test8);
        solution(Tests.test9);
        solution(Tests.test10);
        solution(getArray());
    }
    static void solution(int [] array){

        Set<Integer> hashSet = new LinkedHashSet<>();
        Set<Integer> resultHashSet = new LinkedHashSet<>();
        Set<Integer> numbers = new LinkedHashSet<>();
        Set<Integer> resultNumbers = new LinkedHashSet<>();
        System.out.println("----------------");
        System.out.println("Список чисел: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (hashSet.contains(array[i])) {
                if (resultHashSet.size() < hashSet.size()){
                    resultHashSet = new LinkedHashSet<>(hashSet);
                    resultNumbers = new LinkedHashSet<>(numbers);}
                hashSet.clear();
                numbers.clear();
                hashSet.add(array[i]);
                numbers.add(i);
            } else{
                hashSet.add(array[i]);
                numbers.add(i);}
            if (i == array.length-1) {
                hashSet.add(array[i]);
                numbers.add(i);
                if (resultHashSet.size() < hashSet.size())
                    resultHashSet = new LinkedHashSet<>(hashSet);
                    resultNumbers = new LinkedHashSet<>(numbers);
            }
        }
        int i = 0;
        Iterator<Integer> resultIterator = resultHashSet.iterator();
        System.out.println("Самая длинная последовательность: ");
        while (resultIterator.hasNext()) {
            System.out.print(" [" + resultIterator.next() + "]");
            i ++;
        }
        //неправильно выводит индекс первого члена, если первый
        // член последней и предыдущей последовательности одинаковы
        System.out.println();
        System.out.println("Длина самой длинной последовательности: " + i);
        System.out.println("Индекс первого числа последовательности: " + resultNumbers.toArray()[0]);
        System.out.println("----------------");
    }
    public static int[] getArray(){
        System.out.println("Введите длину массива:");
        int razmer;
        razmer = scanner.nextInt();
        int[] array;
        array = new int[razmer];
        for (int i = 0; i <= array.length-1; i++){
            System.out.printf("Введите %s-й член массива: ", i);
            int num;
            num = scanner.nextInt();
            array[i] = num;
        }
        return array;
    }
}



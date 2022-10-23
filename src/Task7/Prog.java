package Task7;


import java.util.*;


public class Prog {
    public static void main(String[] args) {
        int[] test1 = {303, 77, 295, 203, 466, 77, 248, 485, 227, 369, 323, 285, 123, 270, 450, 133, 43, 9, 462, 209};

        Set<Integer> hashSet = new LinkedHashSet<>();
        Set<Integer> resultHashSet = new LinkedHashSet<>();
        Set<Integer> numbers = new LinkedHashSet<>();
        Set<Integer> resultNumbers = new LinkedHashSet<>();

        System.out.println("Список чисел: " + Arrays.toString(test1));
        for (int i = 0; i < test1.length; i++) {
            if (hashSet.contains(test1[i])) {
                if (resultHashSet.size() < hashSet.size())
                    resultHashSet = new LinkedHashSet<>(hashSet);
                    resultNumbers = new LinkedHashSet<>(numbers);
                hashSet.clear();
                numbers.clear();
                hashSet.add(test1[i]);
                numbers.add(i);
            } else
                hashSet.add(test1[i]);
                numbers.add(test1[i]);
            if (i == test1.length-1) {
                hashSet.add(test1[i]);
                numbers.add(i);
                if (resultHashSet.size() < hashSet.size())
                    resultHashSet = new LinkedHashSet<>(hashSet);
                    resultNumbers = new LinkedHashSet<>(numbers);
            }
        }
        Iterator<Integer> resultIteratorN = resultNumbers.iterator();
        int i = 0;
        Iterator<Integer> resultIterator = resultHashSet.iterator();
        System.out.println("Самая длинная последовательность: ");
        while (resultIterator.hasNext()) {
            System.out.print(" [" + resultIterator.next() + "]");
            i ++;
        }
        System.out.println();
        System.out.println("Длина самой длинной последовательности: " + i);
        System.out.println("Индекс первого числа последовательности: " + resultIteratorN.next());
    }
}



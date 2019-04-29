import java.util.Arrays;
import java.util.List;

public class BubbleSortDemo {


    public static void bubbleSort(int[] arr) {
        if (arr.length <= 1) {
            System.out.println(arr);
        }
        for (int i = 0; i < arr.length; i++) {
//            System.out.println("================");
//            System.out.println("i 为" + i);
//            System.out.println("================");
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] >arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }

            }
//            System.out.println("================");
        }

//        System.out.println(arr);
    }

    public static void main(String[] args) {

//        BubbleSortDemo bubbleSortDemo = new BubbleSortDemo();
        int[] arr = {3, 9, 5, 11, 1, 6};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("=================");
        String[] arrStr = {"1", "2", "3"};
        List<String> list = Arrays.asList(arrStr);
        list.add("4");

        // Exception in thread "main" java.lang.UnsupportedOperationException
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=================");
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("=================");

    }
}

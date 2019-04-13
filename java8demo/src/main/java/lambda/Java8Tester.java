package lambda;

public class Java8Tester {

    public static void main(String[] args) {
        Java8Tester demo = new Java8Tester();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;
        //不用声明类型
        MathOperation subtraction = (a, b) -> a - b;
        //大括号中返回语句
        MathOperation multiplication = (a, b) -> {
            return a * b;
        };
        //没有大括号及返回语句
        MathOperation division = (a, b) -> a / b;

        System.out.println("10 + 2" + demo.operate(10, 2, addition));
        System.out.println("10 -2" + demo.operate(10, 2, subtraction));
        System.out.println("10 * 2" + demo.operate(10, 2, multiplication));
        System.out.println("10 / 2" + demo.operate(10, 2, division));

        GreetingService service1 = (params) -> System.out.println("hello " + params);
        service1.sayMessage("Lambda");

    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}

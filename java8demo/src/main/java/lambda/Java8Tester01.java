package lambda;

public class Java8Tester01 {

    /**
     * lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在lambda 内部修改定义在域外的局部变量，否则会编译错误。
     *
     * lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有final 的语义）
     * @param args
     */
    public static void main(String[] args) {

        int num = 2;
        Converter<Integer, String> converter = param -> System.out.println(String.valueOf(param + num));
        converter.convert(2);
    }



    public interface Converter<T1, T2> {
        void convert(int i);
    }
}

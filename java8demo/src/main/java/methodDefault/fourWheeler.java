package methodDefault;

public interface fourWheeler {
    default void print(){
        System.out.println("我是一辆四轮车!");
    }
}

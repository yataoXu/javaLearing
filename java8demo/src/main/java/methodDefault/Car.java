package methodDefault;

/**
 * @ Author : Evan.
 * @ Description :
 * @ Date : Crreate in 2019/4/15 9:22
 * @Mail : xuyt@zendaimoney.com
 */
public class Car implements vehicle, fourWheeler {
    @Override
    public void print() {
        System.out.println("我是一辆四轮汽车!");
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.print();

    }
}

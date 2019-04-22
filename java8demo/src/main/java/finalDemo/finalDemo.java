package finalDemo;


import java.util.Random;

public class finalDemo {

    public static void main(String[] args) {
        Thread1 mt1 = new Thread1("A");
//        Thread1 mt2 = new Thread1("B");
        mt1.start();
//        mt2.start();
    }
}

class Thread1 extends Thread {

    private String name;

    public Thread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            final Person person = new Person();
            person.setAge((int)(Math.random()*100));
            System.out.println(name +"运行"+ person.toString());
        }
    }
}
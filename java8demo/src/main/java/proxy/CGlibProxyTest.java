package proxy;

public class CGlibProxyTest {
    public static void main(String[] args) {
        // 目标对象
        UserDao target = new UserDao();
        // 代理对象
        UserDao proxy = (UserDao) new CGlibProxy(target).getProxyInstance();
        proxy.save();
    }
}

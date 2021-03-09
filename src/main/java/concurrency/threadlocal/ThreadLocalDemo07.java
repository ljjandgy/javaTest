package concurrency.threadlocal;

/**
 * ThreadLocal的第二种应用场景，用于存放线程私有的，需要线程运行中不断被使用到的对象信息。比如用户信息。这样能在保证对象线程安全的情况下，也能减少对象的传递。使得代码更加优雅。
 */
public class ThreadLocalDemo07 {
    public static void main(String[] args) {
        new Service1().service1();

    }
}

class Service1 {

            public void service1() {
                User user = new User("拉勾教育");
                UserContextHolder.holder.set(user);
                new Service2().service2();
            }
        }

class Service2 {

            public void service2() {
                User user = UserContextHolder.holder.get();
                System.out.println("Service2拿到用户名：" + user.name);
                new Service3().service3();
            }
        }

class Service3 {

            public void service3() {
                User user = UserContextHolder.holder.get();
                System.out.println("Service3拿到用户名：" + user.name);
                UserContextHolder.holder.remove();
            }
        }

class UserContextHolder {

            public static ThreadLocal<User> holder = new ThreadLocal<>();
        }

class User {

            String name;

            public User(String name) {
                this.name = name;
            }
}

package pattern.singleton;
//参考博客：
//URL=https://blog.csdn.net/dmk877/article/details/50311791

//两种写法中懒汉式其实是存在线程安全问题的，
// 喜欢刨根问题的同学可能会问，存在怎样的线程安全问题？
// 怎样导致这种问题的？好，我们来说一下什么情况下这种写法会有问题。
// 在运行过程中可能存在这么一种情况：有多个线程去调用getInstance方法来获取Singleton的实例，
// 那么就有可能发生这样一种情况当第一个线程在执行if(instance==null)这个语句时，
// 此时instance是为null的进入语句。
// 在还没有执行instance=new Singleton()时(此时instance是为null的)第二个线程也进入if(instance==null)这个语句，
// 因为之前进入这个语句的线程中还没有执行instance=new Singleton()，
// 所以它会执行instance=new Singleton()来实例化Singleton对象，
// 因为第二个线程也进入了if语句所以它也会实例化Singleton对象。
// 这样就导致了实例化了两个Singleton对象。
// 所以单例模式的懒汉式是存在线程安全问题的，既然它存在问题，那么可能有解决这个问题的方法，
// 那么究竟怎么解决呢？
public class LazySingleton {//单例模式的懒汉式[线程不安全，不可用]
    private static LazySingleton instance = null;
    private LazySingleton(){};
    public static LazySingleton getInstance(){
        if(instance == null)
            instance = new LazySingleton();
        return instance;
    }
}

//加锁，懒汉式线程安全的[线程安全，效率低不推荐使用]
//缺点：效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。
// 而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，
// 直接return就行了。方法进行同步效率太低要改进。
class LazyLockSingleton{
    private static LazyLockSingleton instance = null;
    private LazyLockSingleton(){};
    public static synchronized LazyLockSingleton getInstance(){
        if(instance == null)
            instance = new LazyLockSingleton();
        return instance;
    }
}

//单例模式懒汉式[线程不安全，不可用]
//其实这种写法跟4.3一样是线程不安全的，
// 当一个线程还没有实例化Singleton时另一个线程执行到if(instance==null)这个判断语句时就会进入if语句，
// 虽然加了锁，但是等到第一个线程执行完instance=new Singleton()跳出这个锁时，
// 另一个进入if语句的线程同样会实例化另外一个Singleton对象，
// 线程不安全的原理跟4.3类似。
// 因此这种改进方式并不可行，经过大神们一步一步的探索，写出了懒汉式的双重校验锁。
class LazyLockSingleton_1{
    private static LazyLockSingleton_1 instance = null;
    private LazyLockSingleton_1(){};
    public static LazyLockSingleton_1 getInstance(){
        if(instance == null) {
            synchronized (LazyLockSingleton_1.class) {
                instance = new LazyLockSingleton_1();
            }
        }
        return instance;
    }
}
//单例模式懒汉式双重校验锁[推荐用]
/**
 * 懒汉式变种，属于懒汉式中最好的写法，保证了：延迟加载和线程安全
 */
class LazyDoubleCheckSingleton{
    private static LazyDoubleCheckSingleton instance = null;
    private LazyDoubleCheckSingleton(){};
    public static LazyDoubleCheckSingleton getInstance(){
        if(instance == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new LazyDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}

///内部类[推荐用]
//这种方式跟饿汉式方式采用的机制类似，
// 但又有不同。两者都是采用了类装载的机制来保证初始化实例时只有一个线程。
// 不同的地方在饿汉式方式是只要Singleton类被装载就会实例化，没有Lazy-Loading的作用，
// 而静态内部类方式在Singleton类被装载时并不会立即实例化，
// 而是在需要实例化时，调用getInstance方法，才会装载SingletonHolder类，从而完成Singleton的实例化。
//类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，
// 在类进行初始化时，别的线程是
//无法进入的。
class InnerClassSingleton {
    private InnerClassSingleton() {};

    private static class SingletonHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.instance;
    }
}

//枚举[极推荐使用]
//SingletonEnum.instance.method();
//可以看到枚举的书写非常简单，访问也很简单
// 在这里SingletonEnum.instance这里的instance即为SingletonEnum类型的引用
// 所以得到它就可以调用枚举中的方法了。
//借助JDK1.5中添加的枚举来实现单例模式。
// 不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
// 可能是因为枚举在JDK1.5中才添加，所以在实际项目开发中，很少见人这么写过，
// 这种方式也是最好的一种方式，如果在开发中JDK满足要求的情况下建议使用这种方式。
enum SingletonEnum{
    instance;
    private SingletonEnum(){}
    public void method(){}
}


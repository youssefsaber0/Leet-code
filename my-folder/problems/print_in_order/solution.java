class Foo {
    private Lock lock ;
    private final Condition one;
    private final Condition two;
    private  boolean Condition_one;
    private  boolean Condition_two;
    public Foo() {
        lock = new ReentrantLock();
         one = lock.newCondition();
         two = lock.newCondition();
         Condition_one = false;
         Condition_two = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        Condition_one = true;
        one.signal();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        if(!Condition_one){
             one.await();   
        }
        Condition_two =  true;
        two.signal();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        if(!Condition_two){
             two.await();   
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        lock.unlock();
    }
}
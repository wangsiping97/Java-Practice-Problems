package printer;

class Test implements Runnable {
    public void run() {
        for (int i = 1; i <= 100; ++i) 
            System.out.println("Runnable prints: " + i);
    }
    public static void main (String[] args) {
        Test test = new Test();
        Thread t1 = new Thread(test);
        MyThread t2 = new MyThread();
        t2.setPriority(8);
        t1.start();
        t2.start();
    }
}

class MyThread extends Thread {
    public void run () {
        for (int i = 1; i <= 100; ++i) 
            System.out.println("Thread prints: " + i);
    }
}
//https://leetcode.com/problems/print-zero-even-odd
import java.util.concurrent.*;
class ZeroEvenOdd {
    private int n;
    int curr;
    Semaphore s1,s2,s3;
    public ZeroEvenOdd(int n) {
        this.n = n;
        s1= new Semaphore(1);
        s2= new Semaphore(0);
        s3= new Semaphore(0);
    }
    public void zero(IntConsumer printNumber) throws InterruptedException {
        boolean turn = false;
        for(int i = 0 ; i < n ; i++) {
            s1.acquire();
            printNumber.accept(0);
            if(turn) {
               s2.release(); 
            }
            else {
               s3.release(); 
            }
            turn = !turn;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2 ; i <= n ; i += 2) {
            s2.acquire();
            printNumber.accept(i);
            s1.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1 ; i <= n ; i += 2) {
            s3.acquire();
            printNumber.accept(i);
            s1.release();
        }
    }
}
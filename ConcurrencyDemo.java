class NumberTask implements Runnable {

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println(
                    "[" + Thread.currentThread().getName()
                    + "] Number: " + i
            );

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class LetterTask implements Runnable {

    @Override
    public void run() {

        for (char ch = 'A'; ch <= 'E'; ch++) {

            System.out.println(
                    "[" + Thread.currentThread().getName()
                    + "] Letter: " + ch
            );

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class ConcurrencyDemo {

    public static void main(String[] args) {

        NumberTask numberTask = new NumberTask();
        LetterTask letterTask = new LetterTask();

        Thread numberThread =
                new Thread(numberTask, "Thread-Numbers");

        Thread letterThread =
                new Thread(letterTask, "Thread-Letters");

        numberThread.start();
        letterThread.start();
    }
}
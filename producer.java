import java.util.*;


class PnC {
    public static void main(String[] args) {
        
        ArrayList buffer = new ArrayList<Integer>();

        Thread producer = new Producer(buffer);
        Thread consumer = new Consumer(buffer);
        
        producer.start();
        consumer.start();
    }
    
}

class Producer extends Thread {
    
    ArrayList<Integer> buffer;
    Random random = new Random();

    public Producer(ArrayList<Integer> buff) {
        buffer = buff;
    }

    public void run() {

        while(true) {
            try {
                System.out.println("Producer:");
                if (buffer.size() < 10){
                    buffer.add(random.nextInt(100));
                    System.out.println(buffer);
                    Thread.sleep(random.nextInt(40) + 10);
    
                } else {
                    System.out.println("Buffer full");
                    Thread.sleep(random.nextInt(40) + 10);
                }
    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
   
}

class Consumer extends Thread {
    
    ArrayList<Integer> buffer;
    Random random = new Random();

    public Consumer(ArrayList<Integer> buff) {
        buffer = buff;
    }

    public void run() {
        
        while(true) {
            try {
                System.out.println("Consumer:");
                if (buffer.size() > 0){
                    buffer.remove(buffer.size() - 1);
                    System.out.println(buffer);
                    Thread.sleep(random.nextInt(40) + 10);
    
                } else {
                    System.out.println("Buffer empty");
                    Thread.sleep(random.nextInt(40) + 10);
                }
    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
   
}
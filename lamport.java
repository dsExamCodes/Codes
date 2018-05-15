import java.util.*;

class lamport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lamport lm = new Lamport();

        System.out.println("Enter ticks for clock 1,clock 2");
        int tick1 = sc.nextInt();
        int tick2 = sc.nextInt();
        System.out.println("\nInitial Ticks:\n");
        lm.normalSequencePrinter(tick1);
        lm.normalSequencePrinter(tick2);

        System.out.println("\nEnter which clock sends message");
        int initiator = sc.nextInt();

        System.out.println("\nEnter message start time and end time");
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        lm.printClock(tick1, tick2, start, end, initiator);

    }

    void printClock(int tick1,int tick2, int start, int end, int initiator) {

        Lamport lm = new Lamport();

        if (start < end) {
            
            System.out.println("\nNo Updates:\n");
            lm.normalSequencePrinter(tick1);
            
            lm.normalSequencePrinter(tick2);

        } else {
            

            if (initiator == 1) {

                System.out.println("\nUpdates To Clock 2:\n");
                lm.normalSequencePrinter(tick1);

                lm.updateSequencePrinter(tick2, start, end);

            } else {
                System.out.println("\nUpdates To Clock 1:\n");
                lm.updateSequencePrinter(tick1, start, end);

                lm.normalSequencePrinter(tick2);

            }
        }
    }

    void normalSequencePrinter(int tick){
        int time= 1;
            for ( int i = 1; i < 20; i++) {
                System.out.print(time+" ");
                time += tick;
            }
            System.out.println();
    }

    void updateSequencePrinter(int tick,int sendTime, int recTime ){

        int time = 1;
        int count = 1;
        while(time < recTime) {
            System.out.print(time +" ");
            time += tick;
            count += 1;
        }

        time = sendTime + 1;

        for ( int i = count; i < 20; i+= 1) {
            System.out.print(time + " ");
            time += tick;
        }
        System.out.println();
    }
}

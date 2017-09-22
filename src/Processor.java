import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Processor {
    public void processWorkOrders() {
        moveIt();
        readIt();
    }

    private void moveIt() {
        // move work orders in map from one state to another
        while (){
            Map<Status, WorkOrder> initial = new HashMap<>();
            System.out.println(initial);

//        INITIAL to ASSIGNED
            Map<Status, WorkOrder> assigned = new HashMap<>();
            System.out.println(assigned);

//        ASSIGNED to IN_PROGRESS
            Map<Status, WorkOrder> in_progress = new HashMap<>();
            System.out.println(in_progress);

//        IN_PROGRESS to DONE
            Map<Status, WorkOrder> done = new HashMap<>();
            System.out.println(done);

        }
        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void readIt() {
        // read the json files into WorkOrders and put in map

        File currentDirectory = new File(".");
        File files[] = currentDirectory.listFiles();
        for (File f : files) {
            if (f.getName().endsWith(".json")) {
                // f is a reference to a json file
                try {
                    FileReader fileReader = new FileReader(f);
                    f.delete();
                    System.out.println(workOrder);
                    workOrder.add(moveIt());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                // f.delete(); will delete the file
            }
        }

    }

    public static void main(String args[]) {
        Processor processor = new Processor();
        processor.processWorkOrders();
    }
}


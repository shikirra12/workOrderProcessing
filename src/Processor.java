import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Processor {

    public void processWorkOrders() {
        while (true){
            moveIt();
            readIt();
        }
        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void moveIt() {
        // move work orders in map from one state to another
//        Map<Status, Set<WorkOrder>> allWorkOrders = new HashMap<>();



//        for (Status status: Status.values()){
//            allWorkOrders.put(status, new Set<WorkOrder>);
//        }
//
//        System.out.println("This is the initial state: " + allWorkOrders);
//
////        Map<Status, Set<WorkOrder>> done = new HashMap<>();
////        Map<Status, Set<WorkOrder>> in_progress = new HashMap<>();
////        Map<Status, Set<WorkOrder>> assigned = new HashMap<>();
//
//
//
//
//            //        IN_PROGRESS to DONE
//            Map<Status, Set<WorkOrder>> done = new HashMap<>();
//            System.out.println(done);
//
//            //        ASSIGNED to IN_PROGRESS
//            Map<Status, Set<WorkOrder>> in_progress = new HashMap<>();
//            System.out.println(in_progress);
//
////        INITIAL to ASSIGNED
//            Map<Status, Set<WorkOrder>> assigned = new HashMap<>();
//            System.out.println(assigned);
//
//
//        try {
//            Thread.sleep(5000l);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }


    private void readIt() {
        // read the json files into WorkOrders and put in map

//        File currentDirectory = new File(".");
//        File files[] = currentDirectory.listFiles();
//        for (File f : files) {
//            if (f.getName().endsWith(".json")) {
//                // f is a reference to a json file
//                ObjectMapper mapper = new ObjectMapper();
//
//                try {
//                    WorkOrder jsonToString = mapper.readValue(f, WorkOrder.class);
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                try {
//
//                    FileReader fileReader = new FileReader(f);
////                    f.delete() = Status.Done;
//                    System.out.println(workOrder);
//                    workOrder.put(moveIt());
//                } catch (FileNotFoundException e1) {
//                    e1.printStackTrace();
//                }
//                // f.delete(); will delete the file
//            }
//        }
//
    }

    public static void main(String args[]) {
        Processor processor = new Processor();
        processor.processWorkOrders();
    }
}


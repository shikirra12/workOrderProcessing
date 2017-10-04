import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Processor {

    Map<Status, Set<WorkOrder>> allWorkOrders = new HashMap<>();

    public Processor (){
        for(Status status : Status.getAllStatus()){
            allWorkOrders.put(status, new HashSet<WorkOrder>());
        }
    }

    public void processWorkOrders() {
        try {
            while (true) {
                readIt();
                moveIt();
                Thread.sleep(5000l);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
//        }

        }
    }

    private void moveIt() {
        // move work orders in map from one state to another

        Set<WorkOrder> inProgressOrders = allWorkOrders.get(Status.IN_PROGRESS);
        if (inProgressOrders.size() > 0){
            WorkOrder firstInProgress = inProgressOrders.iterator().next();
            inProgressOrders.remove(firstInProgress);
            firstInProgress.setStatus(Status.DONE);
            allWorkOrders.get(Status.DONE).add(firstInProgress);
        }

        Set<WorkOrder> assignedOrders = allWorkOrders.get(Status.ASSIGNED);
        if (assignedOrders.size() > 0){
            WorkOrder firstInProgress = assignedOrders.iterator().next();
            assignedOrders.remove(firstInProgress);
            firstInProgress.setStatus(Status.IN_PROGRESS);
            allWorkOrders.get(Status.IN_PROGRESS).add(firstInProgress);
        }

        Set<WorkOrder> initialOrders = allWorkOrders.get(Status.INITIAL);
        if (initialOrders.size() > 0){
            WorkOrder firstInProgress = initialOrders.iterator().next();
            initialOrders.remove(firstInProgress);
            firstInProgress.setStatus(Status.ASSIGNED);
            allWorkOrders.get(Status.ASSIGNED);
        }

        System.out.println("This is the initial state: " + allWorkOrders);
        System.out.println("Initial WorkOrders :" + initialOrders);
        System.out.println("Assigned WorkOrders :" + assignedOrders);
        System.out.println("In Progress WorkOrders: " + inProgressOrders);
        System.out.println("Completed WorkOrders: " + allWorkOrders);

    }


    private void readIt() {
        // read the json files into WorkOrders and put in map
        Set<WorkOrder> putInSystem = new HashSet<>();

        File currentDirectory = new File( ".");
        File files[] = currentDirectory.listFiles();
        for (File f : files) {
            if (f.getName().endsWith(".json")) {
                // f is a reference to a json file
                ObjectMapper mapper = new ObjectMapper();

                try {
                    WorkOrder workOrder = mapper.readValue(f, WorkOrder.class);
                    putInSystem.add(workOrder);
                    allWorkOrders.put(Status.INITIAL, putInSystem);
                    System.out.println("This is the workOrder: " + workOrder);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String args[]) {
        Processor processor = new Processor();
        processor.processWorkOrders();
    }
}


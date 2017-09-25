import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Creator {
    public void createWorkOrders() {
        // read input, create work orders and write as json files
        WorkOrder workOrder = new WorkOrder();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Give description of Workorder");
        String descriptionInput = scanner.nextLine();
        workOrder.setDescription(descriptionInput);

        System.out.println("What's your name?");
        String senderNameInput = scanner.nextLine();
        workOrder.setSenderName(senderNameInput);


        workOrder.setStatus(Status.INITIAL);
        WorkOrder.newWorkOrderCount++;
        workOrder.setId(WorkOrder.newWorkOrderCount);


        try {
            System.out.println(workOrder);
            String fileName = workOrder.getId() + ".json";
            File newFile = new File(fileName);
            FileWriter fileWriter = new FileWriter(newFile);
            System.out.println(fileName);


            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(workOrder);

            fileWriter.write(json);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {
        Creator creator = new Creator();
//        creator.createWorkOrders();

        while (true){
            creator.createWorkOrders();
        }
    }
}

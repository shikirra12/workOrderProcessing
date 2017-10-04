import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.description;

public class Creator {
    public void createWorkOrders() {
        // read input, create work orders and write as json files
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;
        while (shouldContinue){
            createWorkOrder();
            System.out.println("Would you like to continue?");
            System.out.println("0: No");
            System.out.println("Any other number: Continue");

            int input = scanner.nextInt();
            shouldContinue = input != 0;
        }
    }

    public void createWorkOrder(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give description of Workorder");
        String description = scanner.nextLine();

        System.out.println("What's your name?");
        String senderName = scanner.nextLine();

        WorkOrder workOrder = new WorkOrder(description, senderName, Status.INITIAL);
        workOrder.setDescription(description);
        workOrder.setSenderName(senderName);
        workOrder.setStatus(Status.INITIAL);


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

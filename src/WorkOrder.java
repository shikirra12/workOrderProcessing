public class WorkOrder {
    private int id;
    private String description;
    private String senderName;
    private Status status;
    private static int newWorkOrderCount = 0;

    public WorkOrder(String description, String senderName, Status initial) {
        this.id = getNextId();
    }

    public WorkOrder(int id, String description, String senderName, Status status) {
        this.id = getNextId();
        this.description = description;
        this.senderName = senderName;
        this.status = status;
    }

    public static int getNextId(){
        return newWorkOrderCount++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}

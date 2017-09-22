public class WorkOrder {
    int id;
    String description;
    String senderName;
    Status status;

    public WorkOrder() {
    }

    public WorkOrder(int id, String description, String senderName, Status status) {
        this.id = id;
        this.description = description;
        this.senderName = senderName;
        this.status = status;
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

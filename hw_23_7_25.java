// Class for each dispatch request
class Request {
    String storeName;
    String productId;
    int quantity;
    Request next;
    public Request(String storeName, String productId, int quantity) {
        this.storeName = storeName;
        this.productId = productId;
        this.quantity = quantity;
        this.next = null;
    }
}
// Queue class using linked list
class DispatchQueue {
    Request front = null, rear = null;
    // Add request to the queue
    void addRequest(String storeName, String productId, int quantity) {
        Request newRequest = new Request(storeName, productId, quantity);
        if (rear == null) {
            front = rear = newRequest;
        } else {
            rear.next = newRequest;
            rear = newRequest;
        }
        System.out.println("Added: " + storeName + ", Product: " + productId + ", Quantity: " + quantity);
    }
    // Process the front request
    void processRequest() {
        if (front == null) {
            System.out.println("No requests to process.");
            return;
        }
        System.out.println("Processing: " + front.storeName + ", Product: " + front.productId + ", Quantity: " + front.quantity);
        front = front.next;

        if (front == null) {
            rear = null;
        }
    }
    // Show all requests in the queue
    void showRequests() {
        if (front == null) {
            System.out.println("No pending requests.");
            return;
        }
        System.out.println("\nPending Requests:");
        Request temp = front;
        while (temp != null) {
            System.out.println(temp.storeName + " - " + temp.productId + " - Qty: " + temp.quantity);
            temp = temp.next;
        }
    }
}
// Main class
public class Main {
    public static void main(String[] args) {
        DispatchQueue queue = new DispatchQueue();
        queue.addRequest("Store A", "P1", 10);
        queue.addRequest("Store B", "P2", 5);
        queue.addRequest("Store C", "P3", 8);
        queue.showRequests();
        queue.processRequest();
        queue.processRequest();
        queue.showRequests();
        queue.processRequest();
        queue.processRequest(); // Trying to process when queue is empty
    }
}

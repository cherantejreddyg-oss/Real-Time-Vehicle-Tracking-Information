package VehicleMonitoring;

public class VehicleHistory {

    private Node head;

    public void addUpdate(Vehicle v) {

        Node newNode = new Node(v);

        if (head == null) {
            head = newNode;
        } else {

            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    public void displayHistory() {

        Node temp = head;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public Node getHead() {
        return head;
    }
}
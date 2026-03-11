package VehicleMonitoring;

public class Sorter {

    public Node sortByDateTime(Node head) {

        if (head == null || head.next == null)
            return head;

        Node mid = getMiddle(head);
        Node nextOfMid = mid.next;
        mid.next = null;

        Node left = sortByDateTime(head);
        Node right = sortByDateTime(nextOfMid);

        return merge(left, right);
    }

    private Node merge(Node a, Node b) {

        if (a == null) return b;
        if (b == null) return a;

        Node result;

        String aDateTime = a.data.date + " " + a.data.time;
        String bDateTime = b.data.date + " " + b.data.time;

        if (aDateTime.compareTo(bDateTime) <= 0) {
            result = a;
            result.next = merge(a.next, b);
        } else {
            result = b;
            result.next = merge(a, b.next);
        }

        return result;
    }

    private Node getMiddle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
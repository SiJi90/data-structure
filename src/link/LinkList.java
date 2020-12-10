package link;

/**
 * @author: slm
 */
public class LinkList {
    private Link first;

    public void LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;  // newLink --> old first
        first = newLink;  // first --> newLink
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.println("List (first-->last)");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

}

class LinkListApp {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insertFirst(22, 2.2);
        linkList.insertFirst(33, 3.3);
        linkList.insertFirst(44, 4.4);
        linkList.insertFirst(55, 5.5);

        linkList.displayList();

        while (!linkList.isEmpty()) {
            linkList.deleteFirst();
            linkList.displayList();
            System.out.println("======================");
        }
    }
}
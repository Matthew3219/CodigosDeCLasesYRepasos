
public class View {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list = list.insert(list, 3);
        list = list.insert(list, 6);
        list = list.insert(list, 9);
        list = list.insert(list, 12);
        list.print(list);
        list = list.insertInicio(list, 3);
        list = list.insertInicio(list, 6);
        list = list.insertInicio(list, 9);
        list = list.insertInicio(list, 12);
        list.print(list);
    }

}

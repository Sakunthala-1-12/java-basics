import java.util.ArrayList;

class Person {
    int id;
    String name;
    ArrayList<Integer> friends;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
        friends = new ArrayList<>();
    }

    void addFriend(int friendId) {
        friends.add(friendId);
    }

    void displayFriends() {
        System.out.print("Friends of " + name + ": ");
        for (int f : friends) {
            System.out.print(f + " ");
        }
        System.out.println();
    }
}

public class Friend{
    public static void main(String[] args) {
        Person madhu = new Person(0, "Madhu");
        Person saku = new Person(1, "Saku");
        Person subi = new Person(2, "Subi");

        madhu.addFriend(1);
        madhu.addFriend(2);
        
        madhu.displayFriends();
    }
}
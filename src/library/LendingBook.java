package library;

import java.util.HashSet;
import java.util.Set;

public class LendingBook extends Book{

    private int itemsLended = 0;
    private Set<LibraryMember> members = new HashSet<LibraryMember>();

    public LendingBook(String isbn, String title, int copyNumber) {
        super(isbn, title, copyNumber);
    }

    public int getItemsLended() {
        return itemsLended;
    }

    @Override
    public String toString() {
        return "LendingBook{" +
                "itemsLended=" + itemsLended +
                ", members=" + members +
                "} " + super.toString();
    }

    //method loan
    public boolean loan(LibraryMember lm){
        if (members.contains(lm) || itemsLended == getCopyNumber()) {
            return false;
        }
        itemsLended++;
        members.add(lm);
        return true;
    }

    //method return back
    public boolean returnBack(LibraryMember lm){
        if(!members.contains(lm) || itemsLended == 0){
            return false;
        }
        itemsLended--;
        members.remove(lm);
        return true;
    }
}

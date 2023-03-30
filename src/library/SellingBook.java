package library;

import java.util.ArrayList;
import java.util.List;

public class SellingBook extends Book {

    private int itemsSold = 0;
    private List<LibraryMember> members = new ArrayList<LibraryMember>();

    public SellingBook(String isbn, String title, int copyNumber) {
        super(isbn, title, copyNumber);
    }

    public int getItemsSold() {
        return itemsSold;
    }

    @Override
    public String toString() {
        return "SellingBook{" +
                "itemsSold=" + itemsSold +
                ", members=" + members +
                "} " + super.toString();
    }

    //method sell
    public boolean sell(LibraryMember lm){
        if (itemsSold == getCopyNumber()){
            return false;
        }
        members.add(lm);
        return true;
    }
}

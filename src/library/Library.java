package library;

import java.util.HashSet;
import java.util.Set;
import java.util.SimpleTimeZone;

public class Library {
    private String name;
    private String address;
    private Set<Book> sellingBooks = new HashSet<Book>();
    private Set<Book> lendingBooks = new HashSet<Book>();
    private Set<LibraryMember> members = new HashSet<LibraryMember>();


    public Library(String name, String address) {
        this.name = name;
        this.address = address;
    }

    //add selling book
    public boolean addSellingBook(SellingBook sb){
        return sellingBooks.add(sb);
    }

    //add lending book
    public boolean addLendingBook(LendingBook lb){
        return lendingBooks.add(lb);
    }

    //add library member
    public boolean addMember(LibraryMember lm){
        //new member id should be unique
        for(LibraryMember member: members){
            if(member.getMemberId().equals(lm.getMemberId())){
                return false;
            }
        }
        return members.add(lm);
    }

    //get member from id
    private LibraryMember getMember(String memberId){
        for(LibraryMember member: members){
            if(member.getId().equals(memberId)){
                return member;
            }
        }
        return null;
    }

    //get selling book from isbn
    private Book getSellingBook(String isbn){
        Book book = new SellingBook(isbn,"",1);
        for(Book b: sellingBooks){
            if(b.equals(book)){
                return b;
            }
        }
        return null;
    }

    //get lending book from isbn
    private Book getLendingBook(String isbn){
        Book book = new LendingBook(isbn,"",1);
        for(Book b: lendingBooks){
            if(b.equals(book)){
                return b;
            }
        }
        return null;
    }

    //selling book
    public boolean sellBook(String isbn, String memberId){
        Book b = getSellingBook(isbn);
        LibraryMember lm = getMember(memberId);
        if(b != null && lm !=null){
            SellingBook sb = (SellingBook) b;
            return sb.sell(lm);
        }
        return false;
    }

    //loan book
    public boolean loanBook(String isbn, String memberId){
        Book b = getLendingBook(isbn);
        LibraryMember lm = getMember(memberId);
        if(b != null && lm != null){
            LendingBook lb = (LendingBook) b;
            return lb.loan(lm);
        }
        return false;
    }

    // return book
    public boolean returnBook(String isbn, String memberId){
        Book b = getLendingBook(isbn);
        LibraryMember lm = getMember(memberId);
        if (b != null && lm != null){
            LendingBook lb = (LendingBook) b;
            return lb.returnBack(lm);
        }
        return false;
    }

    //print method
    public void printStatus(){
        System.out.println("Member:");
        for(LibraryMember lm :members){
            System.out.println(lm);
        }

        System.out.println("Books to Lend:");
        for(Book lb:lendingBooks){
            System.out.println(lb);
        }

        System.out.println("Books to sell:");
        for(Book lb: sellingBooks){
            System.out.println(lb);
        }
    }































}

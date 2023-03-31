package library;

// LibraryMember extends Person with a properties memberId
public class LibraryMember extends Person {
    private String memberId;

    public LibraryMember(String name, String id, String memberId) {
        super(name, id);
        this.memberId = memberId;
    }

    public String getMemberId() {
        return new String(memberId);
    }

    @Override
    public String toString() {
        return "LibraryMember{" +
                "memberId='" + memberId + '\'' +
                "} " + super.toString();
    }
}

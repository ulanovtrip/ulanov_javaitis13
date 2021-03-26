package generics.linked_stack.itis.part1.problem;

public class Main {
    public static void main(String[] args) {
        Cover cover = new Cover();
        IPhone iPhone = new IPhone();
        Nokia nokia = new Nokia();

        cover.setPhone(iPhone);

        Object phoneFromCover = cover.getPhone();
        IPhone iPhoneFromCover = (IPhone) phoneFromCover;
        iPhoneFromCover.createPhoto();

         cover.setPhone(nokia);
        //cover.setPhone(iPhone);
        Object phoneFromCover2 = cover.getPhone();
        Nokia nokiaFromCover = (Nokia) phoneFromCover2;
        nokiaFromCover.call();
    }
}

package generics.linked_stack.itis.part1.parametr_type;

public class Main {
    public static void main(String[] args) {
        Cover<IPhone> cover = new Cover();

        IPhone iPhone = new IPhone();
        cover.setPhone(iPhone);
        IPhone phoneFromCover = cover.getPhone();
        phoneFromCover.createPhoto();

        // не скопилируется, т.к. указан параметр типа <T>
        Nokia nokia = new Nokia();
        //cover.setPhone(nokia);

        Cover<Nokia> nokiaCover = new Cover<>();
        nokiaCover.setPhone(nokia);
        Nokia nokiaFromCover = nokiaCover.getPhone();
        nokiaFromCover.call();
    }
}

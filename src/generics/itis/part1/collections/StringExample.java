package generics.itis.part1.collections;

public class StringExample implements List<String>{

    //  List<String> - автоматически заставляет реализовать все методы с таким типом в параметрах

    @Override
    public void add(String element) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(String element) {
        return false;
    }

    @Override
    public void removeFirst(String element) {

    }

    @Override
    public void removeLast(String element) {

    }

    @Override
    public void removeAll(String element) {

    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public void removeAt(int index) {

    }

    @Override
    public int indexOf(String element) {
        return 0;
    }

    @Override
    public int lastIndexOf(String element) {
        return 0;
    }
}

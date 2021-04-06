package exceptions.bestpractise;

import java.util.List;

public class TestExample {
    public static void main(String[] args) {
        String path = "src/exceptions/examples3/input.txt4";
        NamesRepositoryFileImpl repositoryFile = new NamesRepositoryFileImpl(path);

        // как только получили проверяемое исключение, необходимо обработать его "на месте"
        // т.е. выбросить поверх него непроверяемое исключение, чтобы программа остановила выполнение
        List<String> names = repositoryFile.findNames();

        for(String name : names) {
            System.out.println(name);
        }
    }
}

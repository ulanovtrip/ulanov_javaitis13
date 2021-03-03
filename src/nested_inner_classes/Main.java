package nested_inner_classes;

public class Main {
    public static void main(String[] args) {
        Table table = new Table(10, 12);
        table.put("Ivan", 37);
        table.put("Nikolay", 43);
        table.put("Igor", 34);

        /*
        Создаётся объект внутреннего класса, который привязан к объекту table и имеет доступ к его достоянию.
         */
        Table.TablePrinter printer = table.new TablePrinter();
        printer.print();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        Table anotherTable = new Table(5, 6);
        anotherTable.put("Go", 1);
        anotherTable.put("Went", 2);
        anotherTable.put("Gone", 3);

        Table.TablePrinter printerAnother = anotherTable.new TablePrinter();
        printerAnother.print();
    }
}

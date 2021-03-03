package nestedclasses;

public class Table {
    private static final int MAX_ENTRIES_COUNT = 10;
    private TableEntry[] entries;
    private int rowsCount;
    private int keyWidth;
    private int valueWidth;

    public Table(int keyWidth, int valueWidth) {
        this.entries = new TableEntry[MAX_ENTRIES_COUNT];
        this.keyWidth = keyWidth;
        this.valueWidth = valueWidth;
    }

    public void put(String key, int value) {
        if (rowsCount < MAX_ENTRIES_COUNT) {
            TableEntry tableEntry = new TableEntry(key, value);
            entries[rowsCount] = tableEntry;
            rowsCount++;
        } else {
            System.err.println("Array is Full!");
        }
    }

    //вложенный (nested) static класс, ассоциирован с внешним классом.
    // Ничего не знает об объектах внешнего класса (Table).
    // не имеет доступа к полям объектов внешнего класса
    private static class TableEntry {
        String key = "DEFAULT";
        final int value;

        TableEntry(String key, int value) {
            if (key != null) {
                this.key = key;
            }
            this.value = value;
        }
    }

    // внутренний класс (inner) ассоциирован с объектами внешнего класса и не может быть использован без них.
    class TablePrinter {
        // печать шапки таблиц
        public void print() {
            System.out.printf("|%" + keyWidth + "s|%" + valueWidth + "s|\n", "Key", "Value");
            for (int i = 0; i < rowsCount; i++) {
                System.out.printf("|%" + keyWidth + "s|%" + valueWidth + "d|\n", entries[i].key, entries[i].value);
            }
        }
    }
}

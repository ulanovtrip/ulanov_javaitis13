package patterns.proxy.lite;

/*
Данный класс позволит изменить поведение Driver без изменения самого класса и без необходимости изменения
контекста использования.
 */
public class DriverProxy extends Driver {

    private After after;
    private Before before;
    private Instead instead;

    public DriverProxy(String name) {
        super(name);
    }

    @Override
    public void drive() {

        if (before != null) {
            before.execute();
        }

        if (instead != null) {
            instead.execute();
        } else {
            super.drive();
        }

        if (after != null) {
            after.execute();
        }
    }

    public void setAfter(After after) {
        this.after = after;
    }

    public void setBefore(Before before) {
        this.before = before;
    }

    public void setInstead(Instead instead) {
        this.instead = instead;
    }
}

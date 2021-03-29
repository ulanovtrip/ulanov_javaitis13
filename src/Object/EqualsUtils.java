package Object;

public class EqualsUtils {
    public boolean allEquals(Object... objects) {
        for (int i = 0; i < objects.length - 1; i++) {
            if (!objects[i].equals(objects[i + 1])) {
                return false;
            }
        }
        return true;
    }
}

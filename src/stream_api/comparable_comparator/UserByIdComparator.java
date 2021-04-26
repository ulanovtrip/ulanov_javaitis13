package stream_api.comparable_comparator;

import java.util.Comparator;

public class UserByIdComparator implements Comparator<UserComparator> {

    @Override
    public int compare(UserComparator o1, UserComparator o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}

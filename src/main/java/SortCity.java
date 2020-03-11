import java.util.Comparator;

public class SortCity  implements Comparator<SingleRow> {

    //@Override
    public int compare(SingleRow o1, SingleRow o2) {
        return o1.getCity().compareTo(o2.getCity());
    }
}

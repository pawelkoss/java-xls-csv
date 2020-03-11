import java.util.Comparator;

public class SortCLFComparator implements Comparator<SingleRow> {

    //@Override
    public int compare(SingleRow o1, SingleRow o2) {
        if (o1.getCLF2007() < o2.getCLF2007()){
            return -1;
        }
        else if  (o1.getCLF2007() == o2.getCLF2007()){
            return 0;
        }
        else {
            return 1;
        }
    }
}

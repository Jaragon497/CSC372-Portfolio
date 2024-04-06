import java.util.Comparator;

public class MpgComparator implements Comparator<Vehicle> {
    public int compare(Vehicle v1, Vehicle v2) {
        return Double.compare(v1.getMpg(), v2.getMpg());
    }
}

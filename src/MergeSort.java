import java.util.Comparator;
import java.util.LinkedList;

// UPDATED IMPLEMENTATION OF MERGE SORT DEFINITION
//  CREATED IN CRITICAL THINKING ASSIGNMENT 6
public class MergeSort {
    public static <T> void mergeSort(LinkedList<T> list, Comparator<T> comparator) {
        // Base case
        if (list.size() <= 1) {
            return;
        }
        // Split the array at halfway
        int splitIDX = list.size() / 2;

        // Create two sub-arrays using the split
        LinkedList<T> left = new LinkedList<>(list.subList(0, splitIDX));
        LinkedList<T> right = new LinkedList<>(list.subList(splitIDX, list.size()));

        // Recursive call
        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(list, left, right, comparator);
    }

    private static <T> void merge(LinkedList<T> base, LinkedList<T> left, LinkedList<T> right, Comparator<T> comparator) {
        int leftIDX = 0, rightIDX = 0, idx = 0;

        // Move index position based on comparator
        while (leftIDX < left.size() && rightIDX < right.size()) {
            if (comparator.compare(left.get(leftIDX), right.get(rightIDX)) < 0) {
                base.set(idx++, left.get(leftIDX++));
            } else {
                base.set(idx++, right.get(rightIDX++));
            }
        }

        while (leftIDX < left.size()) {
            base.set(idx++, left.get(leftIDX++));
        }

        while (rightIDX < right.size()) {
            base.set(idx++, right.get(rightIDX++));
        }
    }
}
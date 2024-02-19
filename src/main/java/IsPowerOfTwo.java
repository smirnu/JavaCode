import java.util.HashSet;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        HashSet<Integer> allPowersTwo = new HashSet<>();
        allPowersTwo.add(1);
        Integer nextValue = 2;
        while (true) {
            allPowersTwo.add(nextValue);
            if (nextValue == 1073741824) break;
            nextValue *= 2;
        }

        if (allPowersTwo.contains(n)) return true;
        else return false;
    }
}

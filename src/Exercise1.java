import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 {


    //Input: nums = [2, 7, 1, 8, 2, 8, 1], k = 4 Output: 18

    public static void main(String[] args) {

        List<Integer> inputNumbers = Arrays.asList(1, 7, 1, 8, 3, 8, 1);

         int sum = inputNumbers.stream().distinct().mapToInt(s -> s).sum();

         System.out.println(sum);
    }
}

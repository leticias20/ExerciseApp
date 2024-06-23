import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExercise {

    public static void main(String args[]){

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        myList.sort(Integer::compareTo);
        myList.forEach(System.out::println);
        List<String> myListStrings = myList.stream().map(s -> String.valueOf(s)).filter(s -> s.startsWith("1")).collect(Collectors.toList());

        myListStrings.stream().forEach(System.out::println);


    }
}

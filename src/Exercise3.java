import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise3 {
    public static void main(String [] args){
        //Write a Java program to implement a lambda expression to convert a list of strings to uppercase and lowercase.

        List<String> stringList = Arrays.asList("hola","de nada", "por favor", "gracias");
        List <String> upperStrings = stringList.stream().map(s -> s.replaceAll(s,s.toUpperCase())).collect(Collectors.toList());
        upperStrings.stream().forEach(System.out::println);

        List<String> lowerStrings = upperStrings.stream().map(s -> s.replaceAll(s, s.toLowerCase())).collect(Collectors.toList());
        lowerStrings.stream().forEach(System.out::println);
    }

}

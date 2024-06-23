import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * You want to send your friend a package with different things. Each thing you put inside of a package has such parameters as index number, weight and cost.
 *
 * The package has a weight limitation. Your goal is to determine which things to put into the package so that the total weight is less than or equal to the package limit and the total cost is as large as possible.
 *
 * You would prefer to send a package which has less weight if there is more than one package with the same price. This is a variation of the Knapsack problem.
 *
 * Input: Your program should read lines from standard input. Each line contains the weight that a package can take (before the colon) and the list of things you need to pick from. Each thing is enclosed in parentheses where the 1st number is a thing's index number, the 2nd is its weight and the 3rd is its cost. Max weight any package can take is <= 100. There might be up to 15 things you need to choose from. Max weight and max cost of any thing is <= 100.
 *
 * Output: For each set of things produce a list of things (their index numbers separated by comma) that you put into the package. If none of the items will fit in the package, print a hyphen (-).
 */
public class KnapsackSolution {

    public class Thing{

        int index;
        double weight;
        int cost;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

    }

    public List<Integer> getResult(int weight, String thingsString){

        //parse thingsString
        List<String> packageItems = Arrays.asList(thingsString.split(" "));
        List<Thing> things = new ArrayList<>();
        for(String packageItem : packageItems){
            Thing thing = new Thing();
            List<String> packageItemList = Arrays.asList(packageItem.split(","));
            int count =0;
            for(String item: packageItemList) {
                if(!item.isEmpty()) {
                    if (item.startsWith("(")) {
                        item = item.replace("(", "");
                    }
                    if (count == 0) thing.setIndex(Integer.valueOf(item));
                    if (count == 1) thing.setWeight(Double.valueOf(item));
                    if (count == 2) {
                        thing.setCost(Integer.valueOf(item.replace("$", "").replace(")","")));
                        count = 0;
                    }
                    count++;
                }
            }
            things.add(thing);
        }

        //Logic to calculate output
        List<Integer> output = new ArrayList<>();
        OptionalDouble maxWeight = things.stream().mapToDouble(w -> w.getWeight()).filter(w -> w < weight).max();
        OptionalDouble minWeight = things.stream().mapToDouble(w -> w.getWeight()).filter(w -> w < weight).min();


        for(Thing thing: things) {
            if (thing.getWeight() == maxWeight.getAsDouble()) {
                output.add(thing.getIndex());
            }
        }

        return output;
    }
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {

        KnapsackSolution knapsackSolution = new KnapsackSolution();
        //81 : (1,53.38,$45) (2,88.62,$98) (3,78.48,$3) (4,72.30,$76) (5,30.18,$9) (6,46.34,$48) R= 4
        //75 : (1,85.31,$29) (2,14.55,$74) (3,3.98,$16) (4,26.24,$55) (5,63.69,$52) (6,76.25,$75) (7,60.02,$74) (8,93.18,$35) (9,89.95,$78) R=2,7
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        line = in.readLine();

        List<String> completeInput = Arrays.asList(line.split(":"));

        int weight = Integer.valueOf(completeInput.get(0).trim());

        String thingsString = completeInput.get(1);

        System.out.println(knapsackSolution.getResult(weight,thingsString));

    }
}

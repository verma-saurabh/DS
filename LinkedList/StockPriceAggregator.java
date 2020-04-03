package LinkedList;

import java.util.*;

public class StockPriceAggregator {
    public static class StatisticsAggregatorImpl implements StatisticsAggregator {

        private TreeMap<String, List<Double>> statictics = new TreeMap<>();

        @Override
        public void putNewPrice(String symbol, double price) {

            if (statictics.containsKey(symbol)) {
                List<Double> priceList = statictics.get(symbol);
                priceList.add(price);
                statictics.put(symbol, priceList);
            } else {
                List<Double> priceList = new ArrayList<>();
                priceList.add(price);
                statictics.put(symbol, priceList);
            }
        }

        @Override
        public double getAveragePrice(String symbol) {
            double avgPrice = 0;
            List<Double> priceList = statictics.get(symbol);
            double sum = priceList.stream().mapToDouble(i -> i.doubleValue()).sum();
            avgPrice = sum / priceList.size();
            return avgPrice;
        }

        @Override
        public int getTickCount(String symbol) {
            return statictics.get(symbol).size();
        }
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface StatisticsAggregator {
        // This is an input. Make note of this price.
        public void putNewPrice(String symbol, double price);

        // Get the average price
        public double getAveragePrice(String symbol);

        // Get the total number of prices recorded
        public int getTickCount(String symbol);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final StatisticsAggregator stats = new StatisticsAggregatorImpl();
            final Set<String> symbols = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            for (int i = 1; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String symbol = tokens[0];
                symbols.add(symbol);
                final double price = Double.parseDouble(tokens[1]);

                stats.putNewPrice(symbol, price);

            }

            for (String symbol : symbols) {
                System.out.println(
                        String.format("%s %.4f %d", symbol, stats.getAveragePrice(symbol), stats.getTickCount(symbol)));
            }
        }
        scanner.close();

    }
}
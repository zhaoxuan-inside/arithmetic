package every_day_topic;

import java.util.*;

@SuppressWarnings("unused")
public class topic_2034 {

    static class Stock {
        public int timestamp;
        public int price;

        public Stock(int timestamp, int price) {
            this.timestamp = timestamp;
            this.price = price;
        }
    }

    static class StockPrice {

        private final SortedSet<Integer> timestamps = new TreeSet<>();
        private final SortedSet<Integer> prices = new TreeSet<>();
        private final Map<Integer, Stock> map = new HashMap<>();

        public StockPrice() {

        }

        public synchronized void update(int timestamp, int price) {
            Stock oldPrice = map.get(timestamp);
            if (oldPrice != null) {
                prices.remove(oldPrice.price);
            }
            prices.add(price);
            timestamps.add(timestamp);
            map.put(timestamp, new Stock(timestamp, price));
        }

        public synchronized int current() {
            Integer last = timestamps.last();
            return map.get(last).price;
        }

        public synchronized int maximum() {
            return prices.last();
        }

        public synchronized int minimum() {
            return prices.first();
        }
    }
}
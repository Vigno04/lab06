package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 1000; i<2000; i++){
            arrayList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAll(arrayList);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp=arrayList.get(0);
        arrayList.set(0,arrayList.get(arrayList.size()-1));
        arrayList.set(arrayList.size()-1, temp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer integer : arrayList) {
            System.out.print(integer+" ");
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time1 = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(0,i);
        }
        time1 = System.nanoTime() - time1;

        long time2 = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(0,i);
        }
        time2 = System.nanoTime() - time2;
        System.out.println("\ntime for arrayList="+time1+" time for linkedList="+time2);

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.get(arrayList.size()/2);
        }
        time1 = System.nanoTime() - time1;

        time2 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.get(linkedList.size()/2);
        }
        time2 = System.nanoTime() - time2;
        System.out.println("\ntime for arrayList="+time1+" time for linkedList="+time2);

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */


        final HashMap<String,Long> populationMap = new HashMap<>();

        populationMap.put("Africa", 1110635000L);
        populationMap.put("Americas", 972005000L);
        populationMap.put("Antarctica", 0L);
        populationMap.put("Asia", 4298723000L);
        populationMap.put("Europe", 742452000L);
        populationMap.put("Oceania", 38304000L);

        long worldPopulation = 0;
        for (Long population: populationMap.values()) {
            worldPopulation += population;
            
        }
        System.out.println("La popolazione mondiale e: "+worldPopulation);
    }
}

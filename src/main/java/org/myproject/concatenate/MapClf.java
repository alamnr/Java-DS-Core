package org.myproject.concatenate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class MapClf {

    public static void main(String ... args){
        Map<Integer, String> map = Map.of(1,"one",2,"two",3,"three",4,"four",5,"five",6,"six",7,"seven",8,"eight",9,"nine",10,"ten");

        System.out.println(map);

        Map.Entry<Integer, String> e1 = Map.entry(1,"one"); 
        Map.Entry<Integer, String> e2 = Map.entry(2,"two");
        Map.Entry<Integer, String> e3 = Map.entry(3,"three");
        Map.Entry<Integer, String> e4 = Map.entry(4,"four");
        Map.Entry<Integer, String> e5 = Map.entry(5,"five");
        Map.Entry<Integer, String> e6 = Map.entry(6,"six");
        Map.Entry<Integer, String> e7 = Map.entry(7,"seven");
        Map.Entry<Integer, String> e8 = Map.entry(8,"eight");
        Map.Entry<Integer, String> e9 = Map.entry(9,"nine");
        Map.Entry<Integer, String> e10 = Map.entry(10,"ten");
        Map.Entry<Integer, String> e11 = Map.entry(11,"eleven");

        map = Map.ofEntries(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11);

        System.out.println(map);
        
        map = Map.ofEntries(Map.entry(1,"one"),Map.entry(2,"two"));

        System.out.println(map);

        Map<String,Integer> newMap = new HashMap<>();
        newMap.put("one",1);
        newMap.put("two",null);
        newMap.put("three",3);
        newMap.put("four",4);
        newMap.put("five",null);

        for (String key : newMap.keySet()){
                newMap.putIfAbsent(key, -1);
        }

        for(int val : newMap.values() ){
            System.out.println(val);
        }

        Map<Integer, String> map_1 = new HashMap<>();
        map_1.put(1,"one");
        map_1.put(2,"two");
        map_1.put(3,"three");

        List<String> values = new ArrayList<>();
        for(var i=0;i<=5;i++){
            values.add(map_1.getOrDefault(i, "Unknown"));
        }
        System.out.println("Values = "+ values);

        List<String> values_1 = IntStream.range(0, 5)
        .mapToObj(key -> map_1.getOrDefault(key, "Dwfault"))
        .collect(Collectors.toList());

        System.out.println("values = " + values_1);

        List<String> strings = List.of("one", "two", "three","four","five", "six","seven","eight","nine");
        Map<Integer,List<String>> mappp = new HashMap<>();
        for (String string : strings) {
            int length = string.length();
            // if(!mappp.containsKey(length)){
            //     mappp.put(length, new ArrayList<String>());
            // }
            //mappp.putIfAbsent(length, new ArrayList<String>());
            //mappp.get(length).add(string);
            mappp.computeIfAbsent(length, k -> new ArrayList<String>()).add(string);
        }

        mappp.forEach((k,v)-> System.out.println(k + " :: "+ v));

        SortedMap<Integer,String> sortedMap = new TreeMap<>();
        sortedMap.put(1,"one");
        sortedMap.put(2,"two");
        sortedMap.put(3,"three");
        sortedMap.put(5,"five");
        sortedMap.put(6,"six");

        SortedMap<Integer,String> headMap = sortedMap.headMap(3);
        headMap.put(0,"zero");
        //headMap.put(4,"four");
        sortedMap.forEach((k,v)-> System.out.println(k + "  :: "+v));
        System.out.println(sortedMap.lastEntry());
        
        NavigableMap<Integer, String> naviMap = new TreeMap<>();
        naviMap.put(1, "one");
        naviMap.put(2, "two");
        naviMap.put(3, "three");
        naviMap.put(4, "four");
        naviMap.put(5, "five");

        naviMap.keySet().forEach(key -> System.out.print(key + " "));
        System.out.println();

        NavigableSet<Integer> descendingKeys = naviMap.descendingKeySet();
        descendingKeys.forEach(key -> System.out.print(key + " "));
        
        // List<String> strings_ex = List.of("one","two","three","four","five");
        // var map1 = strings_ex.stream().collect(groupingBy(String::length,count()));
        // map1.forEach((k,v)-> System.out.println(k +" :: "+v));


        System.out.println();
        List<String> strings_NEW = List.of("one", "two", "three", "four");
        Function<String, Integer> toLength = String::length;
        Stream<Integer> ints = strings_NEW.stream().map(toLength);
        System.out.println(ints.count());

        //List<Integer> list = strings_NEW.stream().map(String::length).collect(Collectors.toList());
        //System.out.println("List : "+list);

        IntSummaryStatistics intsStatistics = strings_NEW.stream().mapToInt(String::length).summaryStatistics();
        System.out.println("intsStatistics - "+intsStatistics);

        // var count = strings_NEW.stream().map(String::length).filter(l->l == 3).count();
        // System.out.println("map first then  filter - "+ count);
        // count = strings_NEW.stream().filter(l->l.length() == 3).count();

        // System.out.println("Only filter - "+ count);

        Function<String, Stream<Integer>> flatParser = s -> {
            try {
                return Stream.of(Integer.parseInt(s));
            } catch (NumberFormatException e) {
            }
            return Stream.empty();
        };
        
        List<String> strings_flat = List.of("1", " ", "2", "3 ", "", "3");
        List<Integer> ints1 = 
        strings_flat.stream()
                   .flatMap(flatParser)
                   .collect(Collectors.toList());
        System.out.println("ints1 = " + ints1);

        List<Integer> ints2 =  strings_flat.stream()
               .<Integer>mapMulti((string, consumer) -> {
                    try {
                        consumer.accept(Integer.parseInt(string));
                    } catch (NumberFormatException ignored) {
                    }
               })
               .collect(Collectors.toList());
        System.out.println("ints2 = " + ints2);

    

        List<Integer> list0 = List.of(1, 2, 3);
        List<Integer> list1 = List.of(4, 5, 6);
        List<Integer> list2 = List.of(7, 8, 9);

        // 1st pattern: concat
        List<Integer> concat = 
            Stream.concat(list0.stream(), list1.stream())
                .collect(Collectors.toList());

        // 2nd pattern: flatMap
        List<Integer> flatMap =
            Stream.of(list0.stream(), list1.stream(), list2.stream())
                .flatMap(Function.identity())
                .collect(Collectors.toList());

        System.out.println("concat  = " + concat);
        System.out.println("flatMap = " + flatMap);

        List<String> strings_r = List.of("one", "two", "three", "four");
        List<String> result =
                strings_r.stream()
                        //.peek(s -> System.out.println("Starting with = " + s))
                        .filter(s -> s.startsWith("t"))
                        //.peek(s -> System.out.println("Filtered = " + s))
                        .map(String::toUpperCase)
                        //.peek(s -> System.out.println("Mapped = " + s))
                        .collect(Collectors.toList());
        System.out.println("result = " + result);
    }    
}

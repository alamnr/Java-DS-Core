package org.myproject.concatenate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class MapClf {

    public static void main(String ... args) {
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


        Stream<String> empty = Stream.empty();
        List<String> emptyList = empty.collect(Collectors.toList());
        System.out.println("Empty List : " + emptyList);

        Stream<Integer> intStream = Stream.of(1,2,3,4);
        List<Integer> intList = intStream.collect(Collectors.toList()) ;
        System.out.println("intList - "+ intList );
        String[] stringArray = {"one","two","three"};
        Stream<String> stringStream = Arrays.stream(stringArray);
        List<String> stringList = stringStream.collect(Collectors.toList());
        System.out.println("stringList - " + stringList);

        Stream<String> generated  = Stream.generate(() -> "+");
        List<String> list = generated.limit(10L).collect(Collectors.toList());
        System.out.println("list - "+ list);
               
        Stream<String> iterated = Stream.iterate("+", s -> s + "+");
        iterated.limit(5L).forEach(System.out::println);

        iterated = Stream.iterate("+",s->s.length()<=5, s-> s+"+");
        iterated.limit(5L).forEach(System.out::println);

        Random random = new Random(314L);
        List<Integer> randomInts = 
            random.ints(10, 1, 50)
          .boxed()
          .collect(Collectors.toList());
        System.out.println("randomInts = " + randomInts);

        //random = new Random(314L);
        List<Boolean> booleans =
            random.doubles(1_000, 0d, 1d)
                .mapToObj(rand -> rand <= 0.8) // you can tune the probability here
                .collect(Collectors.toList());

        // Let us count the number of true in this list
        long numberOfTrue =
            booleans.stream()
                    .filter(b -> b)
                    .count();
        System.out.println("numberOfTrue = " + numberOfTrue);

        List<String> letters =
    random.doubles(1_000, 0d, 1d)
          .mapToObj(rand ->
                    rand < 0.5 ? "A" : // 50% of A
                    rand < 0.8 ? "B" : // 30% of B
                    rand < 0.9 ? "C" : // 10% of C
                                 "D")  // 10% of D
          .collect(Collectors.toList());

    Map<String, Long> mapStream =
        letters.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                mapStream.forEach((letter, number) -> System.out.println(letter + " :: " + number));

                String sentence = "Hello Duke";
        List<String> letters1 =   sentence.chars()
                    .mapToObj(codePoint -> (char)codePoint)
                    .map(Object::toString)
                    .collect(Collectors.toList());
        System.out.println("letters = " + letters1);
        letters1 =   sentence.chars()
            .mapToObj(Character::toString)
            .collect(Collectors.toList());
    System.out.println("letters1 = " + letters1);

    Path log = Path.of("/tmp/debug.log"); // adjust to fit your installation
        try (Stream<String> lines = Files.lines(log)) {
            
            long warnings = 
                lines.filter(line -> line.contains("WARNING"))
                    .count();
            System.out.println("Number of warnings = " + warnings);
            
        } catch (IOException e) {
            // do something with the exception
        }
        sentence = "For there is good news yet to hear and fine things to be seen";

        String[] elements = sentence.split(" ");
        Stream<String> stream = Arrays.stream(elements);
        System.out.println(stream.collect(Collectors.toList()));

            sentence = "For there is good news yet to hear and fine things to be seen";

        Pattern pattern = Pattern.compile(" ");
        Stream<String> stream1 = pattern.splitAsStream(sentence);
        List<String> words = stream1.collect(Collectors.toList());

        System.out.println("words = " + words);

        Stream.Builder<String> builder = Stream.<String>builder();

            builder.add("one")
                .add("two")
                .add("three")
                .add("four");

            Stream<String> stream2 = builder.build();

            List<String> list12 = stream2.collect(Collectors.toList());
            System.out.println("list12 = " + list12);

        /*
            // The URI of the file
        URI uri = URI.create("https://www.gutenberg.org/files/98/98-0.txt");

        // The code to open create an HTTP request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).build();


        // The sending of the request
        HttpResponse<Stream<String>> response = null;
        
        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofLines());
        } catch(Exception e){
           // e.printStackTrace();
        }
        List<String> lines = null;
        if(response!=null){
            try (Stream<String> stream34 = response.body()) {
                lines = stream34
                    .dropWhile(line -> !line.equals("A TALE OF TWO CITIES"))
                    .takeWhile(line -> !line.equals("*** END OF THE PROJECT GUTENBERG EBOOK A TALE OF TWO CITIES ***"))
                    .collect(Collectors.toList());
            } 
            System.out.println("# lines = " + lines.size());
        }
        */
        

        /////////////////////////////////////////// Reducing Stream ////////////////////////////

        List<Integer> intsr = List.of(1,2,3,4,5);
        int result1 = intsr.get(0);
        BinaryOperator<Integer> binaryOperator = (a,b) -> a+b;
        for(var i=1;i<intsr.size();i++){
            //result1+=intsr.get(i);
            result1 = binaryOperator.apply(result1, intsr.get(i));
        }
        System.out.println("sum - "+result1);;
        result1 = intsr.get(0);
        binaryOperator = (a,b) -> a>b?a:b;
        for(var i=1;i<intsr.size();i++){
            //result1+=intsr.get(i);
            result1 = binaryOperator.apply(result1, intsr.get(i));
        }
        System.out.println("max - "+result1);;

        binaryOperator = (a,b) -> a+b;
        int result11 = reduce(intsr.subList(0,2),binaryOperator);
        int result22  = reduce(intsr.subList(2, 4),binaryOperator);
        int result33 = binaryOperator.apply(result11,result22);
        System.out.println("Sum = "+result33);

        intList = List.of(3,6,2,1);
        int identity = 0;
        result11 = identity;
        for (int elem : intList) {
            result11 = binaryOperator.apply(result11, elem);
        }
        System.out.println("Sum - "+result11);


        ints = Stream.of(2, 8, 1, 5, 3);
        //Optional<Integer> optional = ints.reduce((i1, i2) -> i1 > i2 ? i1: i2);
        Optional<Integer> optional = ints.reduce((i1, i2) -> i1+i2);

        if (optional.isPresent()) {
            System.out.println("result = " + optional.orElseThrow());
        } else {
            System.out.println("No result could be computed");
        }
        Stream<String> strStream = Stream.of("one","two","three","four","five");
        Function<String, Integer> mapper = String::length;
        BinaryOperator<Integer> combiner = (l1,l2) -> l1+l2;
        //BiFunction<Integer,String,Integer> accumulator = (partialReduction,elem) -> partialReduction + elem.length();
        BiFunction<Integer,String,Integer> accumulator = (partialReduction,elem) -> partialReduction + mapper.apply(elem);
        int result55 = strStream.reduce(0,accumulator,combiner);
        System.out.println(" sum = "+result55);

        ////////////////////  Adding a Terminal Operation on a Stream  //////////////////////
        Collection<String> stringsTerminal = List.of("one","two","three","four","five","six","seven");
        long count = stringsTerminal.stream().filter(s->s.length()>3).count();
        System.out.println(" count - "+ count);
        
        stringsTerminal.stream().filter(s->s.length()==3).map(String::toUpperCase).forEach(System.out::println);
        List<String> result66 = new ArrayList<>();
        stringsTerminal.stream().filter(s-> s.length()==3).map(String::toUpperCase).forEach(result66::add);
        System.out.println("result66 = "+result66);

        result66 = stringsTerminal.stream().filter(s->s.length()==4).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("result66 = "+result66);

        
        result66 = stringsTerminal.stream().filter(s->s.length()==5).map(String::toUpperCase).toList();
        System.out.println("result66 = "+result66);

        List<String> result77 = stringsTerminal.stream().filter(s->s.length()==3).map(String::toUpperCase).collect(Collectors.toCollection(LinkedList::new));
        System.out.println("linked list - "+ result77);

        Set<String> result88 = stringsTerminal.stream().filter(s->s.length()==3).map(String::toUpperCase).collect(Collectors.toSet());
        System.out.println(" Set of string: "+ result88);

        String[] result99 = stringsTerminal.stream().filter(s->s.length()==3).map(String::toUpperCase).toArray(String[]::new);
        System.out.println("string array - " + Arrays.toString(result99));

        String longest = stringsTerminal.stream().max(Comparator.comparing(String::length)).orElseThrow();
        System.out.println("longest = "+longest);

        String findFirst = stringsTerminal.stream().filter(s->s.length()==3).findFirst().orElseThrow();
        System.out.println(" Find first : " + findFirst);

        System.out.println(stringsTerminal.stream().filter(s->s.length()==3).findFirst().isPresent());

        boolean noBlank  = stringsTerminal.stream().allMatch(Predicate.not(String::isBlank));
        boolean oneGT3   = stringsTerminal.stream().anyMatch(s -> s.length() == 3);
        boolean allLT10  = stringsTerminal.stream().noneMatch(s -> s.length() > 10);
                
        System.out.println("noBlank = " + noBlank);
        System.out.println("oneGT3  = " + oneGT3);
        System.out.println("allLT10 = " + allLT10);

        Collection<String> stringCollection = List.of("one","two","three","four","five","six","seven","eight","nine");
        Stream<String> stringsSorted = stringCollection.stream().sorted();
        //stringsSorted.forEach(System.out::println);
        Stream<String> filteredString = stringsSorted.filter(s->s.length()>1);
        //filteredString.forEach(System.out::println);
        Stream<Integer> lengths = filteredString.map(String::length);
        lengths.forEach(System.out::println);

        stringCollection = List.of("one", "two", "two", "three", "four", "five");

        Stream<String> stringsDistinc = stringCollection.stream().distinct();
        filteredString = stringsDistinc.filter(s -> s.length() < 5);
        lengths = filteredString.map(String::length);

        List<Integer>  numbers = IntStream.range(0,10).boxed().collect(Collectors.toList());
        System.out.println(" numbers - "+ numbers);

        Set<Integer> distinctNumbers = IntStream.range(0,10).map(s->s/2).boxed().collect(Collectors.toSet());
        System.out.println("Even number - " +distinctNumbers);

        LinkedList<Integer> linkedList = IntStream.range(0,10).boxed().collect(Collectors.toCollection(LinkedList::new));
        System.out.println("LinkedList - " + linkedList);

        Collection<String> stringCollection1 = List.of("one","two","three");
        long count1 = stringCollection1.stream().count();
        long countingCollector =  stringCollection1.stream().collect(Collectors.counting());
        System.out.println("count - " + count1);
        System.out.println("collector counting - "+ countingCollector);

        String joined = IntStream.range(0,10).boxed().map(Object::toString).collect(Collectors.joining());
        System.out.println("joined - "+ joined);

        joined = IntStream.range(0,15).boxed().map(Object::toString).collect(Collectors.joining(",","{","}"));
        System.out.println("joined - " + joined);

        strings =  List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                    "ten", "eleven", "twelve");

        Map<Boolean,List<String>> map1 = strings.stream().collect(Collectors.partitioningBy(s->s.length()>4));
        map1.forEach((k,v)-> System.out.println(k+ "  ::  "+v));

        Map<Integer,List<String>> map2 = strings.stream().collect(Collectors.groupingBy(String::length));
        map2.forEach((k,v)->System.out.println(k+" :: "+v));

        Map<Integer,Long>  map3 = strings.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        map3.forEach((k,v)->System.out.println(k+" :: "+v));

        Map<Integer,String> map4 = strings.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(", ")));
        map4.forEach((k,v)->System.out.println(k+" :: "+v));


        Map<Integer, String> map5 =  strings.stream().collect(
                                    Collectors.toMap(
                                            element -> element.length(),
                                            element -> element, 
                                            (element1, element2) -> element1 + ", " + element2));

        map5.forEach((key, value) -> System.out.println(key + " :: " + value));

        Map<Integer,Long> histogram = strings.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        histogram.forEach((k,v)-> System.out.println(k +" :: "+v));

        Map.Entry<Integer,Long> maxValue = histogram.entrySet().stream().max(Map.Entry.comparingByValue())
                                                    .orElseThrow();
        System.out.println("Maxvalue - "+ maxValue);

        record  NumberOfLength(int length, long number ){
            static NumberOfLength fromEntry(Map.Entry<Integer, Long> entry) {
                return new NumberOfLength(entry.getKey(), entry.getValue());
            }
        
            static Comparator<NumberOfLength> comparingByLength() {
                return Comparator.comparing(NumberOfLength::length);
            }
        }

        NumberOfLength maxNumberOfLength =
        histogram.entrySet().stream()
             .map(NumberOfLength::fromEntry)
             .max(NumberOfLength.comparingByLength())
             .orElseThrow();

        System.out.println("maxNumberOfLength = " + maxNumberOfLength);

        List<String> result19 = strings.stream().collect(Collectors.mapping(String::toUpperCase, Collectors.toList()));

        System.out.println("result = " + result19);

        var map33 = histogram.entrySet().stream()
                        .map(NumberOfLength::fromEntry)
                        .collect(
                            Collectors.groupingBy(NumberOfLength::number));


        map33.forEach((k,v)->System.out.println(k+"   ::  "+v));

        var map34 = histogram.entrySet().stream()
                .map(NumberOfLength::fromEntry)
                .collect(Collectors.groupingBy(
                NumberOfLength::number, 
                Collectors.mapping(NumberOfLength::length, Collectors.toList())));
        
        map34.forEach((k,v)->System.out.println(k+"   ::  "+v));

        Map<Long, List<Integer>> map35 = histogram.entrySet().stream()
                                    .map(NumberOfLength::fromEntry)
                                    .collect(
                                        Collectors.groupingBy(
                                            NumberOfLength::number,
                                            Collectors.mapping(NumberOfLength::length, Collectors.toList())));

        Map.Entry<Long, List<Integer>> result89 = map35.entrySet().stream()
                                                    .max(Map.Entry.comparingByKey())
                                                    .orElseThrow();

        System.out.println("result = " + result89);
    }    

    static int reduce(List<Integer> ints, BinaryOperator<Integer> sum)
    {
        int result = ints.get(0);
        for(var i=1; i<ints.size();i++){
            result = sum.apply(result,ints.get(i));
        }
        return result;
    }
}

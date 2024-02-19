/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.myproject.concatenate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Alam
 */
public class Concatenate  {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        if(args.length<2){
            System.out.println("You need to provide 2 lists as argument, you provided " + args.length);
            throw new UnsupportedOperationException("You need to provide 2 lists as argument");
        }

        List<Integer> firstSeries = List.of(args[0].split(",")).stream().map(Integer::valueOf)
                                    .collect(Collectors.toList());

        List<Integer> secondSeries = List.of(args[1].split(",")).stream().map(Integer::valueOf)
                                     .collect(Collectors.toList());
        
        List<Integer> elements = extractCommonElements (firstSeries,secondSeries);
        System.out.println(elements);
        double d1 = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1;
        System.out.println("d1 == 1 ? " + (d1 == 1.0));
        System.out.println("d1 = "+ d1);

        Double c1 = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1;
        System.out.println("c1 == 1 ? " + (c1 == 1.0));
        System.out.println("c1 = "+ c1);
        System.out.println();
        for(var i=0;i<5;i++){
            System.out.print(i+"  ");
        }
        System.out.println();
        IntStream.range(0, 5).forEach(i->System.out.print(i+"  "));
        System.out.println();
        IntStream.range(0, 5).forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(0, 5).forEach(System.out::print);
        System.out.println();
        for(var i=0;i<15;i=i+3) {
            System.out.print(i +" ");
        }
        System.out.println();
        IntStream.iterate(0, i->i<15,i->i+3).forEach(i->System.out.print(i+ " "));
        System.out.println();
        IntStream.iterate(0, i->i<15,i->i+3).forEach(System.out::print);
        System.out.println();
        for(var i=0;;i=i+3){
            if(i>20){
                break;
            }
            System.out.print(i+" ");
        }

        System.out.println();
        IntStream.iterate(0, i->i+3).takeWhile(i->i<20).forEach(i->System.out.print(i+" "));

        System.out.println();

        List<String> names = List.of("Jack","Paul","Kate","Peter");
        names.forEach(name->System.out.print(name + "  "));

        System.out.println();
        names.stream().forEach(name->System.out.print(name +" "));

        System.out.println();
        for(var name:names){
            if(name.length()==4){
                System.out.print(name+" ");
            }
        }
        
        System.out.println();

        names.stream().filter(name->name.length()==4).forEach(name->System.out.print(name+"  "));

    }

    private static List<Integer> extractCommonElements(List<Integer> firstSeries, List<Integer> secondSeries) {
        Set<Integer> intersection = new HashSet<>(firstSeries);

        intersection.retainAll(secondSeries);
        if(firstSeries.get(0).equals(secondSeries.get(0))){
            intersection.add(firstSeries.get(0));
        }
        if(firstSeries.get(firstSeries.size()-1).equals(secondSeries.get(secondSeries.size()-1))){
            intersection.add(firstSeries.get(firstSeries.size()-1));
        }
        return intersection.stream().toList();
        
    }
}
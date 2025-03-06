package com.webautomation.exploration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStream {
    public static void main(String[] args) {
      

         List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,6,6,6,7,7,8,8,8,9,9,10);
         List<Integer> result = new ArrayList<>();

         //Skenarionya adalah mengambil semua angka 6 ke, lalu di add ke result
         //Tradisional Looping

        //  for (int i = 0; i < numbers.size(); i++){
        //     if (numbers.get(i) == 6){
        //         result.add(numbers.get(i));     
        //     }
        //  }
         for(Integer integer : numbers){
            if(integer == 6){
                result.add(integer);
            }
         }

         System.out.println("Result Tradisional Looping= " + result);

         //Stream Method

         result = numbers.stream().filter(integer1 -> integer1.equals(6)).collect(Collectors.toList());

         System.out.println("Result menggunakan Stream= " + result);
    }

}

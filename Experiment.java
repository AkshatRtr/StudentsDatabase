package com.practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Experiment {
    public static void main(String[] args) {
        List<String> messages = Arrays.asList("Tesla", "New", "Thirty", "Xmas");
        String sentence = "Tesla is a new age motors company";
        returnCommonSubstrings(sentence, messages).stream().forEach(System.out::println);
    }
    //return substrings from sentence that also exist in messages
    public static List<String> returnCommonSubstrings(String sentence,List<String> messages){
        List<String> commonSubstring= new ArrayList<String>();
        for(String message : messages){
            if (sentence.toLowerCase().contains(message.toLowerCase())) {
                //message = message.toLowerCase();
                commonSubstring.add(message);
            }
        }
        return commonSubstring;
    }
}
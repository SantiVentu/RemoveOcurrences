package com.mycompany.ejercicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Venturini Santiago
 */
public class Ejercicio {

    public static void main(String[] args) {

        String a = removeOcurrences("aabb  $$", 1);
        System.out.println(a);
    }

    private static String removeOcurrences(String target, int max) {
        List<String> targetAsList = toList(target);
        List<String> charactersToRemove = findCharacterToRemove(targetAsList, max); 
        removeCharacters(charactersToRemove, targetAsList);
        return listToString(targetAsList);
    }

    public static String listToString(List<String> targetAsList) {
        return String.join("", targetAsList);
    }

    public static ArrayList<String> toList(String target) {
        return new ArrayList<>(Arrays.asList(target.split("")));
    }

    public static List<String> findCharacterToRemove(List<String> target, int max) {
        List<String> charactersToRemove = new ArrayList<>();
        int occurrences = 0;
        String charPrev = null;   
        for (int i = 0; i < target.size(); i++) {
            String currentChar = target.get(i);
            if (currentChar.equals(charPrev)) {
                occurrences++; 
            } else {
                occurrences = 0;
            }
            if (occurrences >= max) {
                charactersToRemove.add(currentChar);   
            }
            charPrev = currentChar;
        }
        return charactersToRemove;
    }

    public static void removeCharacters(List<String> charactersToRemove, List<String> a) {
        for (int i = 0; i < charactersToRemove.size() ; i++) {
            a.remove(charactersToRemove.get(i));
        }
    }
}

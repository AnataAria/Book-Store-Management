/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.lib;

import java.util.List;

/**
 *
 * @author AnataArisa
 * @param <T>
 */
public class Validate{
    public static boolean regexValidate(String regex, String datain){
        if(regex == null || datain == null) return false;
        if(datain.matches(regex)) return true;
        return false;
    }
    
    public static boolean phoneValidate(String datain, int min, int max){
        if(datain == null) return false;
        if(!checkNumberic(datain)) return false;
        int size = datain.length();
        if(size < min || size > max) return false;
        return true;
    }
    
    public static boolean intValidate(String input, int min, int max){
        if(checkNumberic(input)){
            int a = Integer.parseInt(input);
            if(a >= min && a <= max ) return true;
        }
        return false;
    }
    
    public static boolean intValidate(int in, int min, int max){
         return in >= min && in <= max;
    }
    
    private static boolean checkNumberic(String datain){
        try{
            Integer.parseInt(datain);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
    public static boolean stringValidationSize(String datain, int min, int max){
        return datain.length() >= min && datain.length() <= max;
    }
}

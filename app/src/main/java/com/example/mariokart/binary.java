package com.example.mariokart;

public class binary{
    public static int decode(String input,int base){
        int sum = 0;
        if (!(1 <= base && base <= 9)){
            return -1;
        }
        for (int i = input.length()-1; i >= 0; i--){
            sum += Integer.parseInt(input.substring(i,i+1))*Math.pow(base,input.length()-i-1);
        }
        return sum;
    }
    public static String encode(long input, int base){
        if (!(1 <= base && base <= 9)){
            return "error";
        }
        int digitsReq = (int)(Math.log(input)/Math.log(base)+1);
        long n = input;
        String output = "";
        for (int i = digitsReq-1; i >= 0; i--){
            for (int p = base-1; p >= 0; p--){
                if (n >= p*Math.pow(base,i)){
                    n += -p*Math.pow(base,i);
                    output += Integer.toString(p);
                    break;
                }
            }
        }
        return output;
    }
    // encode(decode())
    public static String changeBase(String input, int baseA, int baseB){
        return encode(decode(input, baseA),baseB);
    }
}
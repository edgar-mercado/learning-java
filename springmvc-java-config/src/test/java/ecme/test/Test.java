package ecme.test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String base2=Integer.toString(n, 2);
        //System.out.println(base2);
        int count=0;
        int maxCount=0;
        boolean found=false;
        for (int i=0; i<base2.length(); i++){
                if ( base2.charAt(i)=='1'){
                        count++;                        

                    found=true;
                } else {
                    if (count>maxCount){
                        maxCount=count;
                      }
                    found = false;
                    count=0;
                }
        }
        if (count>maxCount) maxCount=count;
        System.out.println(maxCount);
    }
    
}
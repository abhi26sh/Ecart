package com.abhi.utils;

public class Helper {

    public static String get5Words(String des)
    {

        String[] str= des.split(" ");
        if(str.length>10)
        {
            String res="";
            for(int i=0;i<10;i++)
            {
                res+=str[i]+" ";

            }
            return res;
        }else{
            return des+"...";
        }
    }
}

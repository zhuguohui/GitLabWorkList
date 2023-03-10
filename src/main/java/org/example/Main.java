package org.example;

import org.example.api.QueryBean;
import org.example.gui.WorkListFrame;

public class Main  {


    public static void main(String[] args) {
       QueryBean queryBean= getUserSetInfo(args);
        WorkListFrame frame = new WorkListFrame(queryBean);
    }

    private static QueryBean getUserSetInfo(String[] args) {
        String url="";
        String name="";
        String token="";
        for(int i=0;i<args.length;i+=2){
            String argName = args[i];
            String argValue=args[i+1];
            if("-url".equals(argName)){
                url=argValue;
            }else if("-name".equals(argName)){
                name=argValue;
            }else if("-token".equals(argName)){
                token=argValue;
            }

        }

        return new QueryBean(url,token,name,"","");
    }

}


package info.md7.hackerrank.problem_solving;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//https://www.hackerrank.com/challenges/time-conversion/problem
public class TimeConversion {

    public static void main(String[] args) {
        System.out.println(timeConversion("12:01:00AM"));
    }

    public static String timeConversion(String s) {
        DateFormat df = new SimpleDateFormat("hh:mm:ssaa");
        DateFormat outputformat = new SimpleDateFormat("HH:mm:ss");
        Date date;
        String output = null;
        try{
            date= df.parse(s);
            output = outputformat.format(date);
        }catch(ParseException pe){
            pe.printStackTrace();
        }
        return output;
    }

}

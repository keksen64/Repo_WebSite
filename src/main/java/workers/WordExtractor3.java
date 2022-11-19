package workers;

//import test.MainClass;
import app.MainClass;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



//класс извлекает из текста связки по три русских слова длиною от трех букв и выполняет первичный подсчет одинаковых связок
public class WordExtractor3 {

    public static WordCountObject[] start(String resp){
        SortedMap<String,Integer> map = new TreeMap<>();
        //Pattern pattern = Pattern.compile("([А-Яа-я][А-Яа-я][А-Яа-я][А-Яа-я]*)");
        Pattern pattern = Pattern.compile("([А-Яа-я][А-Яа-я][А-Яа-я][А-Яа-я]* [А-Яа-я][А-Яа-я][А-Яа-я][А-Яа-я]* [А-Яа-я][А-Яа-я][А-Яа-я][А-Яа-я]*)");

        Matcher matcher = pattern.matcher(resp);
        while (matcher.find()) {
            int start=matcher.start();
            int end=matcher.end();
            if(MainClass.blackList.isInBlackList(resp.substring(start,end).toLowerCase())==true){
                continue;
            }
            Integer chesc = map.get(resp.substring(start,end).toLowerCase());
            if(chesc==null){
                map.put(resp.substring(start,end).toLowerCase(),1);
                // map.put(resp.substring(start,end),1);
            }else{
                Integer a =chesc+1;
                map.put(resp.substring(start,end).toLowerCase(),a);
                // map.put(resp.substring(start,end),a);
                System.out.println("перезапись "+ resp.substring(start,end) + " "+a);
            }
            //System.out.println("Найдено совпадение " + resp.substring(start,end) + " с "+ start + " по " + (end-1) + " позицию");
        }

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        WordCountObject[] arr = new WordCountObject[map.size()];
        int i =0;
        while (i<map.size()){
            Map.Entry<String, Integer> entry = iterator.next();
            arr[i]=new WordCountObject(entry.getKey(),entry.getValue());
            i++;
        }
        System.out.println(arr.length);
        return arr;
    }
}

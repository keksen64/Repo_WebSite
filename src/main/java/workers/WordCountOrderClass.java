package workers;

import java.util.*;



//класс выполняющий сортировку итогового массива объектов WordCouuntObject по кол-ву зафиксированных слов/связок
public class WordCountOrderClass {
    public static Map<String,Integer> transform (WordCountObject[] arr){
        Map<String, Integer> map = new TreeMap<>();
        int i =0;
        while (i< arr.length){
            if(arr[i]!=null){
                map.put(arr[i].word,arr[i].count);
            }
            i++;
        }
        System.out.println(map.size());
        return map;
    }


    public static Map<String, Integer>
    //valueSort(final Map<String, Integer> map)
    valueSort(WordCountObject[] arr)
    {
        Map<String, Integer> map = transform(arr);
        // Static Method with return type Map and
        // extending comparator class which compares values
        // associated with two keys
        Comparator<String> valueComparator = new Comparator<String>() {
            // return comparison results of values of
            // two keys
            public int compare(String k1, String k2)
            {
                int comp = map.get(k2).compareTo(
                        map.get(k1));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }
        };
        // SortedMap created using the comparator
        Map<String, Integer> sorted = new TreeMap<String, Integer>(valueComparator);
        sorted.putAll(map);
        return sorted;
    }


}

package workers;

import java.util.Set;

public class BlackList {
    Set<String> set;
    {
       try {
           set = Reader2Set.read("blackList.csv");
           Object[] ar = set.toArray();
           System.out.println(ar[0].toString());
       }catch (Exception e){
           System.out.println("ОШИБКА ПРИ СОЗДАНИИ ЧЕРНОГО СПИСКА");
       }
    }
    public boolean isInBlackList(String str){
        return set.contains(str);
    }
}

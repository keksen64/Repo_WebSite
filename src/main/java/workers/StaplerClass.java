package workers;

import java.util.List;
import java.util.Set;


public class StaplerClass {
    public static String staple(List<String> list){
        StringBuilder sb = new StringBuilder();
        int i=0;
        while (i<list.size()){
            try {
                sb.append(RequestSender.sendGet(list.get(i)));
            }catch (Exception e){
                System.out.println(e);
            }
            i++;
        }
        try {
            return sb.toString();
        }catch (Exception e){
            System.out.println("степлер вернул пустое тело");
            return "";
        }

    }
}

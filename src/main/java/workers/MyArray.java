package workers;



//класс предназначен для визуализации массивов с обьектами типа WordCountObject
public class MyArray {
    public static void show(WordCountObject[] r){
        int i =0;
        while (i<r.length){
            if(r[i]!=null){
                System.out.println(r[i].toString());
            }else {
                System.out.println("null");
            }
            i++;
        }
    }
}

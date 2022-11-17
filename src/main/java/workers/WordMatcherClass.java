package workers;



// класс выполняет вторичный подсчет одинаковых слов игнорируя отличающиеся окончания
public class WordMatcherClass {
    public static WordCountObject[] match(WordCountObject[] arr){

        int replaseCount =0;
        int size = arr.length;
        int i=0;
        while (i<size){
            int k =0;
            while (k<size){
                if(arr[i]!=null&&arr[k]!=null&&i!=k){
                    //System.out.println("встретились не нули");
                    if(reconciliation(arr[i],arr[k])){
                        System.out.println("сверка делает замену" + arr[i].toString()+ " "+ arr[k].toString());
                        arr[i].count=arr[i].count + arr[k].count;
                        arr[k]=null;
                        replaseCount++;
                        System.out.println("после замены" + arr[i].toString());
                    }
                }
                k++;
            }
            i++;
        }
        System.out.println("сделано "+ replaseCount + " замен");
        return arr;
    }




    public static boolean reconciliation(WordCountObject o1,WordCountObject o2){
        Boolean b = false;
        String s1 = o1.word;
        String s2 = o2.word;



        //если отличие больше двух символов
        if(Math.abs(s1.length()-s2.length())>2){
            return false;
        }
        //если длины равны
        if(Math.abs(s1.length()-s2.length())==0){
            if (s1.length()>4){
                //-2
                String ss1 = s1.substring(0, s1.length() - 2);
                String ss2 = s2.substring(0, s2.length() - 2);
                if(ss1.equals(ss2)){
                    return true;
                }else {
                    return false;
                }
            }else {
                //-1
                String ss1 = s1.substring(0, s1.length() - 1);
                String ss2 = s2.substring(0, s2.length() - 1);
                if(ss1.equals(ss2)){
                    return true;
                }else {
                    return false;
                }
            }
        }
        //если отличие два символа то у бОльшего надо отнять два символа и сравнить
        if(Math.abs(s1.length()-s2.length())==2){
            if (s1.length()>s2.length()){
                //s1 длиннее
                String ss1 = s1.substring(0, s1.length() - 2);
                String ss2 = s2;
                if(ss1.equals(ss2)){
                    return true;
                }else {
                    return false;
                }
            }else {
                //s2 длиннее
                String ss1 = s1;
                String ss2 = s2.substring(0, s2.length() - 2);
                if(ss1.equals(ss2)){
                    return true;
                }else {
                    return false;
                }
            }
        }
        //если отличие один символ
        if(Math.abs(s1.length()-s2.length())==1){
            if (s1.length()>s2.length()){
                //s1 длиннее
                if(s2.length()>3){
                    String ss1 = s1.substring(0, s1.length() - 2);
                    String ss2 = s2.substring(0, s2.length() - 1);
                    if(ss1.equals(ss2)){
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    String ss1 = s1.substring(0, s1.length() - 1);
                    String ss2 = s2;
                    if(ss1.equals(ss2)){
                        return true;
                    }else {
                        return false;
                    }
                }
            }else {
                //s2 длиннее
                if(s1.length()>3){
                    String ss1 = s1.substring(0, s1.length() - 1);
                    String ss2 = s2.substring(0, s2.length() - 2);
                    if(ss1.equals(ss2)){
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    String ss1 = s1;
                    String ss2 = s2.substring(0, s2.length() - 1);
                    if(ss1.equals(ss2)){
                        return true;
                    }else {
                        return false;
                    }
                }
            }
        }
        return b;
    }

}

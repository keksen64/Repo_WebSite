package workers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader2List {
    public static List<String> read(String filePath) throws IOException {
        String file_string = null;
        List<String> list = new ArrayList<String>() {
        };
        try {
            byte[] response = Files.readAllBytes(Paths.get(filePath));
             file_string = "";

            for(int i = 0; i < response.length; i++)
            {
                file_string += (char)response[i];
            }
            Scanner scan = new Scanner(file_string);
            int i =0;
            while (scan.hasNextLine()){
                list.add(i,scan.nextLine());
                //System.out.println(scan.nextLine());
                i++;
            }
        }catch (Exception e){
            System.out.println("Ошибка записи листа");
        }
        return list;
    }

}

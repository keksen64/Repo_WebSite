package workers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Reader2Set {
    public static Set<String> read(String filePath) throws IOException {
        Set<String> set = new HashSet<>() {
        };
        try {
            byte[] response = Files.readAllBytes(Paths.get(filePath));
            String file_string = new String(response, StandardCharsets.UTF_8);
            Scanner scan = new Scanner(file_string);
            System.out.println(file_string);
            int i =0;
            while (scan.hasNextLine()){
                String st = scan.nextLine();
                set.add(st);
                System.out.println(st);
                //System.out.println(scan.nextLine());
                i++;
            }
        }catch (Exception e){
            System.out.println("Ошибка записи сета");
        }
        return set;
    }

}

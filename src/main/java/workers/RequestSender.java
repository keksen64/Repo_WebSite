package workers;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class RequestSender {
    public static String sendGet(String url) {
        //date = "2022-06-04";
        String USER_AGENT = "Mozilla/5.0";
        //  String kk = "gdpr=0; _ym_uid=165221667337589987; _ym_d=1652216720; _ym_isad=2; yandexuid=9362196211652216737; yuidss=9362196211652216737; i=r/ZyEjz6R7kLVC7OYclmLUZ1a34T8x+f930+/YuDQLJFR0/F13YEouunp4n3QcQnB4C/pN14YMyfXU9J+ouXSP1qexA=; ymex=1967576737.yrts.1652216737#1967576737.yrtsi.1652216737; _yasc=QYv7z4L1/gRvcGNuOIqJZMTQEPZ6hLDBhN3xVxEiD0Jwrru9F7g=; _ym_visorc=b; spravka=dD0xNjUyMjE2NzU3O2k9OTUuNzIuMTMwLjE1MTtEPTUyN0U5QjA1Rjk1QzQ4N0I1MzY1ODZFOThCNUYzNjYyRkREQkI0ODFEQzI3MkQwODg0QjU4NjA4MjU4ODY0OThFM0VEQjQ2Mjt1PTE2NTIyMTY3NTczNzEzMjU3MDQ7aD0wOGUzYTRhYTc4NmU5ZTllNjIyMGY3ZTBlYTNlYTQ0OA==";
        //String url = "https://afisha.yandex.ru/api/events/rubric/theatre?limit=20&offset=" + offset + "&hasMixed=0&date=" + date + "&period=1&city=moscow";
        //String url = "https://www.rbc.ru/";

       // String kk = "yandexuid=4828503981653031824; afisha.sid=s%3ANjBKyHpGMlpN_fqLYM-wC1vwblB269SI.HXXqUzyI1JfKKipn0c9zH1gCD4hpdpAXm7cvtUhbu%2F8; _yasc=e1B5VRHsjtWZnZJRSv78MMN61fJyBjC1G8k6WR3B0aCN3pFFr3pp+g==; i=zoYFKGIjh5IVaz8eP83bwdz3aQMzKmabikE1ALBwr7Lb+rwzkvYfPHeD+Wm1X1YoALfhyHEUZC0pPa4BXIbp8v/OYHo=; yuidss=4828503981653031824; ymex=1968391826.yrts.1653031826; is_gdpr=0; is_gdpr_b=CIbRLhD6cw==; _ym_uid=1653031809899399395; _ym_d=1653031810; involved=1; _ga=GA1.2.180188634.1653035716; _csrf=mmwdj-VEwcjoLUL8MNXhccFE";
        // String kk = "yandexuid=7704227391623953799; yuidss=7704227391623953799; ymex=1939313799.yrts.1623953799#1939313799.yrtsi.1623953799; is_gdpr=0; amcuid=3222335021624455394; _ym_uid=162591336825833330; gdpr=0; is_gdpr_b=CPmbExDbSCgC; my=YwA=; L=BjkGQFh2XHFWZUBgR0ZEZkR0bAFlUAhbHzERIgl0PgMCYiQCNSI=.1633105869.14745.331070.9c26139025c2d45577949804c137266a; yandex_login=nphne-vus4qiyr; _ym_d=1643412162; i=E4IOSDZeJLG5zo8tker/rhDAiaxgzREq9DBBB6UHXblsOcjWQTGbo6tWLh+trHGS6Cwdekc7Z4udZRclGZr/wiKeIUE=; yp=1948465869.udn.cDrQkNC90LDRgdGC0LDRgdC40Y8g0KHQu9GO0YHQsNGA0LXQvdC60L4=#1648873819.szm.1_25:1536x864:1536x696#1948465869.multib.1#1643498586.nwcst.1643414400_10750_2#1646004184.ygu.1#1646004162.spcs.l#1646090596.csc.1#1674948175.p_sw.1643412174#1644016975.mcv.0#1644016975.mcl.; afisha.sid=s:oX4etKVHDVw6weY1T2XlISYJGv7jjL0V.e27d4kQLnmcUzq1/75vvkaslFC9gZZu9heePrEUUNXc; spravka=dD0xNjUyMjE2NTQzO2k9OTUuNzIuMTMwLjE1MTtEPTY3RkJFQzI2QUI0QUEzMDZFMkJFMjFCNDkxODlEMkI5RTg1MjYyRTRERUZERjU4RkM5RDIzMjgxQTQzRUEwODZGN0FERDYyODt1PTE2NTIyMTY1NDM1NTc2NzYyMDk7aD01ZjZkMzZlNzU0YmQyMmRkNGFmNDlkMjAzOTY3MWEyZQ==; _ga=GA1.2.1455372639.1652218302; Session_id=3:1653031026.5.1.1626689696482:js-6wg:45.1.2:1|1454389110.0.402|1485242205.-1.0.2:6416173|3:252609.280435.gAuIi_-M1TkXSVKFxHXO-p8pf5Q; sessionid2=3:1653031026.5.1.1626689696482:js-6wg:45.1.2:1.499:1|1454389110.0.402|1485242205.-1.0.2:6416173|3:252609.14453.aufGM1MZfMrkdTADgi7ShqbY2NE; ys=udn.cDrQkNC90LDRgdGC0LDRgdC40Y8g0KHQu9GO0YHQsNGA0LXQvdC60L4=#c_chck.2264057363; _csrf=xJWRKDItk-8-U9kDDV7vh49O; _ym_isad=2; _yasc=uOMuLBtGkEdNsDbhDjtkMjAQ/vQOb60YbLbxrr5lxlSuXAWKzP4=; cycada=QSGoGBVHisP/smisG19Y3v7H5uy3Z+NjEb07ujUbPa4=";
        // String url = "https://afisha.yandex.ru/moscow/theatre?source=menu&date=2022-05-27&period=1";
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.54 Safari/537.36");
        //request.addHeader(":path:", "/film/"+ id +"/like/");
        request.addHeader("method", "GET");
        //request.addHeader("cookie", kk);
        //request.addHeader("accept-encoding", "gzip, deflate, br");
        request.addHeader("accept-language", "ru-RU,ru;q=0.9");
        request.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        request.addHeader("User-Agent", USER_AGENT);

        try {
            HttpResponse response = client.execute(request);
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " +
                    response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String str;
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        }catch (Exception e){
            System.out.println(e);
            System.out.println("ошибка отправки запроса гет");
            return null;
        }


//        ArrayList<MT> mc = new ArrayList<MT>();
//        for (int i = 0; i < 30; i++) {
//            mc.add(new MT());
//            mc.get(i).start();
//        }
        //System.out.println(result.toString());


    }
}
package app;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import workers.*;

public class MainClass {
   // public static BlackList blackList = new BlackList();



    public static void main(String[] args) throws Exception {

//        WordCountObject[] r = WordMatcherClass.match(WordExtractorClass.start(StaplerClass.staple(Reader2List.read("siteList.csv"))));
//        System.out.println(r.length);
////        System.out.println(WordCountOrderClass.valueSort(r));
////String test = "Стена состояла из бетонных сегментов высотой в 3,60 м, оборудованных сверху практически непреодолимыми цилиндрическими барьерами. При необходимости стену можно было нарастить в высоту. Кроме самой стены были возведены новые сторожевые башни, строения для пограничников, увеличено количество средств уличного освещения, создана сложная система барьеров. Каждые 200 метров располагались посты пограничников. Со стороны Восточного Берлина вдоль всей протяжённости стены существовала специальная запретная зона с предупредительными табличками «Стой! Пограничная зона. Проход запрещён». Заходить на эту зону гражданским лицам категорически запрещалось. Далее — стена, отделяющая Восточный Берлин, после стены шли металлическая сетка с колючей проволокой, оборудованная бесшумной сигнализацией";
//        WordCountObject[] r = WordMatcher3.match(WordExtractor3.start(StaplerClass.staple(Reader2List.read("siteList.csv"))));
////        WordCountObject[] r = WordMatcher3.match(WordExtractor3.start(test));
//        System.out.println(r.length);
//        System.out.println(WordCountOrderClass.valueSort(r));


        HttpServer server = HttpServer.create(new InetSocketAddress(8003), 0);
        server.createContext("/app", new MyHandler());
        server.createContext("/main", new StatikHTML());
        server.createContext("/blog.css", new Statikcss1());
        server.createContext("/bootstrap.min.css", new Statikcss2());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "Ответ тестового обработчика";

           // String rawString = "Entwickeln Sie mit Vergnügen";
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
            t.getResponseHeaders().set("Access-Control-Allow-Origin"," *");
            t.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
           // t.sendResponseHeaders("Access-Control-Allow-Origin: *");
            t.sendResponseHeaders(200, 0);
            OutputStream os = t.getResponseBody();
            Writer ow = new OutputStreamWriter(os);
            ow.write(utf8EncodedString);
            ow.close();
            os.close();
        }
    }


    static class StatikHTML implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {

            try {
                String filePath = "index.html";

                // file to byte[], Path
                byte[] response = Files.readAllBytes(Paths.get(filePath));
                httpExchange.setAttribute("Content-Type", "text/html; charset=UTF-8");
                httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", " *");
                httpExchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
                OutputStream outputStream = httpExchange.getResponseBody();
                httpExchange.sendResponseHeaders(200, response.length);
                outputStream.write(response);
                outputStream.flush();
                outputStream.close();
                httpExchange.getRequestBody().close();
            }catch (Exception e){
                String responseErr = "ошибка загрузки файла";
                byte[] bytesErr = responseErr.getBytes(StandardCharsets.UTF_8);
                String utf8EncodedStringErr = new String(bytesErr, StandardCharsets.UTF_8);
                httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", " *");
                httpExchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
                // t.sendResponseHeaders("Access-Control-Allow-Origin: *");
                httpExchange.sendResponseHeaders(200, 0);
                OutputStream os = httpExchange.getResponseBody();
                Writer ow = new OutputStreamWriter(os);
                ow.write(utf8EncodedStringErr);
                ow.close();
                os.close();
            }
        }
    }

    static class Statikcss1 implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {

            try {
                String filePath = "blog.css";
                // file to byte[], Path
                byte[] response = Files.readAllBytes(Paths.get(filePath));
                httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", " *");
                httpExchange.getResponseHeaders().set("Content-Type", "text/css; charset=UTF-8");
                httpExchange.setAttribute("Content-Type", "text/css; charset=UTF-8");
                OutputStream outputStream = httpExchange.getResponseBody();
                httpExchange.sendResponseHeaders(200, response.length);
                outputStream.write(response);
                outputStream.flush();
                outputStream.close();
                httpExchange.getRequestBody().close();
            }catch (Exception e){
                System.out.println(e);
                String responseErr = "ошибка загрузки файла";
                byte[] bytesErr = responseErr.getBytes(StandardCharsets.UTF_8);
                String utf8EncodedStringErr = new String(bytesErr, StandardCharsets.UTF_8);
                httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", " *");
                httpExchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
                // t.sendResponseHeaders("Access-Control-Allow-Origin: *");
                httpExchange.sendResponseHeaders(200, 0);
                OutputStream os = httpExchange.getResponseBody();
                Writer ow = new OutputStreamWriter(os);
                ow.write(utf8EncodedStringErr);
                ow.close();
                os.close();
            }
        }
    }


    static class Statikcss2 implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {

            try {
                String filePath = "bootstrap.min.css";
                // file to byte[], Path
                byte[] response = Files.readAllBytes(Paths.get(filePath));
                httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", " *");
                httpExchange.getResponseHeaders().set("Content-Type", "text/css; charset=UTF-8");
                httpExchange.setAttribute("Content-Type", "text/css; charset=UTF-8");
                OutputStream outputStream = httpExchange.getResponseBody();
                httpExchange.sendResponseHeaders(200, response.length);
                outputStream.write(response);
                outputStream.flush();
                outputStream.close();
                httpExchange.getRequestBody().close();
            }catch (Exception e){
                System.out.println(e);
                String responseErr = "ошибка загрузки файла";
                byte[] bytesErr = responseErr.getBytes(StandardCharsets.UTF_8);
                String utf8EncodedStringErr = new String(bytesErr, StandardCharsets.UTF_8);
                httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", " *");
                httpExchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
                // t.sendResponseHeaders("Access-Control-Allow-Origin: *");
                httpExchange.sendResponseHeaders(200, 0);
                OutputStream os = httpExchange.getResponseBody();
                Writer ow = new OutputStreamWriter(os);
                ow.write(utf8EncodedStringErr);
                ow.close();
                os.close();
            }
        }
    }


}
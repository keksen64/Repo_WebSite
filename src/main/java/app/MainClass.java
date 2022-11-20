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

public class MainClass {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8003), 0);
        server.createContext("/app", new MyHandler());
        server.createContext("/main", new StatikHTML());
        server.createContext("/blog.css", new StatikcssBlog());
        server.createContext("/bootstrap.min.css", new StatikcssBootstrap());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

//    static class MyHandler implements HttpHandler {
//        @Override
//        public void handle(HttpExchange t) throws IOException {
//            String response = "Ответ тестового обработчика";
//           // String rawString = "Entwickeln Sie mit Vergnügen";
//            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
//            String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
//            t.getResponseHeaders().set("Access-Control-Allow-Origin"," *");
//            t.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
//           // t.sendResponseHeaders("Access-Control-Allow-Origin: *");
//            t.sendResponseHeaders(200, 0);
//            OutputStream os = t.getResponseBody();
//            Writer ow = new OutputStreamWriter(os);
//            ow.write(utf8EncodedString);
//            ow.close();
//            os.close();
//        }
//    }
//
//
//    static class StatikHTML implements HttpHandler {
//        @Override
//        public void handle(HttpExchange httpExchange) throws IOException {
//
//            try {
//                String filePath = "index.html";
//                byte[] response = Files.readAllBytes(Paths.get(filePath));
//                httpExchange.setAttribute("Content-Type", "text/html; charset=UTF-8");
//                httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", " *");
//                httpExchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
//                OutputStream outputStream = httpExchange.getResponseBody();
//                httpExchange.sendResponseHeaders(200, response.length);
//                outputStream.write(response);
//                outputStream.flush();
//                outputStream.close();
//                httpExchange.getRequestBody().close();
//            }catch (Exception e){
//                String responseErr = "ошибка загрузки файла";
//                byte[] bytesErr = responseErr.getBytes(StandardCharsets.UTF_8);
//                String utf8EncodedStringErr = new String(bytesErr, StandardCharsets.UTF_8);
//                httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", " *");
//                httpExchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
//                // t.sendResponseHeaders("Access-Control-Allow-Origin: *");
//                httpExchange.sendResponseHeaders(200, 0);
//                OutputStream os = httpExchange.getResponseBody();
//                Writer ow = new OutputStreamWriter(os);
//                ow.write(utf8EncodedStringErr);
//                ow.close();
//                os.close();
//            }
//        }
//    }
//
//    static class Statikcss1 implements HttpHandler {
//        @Override
//        public void handle(HttpExchange httpExchange) throws IOException {
//
//            try {
//                String filePath = "blog.css";
//                byte[] response = Files.readAllBytes(Paths.get(filePath));
//                httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", " *");
//                httpExchange.getResponseHeaders().set("Content-Type", "text/css; charset=UTF-8");
//                httpExchange.setAttribute("Content-Type", "text/css; charset=UTF-8");
//                OutputStream outputStream = httpExchange.getResponseBody();
//                httpExchange.sendResponseHeaders(200, response.length);
//                outputStream.write(response);
//                outputStream.flush();
//                outputStream.close();
//                httpExchange.getRequestBody().close();
//            }catch (Exception e){
//                System.out.println(e);
//                String responseErr = "ошибка загрузки файла";
//                byte[] bytesErr = responseErr.getBytes(StandardCharsets.UTF_8);
//                String utf8EncodedStringErr = new String(bytesErr, StandardCharsets.UTF_8);
//                httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", " *");
//                httpExchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
//                // t.sendResponseHeaders("Access-Control-Allow-Origin: *");
//                httpExchange.sendResponseHeaders(200, 0);
//                OutputStream os = httpExchange.getResponseBody();
//                Writer ow = new OutputStreamWriter(os);
//                ow.write(utf8EncodedStringErr);
//                ow.close();
//                os.close();
//            }
//        }
//    }
//
//
//    static class Statikcss2 implements HttpHandler {
//        @Override
//        public void handle(HttpExchange httpExchange) throws IOException {
//            try {
//                String filePath = "bootstrap.min.css";
//                // file to byte[], Path
//                byte[] response = Files.readAllBytes(Paths.get(filePath));
//                httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", " *");
//                httpExchange.getResponseHeaders().set("Content-Type", "text/css; charset=UTF-8");
//                httpExchange.setAttribute("Content-Type", "text/css; charset=UTF-8");
//                OutputStream outputStream = httpExchange.getResponseBody();
//                httpExchange.sendResponseHeaders(200, response.length);
//                outputStream.write(response);
//                outputStream.flush();
//                outputStream.close();
//                httpExchange.getRequestBody().close();
//            }catch (Exception e){
//                System.out.println(e);
//                String responseErr = "ошибка загрузки файла";
//                byte[] bytesErr = responseErr.getBytes(StandardCharsets.UTF_8);
//                String utf8EncodedStringErr = new String(bytesErr, StandardCharsets.UTF_8);
//                httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", " *");
//                httpExchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
//                // t.sendResponseHeaders("Access-Control-Allow-Origin: *");
//                httpExchange.sendResponseHeaders(200, 0);
//                OutputStream os = httpExchange.getResponseBody();
//                Writer ow = new OutputStreamWriter(os);
//                ow.write(utf8EncodedStringErr);
//                ow.close();
//                os.close();
//            }
//        }
//    }
}
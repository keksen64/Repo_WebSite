package app;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StatikcssBootstrap implements HttpHandler {

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

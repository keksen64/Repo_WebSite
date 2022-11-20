package app;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class MyHandler implements HttpHandler {
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

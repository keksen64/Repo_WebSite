package app;


import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class MainClass {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8003), 0);
        server.createContext("/app", new MyHandler());
        server.createContext("/main", new StatikHTML());
        server.createContext("/blog.css", new StatikcssBlog());
        server.createContext("/bootstrap.min.css", new StatikcssBootstrap());
        server.createContext("/a.png", new StaticImage1());
        server.createContext("/mem.jpeg", new StaticImage2());
        server.createContext("/CV.pdf", new StaticCV());
        server.setExecutor(java.util.concurrent.Executors.newFixedThreadPool(10));
        server.start();
    }
}
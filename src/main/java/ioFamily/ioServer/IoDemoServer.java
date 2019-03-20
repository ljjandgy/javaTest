package ioFamily.ioServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: LJJ
 * @Date: 2019/2/24 22:00
 */
public class IoDemoServer extends Thread{
        private ServerSocket serverSocket;
        private ExecutorService executor;
        public int getPort() {
            return  serverSocket.getLocalPort();
        }
        @Override
        public void run() {
            try {
                serverSocket = new ServerSocket(0);
                while (true) {
                    Socket socket = serverSocket.accept();
                    executor = Executors.newFixedThreadPool(8);//定义线程池
                    RequestHandler requestHandler = new RequestHandler(socket);
                    executor.execute(requestHandler);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ;
                }
            }
        }
        public static void main(String[] args) throws IOException {
        IoDemoServer server = new IoDemoServer();
        server.start();
        try (Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println(s));
        }
    }
}

package ioFamily.ioServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author: LJJ
 * @Date: 2019/2/24 22:12
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        IoDemoServer server = new IoDemoServer();
        server.start();
        try (Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println(s));
        }
    }
}

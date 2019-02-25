package ioFamily.ioServer;

import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author: LJJ
 * @Date: 2019/2/24 22:01
 */
public class RequestHandler extends Thread{
    private Socket socket;
    RequestHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream());) {
            out.println("Hello world!");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

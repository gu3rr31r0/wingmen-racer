package org.academiadecodigo.roothless.udpserver;

import com.badlogic.gdx.Input;
import org.academiadecodigo.roothless.gameworld.GameWorld;
import org.academiadecodigo.roothless.helpers.InputHandler;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by codecadet on 31/03/17.
 */
public class UDPServer implements Runnable {


    int port = 9999;
    private InputHandler inputHandler;
    DatagramSocket socket = null;

    public UDPServer(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
        try {
            socket = new DatagramSocket(port);
            System.out.println(socket.getPort());
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void listen() {

        byte[] received = new byte[1024];
        String message = null;


        try {
            System.out.println("waiting packet");
            DatagramPacket receivedPacket = new DatagramPacket(received, received.length);
            socket.receive(receivedPacket);

            message = new String(received);

            System.out.println(message);

            if (message.equals("left")) {
                inputHandler.keyDown(Input.Keys.LEFT);
            }

            if (message.equals("right")) {
                inputHandler.keyDown(Input.Keys.RIGHT);
            }

            if (message.equals("start")) {
                inputHandler.keyDown(Input.Keys.SPACE);
            }


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            listen();
        }
    }
}

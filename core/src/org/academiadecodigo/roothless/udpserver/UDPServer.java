package org.academiadecodigo.roothless.udpserver;

import com.badlogic.gdx.Input;
import org.academiadecodigo.roothless.helpers.InputHandler;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by codecadet on 31/03/17.
 */
public class UDPServer implements Runnable{


    int port = 8080;
    private InputHandler inputHandler;

    public UDPServer(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void listen() {

        byte[] received = new byte[1024];
        String message = null;

        DatagramSocket socket = null;
        try {


            socket = new DatagramSocket(port);
            while (true) {

                DatagramPacket receivedPacket = new DatagramPacket(received, received.length);
               socket.receive(receivedPacket);

               message = new String(received);

               if (message.equals("left")) {
                   inputHandler.keyDown(Input.Keys.LEFT);
               }

               if (message.equals("right")) {
                   inputHandler.keyDown(Input.Keys.RIGHT);
               }

               if (message.equals("pause")) {
                   inputHandler.keyDown(Input.Keys.ESCAPE);
               }

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

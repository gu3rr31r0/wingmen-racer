package org.academiadecodigo.roothless;

import java.io.IOException;
import java.net.*;


/**
 * Created by codecadet on 31/03/17.
 */
public class UDPConnector {

    String message = "";

    private InputHandler inputHandler;

    public void setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void render() {


        if (message.equals("")) {
            return;
        }

        inputHandler.setSendMessage(false);
        String host = "192.168.1.4";
        int port = 9999;

        byte[] sendBuffer = message.getBytes();

        DatagramSocket socket = null;

        System.out.println(message);

        message = "";

        try {
            socket = new DatagramSocket();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(host), port);
            socket.send(sendPacket);


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }

    }

    public void sendMessage(String message) {
        this.message = message;
    }
}

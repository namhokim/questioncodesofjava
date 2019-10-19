package com.naver.cafe.javachobostudy.sjw7324;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

    private DatagramSocket serverSocket;

    private Server(int port) throws SocketException {
        serverSocket = new DatagramSocket(9876);
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(9876);

        while (true) {
            ReceivePayload payload = server.receive();
            System.out.println(payload.message);
            server.echoBack(payload);
        }
    }

    private void echoBack(ReceivePayload payload) throws IOException {
        byte[] sendData = payload.message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, payload.clientAddress, payload.clientPort);
        serverSocket.send(sendPacket);
    }

    private ReceivePayload receive() throws IOException {
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        return ReceivePayload.from(receivePacket);
    }

    static class ReceivePayload {
        private InetAddress clientAddress;
        private int clientPort;
        private String message;

        ReceivePayload(InetAddress clientAddress, int clientPort, String message) {
            this.clientAddress = clientAddress;
            this.clientPort = clientPort;
            this.message = message;
        }

        static ReceivePayload from(DatagramPacket datagramPacket) {
            String message = new String(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength());
            return new ReceivePayload(datagramPacket.getAddress(), datagramPacket.getPort(), message);
        }
    }
}

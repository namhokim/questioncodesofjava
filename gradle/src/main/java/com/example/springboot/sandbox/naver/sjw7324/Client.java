package com.example.springboot.sandbox.naver.sjw7324;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

@Slf4j
public class Client implements Runnable {

    private InetAddress serverAddress;
    private int serverPort;
    private DatagramSocket clientSocket;   // 소켓

    private Client(InetAddress serverAddress, int serverPort) throws SocketException {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.clientSocket = new DatagramSocket();
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client(InetAddress.getLoopbackAddress(), 9876);

        Thread threadForReceive = new Thread(client);
        threadForReceive.start();

        Scanner sc = new Scanner(System.in);
        while (true) {
            String lineWithoutLF = sc.nextLine();
            String lineWithLF = String.format("%s%n", lineWithoutLF);
            client.send(lineWithLF);
        }
    }

    private void send(String message) throws IOException {
        byte[] sendData = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
        clientSocket.send(sendPacket);
    }

    @Override
    public void run() {
        while (true) {
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            try {
                clientSocket.receive(receivePacket);   // 서버로 부터 메시지를 받음
            } catch (IOException e) {
                log.error("Client exception", e);
            }
            String message = new String(receiveData, 0, receivePacket.getLength());
            System.out.print(message);
        }
    }
}

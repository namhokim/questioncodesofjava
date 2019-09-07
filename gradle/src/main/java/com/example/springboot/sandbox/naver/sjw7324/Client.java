package com.example.springboot.sandbox.naver.sjw7324;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

@Slf4j
public class Client implements Runnable {

    static DatagramSocket clientSocket;   // 소켓
    static byte[] IP = {127, 0, 0, 1};       // 서버 IP
    static InetAddress IPAddress;         // 서버 IP
    static byte[] sendData;               // 전송할 데이터
    static byte[] receiveData;           // 전송받은 데이터
    static DatagramPacket sendPacket;     // 출력 패킷
    static DatagramPacket receivePacket;  // 입력 패킷

    Thread t = new Thread(this);
    public Client() {
        t.start();
    }

    public static void main(String[] args) throws IOException {
        clientSocket = new DatagramSocket();
        IPAddress = InetAddress.getByAddress(IP);
        sendData = new byte[1024];
        receiveData = new byte[1024];

        Scanner sc = new Scanner(System.in);

        new Client();
        while (true) {
            String sentance = sc.next();
            sendData = sentance.getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            clientSocket.send(sendPacket);
        }
    }

    @Override
    public void run() {
        while (true) {
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            try {
                clientSocket.receive(receivePacket);   // 서버로 부터 채팅을 받음
            } catch (IOException e) {
                log.error("Client exception", e);
            }
            String re = new String(receivePacket.getData());
            System.out.println(re);
        }
    }
}

package com.example.springboot.sandbox.devhaja.nyong;

import java.util.HashMap;

public class CommandBuilder {
    private V2 v2;
    private V3 v3;
    private String version;

    public CommandBuilder(String version, HashMap<String, String> param) {
        V2 v2cmd;
        V3 v3cmd;
        if (version.equals("2.x")) {
            v2cmd = new V2.Builder()
                    .setA(param.get("a"))
                    .setB(param.get("b"))
                    .setC(param.get("c"))
                    .setD(param.get("d"))
                    .build();
        } else if (version.equals("3.x")) {
            v3cmd = new V3.Builder()
                    .setA(param.get("a"))
                    .setB(param.get("b"))
                    .setC(param.get("c"))
                    .setE(param.get("e"))
                    .build();
        }
    }

    public String result() {
        return this.v2.toString();
    }

    public static void main(String[] args) {

        HashMap<String, String> param = new HashMap<>();
        param.put("a", "apple");
        param.put("b", "banana");
        param.put("c", "camera");
        param.put("d", "drama");

        CommandBuilder commandBuilder = new CommandBuilder("2.x", param);
        commandBuilder.result();
        String v2 = commandBuilder.result();

        System.out.println("");
    }
}

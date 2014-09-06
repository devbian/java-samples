package com.devbian.webserver;

import java.io.*;
import java.net.Socket;

/**
 * Created by phnix on 2014/9/6.
 */
public class Processor extends Thread {
    private InputStream input;
    private PrintStream output;

    private static final String WEB_ROOT = "D:\\workspace\\web";

    public Processor(Socket socket) {
        try {
            input = socket.getInputStream();
            output = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        try {
            String fileName = parse(input);
            readFile(fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private String parse(InputStream input) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
        String inputContent = bufferedReader.readLine();
        if (inputContent == null || inputContent.length() == 0) {
            sendError(400, "client invoke error");
            return null;
        }

        String[] request = inputContent.split(" ");
        if (request.length != 3) {
            sendError(400, "client invoke error");
            return null;
        }

        String method = request[0];
        String fileName = request[1];
        String httpVersion = request[2];

        System.out.println("Method: " + method + ", file name: " + fileName + ", HTTP Version: " + httpVersion);
        return fileName;
    }

    public void readFile(String fileName) throws IOException {
        File file = new File(WEB_ROOT + fileName);
        if (!file.exists()) {
            sendError(404, "file not found");
            return;
        }
        InputStream in = new FileInputStream(file);
        byte[] content = new byte[(int) file.length()];
        in.read(content);
        output.println("HTTP/1.1 200 sendFile");
        output.println("Content-length: " + content.length);
        output.println();
        output.write(content);
        output.flush();
        output.close();
        in.close();
    }

    public void sendError(int errNum, String errMsg) throws IOException {
        output.println("HTTP/1.1 " + errNum + " " + errMsg);
        output.println("Content-type: text/html");
        output.println();
        output.println("<html>");
        output.println("<head><title>Error</title></head>");
        output.println("<body><h1> " + errNum + " " + errMsg + "</h1></body>");
        output.println("</html>");
        output.println();
        output.flush();
        output.close();
        input.close();
    }
}

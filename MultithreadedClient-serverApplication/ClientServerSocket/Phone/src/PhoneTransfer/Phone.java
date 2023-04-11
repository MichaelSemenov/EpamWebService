package PhoneTransfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Phone implements Closeable {
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    public void writeLine(String message) throws IOException {
        writer.write(message);
        writer.newLine();
        writer.flush();
    }
    public String readLine() throws IOException {
        return reader.readLine();
    }
    public Phone(String ip, int port) throws IOException {
        this.socket = new Socket(ip , port);
        this.reader = ctreateReader();
        this.writer = createWriter();
    }

    private BufferedWriter createWriter() throws IOException {
        return new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
    }

    private BufferedReader ctreateReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }

    public Phone(ServerSocket server) throws IOException {
        this.socket = server.accept();
        this.reader = ctreateReader();
        this.writer = createWriter();
    }
    public Phone(ServerSocket socket, BufferedReader reader, BufferedWriter writer) throws IOException {
        this.socket = socket.accept();
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void close() throws IOException {
        writer.close();
        reader.close();
        socket.close();
    }
}

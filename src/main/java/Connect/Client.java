package Connect;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client implements  Runnable {
    private BufferedWriter writer;
    private BufferedReader reader;
    ArrayList<Client> clients;
    String client_Name;
    private  BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter("src/data.txt",true));

    public Client(Socket socket,ArrayList<Client> clients) throws IOException {
        try {
            OutputStreamWriter  osr= new OutputStreamWriter(socket.getOutputStream());
            writer= new BufferedWriter(osr);

            InputStreamReader isr= new InputStreamReader(socket.getInputStream());
            reader= new BufferedReader(isr);
            client_Name= reader.readLine();
            this.clients=clients;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String Client_Data= reader.readLine()+"\n";
            Client_Data=client_Name+":"+Client_Data;
            while (Client_Data!=null)
            {
                for (Client c: clients)
                {
                    synchronized (c.writer)
                    {
                        c.writer.write(Client_Data);
                        c.writer.flush();
                        bufferedWriter.write(Client_Data);
                        bufferedWriter.flush();
                    }
                }
                Client_Data= client_Name+":"+reader.readLine()+"\n";
            }
        }
        catch (IOException e)  {
            e.printStackTrace();
        }

    }
}

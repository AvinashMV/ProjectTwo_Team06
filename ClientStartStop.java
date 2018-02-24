import java.net.Socket;
/**
 * Lab 2, Team 6
 * @author SER 516, Rishabh Modi (#75)
 */
public class ClientStartStop
{
    Socket clientsocket = null;
    boolean flag=true;
    void start()
    {
        try
        {
            clientsocket = new Socket("localhost", 1024);
            System.out.println("Connected");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    void stop()
    {
        try
        {
            clientsocket.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}

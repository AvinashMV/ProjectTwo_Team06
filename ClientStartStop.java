import java.net.Socket;
/**
 *
 * @author P075 Rishabh Modi
 *
 */
public class ClientStartStop
{
    Socket clientsocket = null;

    void start()
    {
        try
        {
            clientsocket = new Socket("localhost", 1516);
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

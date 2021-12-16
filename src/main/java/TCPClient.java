import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Project name(项目名称)：TCP
 * Package(包名): PACKAGE_NAME
 * Class(类名): TCPClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/16
 * Time(创建时间)： 13:03
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class TCPClient
{
    public static void main(String[] args)
    {
        Socket socket = null;
        FileInputStream fileInputStream = null;
        OutputStream outputStream = null;
        try
        {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 8888);
            fileInputStream = new FileInputStream("test.txt");
            outputStream = socket.getOutputStream();
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = fileInputStream.read(buffer)) != -1)
            {
                outputStream.write(buffer, 0, count);
            }
        }
        catch (ConnectException e)
        {
            System.out.println("连接异常！！！");
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (socket != null)
                {
                    socket.close();
                }
                if (fileInputStream != null)
                {
                    fileInputStream.close();
                }
                if (outputStream != null)
                {
                    outputStream.close();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}

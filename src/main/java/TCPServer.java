import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Project name(项目名称)：TCP
 * Package(包名): PACKAGE_NAME
 * Class(类名): TCPServer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/16
 * Time(创建时间)： 13:19
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class TCPServer
{
    public static void main(String[] args)
    {
        ServerSocket serverSocket = null;
        Socket socket = null;
        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try                                  //打开连接或者流
        {
            serverSocket = new ServerSocket(8888);
            socket = serverSocket.accept();
            fileOutputStream = new FileOutputStream("testOut.txt");
            inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = inputStream.read(buffer)) != -1)
            {
                fileOutputStream.write(buffer, 0, count);
            }
        }
        catch (FileNotFoundException e)      //文件未找到
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("文件未找到！！！  " + "\n错误内容：" + e.toString());
        }
        catch (ConnectException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("连接异常！！！  " + e.toString());
            e.printStackTrace();
        }
        catch (Exception e)                  //其它异常
        {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
        }
        finally
        {
            try                              //关闭连接或者关闭流
            {
                if (serverSocket != null)
                {
                    serverSocket.close();
                }
                if (socket != null)
                {
                    socket.close();
                }
                if (fileOutputStream != null)
                {
                    fileOutputStream.close();
                }
                if (inputStream != null)
                {
                    inputStream.close();
                }
            }
            catch (NullPointerException e)    //空指针异常
            {
                Toolkit.getDefaultToolkit().beep();
                System.err.println("连接或者流已经被关闭，无法再次关闭！！！");
            }
            catch (Exception e)              //其它异常
            {
                Toolkit.getDefaultToolkit().beep();
                e.printStackTrace();
            }
        }
    }
}

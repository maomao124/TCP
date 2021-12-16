/**
 * Project name(项目名称)：TCP
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/16
 * Time(创建时间)： 12:58
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test implements Runnable
{
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(300);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        TCPClient.main(null);
    }

    public static void main(String[] args)
    {
        test t = new test();
        Thread thread = new Thread(t);
        thread.start();
        TCPServer.main(null);
    }


}

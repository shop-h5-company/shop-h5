package xframe.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 容器启动监听器
 *
 * @author : zhangqiang
 * @version : 2014-9-3 15:20
 */
public class StartupListener implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        String root = servletContextEvent.getServletContext().getRealPath("/");
        System.out.println("**************************************************");
        System.out.println("*  Webapp root: " + root);
        System.out.println("*  Webapp initialize complete. ");
        System.out.println("**************************************************");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        System.out.println("************ Webapp has bean destroyed. *************");
    }
}

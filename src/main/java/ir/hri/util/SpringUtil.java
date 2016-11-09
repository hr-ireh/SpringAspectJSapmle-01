package ir.hri.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            new String[]{"beans.xml"});

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void reInitializeApplicationContext() {
        applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"beans.xml"});
    }
}
package com.tistory.hskimsky.oozie_noti.utils;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.selector.ContextSelector;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.classic.util.ContextSelectorStaticBinder;
import ch.qos.logback.core.joran.spi.JoranException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

import javax.servlet.ServletContextEvent;

/**
 * Description.
 *
 * @author Ha Neul Kim
 * @version 2.1.0
 */
public class LogbackInitializer implements javax.servlet.ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(LogbackInitializer.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.setProperty("PID", SystemUtils.getPid());

        try {
            LoggerContext loggerContext = (LoggerContext) StaticLoggerBinder.getSingleton().getLoggerFactory();
            loggerContext.reset();
            new ContextInitializer(loggerContext).configureByResource(this.getClass().getResource("/logback.xml"));
        } catch (JoranException e) {
            e.printStackTrace();
        }

        logger.info("\n" +
                "   ____              _         _   __      __  _ _____            __  _           \n" +
                "  / __ \\____  ____  (_)__     / | / /___  / /_(_) __(_)________ _/ /_(_)___  ____ \n" +
                " / / / / __ \\/_  / / / _ \\   /  |/ / __ \\/ __/ / /_/ / ___/ __ `/ __/ / __ \\/ __ \\\n" +
                "/ /_/ / /_/ / / /_/ /  __/  / /|  / /_/ / /_/ / __/ / /__/ /_/ / /_/ / /_/ / / / /\n" +
                "\\____/\\____/ /___/_/\\___/  /_/ |_/\\____/\\__/_/_/ /_/\\___/\\__,_/\\__/_/\\____/_/ /_/ \n" +
                "                                                                                  ");
        logger.info("============================================================");
        logger.info(" Now starting ..... PID: " + SystemUtils.getPid());
        logger.info("============================================================");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ContextSelector selector = ContextSelectorStaticBinder.getSingleton().getContextSelector();
        LoggerContext loggerContext = selector.getLoggerContext();
        String loggerContextName = loggerContext.getName();
        LoggerContext context = selector.detachLoggerContext(loggerContextName);
        context.reset();
    }
}

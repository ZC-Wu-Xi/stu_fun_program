package com.xi.day1;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

// 函数对象好处2：延迟执行
public class Sample7 {
    static Logger logger = init(Level.DEBUG);
//    static Logger logger = init(Level.INFO);

    public static void main(String[] args) {
        /*if (logger.isDebugEnabled()) {// 解决方式1：是debug级别 执行
            logger.debug("{}", expensive());
        }*/

        logger.debug("{}", expensive());        // 即使在INFO级别expensive() 也立刻执行，而不打印日志

        logger.debug("{}", () -> expensive());  // 函数对象使得 expensive 延迟执行

    }

    static String expensive() {
        System.out.println("执行耗时操作...");
        return "日志";
    }

    static Logger init(Level level) {
        ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder()
                .setStatusLevel(Level.ERROR)
                .setConfigurationName("BuilderTest");
        AppenderComponentBuilder appender =
                builder.newAppender("Stdout", "CONSOLE")
                        .addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT)
                        .add(builder.newLayout("PatternLayout").addAttribute("pattern", "%d [%t] %-5level: %msg%n%throwable"));
        builder.add(appender)
                .add(builder.newRootLogger(level).add(builder.newAppenderRef("Stdout")));
        Configurator.initialize(builder.build());
        return LogManager.getLogger();
    }
}

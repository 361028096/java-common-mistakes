package org.pratice.time.concurrenttool.threadlocal;

import org.geekbang.time.commonmistakes.common.Utils;
import org.geekbang.time.commonmistakes.concurrenttool.threadlocal.CommonMistakesApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @date 2020/11/22 12:21
 */
@SpringBootApplication
public class CommmistackApplication {

    public static void main(String[] args) {

        Utils.loadPropertySource(CommonMistakesApplication.class, "tomcat.properties");

        SpringApplication.run(CommonMistakesApplication.class, args);

    }
}

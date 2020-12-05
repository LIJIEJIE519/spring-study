package com.xjj.e_02_scheduling_tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author LJ
 * @Date 2020/11/24
 * msg 定时任务，后台异步任务
 */

//@Component(value = "task")      // 装配为bean
//@EnableScheduling               // 定时任务 ScheduledTasks
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)        // 间隔时间
    public void reportCurrentTime() {
        log.info("当前时间为：{}", dateFormat.format(new Date()));
    }
}

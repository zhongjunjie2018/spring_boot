package com.zjj.exercise;

import com.zjj.exercise.common.async.AsyncTask;
import com.zjj.exercise.common.async.AsyncTaskFuture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestO {
    @Autowired
    private AsyncTask asyncTask;
    @Autowired
    private AsyncTaskFuture asyncTaskFuture;
    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void send(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1060891243@qq.com");
        message.setTo("769814286@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("焦满想  不要脸");
        mailSender.send(message);

    }

    @Test
    public void ttAs() throws Exception {
        long start = System.currentTimeMillis();

        Future<String> task1 = asyncTaskFuture.doTaskOne();
        Future<String> task2 = asyncTaskFuture.doTaskTwo();
        Future<String> task3 = asyncTaskFuture.doTaskThree();

        while(true) {
            if(task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

    }
    @Test
    public void tt() throws Exception {
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
    }



    @Test
    public void testUrl(){

        String url = "/image/index";
        String str = "/image";
        Boolean boo = url.startsWith(str);

        System.out.println("是否正确："+boo);
    }

    @Test
    public void  testList(){

        List list = new ArrayList();

        String str = "zjj";
        String str2 = "zbl";



    }
}

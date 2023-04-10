package cn.itcast.mq.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 32424
 * Date:2023/4/9
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqpTest {
    @Resource
    private RabbitTemplate rabbitTemplate;
    
    @Test
    public void test1(){
        String queueName = "simple.queue";
        String message = "hello, Spring amqp111";
        rabbitTemplate.convertAndSend(queueName,message);
    }
    @Test
    public void test2() throws InterruptedException {
        String queueName = "simple.queue";
        String message = "hello, Spring amqp222____";
        for (int i = 1; i <= 50; i++) {
            rabbitTemplate.convertAndSend(queueName,message + i);
            Thread.sleep(20);
        }
        
    }
    
    
    @Test
    public void test3(){
        // 交换机名称
        String exchangeName = "itcast.hanout";
        String message = "hello world";
        
        rabbitTemplate.convertAndSend(exchangeName,"",message);
    }

}

package cn.itcast.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 32424
 * Date:2023/4/9
 */

@Component
public class SpringRabbitListener {
    //    @RabbitListener(queues = {"simple.queue"})
    //    public void listenerSimpleQueue(String message){
    //        System.out.println("消费者接收到的消息：" + message);
    //    }
    
    
    @RabbitListener (queues = { "simple.queue" })
    public void listenerSimpleQueue1111 (String message) throws InterruptedException {
        System.out.println("消费者1111接收到的消息：" + message);
        Thread.sleep(20);
    }
    
    
    @RabbitListener (queues = { "simple.queue" })
    public void listenerSimpleQueue2222 (String message) throws InterruptedException {
        System.out.println("消费者2222接收到的消息：" + message);
        Thread.sleep(200);
    }
    
    @RabbitListener (queues = { "fanout.queue1" })
    public void listenerFanoutQueue1 (String message) {
        System.out.println("消费者接收到fanout.queue1的消息：" + message);
    }
    
    @RabbitListener (queues = { "fanout.queue2" })
    public void listenerFanoutQueue2 (String message) {
        System.out.println("消费者接收到fanout.queue2的消息：" + message);
    }
}

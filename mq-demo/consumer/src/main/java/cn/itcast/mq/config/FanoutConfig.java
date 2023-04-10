package cn.itcast.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 32424
 * Date:2023/4/9
 */
@Configuration
public class FanoutConfig {
    // 声明交换机
    @Bean
    public FanoutExchange fanoutExchange () {
        return new FanoutExchange("it cast.fanout");
    }
    
    @Bean
    public Queue queue1 () {
        return new Queue("queue1");
    }
    
    @Bean
    public Queue queue2 () {
        return new Queue("queue2");
    }
    
    @Bean
    public Binding binding1 (FanoutExchange fanoutExchange, Queue queue1) {
        return BindingBuilder.bind(queue1).to(fanoutExchange);
    }
    
    
    @Bean
    public Binding binding2 (FanoutExchange fanoutExchange, Queue queue2) {
        return BindingBuilder.bind(queue2).to(fanoutExchange);
    }
}

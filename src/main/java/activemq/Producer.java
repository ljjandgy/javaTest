package activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * mq消费者
 */
public class Producer {
    /**
     * 因为activemq是基于jms实现的，所以我们需要实例化jms包含的所有对象才能实现对activemq的使用
     */
    public static void main(String[] args) {
        //连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        //连接
        Connection connection = null;
        //会话
        Session session;
        try{
            connection = connectionFactory.createConnection();
            connection.start();
            //创建session也就是会话信息，用于信息传递。有两个参数，分别为是否开启事务和消费者的应答模式
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            //通过session创建一个topic,也就是消息的目的地
            Destination topic = session.createTopic("helloActivemq");
            //创建消费者，通过消费者对象向目的地发送消息，用于消费
            MessageProducer messageProducer = session.createProducer(topic);
            for (int i=0;i<5;++i){
                String msg = "发送第"+i+"消息";
                TextMessage message = session.createTextMessage(msg);
                messageProducer.send(message);
                System.out.println("生产者发送消息"+msg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

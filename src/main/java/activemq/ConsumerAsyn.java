package activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 异步的消费者，依靠监听实现消息消费
 */
public class ConsumerAsyn {
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
            MessageConsumer messageConsumer = session.createConsumer(topic);
            messageConsumer.setMessageListener(message -> {
                TextMessage textMessage = (TextMessage)message;
                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

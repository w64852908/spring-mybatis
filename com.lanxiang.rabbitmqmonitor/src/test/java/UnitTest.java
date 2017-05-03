import com.lanxiang.rabbitmqmonitor.api.RMQApi;
import com.lanxiang.rabbitmqmonitor.check.AMQPPingCheck;
import com.lanxiang.rabbitmqmonitor.check.APIPingCheck;
import com.lanxiang.rabbitmqmonitor.check.ClusterHealthCheck;
import com.lanxiang.rabbitmqmonitor.check.QueueConfigCheck;
import com.lanxiang.rabbitmqmonitor.model.CheckQueue;
import com.lanxiang.rabbitmqmonitor.remote.model.response.Vhost;
import com.lanxiang.rabbitmqmonitor.remote.resource.RMQResource;
import com.lanxiang.rabbitmqmonitor.utils.RMQConfig;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lanxiang on 2017/4/20.
 */
public class UnitTest {

    private RMQResource rmqResource;

    @Before
    public void init() {
        rmqResource = RMQApi.getService(RMQResource.class);
    }

    @Test
    public void run() {
        RMQConfig rmqConfig = RMQConfig.Singleton.INSTANCE.getRmqConfig();
        System.out.println(rmqConfig);
    }

    @Test
    public void pingCheck() {
        AMQPPingCheck.checkAMQPPing();
    }

    @Test
    public void apiTest() {
        Vhost[] vhosts = rmqResource.getVhosts();
        for (Vhost vhost : vhosts) {
            System.out.println(vhost);
        }
    }

    @Test
    public void alivenessTest() {
        String vhost = "/";
        System.out.println(rmqResource.testAliveness(vhost));
    }

    @Test
    public void apiPingCheck() {
        String vhost = "/";
        APIPingCheck.checkAPIPing(vhost);
    }

    @Test
    public void testGetQueueInfo() {
        String vhost = "/";
        String name = "springrabbitexercise";
        System.out.println(rmqResource.getQueueInfo(vhost, name));
    }

    @Test
    public void testQueueConfig() {
        String queue_name = "springrabbitexercise";
        Boolean auto_delete = false;
        Boolean durable = true;
        String vhost = "/";
        CheckQueue queue = new CheckQueue(queue_name, auto_delete, durable);
        QueueConfigCheck.checkQueueConfig(vhost, queue);
    }

    @Test
    public void testClusterHealthCheck() {
        ClusterHealthCheck.checkClusterHealth();
    }
}

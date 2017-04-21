import com.lanxiang.rabbitmqmonitor.api.RMQApi;
import com.lanxiang.rabbitmqmonitor.check.AMQPPingCheck;
import com.lanxiang.rabbitmqmonitor.remote.model.Vhost;
import com.lanxiang.rabbitmqmonitor.remote.resource.VhostResource;
import com.lanxiang.rabbitmqmonitor.utils.RMQConfig;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.Arrays;

/**
 * Created by lanxiang on 2017/4/20.
 */
public class UnitTest {

    private VhostResource vhostResource;

    @Before
    public void init() {
        vhostResource = RMQApi.getService(VhostResource.class);
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
        Response response = vhostResource.getVhosts();
        System.out.println(Arrays.toString(response.readEntity(Vhost[].class)));
    }
}

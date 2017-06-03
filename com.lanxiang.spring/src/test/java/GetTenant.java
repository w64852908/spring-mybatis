import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by lanxiang on 2017/4/18.
 */
public class GetTenant {


    private String txtPath = "/Users/lanxiang/Desktop/tenant.txt";

    @Test
    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(txtPath));
        String content;
        while ((content = br.readLine()) != null) {
            System.out.println(content + ",");
        }
    }
}

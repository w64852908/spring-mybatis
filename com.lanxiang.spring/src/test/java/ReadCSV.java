import org.junit.Test;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lanxiang on 2017/4/14.
 */
public class ReadCSV {


    private final static String csv = "/Users/lanxiang/Downloads/query_result.csv";

    @Test
    public void run() throws IOException {
        Set<String> result = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csv)));

        String content = null;
        while ((content = br.readLine()) != null) {
            result.add(content.split(",")[1]);
        }
        for (String temp : result) {
            System.out.println(temp + ",");
        }
    }
}

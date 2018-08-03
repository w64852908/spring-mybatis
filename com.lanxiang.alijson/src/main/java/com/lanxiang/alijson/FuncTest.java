package com.lanxiang.alijson;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by lanxiang on 2018/3/16.
 */
public class FuncTest {

    @Test
    public void getJSONField() {
        String str = "{\n" +
                "    \"errcode\": 0,\n" +
                "    \"errmsg\": \"ok\",\n" +
                "    \"card\": {\n" +
                "        \"card_type\": \"GROUPON\",\n" +
                "        \"groupon\": {\n" +
                "            \"base_info\": {\n" +
                "                \"id\": \"pTWwa08QgoCvkLwFh3OX9cc4uJx4\",\n" +
                "                \"logo_url\": \"http://mmbiz.qpic.cn/mmbiz_jpg/v110Bhes66lX080IVPubC7Y5uI2ZrbgOBU0USKZuL0e7s3yd8IN62gzagWic38pWuRqV1IzCDBYRKr2kXuTV7MA/0\",\n" +
                "                \"code_type\": \"CODE_TYPE_TEXT\",\n" +
                "                \"brand_name\": \"塞尔达限量会员卡\",\n" +
                "                \"title\": \"塞尔达限量会员卡\",\n" +
                "                \"sub_title\": \"塞尔达会员卡\",\n" +
                "                \"date_info\": {\n" +
                "                    \"type\": \"DATE_TYPE_FIX_TERM\",\n" +
                "                    \"fixed_term\": 15,\n" +
                "                    \"fixed_begin_term\": 0\n" +
                "                },\n" +
                "                \"color\": \"#63b359\",\n" +
                "                \"notice\": \"玩塞尔达时出示此会员卡\",\n" +
                "                \"service_phone\": \"020-88888888\",\n" +
                "                \"description\": \"塞尔达传说，超级马里奥奥德赛免费玩\",\n" +
                "                \"location_id_list\": [],\n" +
                "                \"get_limit\": 3,\n" +
                "                \"can_share\": true,\n" +
                "                \"can_give_friend\": true,\n" +
                "                \"use_custom_code\": false,\n" +
                "                \"bind_openid\": false,\n" +
                "                \"status\": \"CARD_STATUS_NOT_VERIFY\",\n" +
                "                \"sku\": {\n" +
                "                    \"quantity\": 499999,\n" +
                "                    \"total_quantity\": 500000\n" +
                "                },\n" +
                "                \"create_time\": 1520503970,\n" +
                "                \"update_time\": 1520503980,\n" +
                "                \"custom_url_name\": \"立即使用\",\n" +
                "                \"custom_url\": \"http://www.qq.com\",\n" +
                "                \"custom_url_sub_title\": \"6个汉字tips\",\n" +
                "                \"promotion_url\": \"http://www.qq.com\",\n" +
                "                \"promotion_url_name\": \"更多优惠\",\n" +
                "                \"area_code_list\": []\n" +
                "            },\n" +
                "            \"deal_detail\": \"以下锅底2选1（有菌王锅、麻辣锅、大骨锅、番茄锅、清补凉锅、酸 菜鱼锅可选）：\\r\\n大锅1份 12元\\r\\n小锅2份 16元 \",\n" +
                "            \"advanced_info\": {\n" +
                "                \"time_limit\": [],\n" +
                "                \"text_image_list\": [],\n" +
                "                \"business_service\": [],\n" +
                "                \"consume_share_card_list\": [],\n" +
                "                \"share_friends\": false\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        JSONObject json = JSON.parseObject(str);
        System.out.println(json.getJSONObject("card").getString("card_type"));
    }

    @Test
    public void test1() {
        String str = null;
        JSONObject json = JSON.parseObject(str);
        System.out.println(json);
    }
}

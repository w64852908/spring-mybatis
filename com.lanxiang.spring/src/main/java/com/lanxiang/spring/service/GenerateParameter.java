package com.lanxiang.spring.service;

import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lanxiang on 2017/10/9.
 */
public class GenerateParameter {

    private static final Channel TEST_CHANNEL = new Channel(1000014, "A013F70DB97834C0A5492378BD76C53A");

    private static final Channel ZY = new Channel(1000009, "f931431e13c751345c40195b9df968c1");



    private Channel using;

    @Before
    public void init() {
        using = ZY;
    }

    @Test
    public void run() {
        TreeMap<String, Object> params = syncShows();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (null != entry.getValue()) {
                if (null != entry.getValue().toString() && !entry.getValue().toString().equals("")) {
                    sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                }
            }
        }
        String s = sb.toString() + "key=" + using.getKey();
        System.out.println(s);
        String sign = DigestUtils.md5Hex(s).toUpperCase();
        System.out.println(sign);
    }

    private TreeMap<String, Object> syncCinemas() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "gateway.sync.cinemas");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> syncShows() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "gateway.sync.show");
        params.put("bizData", "{\"cinemaId\":10497,\"startDate\":\"2018-07-31\"}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> staticSeat() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "gateway.sync.seats");
        params.put("bizData", "{\"cinemaId\":11,\"hallId\":42253}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> dynamicSeat() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "gateway.trade.seat");
        params.put("bizData", "{\"showId\":\"201806220000001\"}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> syncHalls() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "gateway.sync.halls");
        params.put("bizData", "{\"cinemaId\":5111}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> comingMovies() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "mmdb.comingMovies");
        params.put("bizData", "{\"cityId\":840}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> hotMovies() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "mmdb.hotMovies");
        params.put("bizData", "{\"cityId\":1}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }


    private TreeMap<String, Object> fixOrder() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "gateway.trade.fixOrder");
        params.put("bizData", "{\"orderCode\":\"lanxiang490023\",\"orderId\":4446470}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> queryOrder() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "gateway.trade.queryOrder");
        params.put("bizData", "{\"orderId\":4446414}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> lockSeat() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "gateway.trade.lock");
        params.put("bizData", "{\"sellPrice\":11000,\"settlePrice\":11000,\"cinemaId\":\"11\",\"orderCode\":\"MV0101222018071300111704\",\"showId\":\"201807130000231\",\"mobile\":\"13591244598\",\"seatsJSON\":{\"count\":1,\"list\":[{\"sectionId\":\"0000000000000001\",\"seatNo\":\"30274343\",\"rowId\":\"4\",\"columnId\":\"02\"}]}}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> topBox() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "mpro.movie.topBox");
        params.put("bizData", "{\"queryDate\":20180124}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> district() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "base.district");
        params.put("bizData", "{\"cityId\":30}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    //=============
    private TreeMap<String, Object> alert() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "baseservice.msg.alert");
        params.put("bizData", "{\"cinemaId\":\"11\",\"startDate\":\"2017-12-12\"}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> pay() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "pay.common.bank.all");
        params.put("bizData", "{\"offlinePaySource\":2,\"merchantId\":0,\"sign\":\"03cbad80e7c59921ca4136ed62247b5c8ee604a2894fb325be67cb0995671ab0\",\"random\":\"64\"}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "1530305808");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> lowestPrice() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "price.movieLowestPrice");
        params.put("bizData", "{\"movieId\":\"343720\"}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> pushCgvVipPrice() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "data.cgv.vipshow");
        params.put("bizData", "{\"mcardPrice\":{\"LIST_IFMMMaoYanMemberCardPrice\":[{\"MBR_CRD_CD\":\"0048\",\"MBR_CRD_PRC\":\"12\",\"SARFT_THAT_CD\":\"31182201\",\"SCN_SCH_SEQ\":\"0000000008676755\",\"SEAT_GRD_CD\":\"01\"},{\"MBR_CRD_CD\":\"0048\",\"MBR_CRD_PRC\":\"13\",\"SARFT_THAT_CD\":\"31182201\",\"SCN_SCH_SEQ\":\"0000000008676756\",\"SEAT_GRD_CD\":\"02\"},{\"MBR_CRD_CD\":\"0048\",\"MBR_CRD_PRC\":\"12\",\"SARFT_THAT_CD\":\"31182201\",\"SCN_SCH_SEQ\":\"0000000008676756\",\"SEAT_GRD_CD\":\"01\"},{\"MBR_CRD_CD\":\"0048\",\"MBR_CRD_PRC\":\"48\",\"SARFT_THAT_CD\":\"31182201\",\"SCN_SCH_SEQ\":\"0000000008676753\",\"SEAT_GRD_CD\":\"01\"},{\"MBR_CRD_CD\":\"0048\",\"MBR_CRD_PRC\":\"48\",\"SARFT_THAT_CD\":\"31182201\",\"SCN_SCH_SEQ\":\"0000000008676754\",\"SEAT_GRD_CD\":\"01\"}]}}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> cmdataInfo() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "cmdata.movieInfo");
        params.put("bizData", "{\"movieId\":\"131\"}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }

    private TreeMap<String, Object> cmdataMovieallInfo() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("api", "cmdata.movieallinfo");
        params.put("bizData", "{\"offset\":0,\"limit\":10,\"timestamp\":" + "\"1528339402709000\"" + "}");
//        params.put("bizData", "{\"offset\":0,\"limit\":10,\"timestamp\":" + System.currentTimeMillis() * 1000 + "}");
        params.put("merCode", using.getMerId());
        params.put("signType", "MD5");
        params.put("timestamp", "2690258952");
        params.put("version", "1.0");
        return params;
    }
}

class Channel {

    private int merId;

    private String key;

    public Channel(int merId, String key) {
        this.merId = merId;
        this.key = key;
    }

    public int getMerId() {
        return merId;
    }

    public String getKey() {
        return key;
    }
}

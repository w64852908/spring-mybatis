package com.lanxiang.rabbitmqmonitor.remote.model.response;

import lombok.Data;

/**
 * Created by lanxiang on 2017/4/24.
 */

@Data
public class CheckResp {

    private String status;

    private String reason;
}

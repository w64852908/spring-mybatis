package com.lanxiang.alijson.demo;

import org.junit.Test;

/**
 * Created by lanxiang on 2018/6/14.
 */
public class SqlTest {
    /**
     * Created by lanxiang on 2018/5/30.
     */
    @Test
    public void test1() {
        generate32tables(CREATE_ATTEND_HISTORY_SQL);
    }

    private void generate32tables(String sql) {
        for (int i = 0; i < 32; i++) {
            String temp = String.format(sql, i);
            System.out.println(temp);
        }
    }

    private String CREATE_ATTEND_HISTORY_SQL = "CREATE TABLE `attend_history%s` (\n" +
            "  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,\n" +
            "  `user_id` bigint(20) NOT NULL,\n" +
            "  `unique_id` bigint(20) DEFAULT NULL,\n" +
            "  `season_id` int(11) NOT NULL,\n" +
            "  `activity_id` int(11) NOT NULL,\n" +
            "  `reply` text NOT NULL COMMENT '用户的回答',\n" +
            "  `reply_type` int(4) NOT NULL COMMENT '回答类型',\n" +
            "  `ticket_cost` int(10) NOT NULL DEFAULT '0' COMMENT '消耗的答题券',\n" +
            "  `coin_award` int(11) NOT NULL COMMENT '金币奖励',\n" +
            "  `status` int(4) NOT NULL DEFAULT '1' COMMENT '状态',\n" +
            "  `reply_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '答题时间',\n" +
            "  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `unique_idx_userid_activityid` (`user_id`,`activity_id`),\n" +
            "  KEY `union_idx_userid_seasonid` (`user_id`,`season_id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='用户答题历史';";


    private String CREATE_ACCOUNT_FLOW_SQL = "CREATE TABLE `account_flow%s` (\n" +
            "  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增唯一标识',\n" +
            "  `user_id` bigint(20) NOT NULL COMMENT '用户id',\n" +
            "  `unique_id` bigint(20) NOT NULL COMMENT '任务Id',\n" +
            "  `biz_data` text COLLATE utf8mb4_unicode_ci COMMENT '业务数据',\n" +
            "  `type` tinyint(3) NOT NULL COMMENT '流水类型1:领取,2:答题,3:中奖,4:分享',\n" +
            "  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
            "  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `uk_task_id` (`unique_id`),\n" +
            "  KEY `idx_user_id` (`user_id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='账户流水表';";


}

package com.lanxiang.rabbitmqmonitor.remote.model.common;

import lombok.Data;

/**
 * Created by lanxiang on 2017/4/25.
 */

@Data
public class GarbageCollection {

    private Long minor_gcs;

    private Long fullsweep_after;

    private Long min_heap_size;

    private Long min_bin_vheap_size;

    private Long max_heap_size;
}

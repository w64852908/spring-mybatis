package com.lanxiang.localcache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * Created by lanxiang on 2018/1/9.
 */

public class HallCacheService {

    private Cache<Integer, List<SpecialHall>> specialHallCache;

    @Before
    public void init() {
        specialHallCache = CacheBuilder.newBuilder().concurrencyLevel(8)
                .expireAfterWrite(30 * 60, TimeUnit.SECONDS)
                .initialCapacity(10)
                .maximumSize(10000)
                .recordStats()
                .build();
    }

    @Test
    public void test1() throws ExecutionException {
        List<SpecialHall> hallList = getSpecialHallsByCityId(1);
        System.out.println(hallList.size());
        hallList = getSpecialHallsByCityId(1);
        System.out.println(hallList.size());
        hallList = getSpecialHallsByCityId(0);
        System.out.println(hallList.size());
        hallList = getSpecialHallsByCityId(0);
        System.out.println(hallList.size());
    }

    private List<SpecialHall> getSpecialHallsByCityId(final int cityId) {
        try {
            return specialHallCache.get(cityId, new Callable<List<SpecialHall>>() {
                @Override
                public List<SpecialHall> call() throws Exception {
                    return innerGetSpecialHallsByCityId(cityId);
                }
            });
        } catch (ExecutionException e) {
            System.out.println(e);
        } finally {
            System.out.println(specialHallCache.stats().toString());
        }
        return new ArrayList<>();
    }

    private List<SpecialHall> innerGetSpecialHallsByCityId(int cityId) {
        if (cityId == 1) {
            SpecialHall hall1 = new SpecialHall(1, "钛合金特效", "233", "baidu.com", "233", 0, 0, 0);
            SpecialHall hall2 = new SpecialHall(2, "铝合金特效", "666", "sina.com", "666", 0, 0, 1);
            return Arrays.asList(hall1, hall2);
        } else {
            return new ArrayList<>();
        }
    }
}

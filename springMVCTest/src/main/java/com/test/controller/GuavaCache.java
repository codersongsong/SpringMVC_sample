package com.test.controller;

import com.google.common.base.Optional;
import com.google.common.cache.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName: GuavaCache
 * @Description: (Description)
 * @Author: songzhengjie
 * @DATE: 2017/5/10 17:18
 */
public class GuavaCache {

    //http://www.majiang.life/blog/simple-in-memory-cache-in-java/?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
    public static void main(String[] args) {

        LoadingCache<String, Optional<String>> loadingCache = CacheBuilder
                .newBuilder()
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .removalListener(new RemovalListener<String, Optional<String>>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, Optional<String>> removalNotification) {
                        System.out.println("cache expired ,delete key:" + removalNotification.getKey());
                    }
                })
                .build(new CacheLoader<String, Optional<String>>() {
                    @Override
                    public Optional<String> load(String key) throws Exception {
                        return Optional.fromNullable("取到默认值default!!!");
                    }
                });

        try {
            System.out.println("load form cache once :" +loadingCache.get("github").orNull());
        } catch (ExecutionException e) {


        }
    }

}

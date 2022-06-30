package com.gemini.imageUploading.cache;

import com.gemini.SpringbootDemoApplication;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheEventLogger
        implements CacheEventListener<Object, Object> {

    public static final Logger logger= LoggerFactory.getLogger(CacheEventLogger.class);
    // ...
    @Override
    public void onEvent(
            CacheEvent<? extends Object, ? extends Object> cacheEvent) {
        logger.info("Key: {} | EventType: {} | Old value: {} | New value: {}",
                cacheEvent.getKey(), cacheEvent.getType(), cacheEvent.getOldValue(),
                cacheEvent.getNewValue());

    }
}

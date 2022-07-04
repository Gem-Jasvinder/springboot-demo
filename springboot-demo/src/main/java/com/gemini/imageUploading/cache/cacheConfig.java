package com.gemini.imageUploading.cache;



import net.sf.ehcache.Cache;
import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;


import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;


@Configuration
@EnableCaching
public class cacheConfig {


    @Bean
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(cacheMangerFactory().getObject());

    }


//    @Profile("default")
//    @Bean
//    public void customConfig() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//
//        XmlConfiguration xmlConfiguration = new XmlConfiguration(getClass().getResource("src/main/resources/ehcache.xml"));
//
//        CacheConfigurationBuilder<Long, String> configurationBuilder = xmlConfiguration.newCacheConfigurationBuilderFromTemplate("Students", Long.class, String.class);
//        configurationBuilder = configurationBuilder.withResourcePools(ResourcePoolsBuilder
//                        .heap(1000)
//                        .offheap(2, MemoryUnit.MB))
//                .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(30)));
//    }

    @Profile("dev")
    @Bean
    public void customUpdateDev() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        net.sf.ehcache.CacheManager manager =  net.sf.ehcache.CacheManager.newInstance("src/main/resources/ehcache.xml");
        Cache cache = manager.getCache("Students");
        CacheConfiguration config = cache.getCacheConfiguration();
        config.setTimeToLiveSeconds(30);

    }

    @Profile("test")
    @Bean

    public void customUpdateTest(){
        net.sf.ehcache.CacheManager manager =  net.sf.ehcache.CacheManager.newInstance("src/main/resources/ehcache.xml");
        Cache cache = manager.getCache("Students");
        CacheConfiguration config = cache.getCacheConfiguration();
        config.setTimeToLiveSeconds(60);
    }

    @Bean
    public EhCacheManagerFactoryBean cacheMangerFactory() {
        EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
        bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        bean.setShared(true);
        return bean;
    }



}

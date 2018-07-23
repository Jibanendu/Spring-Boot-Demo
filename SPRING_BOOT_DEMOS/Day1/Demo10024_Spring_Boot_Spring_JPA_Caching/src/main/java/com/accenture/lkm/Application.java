package com.accenture.lkm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

//Step2: for enabling caching cache management support..
@EnableCaching 
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    
    //Step3: Cache manager implementation
    @Bean
    public CacheManager cacheManager()
    {
    	ConcurrentMapCacheManager  cache = new ConcurrentMapCacheManager("empCacheSpace"); 
    										// parameter empCacheSpace is the name of the cache
    										// in production environment cache manager that is used is:
    									    // GuavaCache, EHCache and RedisCache																					
    	return cache;
    }
    
}

// Step4 to annotate the method with cache instructions



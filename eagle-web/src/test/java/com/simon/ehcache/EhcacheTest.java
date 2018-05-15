package com.simon.ehcache;

import org.junit.Test;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @Author 陈辰强
 * @Date 2018/5/13 0:59
 */
public class EhcacheTest {

    @Test
    public void helloEhcache(){
        // 1. 创建缓存管理器
        CacheManager cacheManager = CacheManager.create("D:\\00-WorkSpace\\99-OwnProject\\01-Blog\\eagleBlog\\eagle-web\\src\\test\\resources\\ehcacheTest.xml");

        // 2. 获取缓存对象
        Cache cache = cacheManager.getCache("HelloWorldCache");

        // 3. 创建元素
        Element element = new Element("key1", "value1");

        // 4. 将元素添加到缓存
        cache.put(element);

        // 5. 获取缓存
        Element value = cache.get("key1");
        System.out.println(value);
        System.out.println(value.getObjectValue());

        // 6. 删除元素
        cache.remove("key1");

        System.out.println(cache.getSize());

        // 7. 刷新缓存
        cache.flush();

        // 8. 关闭缓存管理器
        cacheManager.shutdown();
    }

}

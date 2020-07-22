package com.xyg.learn.spring.service;

import com.xyg.learn.spring.pojo.MyUser;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 扩展：注解失效时间
 * Spring Cache 两个需求
 * 缓存失效时间支持在方法的注解上指定
 * Spring Cache默认是不支持在@Cacheable上添加过期时间的，可以在配置缓存容器时统一指定：
 * @Bean
 * public CacheManager cacheManager(
 * @SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
 * CustomizedRedisCacheManager cacheManager= new CustomizedRedisCacheManager(redisTemplate);
 * cacheManager.setDefaultExpiration(60);
 * Map<String,Long> expiresMap=new HashMap<>();
 * expiresMap.put("Product",5L);
 * cacheManager.setExpires(expiresMap);
 * return cacheManager;
 * }
 * 想这样配置过期时间，焦点在value的格式上Product#5#2，详情下面会详细说明。
 *
 * @Cacheable(value = {"Product#5#2"},key ="#id")
 *
 * 上面两种各有利弊，并不是说哪一种一定要比另外一种强，根据自己项目的实际情况选择。
 */
@Service
//@Profile("single")
public class SpringCacheService {

    /**
     * springcache注解版本（官方大部分资料开始往springboot方向引导，实际上不用springboot，也是差不多的方式）
     */
    // value~单独的缓存前缀
    // key缓存key 可以用springEL表达式
//    value+key 来查询 cache-1+userid 来查看
    @Cacheable(cacheManager = "cacheManager", value = "cache-1", key = "#userId")
    public MyUser findUserById(String userId) throws Exception {
        // 读取数据库
        MyUser user = new MyUser(userId, "张三");
        System.out.println("从数据库中读取到数据：" + user);
        return user;
    }

    @CacheEvict(value = "cache-1", key = "#userId")
    public void deleteUserById(String userId) throws Exception {
        System.out.println("用户从数据库删除成功，请检查缓存是否清除~~" + userId);
    }

    // 如果数据库更新成功，更新redis缓存
    @CachePut( value = "cache-1", key = "#user.userId", condition = "#result ne null")
    public MyUser updateUser(MyUser user) throws Exception {
        // 读取数据库
        System.out.println("数据库进行了更新，检查缓存是否一致");
        return user; // 返回最新内容，代表更新成功
    }

    // 如果数据库更新成功，更新redis缓存
    @CachePut( value = "cache-1",  condition = "#result ne null")
    public MyUser updateUser2(MyUser user) throws Exception {
        // 读取数据库
        System.out.println("数据库进行了更新，检查缓存是否一致");
        return user; // 返回最新内容，代表更新成功
    }
}

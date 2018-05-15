package com.simon.shiro;

import com.simon.pojo.User;
import com.simon.services.UserService;
import com.simon.springContext.SpringContextHolder;
import com.simon.utils.CacheUtils;
import com.simon.utils.Dictionary;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * 说明:shiro工具类
 *
 * @Author 李鑫浩
 * @Date 2017/3/9 下午5:00
 */
public class ShiroUtils {
    private static UserService userService = SpringContextHolder.getBean(UserService.class);

    /**
     * 根据ID获取用户
     *
     * @param id
     * @return 取不到返回null
     */
    public static User get(String id) {
        User user = (User) CacheUtils.get(Dictionary.USER_CACHE, Dictionary.USER_CACHE_ID + id);
        if (user == null) {
            user = userService.queryUserById(id);
            if (user == null) {
                return null;
            }
//            user.setRoleList(roleService.findList(new Role(user)));
            CacheUtils.put(Dictionary.USER_CACHE, Dictionary.USER_CACHE_ID + user.getUserId(), user);
            CacheUtils.put(Dictionary.USER_CACHE, Dictionary.USER_CACHE_LOGIN_NAME + user.getUserName(), user);
            CacheUtils.put(Dictionary.USER_CACHE, Dictionary.USER_CACHE_ROLE_ID + user.getRoleId());
        }
        return user;
    }

    /**
     * 放入缓存
     *
     * @param key
     * @param value
     */
    public static void putCache(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    /**
     * 移除缓存
     *
     * @param key
     */
    public static void removeCache(String key) {
        getSession().removeAttribute(key);
    }

    /**
     * 获取授权主要对象
     *
     * @return
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取当前登入用户
     *
     * @return
     */
    public static Principal getPrincipal() {
        try {
            Subject subject = SecurityUtils.getSubject();
            Principal principal = (Principal) subject.getPrincipal();
            if (principal != null) {
                return principal;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取Shiro Session
     *
     * @return
     */
    public static Session getSession() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(false);
        return session;
    }

    /**
     * cache
     *
     * @param key
     * @return
     */
    public static Object getCache(String key) {
        return getCache(key, null);
    }

    public static Object getCache(String key, Object defaultValue) {
        Object obj = getSession().getAttribute(key);
        return obj == null ? defaultValue : obj;
    }

    /**
     * 获取当前用户
     *
     * @return 取不到返回 new User()
     */
    public static User getUser() {
        Principal principal = getPrincipal();
        if (principal != null) {
            User user = get(principal.getId());
            if (user != null) {
                return user;
            }
            return new User();
        }
        // 如果没有登录，则返回实例化空的User对象。
        return new User();
    }

    /**
     * 清除指定用户缓存
     *
     * @param user
     */
    public static void clearCache(User user) {
        CacheUtils.remove(Dictionary.USER_CACHE, Dictionary.USER_CACHE_ID + user.getUserId());
        CacheUtils.remove(Dictionary.USER_CACHE, Dictionary.USER_CACHE_LOGIN_NAME + user.getUserName());
        if (StringUtils.isEmpty(user.getRoleId())) {
            CacheUtils.remove(Dictionary.USER_CACHE, Dictionary.USER_CACHE_ROLE_ID + user.getRoleId());
        }
    }

}

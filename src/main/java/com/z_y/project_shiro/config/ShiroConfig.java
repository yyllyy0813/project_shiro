package com.z_y.project_shiro.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig
{

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager)
    {
        System.out.println("执行 ShiroFilterFactoryBean.shiroFilter");

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        shiroFilterFactoryBean.setLoginUrl("/need_login");

        //shiroFilterFactoryBean.setSuccessUrl("/");

        shiroFilterFactoryBean.setUnauthorizedUrl("/not_permit");

        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("roleOrFilter", new UserRolesOrAuthorizationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/register", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/index/**", "authc");
        filterChainDefinitionMap.put("/admin/**", "roles[root]");
        filterChainDefinitionMap.put("/event/add", "perms[event_add]");
        //filterChainDefinitionMap.put("/event/eventList", "roles[root, admin]");
        filterChainDefinitionMap.put("/event/eventList", "roleOrFilter[root, admin]");
        filterChainDefinitionMap.put("/event/delete", "perms[event_delete]");
        filterChainDefinitionMap.put("/event/**", "authc");
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    @Bean(name = "secuityManager")
    public SecurityManager securityManager(@Qualifier("userRealm") UserRealm userRealm,
                                           @Qualifier("sessionManager") SessionManager sessionManager)
    {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setSessionManager(sessionManager);
        securityManager.setCacheManager(cacheManager());
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public UserRealm userRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher credentialsMatcher)
    {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(credentialsMatcher);
        return userRealm;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher()
    {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(1024);

        return credentialsMatcher;
    }


    @Bean
    public SessionManager sessionManager()
    {
        UserSessionManager usersessionManager = new UserSessionManager();
        // 设置超时时间
        //sessionManager.setGlobalSessionTimeout(200000000);

        usersessionManager.setSessionDAO(redisSessionDAO());
        return usersessionManager;
    }

    @Bean
    public RedisManager getRedisManager()
    {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost("localhost");
        redisManager.setPort(6379);
        return redisManager;
    }

    @Bean
    public RedisCacheManager cacheManager()
    {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(getRedisManager());
        redisCacheManager.setExpire(20);
        return redisCacheManager;
    }

    public RedisSessionDAO redisSessionDAO()
    {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(getRedisManager());
        return redisSessionDAO;
    }
}

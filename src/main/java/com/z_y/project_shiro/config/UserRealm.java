package com.z_y.project_shiro.config;

import com.z_y.project_shiro.domain.Permission;
import com.z_y.project_shiro.domain.Role;
import com.z_y.project_shiro.domain.User;
import com.z_y.project_shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserRealm extends AuthorizingRealm
{
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal)
    {
        System.out.println("认证 doGetAuthorizationInfo");

        User newUser = (User) principal.getPrimaryPrincipal();
        User user = userService.findAllUserInfoByUsername(newUser.getUsername());

        List<String> stringRoleList = new ArrayList<>();
        List<String > stringPermissionList = new ArrayList<>();

        List<Role> roleList = user.getRoleList();

        for (Role role : roleList)
        {
            stringRoleList.add(role.getName());

            List<Permission> permissionList = role.getPermissionList();
            for (Permission permission : permissionList)
            {
                if(permission != null)
                {
                    stringPermissionList.add(permission.getName());
                }
            }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(stringRoleList);
        simpleAuthorizationInfo.addStringPermissions(stringPermissionList);

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException
    {
        System.out.println("认证 doGetAuthenticationInfo");
        String username = (String) token.getPrincipal();

        User user = userService.findAllUserInfoByUsername(username);

        String pwd = user.getPassword();
        if(pwd == null || "".equals(pwd))
        {
            return null;
        }

        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }
}

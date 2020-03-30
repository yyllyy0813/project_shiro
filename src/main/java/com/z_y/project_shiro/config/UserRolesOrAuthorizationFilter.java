package com.z_y.project_shiro.config;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Set;

public class UserRolesOrAuthorizationFilter extends AuthorizationFilter
{
    @SuppressWarnings({"unchecked"})
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException
    {
        Subject subject = this.getSubject(request, response);
        // 获取所需要的角色集合
        String[] rolesArray = (String[])((String[])mappedValue);

        if (rolesArray != null && rolesArray.length != 0)
        {
            return true;
        }

        Set<String> roles = CollectionUtils.asSet(rolesArray);

        for (String role : roles)
        {
            if (subject.hasRole(role))
            {
                return true;
            }
        }
        return false;
    }
}

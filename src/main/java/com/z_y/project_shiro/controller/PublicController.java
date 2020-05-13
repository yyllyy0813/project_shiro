package com.z_y.project_shiro.controller;

import com.z_y.project_shiro.domain.*;
import com.z_y.project_shiro.error.BussinessException;
import com.z_y.project_shiro.service.UserService;
import com.z_y.project_shiro.serviceImp.UserServiceImp;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
public class PublicController extends BaseController
{

    @Autowired
    private UserService userService;

    /*
    @RequestMapping("find_user_info")
    public Object findUserInfo(@RequestParam("username") String username)
    {
        return userService.findAllUserInfoByUsername(username);
    }
     */

    @RequestMapping("need_login")
    public JsonData needLogin()
    {
        return JsonData.buildSuccess("请登录", -2);
    }

    @RequestMapping("not_permit")
    public JsonData notPermit()
    {
        return JsonData.buildSuccess("没有权限", -3);
    }



    @PostMapping(value = "login")
    //@RequestMapping(value = "login")
    @ResponseBody
    public JsonData login(@RequestBody UserQuery userQuery, HttpServletRequest request, HttpServletResponse response)
    {
        Subject subject = SecurityUtils.getSubject();
        Map<String, Object> info = new HashMap<>();
        try
        {
            UsernamePasswordToken token = new UsernamePasswordToken(userQuery.getUsername(), userQuery.getPassword());
            subject.login(token);



            info.put("msg", "登陆成功");
            info.put("session_id", subject.getSession().getId());

            User user = userService.findAllUserInfoByUsername(userQuery.getUsername());

            List<String> stringRoleList = new ArrayList<>();
            Set<String > stringPermissionSet = new HashSet<>();

            List<Role> roleList = user.getRoleList();

            for (Role role : roleList)
            {
                stringRoleList.add(role.getName());

                List<Permission> permissionList = role.getPermissionList();
                for (Permission permission : permissionList)
                {
                    if(permission != null)
                    {
                        stringPermissionSet.add(permission.getName());
                    }
                }
            }
            info.put("role", stringRoleList);
            info.put("permission", stringPermissionSet);

            return JsonData.buildSuccess(info,"登陆成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return JsonData.buildError("账号或密码错误");
        }

    }

    //用户注册接口
    @PostMapping(value = "register")
    public JsonData register(@RequestBody UserQuery userQuery,
                             HttpServletRequest request, HttpServletResponse response) throws BussinessException, UnsupportedEncodingException, NoSuchAlgorithmException
    {
        //用户的注册流程
        String username = userQuery.getUsername();
        String password = String.valueOf(new SimpleHash("md5", userQuery.getPassword(), userQuery.getUsername(), 1024));
        // password = new Md5Hash(password, username, 1024).toBase64();

        userService.insertUser(username, password);
        return JsonData.buildSuccess("注册成功");
    }

    @RequestMapping("index")
    public JsonData index()
    {
        return JsonData.buildSuccess("查看首页");
    }
}

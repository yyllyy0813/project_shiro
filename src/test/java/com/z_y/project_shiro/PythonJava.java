package com.z_y.project_shiro;

import net.minidev.json.JSONObject;
import org.apache.shiro.crypto.hash.Hash;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;

public class PythonJava
{
    public static String invokeAlgorithm(String url, HashMap params) throws Exception {

        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(mediaType);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        HttpEntity<String> httpEntity = new HttpEntity<>(JSONObject.toJSONString(params), headers);

        RestTemplate rst = new RestTemplate();
        ResponseEntity<String> stringResponseEntity = rst.getForEntity(url, String.class, httpEntity);

        return stringResponseEntity.getBody();
    }

    @Test
    public void pythonJava() throws Exception
    {
        HashMap<Object, Object> map = new HashMap<>();
        String s = PythonJava.invokeAlgorithm("http://0.0.0.0:5000/", map);
        System.out.println(s);
    }
}

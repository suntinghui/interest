package com.interest.controller.sys;

import com.alibaba.fastjson.JSON;
import com.interest.controller.sys.UserController;
import com.interest.model.entity.UserEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    protected MockMvc mockMvc;
    //集成Web环境,将会从该上下文获取相应的控制器并得到相应的MockMvc；
    @Autowired
    protected WebApplicationContext wac;

    @Before()
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //构造MockMvc对象
    }

    @Test
    public void testInserUser() throws Exception {
        UserEntity user = new UserEntity();
        user.setLoginName("sth");
        user.setName("suntinghui");
        user.setPassword("123456");
        user.setUrl("http://www.baidu.com");
        user.setEmail("tinghuisun@163.com");
        user.setUsertype(0);
        user.setCreateTime(new Date().getTime()+"");
        user.setHeadimg("http://img4.imgtn.bdimg.com/it/u=1358126537,2470243223&fm=26&gp=0.jpg");

        String content = JSON.toJSONString(user);

        String result = mockMvc.perform(post("/users/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)   // 请求中的媒体类型信息—json数据格式
                .content(content))  // RequestBody信息
                .andDo(print()) // 打印出请求和相应的内容
                .andExpect(status().isOk()) // 返回的状态是200
                .andReturn().getResponse().getContentAsString();    // 返回MvcResult并且转为字符串
        Assert.assertNotNull(result);
    }
}

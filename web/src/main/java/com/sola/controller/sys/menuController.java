package com.sola.controller.sys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/menuController")
public class menuController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass()) ;

    @RequestMapping(value = "/list")
    public Object toList(){

        return "sys/menuList" ;
    }


    @RequestMapping(value = "listDate")
    @ResponseBody
    public Object toListDate(){

        String content = "{\n" +
                "  \"code\": 0\n" +
                "  ,\"msg\": \"\"\n" +
                "  ,\"count\": 3000000\n" +
                "  ,\"data\": [{\n" +
                "    \"id\": \"10001\"\n" +
                "    ,\"username\": \"杜甫\"\n" +
                "    ,\"email\": \"xianxin@layui.com\"\n" +
                "    ,\"sex\": \"男\"\n" +
                "    ,\"city\": \"浙江杭州\"\n" +
                "    ,\"sign\": \"点击此处，显示更多。当内容超出时，点击单元格会自动显示更多内容。\"\n" +
                "    ,\"experience\": \"116\"\n" +
                "    ,\"ip\": \"192.168.0.8\"\n" +
                "    ,\"logins\": \"108\"\n" +
                "    ,\"joinTime\": \"2016-10-14\"\n" +
                "  }, {\n" +
                "    \"id\": \"10002\"\n" +
                "    ,\"username\": \"李白\"\n" +
                "    ,\"email\": \"xianxin@layui.com\"\n" +
                "    ,\"sex\": \"男\"\n" +
                "    ,\"city\": \"浙江杭州\"\n" +
                "    ,\"sign\": \"君不见，黄河之水天上来，奔流到海不复回。 君不见，高堂明镜悲白发，朝如青丝暮成雪。 人生得意须尽欢，莫使金樽空对月。 天生我材必有用，千金散尽还复来。 烹羊宰牛且为乐，会须一饮三百杯。 岑夫子，丹丘生，将进酒，杯莫停。 与君歌一曲，请君为我倾耳听。(倾耳听 一作：侧耳听) 钟鼓馔玉不足贵，但愿长醉不复醒。(不足贵 一作：何足贵；不复醒 一作：不愿醒/不用醒) 古来圣贤皆寂寞，惟有饮者留其名。(古来 一作：自古；惟 通：唯) 陈王昔时宴平乐，斗酒十千恣欢谑。 主人何为言少钱，径须沽取对君酌。 五花马，千金裘，呼儿将出换美酒，与尔同销万古愁。\"\n" +
                "    ,\"experience\": \"12\"\n" +
                "    ,\"ip\": \"192.168.0.8\"\n" +
                "    ,\"logins\": \"106\"\n" +
                "    ,\"joinTime\": \"2016-10-14\"\n" +
                "    ,\"LAY_CHECKED\": true\n" +
                "  }, {\n" +
                "    \"id\": \"10003\"\n" +
                "    ,\"username\": \"王勃\"\n" +
                "    ,\"email\": \"xianxin@layui.com\"\n" +
                "    ,\"sex\": \"男\"\n" +
                "    ,\"city\": \"浙江杭州\"\n" +
                "    ,\"sign\": \"人生恰似一场修行\"\n" +
                "    ,\"experience\": \"65\"\n" +
                "    ,\"ip\": \"192.168.0.8\"\n" +
                "    ,\"logins\": \"106\"\n" +
                "    ,\"joinTime\": \"2016-10-14\"\n" +
                "  }, {\n" +
                "    \"id\": \"10004\"\n" +
                "    ,\"username\": \"李清照\"\n" +
                "    ,\"email\": \"xianxin@layui.com\"\n" +
                "    ,\"sex\": \"女\"\n" +
                "    ,\"city\": \"浙江杭州\"\n" +
                "    ,\"sign\": \"人生恰似一场修行\"\n" +
                "    ,\"experience\": \"666\"\n" +
                "    ,\"ip\": \"192.168.0.8\"\n" +
                "    ,\"logins\": \"106\"\n" +
                "    ,\"joinTime\": \"2016-10-14\"\n" +
                "  }, {\n" +
                "    \"id\": \"10005\"\n" +
                "    ,\"username\": \"冰心\"\n" +
                "    ,\"email\": \"xianxin@layui.com\"\n" +
                "    ,\"sex\": \"女\"\n" +
                "    ,\"city\": \"浙江杭州\"\n" +
                "    ,\"sign\": \"人生恰似一场修行\"\n" +
                "    ,\"experience\": \"86\"\n" +
                "    ,\"ip\": \"192.168.0.8\"\n" +
                "    ,\"logins\": \"106\"\n" +
                "    ,\"joinTime\": \"2016-10-14\"\n" +
                "  }, {\n" +
                "    \"id\": \"10006\"\n" +
                "    ,\"username\": \"贤心\"\n" +
                "    ,\"email\": \"xianxin@layui.com\"\n" +
                "    ,\"sex\": \"男\"\n" +
                "    ,\"city\": \"浙江杭州\"\n" +
                "    ,\"sign\": \"人生恰似一场修行\"\n" +
                "    ,\"experience\": \"12\"\n" +
                "    ,\"ip\": \"192.168.0.8\"\n" +
                "    ,\"logins\": \"106\"\n" +
                "    ,\"joinTime\": \"2016-10-14\"\n" +
                "  }, {\n" +
                "    \"id\": \"10007\"\n" +
                "    ,\"username\": \"贤心\"\n" +
                "    ,\"email\": \"xianxin@layui.com\"\n" +
                "    ,\"sex\": \"男\"\n" +
                "    ,\"city\": \"浙江杭州\"\n" +
                "    ,\"sign\": \"人生恰似一场修行\"\n" +
                "    ,\"experience\": \"16\"\n" +
                "    ,\"ip\": \"192.168.0.8\"\n" +
                "    ,\"logins\": \"106\"\n" +
                "    ,\"joinTime\": \"2016-10-14\"\n" +
                "  }, {\n" +
                "    \"id\": \"10008\"\n" +
                "    ,\"username\": \"贤心\"\n" +
                "    ,\"email\": \"xianxin@layui.com\"\n" +
                "    ,\"sex\": \"男\"\n" +
                "    ,\"city\": \"浙江杭州\"\n" +
                "    ,\"sign\": \"人生恰似一场修行\"\n" +
                "    ,\"experience\": \"106\"\n" +
                "    ,\"ip\": \"192.168.0.8\"\n" +
                "    ,\"logins\": \"106\"\n" +
                "    ,\"joinTime\": \"2016-10-14\"\n" +
                "  }]\n" +
                "}  " ;

        return content ;
    }

    @RequestMapping(value = "/toListTree")
    public Object toListTree(){
        return "sys/menuTreeList" ;
    }

    @RequestMapping(value = "toListDateTree")
    @ResponseBody
    public Object toListDateTree(){

        String content = "{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"count\": 19,\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"authorityId\": 1,\n" +
                "      \"authorityName\": \"系统管理\",\n" +
                "      \"orderNumber\": 1,\n" +
                "      \"menuUrl\": null,\n" +
                "      \"menuIcon\": \"layui-icon-set\",\n" +
                "      \"createTime\": \"2018/06/29 11:05:41\",\n" +
                "      \"authority\": null,\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/07/13 09:13:42\",\n" +
                "      \"isMenu\": 0,\n" +
                "      \"parentId\": -1\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 2,\n" +
                "      \"authorityName\": \"用户管理\",\n" +
                "      \"orderNumber\": 2,\n" +
                "      \"menuUrl\": \"system/user\",\n" +
                "      \"menuIcon\": null,\n" +
                "      \"createTime\": \"2018/06/29 11:05:41\",\n" +
                "      \"authority\": null,\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/07/13 09:13:42\",\n" +
                "      \"isMenu\": 0,\n" +
                "      \"parentId\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 3,\n" +
                "      \"authorityName\": \"查询用户\",\n" +
                "      \"orderNumber\": 3,\n" +
                "      \"menuUrl\": \"\",\n" +
                "      \"menuIcon\": \"\",\n" +
                "      \"createTime\": \"2018/07/21 13:54:16\",\n" +
                "      \"authority\": \"user:view\",\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/07/21 13:54:16\",\n" +
                "      \"isMenu\": 1,\n" +
                "      \"parentId\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 4,\n" +
                "      \"authorityName\": \"添加用户\",\n" +
                "      \"orderNumber\": 4,\n" +
                "      \"menuUrl\": null,\n" +
                "      \"menuIcon\": null,\n" +
                "      \"createTime\": \"2018/06/29 11:05:41\",\n" +
                "      \"authority\": \"user:add\",\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/07/13 09:13:42\",\n" +
                "      \"isMenu\": 1,\n" +
                "      \"parentId\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 5,\n" +
                "      \"authorityName\": \"修改用户\",\n" +
                "      \"orderNumber\": 5,\n" +
                "      \"menuUrl\": null,\n" +
                "      \"menuIcon\": null,\n" +
                "      \"createTime\": \"2018/06/29 11:05:41\",\n" +
                "      \"authority\": \"user:edit\",\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/07/13 09:13:42\",\n" +
                "      \"isMenu\": 1,\n" +
                "      \"parentId\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 6,\n" +
                "      \"authorityName\": \"删除用户\",\n" +
                "      \"orderNumber\": 6,\n" +
                "      \"menuUrl\": null,\n" +
                "      \"menuIcon\": null,\n" +
                "      \"createTime\": \"2018/06/29 11:05:41\",\n" +
                "      \"authority\": \"user:delete\",\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/07/13 09:13:42\",\n" +
                "      \"isMenu\": 1,\n" +
                "      \"parentId\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 7,\n" +
                "      \"authorityName\": \"角色管理\",\n" +
                "      \"orderNumber\": 7,\n" +
                "      \"menuUrl\": \"system/role\",\n" +
                "      \"menuIcon\": null,\n" +
                "      \"createTime\": \"2018/06/29 11:05:41\",\n" +
                "      \"authority\": null,\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/07/13 09:13:42\",\n" +
                "      \"isMenu\": 0,\n" +
                "      \"parentId\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 8,\n" +
                "      \"authorityName\": \"查询角色\",\n" +
                "      \"orderNumber\": 8,\n" +
                "      \"menuUrl\": \"\",\n" +
                "      \"menuIcon\": \"\",\n" +
                "      \"createTime\": \"2018/07/21 13:54:59\",\n" +
                "      \"authority\": \"role:view\",\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/07/21 13:54:58\",\n" +
                "      \"isMenu\": 1,\n" +
                "      \"parentId\": 7\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 9,\n" +
                "      \"authorityName\": \"添加角色\",\n" +
                "      \"orderNumber\": 9,\n" +
                "      \"menuUrl\": \"\",\n" +
                "      \"menuIcon\": \"\",\n" +
                "      \"createTime\": \"2018/06/29 11:05:41\",\n" +
                "      \"authority\": \"role:add\",\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/07/13 09:13:42\",\n" +
                "      \"isMenu\": 1,\n" +
                "      \"parentId\": 7\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 10,\n" +
                "      \"authorityName\": \"修改角色\",\n" +
                "      \"orderNumber\": 10,\n" +
                "      \"menuUrl\": \"\",\n" +
                "      \"menuIcon\": \"\",\n" +
                "      \"createTime\": \"2018/06/29 11:05:41\",\n" +
                "      \"authority\": \"role:edit\",\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/07/13 09:13:42\",\n" +
                "      \"isMenu\": 1,\n" +
                "      \"parentId\": 7\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 11,\n" +
                "      \"authorityName\": \"删除角色\",\n" +
                "      \"orderNumber\": 11,\n" +
                "      \"menuUrl\": \"\",\n" +
                "      \"menuIcon\": \"\",\n" +
                "      \"createTime\": \"2018/06/29 11:05:41\",\n" +
                "      \"authority\": \"role:delete\",\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/07/13 09:13:42\",\n" +
                "      \"isMenu\": 1,\n" +
                "      \"parentId\": 7\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 12,\n" +
                "      \"authorityName\": \"角色权限管理\",\n" +
                "      \"orderNumber\": 12,\n" +
                "      \"menuUrl\": \"\",\n" +
                "      \"menuIcon\": \"\",\n" +
                "      \"createTime\": \"2018/06/29 11:05:41\",\n" +
                "      \"authority\": \"role:auth\",\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/07/13 15:27:18\",\n" +
                "      \"isMenu\": 1,\n" +
                "      \"parentId\": 7\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 13,\n" +
                "      \"authorityName\": \"权限管理\",\n" +
                "      \"orderNumber\": 13,\n" +
                "      \"menuUrl\": \"system/authorities\",\n" +
                "      \"menuIcon\": null,\n" +
                "      \"createTime\": \"2018/06/29 11:05:41\",\n" +
                "      \"authority\": null,\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/07/13 15:45:13\",\n" +
                "      \"isMenu\": 0,\n" +
                "      \"parentId\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 14,\n" +
                "      \"authorityName\": \"查询权限\",\n" +
                "      \"orderNumber\": 14,\n" +
                "      \"menuUrl\": \"\",\n" +
                "      \"menuIcon\": \"\",\n" +
                "      \"createTime\": \"2018/07/21 13:55:57\",\n" +
                "      \"authority\": \"authorities:view\",\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/07/21 13:55:56\",\n" +
                "      \"isMenu\": 1,\n" +
                "      \"parentId\": 13\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 15,\n" +
                "      \"authorityName\": \"添加权限\",\n" +
                "      \"orderNumber\": 15,\n" +
                "      \"menuUrl\": \"\",\n" +
                "      \"menuIcon\": \"\",\n" +
                "      \"createTime\": \"2018/06/29 11:05:41\",\n" +
                "      \"authority\": \"authorities:add\",\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/06/29 11:05:41\",\n" +
                "      \"isMenu\": 1,\n" +
                "      \"parentId\": 13\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 16,\n" +
                "      \"authorityName\": \"修改权限\",\n" +
                "      \"orderNumber\": 16,\n" +
                "      \"menuUrl\": \"\",\n" +
                "      \"menuIcon\": \"\",\n" +
                "      \"createTime\": \"2018/07/13 09:13:42\",\n" +
                "      \"authority\": \"authorities:edit\",\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/07/13 09:13:42\",\n" +
                "      \"isMenu\": 1,\n" +
                "      \"parentId\": 13\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 17,\n" +
                "      \"authorityName\": \"删除权限\",\n" +
                "      \"orderNumber\": 17,\n" +
                "      \"menuUrl\": \"\",\n" +
                "      \"menuIcon\": \"\",\n" +
                "      \"createTime\": \"2018/06/29 11:05:41\",\n" +
                "      \"authority\": \"authorities:delete\",\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/06/29 11:05:41\",\n" +
                "      \"isMenu\": 1,\n" +
                "      \"parentId\": 13\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 18,\n" +
                "      \"authorityName\": \"登录日志\",\n" +
                "      \"orderNumber\": 18,\n" +
                "      \"menuUrl\": \"system/loginRecord\",\n" +
                "      \"menuIcon\": null,\n" +
                "      \"createTime\": \"2018/06/29 11:05:41\",\n" +
                "      \"authority\": null,\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/06/29 11:05:41\",\n" +
                "      \"isMenu\": 0,\n" +
                "      \"parentId\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"authorityId\": 19,\n" +
                "      \"authorityName\": \"查询登录日志\",\n" +
                "      \"orderNumber\": 19,\n" +
                "      \"menuUrl\": \"\",\n" +
                "      \"menuIcon\": \"\",\n" +
                "      \"createTime\": \"2018/07/21 13:56:43\",\n" +
                "      \"authority\": \"loginRecord:view\",\n" +
                "      \"checked\": 0,\n" +
                "      \"updateTime\": \"2018/07/21 13:56:43\",\n" +
                "      \"isMenu\": 1,\n" +
                "      \"parentId\": 18\n" +
                "    }\n" +
                "  ]\n" +
                "}" ;

        return content ;
    }

}

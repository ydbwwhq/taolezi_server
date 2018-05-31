package com.example.commentserver.config;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class CommonConfig {
    public  static  final  Boolean isTest = false;

    public static final String SERVER = isTest ? "http://172.16.50.175:8888" : "http://139.196.185.36:8888";

    public static  final List<Map> USERCONFIG = new ArrayList<Map>(){{
        Map<String,Object> map = new HashMap<String,Object>(){{
            put("name","萌大叔");
            put("icon","icon.jpg");
            put("sex",0);
        }};
        add(map);

        Map<String,Object> map1 = new HashMap<String,Object>(){{
            put("name","小仙肉");
            put("icon","icon1.jpg");
            put("sex",0);
        }};
        add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>(){{
            put("name","小萌妞");
            put("icon","icon2.jpg");
            put("sex",1);
        }};
        add(map2);

        Map<String,Object> map3 = new HashMap<String,Object>(){{
            put("name","小姐姐");
            put("icon","icon3.jpg");
            put("sex",1);
        }};
        add(map3);


        Map<String,Object> map4 = new HashMap<String,Object>(){{
            put("name","老司机");
            put("icon","icon4.jpg");
            put("sex",0);
        }};
        add(map4);

        Map<String,Object> map5 = new HashMap<String,Object>(){{
            put("name","女司机");
            put("icon","icon5.jpg");
            put("sex",1);
        }};
        add(map5);

        Map<String,Object> map6 = new HashMap<String,Object>(){{
            put("name","女汉纸");
            put("icon","icon6.jpg");
            put("sex",1);
        }};
        add(map6);


        Map<String,Object> map7 = new HashMap<String,Object>(){{
            put("name","小黄人");
            put("icon","icon7.jpg");
            put("sex",0);
        }};
        add(map7);

        Map<String,Object> map8 = new HashMap<String,Object>(){{
            put("name","小确幸");
            put("icon","icon8.jpg");
            put("sex",1);
        }};
        add(map8);

        Map<String,Object> map9 = new HashMap<String,Object>(){{
            put("name","温小暖");
            put("icon","icon9.jpg");
            put("sex",1);
        }};
        add(map9);

        Map<String,Object> map10 = new HashMap<String,Object>(){{
            put("name","路人甲");
            put("icon","icon10.jpg");
            put("sex",0);
        }};
        add(map10);


        Map<String,Object> map11 = new HashMap<String,Object>(){{
            put("name","朕好萌");
            put("icon","icon11.jpg");
            put("sex",0);
        }};
        add(map11);


        Map<String,Object> map12 = new HashMap<String,Object>(){{
            put("name","老顽童");
            put("icon","icon12.jpeg");
            put("sex",0);
        }};
        add(map12);

        Map<String,Object> map13 = new HashMap<String,Object>(){{
            put("name","高富帅");
            put("icon","icon13");
            put("sex",0);
        }};
        add(map13);

        Map<String,Object> map14 = new HashMap<String,Object>(){{
            put("name","屌丝男");
            put("icon","icon14.jpg");
            put("sex",0);
        }};
        add(map14);

        Map<String,Object> map15 = new HashMap<String,Object>(){{
            put("name","王大厨");
            put("icon","icon15.jpg");
            put("sex",0);
        }};
        add(map15);


        Map<String,Object> map16 = new HashMap<String,Object>(){{
            put("name","程序猿");
            put("icon","icon16.jpg");
            put("sex",0);
        }};
        add(map16);


        Map<String,Object> map17 = new HashMap<String,Object>(){{
            put("name","俏护士");
            put("icon","icon17.jpg");
            put("sex",1);
        }};
        add(map17);

        Map<String,Object> map18 = new HashMap<String,Object>(){{
            put("name","为人民币服务");
            put("icon","ico18.jpg");
            put("sex",0);
        }};
        add(map18);


        Map<String,Object> map19 = new HashMap<String,Object>(){{
            put("name","猪猪侠");
            put("icon","icon19.jpg");
            put("sex",0);
        }};
        add(map19);

        Map<String,Object> map20 = new HashMap<String,Object>(){{
            put("name","奥特曼");
            put("icon","icon20.png");
            put("sex",0);
        }};
        add(map20);


        Map<String,Object> map21 = new HashMap<String,Object>(){{
            put("name","少先队员");
            put("icon","icon21.jpg");
            put("sex",1);
        }};
        add(map21);


        Map<String,Object> map22 = new HashMap<String,Object>(){{
            put("name","红领巾");
            put("icon","icon22.jpg");
            put("sex",0);
        }};
        add(map22);



        Map<String,Object> map23 = new HashMap<String,Object>(){{
            put("name","官方认证我最帅");
            put("icon","icon23.jpg");
            put("sex",0);
        }};
        add(map23);


        Map<String,Object> map24 = new HashMap<String,Object>(){{
            put("name","幼儿园老大");
            put("icon","icon24.jpg");
            put("sex",0);
        }};
        add(map24);


        Map<String,Object> map25 = new HashMap<String,Object>(){{
            put("name","范建");
            put("icon","icon25.jpg");
            put("sex",0);
        }};
        add(map25);

        Map<String,Object> map26 = new HashMap<String,Object>(){{
            put("name","萌你妹");
            put("icon","icon26.jpg");
            put("sex",1);
        }};
        add(map26);


        Map<String,Object> map27 = new HashMap<String,Object>(){{
            put("name","绿帽侠");
            put("icon","icon27.jpg");
            put("sex",0);
        }};
        add(map27);


        Map<String,Object> map28 = new HashMap<String,Object>(){{
            put("name","犯二的骚年");
            put("icon","icon28.jpg");
            put("sex",0);
        }};
        add(map28);


        Map<String,Object> map29 = new HashMap<String,Object>(){{
            put("name","神鲸大侠");
            put("icon","icon29.jpg");
            put("sex",0);
        }};
        add(map29);

        Map<String,Object> map30 = new HashMap<String,Object>(){{
            put("name","贱男春");
            put("icon","icon30.jpg");
            put("sex",0);
        }};
        add(map30);

    }};
}

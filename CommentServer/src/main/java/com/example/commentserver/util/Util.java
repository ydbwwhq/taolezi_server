package com.example.commentserver.util;


import com.example.commentserver.config.CommonConfig;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Util {
   public static long getTimeStamp()
    {
        return  System.currentTimeMillis() / 1000;
    }
    public static String getImagePath()
    {
        if(CommonConfig.isTest)
        {
            return  "/Users/shinezone/Desktop/joke_img";
        }else
        {
            return  "/root/joke_img";
        }
    }
    public static  String getJokeImagePath()
    {
        return getImagePath()+ "/content";
    }
    public static String getUserIconPath()
    {
        return  getImagePath() +"/usericon";
    }
    public static String getImageURL(String imageName)
    {
        return "/imgs/" + imageName;
    }
    public static int  generateRandomNum()
    {
        return (int)((Math.random()*9 +1) * 100000);
    }
    public static  int generateRandomNum(int min,int max)
    {
        Random random = new Random();
        return random.nextInt(max)%(max - min + 1) + min;
    }
    public static String getTimeDes(long timestamp)
    {
        long times = timestamp;
        long seconds = System.currentTimeMillis() / 1000;
        int timeDel = (int) (seconds - times + 1);
//        System.out.println("time1" + timestamp);
//        System.out.println("time2" + seconds);
//        System.out.println("timeDel" +timeDel);
        if(timeDel < 60)
        {
            return "刚刚";
        }else
        {

            int min = timeDel / 60;
           // System.out.println("min"+ min);
            if(min <= 60)
            {
                return min + "分钟前";
            }else
            {
                int h = timeDel / 60 / 60 ;
                if(h < 24)
                {
                    return h + "小时前";
                }else
                {
                    int d = timeDel / 60 / 60 / 24;
                    if(d < 30)
                    {
                        return d + "天前";
                    }else
                    {
                        int m = timeDel / 60 / 60 / 24 / 30 ;
                        if(m < 12)
                        {
                            return m + "个月前";
                        }else
                        {
                            int y = timeDel / 60 / 60 / 24 / 365 ;
                           // return  "";
                            return  y + "年前";
                        }
                    }
                }
            }
        }
    }
//    public static String encodeBase64(String string)  {
//       String result = "";
//       try {
//          result = Base64.getEncoder().encodeToString(string.getBytes("utf-8"));
//       }catch (UnsupportedEncodingException exception){
//       }
//       return  result;
//    }
//    public static String decodeBase64(String base64Str)
//    {
//        String result = "";
//        try {
//            result = new String(Base64.getDecoder().decode(base64Str),"utf-8") ;
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return  result;
//    }
    public static  String getCountDes(int count)
    {
        if(count < 1000)
        {
            return  count + "";
        }else if(count < 10000)
        {
            return count / 1000 + "千";
        }else if(count < 100000)
        {
            return  count / 10000 + "万";
        }else {
            return count + "";
        }
    }

}

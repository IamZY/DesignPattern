package com.ntuzy.flyweight;

import java.util.HashMap;

// 网站工厂类 根据需求返回一个网站
public class WebSiteFactory {

    // 集合 充当池的形式
    private HashMap<String, ConcreteWebSite> pool = new HashMap<>();

    // 根据网站的类型 返回一个网站 如果没有就创建一个网站并放入到池中
    public WebSite getWebSiteCategory(String type) {
        if (!pool.containsKey(type)) {
            // 就创建一个网站
            pool.put(type, new ConcreteWebSite(type));
        }

        return (WebSite) pool.get(type);
    }

    // 获取网站分类的总数,池中有多少实际的网站
    public int getWebSiteCount() {
        return pool.size();
    }

}

package com.ntuzy.flyweight;

public class Client {
    public static void main(String[] args) {
        WebSiteFactory webSiteFactory = new WebSiteFactory();

        // 客户要一个以新闻形式发布的网站
        WebSite website1 = webSiteFactory.getWebSiteCategory("新闻");
        User user = new User();
        user.setName("新浪");
        website1.use(user);

        System.out.println(webSiteFactory.getWebSiteCount());
    }
}

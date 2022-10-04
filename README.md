# hotel-server

hotel-user用来管理登录用户

- java包下有pojo，controller，vo，utils，service，mapper包。
 --pojo是用来封装数据库对象，就是把数据库的所有列名对应到具体的对象里。
 --controller用来控制具体的操作，比如说登录服务，注册服务等。
 --service提供服务所需要的接口，比如说登陆服务的具体代码写在service里面。
 --mapper相当于JDBC。
 --utils包管理md5加密和cookie，可以不用理会。
- resources包下有templates，static，img包。
 --templates用来写html页面。
 --static用来管理具体的js，css引用。
 --img包管理用到的图片。
hotel-common:公共的插件，比如说所有的微服务模块都需要用到mybatis-plus就直接把maybatis-plus写在这里，所有的微服务pom直接引用这里的插件。


# OSGi的概念验证

## 运行方法
    mvn clean install
    运行 starter 模块里的 starter.Starter.main 方法
## 验证
依次执行下列命令：  

    greeting zhangsan
    install bundleA-1.0-SNAPSHOT.jar
    greeting zhangsan
    install bundleB-1.0-SNAPSHOT.jar
    greeting zhangsan

修改 bundle.a.A.apply 方法  
    
    install bundleA-1.0-SNAPSHOT.jar
    greeting zhangsan
    
## 结论
    bundleA 和 bundleB 都能正确安装并生效。
    修改 bundleA 后安装可以生效。
    可以实现动态加载bundle。

# OSGi的介绍
官网  
[https://www.osgi.org](https://www.osgi.org 'OSGi 官网')   

OSGi分层  
![OSGi分层](layering-osgi.png)

OSGi的优点  
[https://www.osgi.org/developer/benefits-of-using-osgi/](https://www.osgi.org/developer/benefits-of-using-osgi/ 'OSGi的优点  ')   

OSGi的实现  
[https://www.eclipse.org/equinox](https://www.eclipse.org/equinox 'equinox')   
[https://felix.apache.org](https://felix.apache.org 'felix')   

OSGi的工具  
[https://bnd.bndtools.org](https://bnd.bndtools.org 'bnd')   

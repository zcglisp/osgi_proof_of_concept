# osgi_proof_of_concept
OSGi的概念验证
# 运行方法
    mvn clean install
    运行 starter 模块里的 starter.Starter.main 方法
# 验证
依次执行下列命令：  

    greeting zhangsan
    install bundleA-1.0-SNAPSHOT.jar
    greeting zhangsan
    install bundleB-1.0-SNAPSHOT.jar
    greeting zhangsan

修改 bundle.a.A.apply 方法  
    
    install bundleA-1.0-SNAPSHOT.jar
    greeting zhangsan
    
# 结论
    bundleA 和 bundleB 都能正确安装并生效。
    修改 bundleA 后安装可以生效。
    可以实现动态加载bundle。
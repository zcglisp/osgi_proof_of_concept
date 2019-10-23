package starter;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.ServiceLoader;
import java.util.function.Function;

public class Starter {

    private static BundleContext bundleContext;
    private static Bundle bundle;

    public static void main(String[] args) {
        startOsgiFramework();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("请输入命令：");
            System.out.println("install jar文件路径");
            System.out.println("greeting 名字");

            String command = scanner.nextLine();
            if (command.startsWith("install ")) {
                install(command.substring(8));
            }
            if (command.startsWith("greeting ")) {
                greeting(command.substring(9));
            }
        }
    }

    private static void startOsgiFramework() {
        ServiceLoader<FrameworkFactory> serviceLoader = ServiceLoader.load(FrameworkFactory.class);
        serviceLoader.iterator().forEachRemaining(Starter::startOsgiFramework);
    }

    private static void startOsgiFramework(FrameworkFactory factory) {
        Framework framework = factory.newFramework(null);
        try {
            framework.start();
            bundleContext = framework.getBundleContext();
        } catch (BundleException e) {
            e.printStackTrace();
        }
    }

    private static void install(String pathname) {
        File file = new File(pathname);
        try {
            InputStream targetStream = new FileInputStream(file);
            if (bundle != null) {
                bundle.update(targetStream);
            } else {
                bundle = bundleContext.installBundle("bundleid", targetStream);
            }
            targetStream.close();
            bundle.start();
        } catch (BundleException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void greeting(String s) {
        ServiceReference<Function> serviceReference = bundleContext.getServiceReference(Function.class);
        if (serviceReference == null) {
            System.out.println("没有发现可调用的服务");
            return;
        }
        Function service = bundleContext.getService(serviceReference);
        Object starter = service.apply(s);
        System.out.println(starter);
    }
}

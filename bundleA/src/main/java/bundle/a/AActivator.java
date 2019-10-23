package bundle.a;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.function.Function;

public class AActivator implements BundleActivator {

    private A service = new A();
    private ServiceRegistration<Function> serviceRegistration;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        serviceRegistration = bundleContext.registerService(Function.class, service, null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        serviceRegistration.unregister();
    }
}

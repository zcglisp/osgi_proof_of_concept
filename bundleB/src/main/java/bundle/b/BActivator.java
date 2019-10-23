package bundle.b;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.function.Function;

public class BActivator implements BundleActivator {

    private B service = new B();
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

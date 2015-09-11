package co.techmagic.common.eventbus;

import com.squareup.otto.Bus;

public class BusNotifier {

    public static final String TAG = BusNotifier.class.getSimpleName();

    private static volatile Bus bus;

    static {
        bus = new MainThreadBus();
    }

    public static void notifyEvent(Object event) {
        bus.post(event);
    }

    public static void register(Object receiver) {
        bus.register(receiver);
    }

    public static void unregister(Object receiver) {
        bus.unregister(receiver);
    }
}

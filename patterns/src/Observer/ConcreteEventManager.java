package Observer;

import java.util.*;

public class ConcreteEventManager implements EventManager<EventArgs> {
    private static ConcreteEventManager manager;
    private Map<EventType, List<EventListener>> listeners;

    {
        this.listeners = new HashMap<>();
    }

    private ConcreteEventManager() {
        manager = this;
    }

    @Override
    public void subscribe(EventType type, EventListener listener) {
        if (listeners.containsKey(type))
            listeners.get(type).add(listener);
        else{
            listeners.put(type, new ArrayList<>(Arrays.asList(listener)));
        }
    }

    @Override
    public void unsubscribe(EventType type, EventListener listener) {
        if(!listeners.containsKey(type))
            return;

        listeners.get(type).remove(listener);
    }

    @Override
    public void notify(Object sender, EventType type, EventArgs args) {
        if (!listeners.containsKey(type))
            return;
        listeners.get(type).stream().forEach(x -> x.update(sender, args, type));
    }

    public static ConcreteEventManager getInstance() {
        return Optional.ofNullable(manager).orElse(new ConcreteEventManager());
    }
}

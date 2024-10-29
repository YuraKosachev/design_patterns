package Observer;

public interface EventManager<T> {
    void subscribe(EventType type, EventListener listener);
    void unsubscribe(EventType type, EventListener listener);
    void notify(Object sender, EventType type, T args);
}

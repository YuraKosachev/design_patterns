package Observer;

public interface EventListener {
    void update(Object sender, EventArgs arg, EventType type);
}

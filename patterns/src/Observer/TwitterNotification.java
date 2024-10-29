package Observer;

import java.util.Optional;

public class TwitterNotification implements EventListener {

    private final EventManager<EventArgs> eventManager;

    public TwitterNotification(EventManager<EventArgs> eventManager) {
        this.eventManager = eventManager;
        this.eventManager.subscribe(EventType.CREATED, this);
    }

    @Override
    public void update(Object sender, EventArgs arg, EventType type) {
        System.out.println("Twitter posted:" + arg.id());
    }
}

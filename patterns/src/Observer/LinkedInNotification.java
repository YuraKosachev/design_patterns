package Observer;

public class LinkedInNotification implements EventListener{
    private final EventManager<EventArgs> eventManager;

    public LinkedInNotification(EventManager<EventArgs> eventManager) {
        this.eventManager = eventManager;
        this.eventManager.subscribe(EventType.CREATED, this);
    }

    @Override
    public void update(Object sender, EventArgs arg, EventType type) {
        System.out.println("LinkedIn posted:" + arg.id());
    }
}

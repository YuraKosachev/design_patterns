package Observer;

import java.util.UUID;

public class Publisher {
    private final EventManager<EventArgs> manager;

    public Publisher(EventManager<EventArgs> manager) {
        this.manager = manager;
    }

    public void postCreate(String postName, String author) {
        //
        if (savePost(postName, author))
            this.manager.notify(this, EventType.CREATED,
                    new EventArgs(UUID.randomUUID(), postName + "-" + author, 1));

    }

    private boolean savePost(String name, String author) {
        System.out.println("Save data to db");
        return true;
    }
}

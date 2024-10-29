package Observer;

public class Main {
    public static void main(String[] args) {
        EventManager<EventArgs> manager = ConcreteEventManager.getInstance();
        EventListener twitter = new TwitterNotification(manager);
        EventListener linkedIn = new LinkedInNotification(manager);

        Publisher publisher = new Publisher(manager);

        publisher.postCreate("New greate post name", "Yury Kosahou");

    }
}

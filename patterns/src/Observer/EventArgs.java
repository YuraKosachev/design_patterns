package Observer;

import java.util.UUID;

public record EventArgs(UUID id, String name, int count){};

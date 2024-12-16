import java.io.Serializable;

public class Chat implements Serializable {

    transient String currentID; // mark an instance variable transient to stop it from being serialized.
    String userName;
}

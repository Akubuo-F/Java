package main.api.endpoints;

public class Authenticator {

    public static boolean authenticate(String secret) {
        //todo: need to implement a proper authentication
        return secret.equals("authorized");
    }
}

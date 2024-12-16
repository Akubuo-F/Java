import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SavingObjects {
    public static void main(String[] args) {
        GameCharacter character1 = new GameCharacter(
                50,
                "Elf",
                new String[]{"Bow", "Sword", "Dust"}
        );
        GameCharacter character2 = new GameCharacter(
                200,
                "Troll",
                new String[]{"Bare Hands", "Big Axe"}
        );
        GameCharacter character3 = new GameCharacter(
                120,
                "Magician",
                new String[]{"Spells", "Invisibility"}
        );

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("MyGame.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(character1);
            objectOutputStream.writeObject(character2);
            objectOutputStream.writeObject(character3);

            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

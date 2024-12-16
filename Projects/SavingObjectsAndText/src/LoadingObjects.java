import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadingObjects {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("MyGame.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object one = objectInputStream.readObject();
            Object two = objectInputStream.readObject();
            Object three = objectInputStream.readObject();

            GameCharacter character1 = (GameCharacter) one;
            GameCharacter character2 = (GameCharacter) two;
            GameCharacter character3 = (GameCharacter) three;

            objectInputStream.close();

            System.out.println("Character1's type: " + character1.getType());
            System.out.println("Character2's type: " + character2.getType());
            System.out.println("Character3's type: " + character3.getType());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

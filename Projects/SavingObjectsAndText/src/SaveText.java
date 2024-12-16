import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SaveText {
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

        GameCharacter[] gameCharacters = new GameCharacter[] {character1, character2, character3};
        String gameCharactersAsString = convertGameCharactersToString(gameCharacters);
        try {
            FileWriter fileWriter = new FileWriter("MyGame.txt");
            fileWriter.write(String.join("\n", gameCharactersAsString));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String convertGameCharacterToString(GameCharacter character) {
        String power = Integer.toString(character.getPower());
        String type = character.getType();
        String weapons = String.join(",", character.getWeapons());
        return String.join(",", new String[] {
                power,
                type,
                weapons
        });
    }

    public static String convertGameCharactersToString(GameCharacter[] gameCharacters) {
        List<String> stringArray = Arrays.stream(gameCharacters)
                .map(SaveText::convertGameCharacterToString)
                .toList();
        return String.join("\n", stringArray);
    }
}

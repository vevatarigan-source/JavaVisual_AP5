
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;

public class Main {

    public static void main(String[] args) {

        // Membuat objek CharacterManager
        CharacterManager manager = new CharacterManager();

        // Membuat beberapa karakter
        Character c1 = new Character(
            "Aragorn", CharacterType.WARRIOR, 5
        );

        Character c2 = new Character(
            "Gandalf", CharacterType.MAGE, 8
        );

        Character c3 = new Character(
            "Legolas", CharacterType.ARCHER, 6
        );

        // Menambahkan karakter ke dalam manager
        System.out.println("=== MENAMBAHKAN KARAKTER ===");
        System.out.println("Aragorn: " + manager.addCharacter(c1));
        System.out.println("Gandalf: " + manager.addCharacter(c2));
        System.out.println("Legolas: " + manager.addCharacter(c3));

        // Menguji penolakan nama duplikat
        Character duplicate = new Character(
            "Aragorn", CharacterType.WARRIOR, 3
        );

        System.out.println(
            "Duplikat Aragorn ditambahkan: "
            + manager.addCharacter(duplicate)
        );

        // Menampilkan semua karakter
        System.out.println("\n=== DAFTAR KARAKTER ===");

        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        // Menampilkan jumlah karakter
        System.out.println(
            "\nTotal karakter: " + manager.getTotalCharacters()
        );

        // Menguji method baru findStrongest()
        System.out.println("\n=== KARAKTER TERKUAT ===");

        Character strongest = manager.findStrongest();

        if (strongest != null) {
            System.out.println(strongest);
        } else {
            System.out.println("Belum ada karakter.");
        }

        // Menguji pencarian berdasarkan nama
        System.out.println("\n=== PENCARIAN KARAKTER ===");

        Character found = manager.findByName("Gandalf");

        if (found != null) {
            System.out.println("Ditemukan: " + found);
        } else {
            System.out.println("Karakter tidak ditemukan.");
        }

        // Menguji penghapusan karakter
        System.out.println("\n=== MENGHAPUS KARAKTER ===");

        System.out.println(
            "Legolas dihapus: "
            + manager.removeCharacter("Legolas")
        );

        System.out.println(
            "Total karakter sekarang: "
            + manager.getTotalCharacters()
        );

        // Menguji mana dan isAlive()
        System.out.println("\n=== STATUS KARAKTER ===");

        c2.setMana(50);

        System.out.println("Mana Gandalf: " + c2.getMana());
        System.out.println("Gandalf masih hidup: " + c2.isAlive());
    }
}

import java.util.ArrayList;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        Character c1 = new Character(
            "Arjuna", 10, 80, CharacterType.WARRIOR
        );

        Character c2 = new Character(
            "Srikandi", 8, 90, CharacterType.ARCHER
        );

        Character c3 = new Character(
            "Bima", 12, 70, CharacterType.WARRIOR
        );

        Character c4 = new Character(
            "Dewi", 6, 100, CharacterType.HEALER
        );

        System.out.println("=== 1. TAMBAH KARAKTER ===");

        System.out.println("Arjuna ditambahkan: "
            + manager.addCharacter(c1));
        System.out.println("Srikandi ditambahkan: "
            + manager.addCharacter(c2));
        System.out.println("Bima ditambahkan: "
            + manager.addCharacter(c3));
        System.out.println("Dewi ditambahkan: "
            + manager.addCharacter(c4));

        System.out.println("\n=== 2. UJI NAMA DUPLIKAT ===");

        Character duplicate = new Character(
            "arjuna", 5, 50, CharacterType.MAGE
        );

        System.out.println("Arjuna duplikat ditambahkan: "
            + manager.addCharacter(duplicate));
        System.out.println("Total karakter: "
            + manager.getTotalCharacters());

        System.out.println("\n=== 3. CARI KARAKTER ===");

        System.out.println("Cari Srikandi: "
            + manager.findByName("Srikandi"));

        System.out.println("Cari nama tidak ada: "
            + manager.findByName("Gatotkaca"));

        System.out.println("\n=== 4. SEMUA KARAKTER ===");

        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }

        System.out.println("\n=== 5. MINI-CHALLENGE ===");

        System.out.println("Rata-rata level: "
            + manager.getAverageLevel());

        System.out.println("Karakter tipe WARRIOR:");

        for (Character c : manager.findByType(
                CharacterType.WARRIOR)) {
            System.out.println(c);
        }

        System.out.println("Jumlah WARRIOR: "
            + manager.countByType(CharacterType.WARRIOR));

        System.out.println("\n=== 6. UJI SALINAN ARRAYLIST ===");

        ArrayList<Character> copy = manager.getAllCharacters();

        System.out.println("Ukuran daftar asli sebelum: "
            + manager.getTotalCharacters());

        copy.clear();

        System.out.println("Ukuran daftar salinan setelah clear: "
            + copy.size());

        System.out.println("Ukuran daftar asli setelah clear: "
            + manager.getTotalCharacters());

        System.out.println("\n=== 7. UJI REFERENCE OBJEK ===");

        ArrayList<Character> anotherCopy = manager.getAllCharacters();

        Character referenceA = anotherCopy.get(0);
        Character referenceB = referenceA;

        referenceB.setLevel(99);

        System.out.println("Level referenceA: "
            + referenceA.getLevel());
        System.out.println("referenceA == referenceB: "
            + (referenceA == referenceB));

        // Pulihkan level agar data pengujian berikutnya rapi.
        referenceA.setLevel(10);

        System.out.println("\n=== 8. HAPUS KARAKTER ===");

        System.out.println("Arjuna berhasil dihapus: "
            + manager.removeCharacter("Arjuna"));

        System.out.println("Arjuna dihapus lagi: "
            + manager.removeCharacter("Arjuna"));

        System.out.println("Total karakter sekarang: "
            + manager.getTotalCharacters());

        System.out.println("\n=== 9. RATA-RATA LIST KOSONG ===");

        CharacterManager emptyManager = new CharacterManager();

        System.out.println("Rata-rata level kosong: "
            + emptyManager.getAverageLevel());

        System.out.println("Jumlah karakter kosong: "
            + emptyManager.getTotalCharacters());

        System.out.println("\nTotal objek Character dibuat: "
            + Character.getTotalCharacterCreated());
    }
}

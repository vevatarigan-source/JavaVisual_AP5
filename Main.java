
public class Main {
    public static void main(String[] args) {

        // 5. Membuat karakter baru
        Character hero = new Character("Zilong", 5, 100);

        // Mengatur mana
        hero.setMana(50);

        // Mencetak data karakter
        System.out.println(hero);

        // Mencetak nilai mana
        System.out.println("Mana: " + hero.getMana());

        // Memeriksa apakah karakter masih hidup
        System.out.println("Is Alive: " + hero.isAlive());
    }
}

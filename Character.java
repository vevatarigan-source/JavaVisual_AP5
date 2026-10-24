
public class Character {
    private String name;
    private int level;
    private int hitPoints;
    private int mana; // 1. Atribut baru

    public Character(String name, int level, int hitPoints) {
        this.name = name;
        this.level = level;
        this.hitPoints = hitPoints;
        this.mana = 0;
    }

    // 2. Getter mana
    public int getMana() {
        return mana;
    }

    // 2. Setter mana dengan validasi
    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh negatif!"
            );
        }
        this.mana = mana;
    }

    // 3. Mengecek apakah karakter masih hidup
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // 4. Menampilkan data karakter termasuk mana
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", mana=" + mana +
                '}';
    }
}

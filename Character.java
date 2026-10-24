package com.unpri.charactermanager.model;

import java.util.Objects;

public class Character {

    private String name;
    private int level;
    private int mana;
    private CharacterType type;

    private static int totalCharacterCreated = 0;

    public Character(String name, CharacterType type) {
        this(name, 1, 100, type);
    }

    public Character(String name, int level, int mana,
                     CharacterType type) {
        setName(name);
        setLevel(level);
        setMana(mana);
        setType(type);
        totalCharacterCreated++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nama karakter tidak boleh kosong."
            );
        }
        this.name = name.trim();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                "Level minimal adalah 1."
            );
        }
        this.level = level;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0 || mana > 100) {
            throw new IllegalArgumentException(
                "Mana harus berada antara 0 dan 100."
            );
        }
        this.mana = mana;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        if (type == null) {
            throw new IllegalArgumentException(
                "Tipe karakter tidak boleh null."
            );
        }
        this.type = type;
    }

    public boolean isAlive() {
        return mana > 0;
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;

        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(
            java.util.Locale.ROOT
        ));
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", mana=" + mana +
                ", type=" + type +
                '}';
    }
}

package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private final ArrayList<Character> characters;

    public CharacterManager() {
        characters = new ArrayList<>();
    }

    public boolean addCharacter(Character character) {
        if (character == null) {
            return false;
        }

        // Tolak nama duplikat.
        if (findByName(character.getName()) != null) {
            return false;
        }

        characters.add(character);
        return true;
    }

    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(name.trim())) {
                return character;
            }
        }

        return null;
    }

    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        characters.remove(character);
        return true;
    }

    public int getTotalCharacters() {
        return characters.size();
    }

    /**
     * Mengembalikan salinan daftar karakter agar pemanggil
     * tidak dapat menambah atau menghapus isi daftar internal.
     *
     * @return salinan ArrayList karakter
     */
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    /**
     * Menghitung rata-rata level semua karakter.
     *
     * @return rata-rata level, atau 0 jika daftar kosong
     */
    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characters.size();
    }

    /**
     * Mencari semua karakter berdasarkan tipe.
     *
     * @param type tipe karakter yang dicari
     * @return ArrayList baru yang berisi karakter dengan tipe tersebut
     */
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        if (type == null) {
            return result;
        }

        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    /**
     * Menghitung banyaknya karakter untuk tipe tertentu.
     *
     * @param type tipe karakter yang akan dihitung
     * @return jumlah karakter dengan tipe tersebut
     */
    public int countByType(CharacterType type) {
        if (type == null) {
            return 0;
        }

        int count = 0;

        for (Character character : characters) {
            if (character.getType() == type) {
                count++;
            }
        }

        return count;
    }
}
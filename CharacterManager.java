
package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private final ArrayList<Character> characters = new ArrayList<>();

    public boolean addCharacter(Character character) {
        if (character == null) {
            return false;
        }

        if (findByName(character.getName()) != null) {
            System.out.println("Gagal: karakter dengan nama '"
                    + character.getName() + "' sudah ada!");
            return false;
        }

        characters.add(character);
        System.out.println("Berhasil menambahkan: " + character.getName());
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
            System.out.println("Karakter tidak ditemukan: " + name);
            return false;
        }

        characters.remove(character);
        System.out.println("Berhasil menghapus: " + name);
        return true;
    }

    public int getTotalCharacters() {
        return characters.size();
    }

    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }

        int total = 0;

        for (Character character : characters) {
            total += character.getLevel();
        }

        return (double) total / characters.size();
    }

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

    public Character findStrongest() {
        if (characters.isEmpty()) {
            return null;
        }

        Character strongest = characters.get(0);

        for (Character character : characters) {
            if (character.getLevel() > strongest.getLevel()) {
                strongest = character;
            }
        }

        return strongest;
    }
}

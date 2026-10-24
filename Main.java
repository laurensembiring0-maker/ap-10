
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Character Manager v0.2 — CRUD Test ===\n");

        CharacterManager manager = new CharacterManager();

        // 1. Tambah beberapa karakter
        manager.addCharacter(
                new Character("Arjuna", CharacterType.WARRIOR, 5));
        manager.addCharacter(
                new Character("Merlin", CharacterType.MAGE, 3));
        manager.addCharacter(
                new Character("Athena", CharacterType.ARCHER, 4));

        // 2. Coba tambah karakter dengan nama duplikat
        System.out.println("\n--- Pengujian Duplikat ---");
        manager.addCharacter(
                new Character("Arjuna", CharacterType.HEALER, 1));

        // 3. Tampilkan total karakter
        System.out.println(
                "\nTotal karakter saat ini: "
                        + manager.getTotalCharacters());

        // 4. Cari karakter
        System.out.println("\n--- Pencarian ---");

        Character hasil = manager.findByName("Merlin");
        System.out.println(
                hasil != null
                        ? "Ditemukan: " + hasil
                        : "Merlin tidak ditemukan");

        Character tidakAda = manager.findByName("Zeus");
        System.out.println(
                tidakAda != null
                        ? "Ditemukan: " + tidakAda
                        : "Zeus tidak ditemukan (sesuai harapan)");

        // 5. Hapus karakter
        System.out.println("\n--- Penghapusan ---");
        manager.removeCharacter("Athena");

        System.out.println(
                "Total setelah hapus: "
                        + manager.getTotalCharacters());

        // 6. Tampilkan karakter yang tersisa
        System.out.println("\n--- Daftar Karakter Tersisa ---");

        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }

        // 7. Eksperimen Object Reference
        System.out.println("\n--- Eksperimen Reference ---");

        Character asli = manager.findByName("Arjuna");
        Character duplikatReferensi = asli;

        if (asli != null) {
            System.out.println(
                    "Level Arjuna sebelum: " + asli.getLevel());

            duplikatReferensi.setLevel(99);

            System.out.println(
                    "Level Arjuna sesudah (lewat asli): "
                            + asli.getLevel());

            System.out.println(
                    "asli == duplikatReferensi? "
                            + (asli == duplikatReferensi));
        }

        // 8. Eksperimen salinan list
        System.out.println("\n--- Eksperimen Salinan List ---");

        ArrayList<Character> salinanList =
                manager.getAllCharacters();

        salinanList.add(
                new Character("Hantu", CharacterType.MAGE, 1));

        System.out.println(
                "Total di manager asli: "
                        + manager.getTotalCharacters());

        System.out.println(
                "Total di salinan list: "
                        + salinanList.size());


        if (asli != null) {
            System.out.println("Level Arjuna sebelum: " + asli.getLevel());

            duplikatReferensi.setLevel(99);

            System.out.println("Level Arjuna sesudah (lewat asli): "
                    + asli.getLevel());

            System.out.println("asli == duplikatReferensi? "
                    + (asli == duplikatReferensi));
        }

        // Menguji salinan list
        System.out.println("\n--- Pengujian Salinan List ---");

        

        salinanList.add(
                new Character("Hantu", CharacterType.MAGE, 1));

        System.out.println("Total di manager asli: "
                + manager.getTotalCharacters());

        System.out.println("Total di salinan list: "
                + salinanList.size());
    }
}
    





import java.util.Scanner;

public class Kafe06 {
    public static void Menu (String namaPelanggan, boolean isMember) {
        System.out.println("Selamat datang " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappucino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
        System.out.println("Silahkan pilih menu yang Anda inginkan");
    }
    public static int hitungTotalHarga06(int pilihanMenu, int banyakItem, String kodePromo) {
        int [] hargaItems = { 15000, 20000, 22000, 12000, 10000, 18000};

        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;

        switch (kodePromo) {
            case "DISKON50":
                hargaTotal *= 0.5;
                break;
            case "DISKON30":
                hargaTotal *= 0.7;
                break;
            default:
                System.out.println("Kode promo tidak valid");
        }
        return hargaTotal;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        Menu("Andi", true);
        int totalHarga = 0;
        String kodePromo = "DISKON50";

        while (true) {
            System.out.print("\nMasukkan nomor menu yang ingin Anda pesan (1-6), masukkan 0 jika sudah selesai : ");
            int pilihanMenu = sc.nextInt();
            if (pilihanMenu == 0) {
                break;
            }

            if (pilihanMenu < 1 || pilihanMenu > 6) {
                System.out.println("Pilihan menu tidak valid. Pilih nomor antara 1-6");
                continue;
            }

            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            int banyakItem = sc.nextInt();

            int hargaMenu = hitungTotalHarga06(pilihanMenu, banyakItem, kodePromo);
            totalHarga += hargaMenu;

            System.out.println("Harga menu tersebut: Rp" + hargaMenu);
        }
        System.out.println("\nTotal menu pesanan: Rp" + totalHarga);
    }
}
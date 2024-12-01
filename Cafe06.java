import java.util.Scanner;

public class Cafe06 {
    static int[][] sales = new int[7][5];
    static String[] menu = {"Kopi", "Teh", "Es Degan", "Roti Bakar", "Gorengan"};
    static Scanner scanner = new Scanner(System.in);

    public static void inputPenjualan() {
        System.out.println("Masukkan data penjualan untuk 7 hari:");
        for (int day = 0; day < 7; day++) {
            System.out.println("Hari ke-" + (day + 1) + ":");
            for (int item = 0; item < menu.length; item++) {
                System.out.print("  Masukkan jumlah penjualan untuk " + menu[item] + ": ");
                sales[day][item] = scanner.nextInt();
            }
        }
        System.out.println("Data penjualan berhasil diinput!");
    }

    public static void tampilPenjualan() {
        System.out.println("\nRekap Penjualan:");
        for (int i = 0; i < sales.length; i++) {
            System.out.print("Hari ke-" + (i + 1) + ": ");
            for (int j = 0; j < sales[i].length; j++) {
                System.out.print(menu[j] + "=" + sales[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void penjualanTertinggi() {
        int[] totalSales = new int[menu.length];

        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                totalSales[j] += sales[i][j];
            }
        }

        int maxSales = totalSales[0];
        int maxIndex = 0;

        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > maxSales) {
                maxSales = totalSales[i];
                maxIndex = i;
            }
        }

        System.out.println("Menu dengan penjualan tertinggi: " + menu[maxIndex] + " dengan total penjualan " + maxSales);
    }

    public static void rataPenjualan() {
        System.out.println("\nRata-rata penjualan per menu:");
        for (int i = 0; i < menu.length; i++) {
            int total = 0;
            for (int j = 0; j < sales.length; j++) {
                total += sales[j][i];
            }
            double average = (double) total / sales.length;
            System.out.println(menu[i] + ": " + average);
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nMenu Pilihan:");
            System.out.println("1. Input data penjualan");
            System.out.println("2. Tampilkan seluruh data penjualan");
            System.out.println("3. Tampilkan menu dengan penjualan tertinggi");
            System.out.println("4. Tampilkan rata-rata penjualan per menu");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inputPenjualan();
                    break;
                case 2:
                    tampilPenjualan();
                    break;
                case 3:
                    penjualanTertinggi();
                    break;
                case 4:
                    rataPenjualan();
                    break;
                case 5:
                    System.out.println("Keluar dari program...");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
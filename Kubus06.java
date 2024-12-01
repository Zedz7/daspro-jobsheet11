import java.util.Scanner;

public class Kubus06 {
    static int hitungVolume (int sisi) {
        return sisi * sisi * sisi;
    }
    static int hitungLuas (int sisi) {
        return 6 * sisi * sisi;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s, L, vol;

        System.out.print("Masukkan panjang sisi kubus: ");
        s = sc.nextInt();

        vol = hitungVolume(s);
        System.out.println("Volume kubus: " + vol);

        L = hitungLuas(s);
        System.out.println("Luas permukaan kubus: " + L);
    }
}
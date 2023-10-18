package Pecahan;

public class Pecahan {
    private int pembilang;
    private int penyebut;

    public Pecahan(int pembilang, int penyebut) {
        this.pembilang = pembilang;
        this.penyebut = penyebut;
    }

    public Pecahan tambah(Pecahan other) {
        int newPembilang = (this.pembilang * other.penyebut) + (other.pembilang * this.penyebut);
        int newPenyebut = this.penyebut * other.penyebut;
        return sederhanakan(new Pecahan(newPembilang, newPenyebut));
    }

    public Pecahan kurang(Pecahan other) {
        int newPembilang = (this.pembilang * other.penyebut) - (other.pembilang * this.penyebut);
        int newPenyebut = this.penyebut * other.penyebut;
        return sederhanakan(new Pecahan(newPembilang, newPenyebut));
    }

    public Pecahan kali(Pecahan other) {
        int newPembilang = this.pembilang * other.pembilang;
        int newPenyebut = this.penyebut * other.penyebut;
        return sederhanakan(new Pecahan(newPembilang, newPenyebut));
    }

    public Pecahan bagi(Pecahan other) {
        int newPembilang = this.pembilang * other.penyebut;
        int newPenyebut = this.penyebut * other.pembilang;
        return sederhanakan(new Pecahan(newPembilang, newPenyebut));
    }

    private int fpb(int a, int b) {
        if (b == 0) {
            return a;
        }
        return fpb(b, a % b);
    }

    private Pecahan sederhanakan(Pecahan pecahan) {
        int common = fpb(pecahan.pembilang, pecahan.penyebut);
        pecahan.pembilang /= common;
        pecahan.penyebut /= common;
        return pecahan;
    }

    @Override
    public String toString() {
        return pembilang + "/" + penyebut;
    }
}
package com.example.projetaslaks;

public class Musteri {
    private String isim;
    private String tcNo;
    private String sifre;
    private int bakiye;
    private String sonKonum;
    private Arac arac =new Arac();

    public Musteri(String isim, String tcNo, String sifre, int bakiye, String sonKonum, Arac arac) {
        this.isim = isim;
        this.tcNo = tcNo;
        this.sifre = sifre;
        this.bakiye = bakiye;
        this.sonKonum = sonKonum;
        this.arac = arac;
    }


}

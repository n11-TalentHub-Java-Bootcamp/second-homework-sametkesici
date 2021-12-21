package com.bahadirmemis.springboot.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "KATEGORI")
public class Kategori  implements Serializable {

    public Kategori(Long id, String adi, Long kirilim, Kategori ustKategori) {
        this.id = id;
        this.adi = adi;
        this.kirilim = kirilim;
        this.ustKategori = ustKategori;
    }

    public Kategori() {
    }

    @SequenceGenerator(name = "generator", sequenceName = "KATEGORI_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID")
    private Long id;

    @Column(name = "ADI", nullable = false, length = 50)
    private String adi;

    @Column(name = "KIRILIM")
    private Long kirilim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_UST_KATEGORI")
    private Kategori ustKategori;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public Long getKirilim() {
        return kirilim;
    }

    public void setKirilim(Long kirilim) {
        this.kirilim = kirilim;
    }

    public Kategori getUstKategori() {
        return ustKategori;
    }

    public void setUstKategori(Kategori ustKategori) {
        this.ustKategori = ustKategori;
    }

    @Override
    public String toString() {
        return id == null ? "" : id.toString();
    }
}

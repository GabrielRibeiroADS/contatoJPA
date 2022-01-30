package br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.entidade;

import javax.persistence.*;

@Entity
@Table(name="curriculo")
public class Curriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String pdf;

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

}

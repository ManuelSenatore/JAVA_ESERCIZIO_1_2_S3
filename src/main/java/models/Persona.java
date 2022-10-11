package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cognome;



    private String email;
    private String datadinascita;

    public Persona() {
    }

    public Persona(String nome, String cognome, String email, String datadinascita, Sesso sesso) {
        super();
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.datadinascita = datadinascita;
        this.sesso = sesso;
    }


    public List<Partecipazione> getListapartecipazioni() {
        return listapartecipazioni;
    }

    public void setListapartecipazioni(List<Partecipazione> listapartecipazioni) {
        this.listapartecipazioni = listapartecipazioni;
    }
    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatadinascita() {
        return datadinascita;
    }

    public void setDatadinascita(String datadinascita) {
        this.datadinascita = datadinascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    @OneToMany(mappedBy = "persona")
    private List<Partecipazione> listapartecipazioni;

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", datadinascita='" + datadinascita + '\'' +
                ", sesso=" + sesso +
                '}';
    }
}

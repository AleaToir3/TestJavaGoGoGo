package tech.chillo.sa.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //verification de email unique 3 facon de faire ici ou dans le sql "EMAIL varchar(50) UNIQUE" ou verifier dans le service
    @Column(unique = true)
    private String email;

    public Client() {
    }

    public Client(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

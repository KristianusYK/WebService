package pojos;
// Generated Dec 11, 2018 12:07:25 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Klinik generated by hbm2java
 */
@Entity
@Table(name="klinik"
    ,catalog="rsku"
)
public class Klinik  implements java.io.Serializable {


     private String idKlinik;
     private String nama;
     private String spesialis;

    public Klinik() {
    }

	
    public Klinik(String idKlinik) {
        this.idKlinik = idKlinik;
    }
    public Klinik(String idKlinik, String nama, String spesialis) {
       this.idKlinik = idKlinik;
       this.nama = nama;
       this.spesialis = spesialis;
    }
   
     @Id 

    
    @Column(name="idKlinik", unique=true, nullable=false, length=20)
    public String getIdKlinik() {
        return this.idKlinik;
    }
    
    public void setIdKlinik(String idKlinik) {
        this.idKlinik = idKlinik;
    }

    
    @Column(name="nama", length=50)
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }

    
    @Column(name="spesialis", length=50)
    public String getSpesialis() {
        return this.spesialis;
    }
    
    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

public String toJson() {
        return "{\"idKlinik\":\"" + getIdKlinik() + "\",\"nama\":\"" + getNama() + "\",\"spesialis\":\"" + getSpesialis() + "\"}";
    }


}



package pojos;
// Generated Dec 11, 2018 12:07:25 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Dokter generated by hbm2java
 */
@Entity
@Table(name="dokter"
    ,catalog="rsku"
)
public class Dokter  implements java.io.Serializable {


     private Integer id;
     private String nama;
     private String spesialis;

    public Dokter() {
    }

    public Dokter(String nama, String spesialis) {
       this.nama = nama;
       this.spesialis = spesialis;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="nama", length=100)
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }

    
    @Column(name="spesialis", length=100)
    public String getSpesialis() {
        return this.spesialis;
    }
    
    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

public String toJson() {
        return "{\"id\":\"" + getId() + "\",\"nama\":\"" + getNama() + "\",\"spesialis\":\"" + getSpesialis() + "\"}";
    }


}


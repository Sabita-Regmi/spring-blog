import javax.persistence.*;

@Entity
@Table(name="users")
public class JpaPractice {
    @Id @GeneratedValue
    private long id;
    @Column(nullable=false,length=100)
    private String firstName;

    @Column(nullable=false,length=200)
    private String lastName;

    @Column(nullable=false,length=300)
    private String address;

    @Column (nullable=false)
    private int zip_code;
}

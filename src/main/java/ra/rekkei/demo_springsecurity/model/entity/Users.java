package ra.rekkei.demo_springsecurity.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Users {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    @Column(name = "username",length = 100,unique = true,nullable = false)
    private String username;
    @Column(name = "password",length = 200,nullable = false)
    private String password;
    @Column(name = "full_name",length = 700,nullable = false)
    private String fullName;
    @Column(name = "email",length = 100,unique = true,nullable = false)
    private String email;
    @Column(name = "phone",length = 20,unique = true,nullable = false)
    private String phone;
    @Column(name = "status")
    private Boolean status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Roles> roles;
}

package com.aantik.demo.HelperClassServices;

    import java.util.HashSet;
    import java.util.Set;
    
    import javax.persistence.*;
    import javax.validation.constraints.Email;
    import javax.validation.constraints.NotBlank;
    import javax.validation.constraints.Size;
    
    @Entity
    @Table(	name = "usersGab", 
            uniqueConstraints = { 
                @UniqueConstraint(columnNames = "username"),
            })
    public class UserG {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        @NotBlank
        @Size(max = 50)
        @Email
        private String username;
    
        @NotBlank
        @Size(max = 120)
        private String password;
    
        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(	name = "user_rolesGabo", 
                    joinColumns = @JoinColumn(name = "usersGab_id"), 
                    inverseJoinColumns = @JoinColumn(name = "rolesGabo_id"))
        private Set<RoleG> roles = new HashSet<>();
    
        public UserG() {
        }
    
        public UserG(String username, String password) {
            this.username = username;
            this.password = password;
        }
    
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getUsername() {
            return username;
        }
    
        public void setUsername(String username) {
            this.username = username;
        }
    
        public String getPassword() {
            return password;
        }
    
        public void setPassword(String password) {
            this.password = password;
        }
    
        public Set<RoleG> getRoles() {
            return roles;
        }
    
        public void setRoles(Set<RoleG> roles) {
            this.roles = roles;
        }
    }
package com.smartcontactman.SmartContactManager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="Users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotBlank(message = "User is Required...")
    private String name;
     @Column(unique = true,nullable = false)

     @NotBlank(message = "Email is required")
     @Email(message = "Enter a valid email address")

     private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
     private String password;
     @Lob
    private String about;
     @Column(length = 100)
    private String profilePicture;
     private String phoneNumber;
     private boolean enabled=false;
     private boolean emailverifyed=false;
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
     private boolean phoneverifyed=false;

     @Enumerated(value = EnumType.STRING)
    private Providers provider=Providers.SELF;
     private  String emailToken;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Contact> contacs=new LinkedHashSet<>();

}


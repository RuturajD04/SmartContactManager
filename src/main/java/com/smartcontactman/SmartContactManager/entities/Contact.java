package com.smartcontactman.SmartContactManager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="User_contacts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    @Id
    @NotBlank(message = "Id is required")
    private String id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phonenumber;

    @Size(max = 200, message = "Address can have maximum 200 characters")
    private String address;

    @Size(max = 255, message = "Picture URL too long")
    private String picture;

    @Size(max = 1000, message = "Description can have maximum 1000 characters")
    @Lob
    private String description;

    private boolean favorite = false;

    @Pattern(
            regexp = "^(https?://.*)?$",
            message = "Website link must be a valid URL"
    )
    private String websiteLink;

    @Pattern(
            regexp = "^(https?://.*)?$",
            message = "LinkedIn link must be a valid URL"
    )
    private String linkedInLink;

    private String cloudinaryImagePublicId;


    @ManyToOne
    private User user;
}
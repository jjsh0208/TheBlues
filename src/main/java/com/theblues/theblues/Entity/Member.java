package com.theblues.theblues.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 16,nullable = false,unique = true)
    private String member_id;
    @Column(length = 16,nullable = false)
    private String password;
    @Column(length = 20)
    private String name;
    @Column
    private String mobile;
    @Column
    private String is_sms;
    @Column(nullable = false, unique = true)
    private String email;
    @Column
    private String is_news_mail;
    @Column
    private String agree_service_check;
    @Column
    private String role;

}

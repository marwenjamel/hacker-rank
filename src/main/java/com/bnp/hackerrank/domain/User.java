package com.bnp.hackerrank.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Interest interest;

    public User(Long userId) {
    }

}

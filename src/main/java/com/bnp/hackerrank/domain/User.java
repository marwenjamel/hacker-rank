package com.bnp.hackerrank.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "Id", nullable = false)
    private Long userId;

}

package com.bnp.hackerrank.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "INTEREST")
public class Interest {

    @EmbeddedId
    private InterestId interestId;
    @Column(unique = true)
    private String name;
}

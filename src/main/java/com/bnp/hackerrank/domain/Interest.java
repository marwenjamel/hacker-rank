package com.bnp.hackerrank.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@IdClass(InterestId.class)
@Table(name = "INTEREST")
public class Interest {

    @EmbeddedId
    private InterestId interestId;
}

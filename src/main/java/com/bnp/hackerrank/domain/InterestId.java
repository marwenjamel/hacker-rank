package com.bnp.hackerrank.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class InterestId implements Serializable {

    private InterestType type;
    private InterestRegion region;
    private InterestLanguage language;

}


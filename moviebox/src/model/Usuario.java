package model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ToString.Exclude
    private BigInteger idUser;

    private String nomeUser;

    private String senha;

}

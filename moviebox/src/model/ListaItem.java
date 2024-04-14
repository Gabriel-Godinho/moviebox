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
public class ListaItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ToString.Exclude
    private long idLista;

    private String nomeLista;

    private BigInteger idUser;

    private long idFilme;

}

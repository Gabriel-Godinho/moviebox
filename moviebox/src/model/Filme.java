package model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class Filme implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ToString.Exclude
    private long idFilme;

    private String nomeFilme;

    private int duracao;

    private int ano;

    private long idDiretor;

    private long idPais;

    private String sinopse;

}

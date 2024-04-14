package model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class Diretor implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ToString.Exclude
    private long idDiretor;

    private String nomeDiretor;
    private String nacionalidade;

    // Construtor com apenas o nome do diretor
    public Diretor(String nomeDiretor, String nacionalidade) {
        this.nomeDiretor = nomeDiretor;
        this.nacionalidade = nacionalidade;
    }

}

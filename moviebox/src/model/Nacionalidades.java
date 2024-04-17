package model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class Nacionalidades implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long idDiretor;

    private long idPais;

}

package model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Lista implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private List<List<ListaItem>> listas;

}

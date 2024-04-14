package model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;

@Getter @Setter
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private BigInteger idUsuario;

}

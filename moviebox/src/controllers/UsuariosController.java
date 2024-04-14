package controllers;

import model.Usuario;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UsuariosController {
    public void criarUsuario(Connection connection) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Para criar seu usuário, insira os dados:");
        System.out.print("Nome de usuário: ");
        String nomeUser = input.next();
        System.out.print("Senha: ");
        String senha = input.next();
        System.out.print("Confirmar senha: ");
        String confirmaSenha = input.next();
        Usuario user = new Usuario(BigInteger.ONE, nomeUser, senha);
        //Usuario.create(user, connection);
        System.out.println("Usuário criado com sucesso!!");
    }
}

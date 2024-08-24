package dataFactory;

import pojo.UsuarioPojo;

public class UsuarioDataFactory {
    public static UsuarioPojo criarUsuarioParaLogin(){
        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setUsuarioLogin("Gabriel");
        usuario.setUsuarioSenha("12345");

        return usuario;
    }
}

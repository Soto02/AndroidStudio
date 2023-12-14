package Modelo

class Usuario {
    private var usuario: String? = null
    private var contraseña: String? = null

    constructor(usuario: String?, contraseña: String?) {
        this.usuario = usuario
        this.contraseña = contraseña
    }

    fun getUsuario(): String? {
        return usuario
    }

    fun setUsuario(contraseña: String?) {
        usuario = usuario
    }

    fun getContraseña(): String? {
        return contraseña
    }

    fun setContraseña(contraseña: String?) {
        this.contraseña = contraseña
    }


}
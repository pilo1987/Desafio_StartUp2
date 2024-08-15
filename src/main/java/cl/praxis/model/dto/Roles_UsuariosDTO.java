package cl.praxis.model.dto;

public class Roles_UsuariosDTO {

	private int usuario_id;
	private int rol_id;

	public Roles_UsuariosDTO(int usuario_id, int rol_id) {
		super();
		this.usuario_id = usuario_id;
		this.rol_id = rol_id;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public int getRol_id() {
		return rol_id;
	}

	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}

}
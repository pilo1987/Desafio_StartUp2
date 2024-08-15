package cl.praxis.model.dto;

import java.util.Date;

public class UsuariosDTO {
		
		private int id;
		private String correo;
		private Date created_at;
		private String nick;
		private String nombre;
		private String password;
		private int peso;
		private Date updated_at;
		
		public UsuariosDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public UsuariosDTO(int id, String correo, Date created_at, String nick, String nombre, String password, int peso,
				Date updated_at) {
			super();
			this.id = id;
			this.correo = correo;
			this.created_at = created_at;
			this.nick = nick;
			this.nombre = nombre;
			this.password = password;
			this.peso = peso;
			this.updated_at = updated_at;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}

		public Date getCreated_at() {
			return created_at;
		}

		public void setCreated_at(Date created_at) {
			this.created_at = created_at;
		}

		public String getNick() {
			return nick;
		}

		public void setNick(String nick) {
			this.nick = nick;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getPeso() {
			return peso;
		}

		public void setPeso(int peso) {
			this.peso = peso;
		}

		public Date getUpdated_at() {
			return updated_at;
		}

		public void setUpdated_at(Date updated_at) {
			this.updated_at = updated_at;
		}

		@Override
		public String toString() {
			return "UsuariosDTO [id=" + id + ", correo=" + correo + ", created_at=" + created_at + ", nick=" + nick
					+ ", nombre=" + nombre + ", password=" + password + ", peso=" + peso + ", updated_at=" + updated_at
					+ "]";
		}

}

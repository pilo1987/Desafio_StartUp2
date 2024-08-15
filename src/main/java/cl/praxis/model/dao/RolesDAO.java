package cl.praxis.model.dao;

import java.util.List;

import cl.praxis.model.dto.RolesDTO;
import cl.praxis.model.dto.Roles_UsuariosDTO;

public interface RolesDAO {
	
	List<RolesDTO> read();
	void create(Roles_UsuariosDTO c);
	int idAdmin();
	int userRol(int userId);

}

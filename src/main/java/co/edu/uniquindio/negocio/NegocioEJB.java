package co.edu.uniquindio.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;

import co.edu.uniquindio.entidades.Libro;
import co.edu.uniquindio.entidades.Resena;
import co.edu.uniquindio.entidades.Usuario;

@Stateless
public class NegocioEJB {

	@PersistenceContext(unitName = "persistencia")
	protected transient EntityManager em;

	public void crearUsuario(Usuario us) {
		em.persist(us);
	}

	/**
	 * Metodo que valida el usuario
	 * 
	 * @param nombreUsuario
	 * @param password
	 * @return
	 */
	public Usuario validarLogin(String nombreUsuario, String password) {
		Query query = em.createNamedQuery(Usuario.USUARIOLOGIN);
		query.setParameter(1, nombreUsuario);
		query.setParameter(2, password);
		List<Usuario> res = query.getResultList();
		return res.size() == 0 ? null : res.get(0);
	}

	public List<Libro> realizarPara(String consulta, String selectedConsoles[]) {
		String arre[] = consulta.split(";");
		List<String> pa = new ArrayList<>();
		for (String strin : arre) {
			pa.add(strin);
		}

		return realizarConsultaLibro(selectedConsoles, pa);
	}

	public List<Libro> realizarConsultaLibro(String selectedConsoles[], List<String> pa) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Libro> cq = cb.createQuery(Libro.class);
		Root<Libro> l = cq.from(Libro.class);
		cq.select(l);
		List<Predicate> predicados = new ArrayList<Predicate>();

		if (selectedConsoles.length == 1) {
			if (selectedConsoles[0].equals("autor"))
				predicados.add(cb.equal(l.get("autor"), pa.get(0)));
			if (selectedConsoles[0].equals("titulo"))
				predicados.add(cb.equal(l.get("nombre"), pa.get(0)));
			if (selectedConsoles[0].equals("id"))
				predicados.add(cb.equal(l.get("isbn"), pa.get(0)));
		}

		if (selectedConsoles.length == 2) {

			if (selectedConsoles[0].equals("autor") && selectedConsoles[1].equals("titulo")) {
				predicados.add(cb.equal(l.get("autor"), pa.get(0)));
				predicados.add(cb.equal(l.get("nombre"), pa.get(1)));
			}
			if (selectedConsoles[0].equals("autor") && selectedConsoles[1].equals("id")) {
				predicados.add(cb.equal(l.get("autor"), pa.get(0)));
				predicados.add(cb.equal(l.get("isbn"), pa.get(1)));
			}
			if (selectedConsoles[0].equals("titulo") && selectedConsoles[1].equals("id")) {
				predicados.add(cb.equal(l.get("nombre"), pa.get(0)));
				predicados.add(cb.equal(l.get("isbn"), pa.get(1)));
			}
		}

		if (selectedConsoles.length == 3) {
			predicados.add(cb.equal(l.get("nombre"), pa.get(1)));
			predicados.add(cb.equal(l.get("isbn"), pa.get(2)));
			predicados.add(cb.equal(l.get("autor"), pa.get(0)));
		}

		if (!predicados.isEmpty()) {
			cq.where(predicados.toArray(new Predicate[] {}));
		}

		Query q = em.createQuery(cq);

		return q.getResultList();
	}
	
	public void registrarComentario(Resena rese){
		em.persist(rese);
	}
	
	public List<Resena> buscarResena(){
		Query query=em.createNamedQuery(Resena.BUSCAR);
		List<Resena> res=query.getResultList();
		return res.size()==0 ? null:res;
	}
}

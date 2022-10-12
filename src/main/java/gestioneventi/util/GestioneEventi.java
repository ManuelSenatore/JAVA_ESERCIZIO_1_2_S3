package gestioneventi.util;

import gestioneventi.util.model.*;
import gestioneventi.util.model.dao.EventoDAO;
import gestioneventi.util.model.dao.LocationDAO;
import gestioneventi.util.model.dao.PartecipazioneDAO;
import gestioneventi.util.model.dao.PersonaDAO;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;


public class GestioneEventi {

	public static void main(String[] args) {
		
//		Location location = saveLocation();
//		Evento evento = saveEvento(location);
		Persona persona = savePersona("Ciccio", "Pasticcio", "pasticciodiciccio@nzevat.com", Sesso.MASCHIO);
//
//		Partecipazione partecipazione = savePartecipazione(evento,persona);

//		Evento evento = new EventoDAO().getById( 1L );
//		System.out.println(evento);


	}



	private static Partecipazione savePartecipazione(Evento evento, Persona persona) {
		Partecipazione part = new Partecipazione();
		part.setEvento(evento);
		part.setPersona(persona);
		part.setStato(StatoPartecipazione.CONFERMATA);
		
		PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();
		partecipazioneDAO.save(part);
		return part;
	}

	private static Persona savePersona(String nome, String cognome, String email, Sesso sesso) {
		Persona per = new Persona();
		per.setNome(nome);
		per.setCognome(cognome);
		per.setEmail(email);
		per.setSesso(sesso);
		per.setDataDiNascita(new GregorianCalendar(1980, Calendar.OCTOBER, 23).getTime());
		PersonaDAO personaDAO = new PersonaDAO();
		personaDAO.save(per);
		return per;
	}

	private static Location saveLocation() {
		Location loc = new Location();
		loc.setCitta("Firenze");
		loc.setNome("Stadio Franchi");
		
		LocationDAO locationDAO = new LocationDAO();
		locationDAO.save(loc);
		return loc;
	}

	private static Evento saveEvento(Location loc) {
		Evento ev = new Evento();
		ev.setDataEvento(new Date());
		ev.setTitolo("Partita");
		ev.setDescrizione("Finale di coppa");
		ev.setNumeroMassimoPartecipanti(10);
		ev.setTipoEvento(TipoEvento.PUBBLICO);
		ev.setLocation(loc);
		
		EventoDAO evDao = new EventoDAO();
		evDao.save(ev);
		return ev;
	}

}

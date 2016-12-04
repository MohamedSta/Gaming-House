package tn.esprit.thewalkingdev.Beans;

 import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.mail.Part;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import tn.esprit.thewalkingdev.entites.Gamer;
import tn.esprit.thewalkingdev.entites.Role;
import tn.esprit.thewalkingdev.entites.Team;
import tn.esprit.thewalkingdev.services.contract.GamerLocal;
import tn.esprit.thewalkingdev.services.contract.TeamLocal;

@ManagedBean
@RequestScoped
public class GestionGamer {
	@EJB
	GamerLocal local;
	Boolean Request=false;
    private StreamedContent dbImage;

	public StreamedContent getDbImage() {
		return dbImage;
	}

	public void setDbImage(StreamedContent dbImage) {
		this.dbImage = dbImage;
	}


	@ManagedProperty("#{authentificationBean.g.id}")
	int i;
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}


	Gamer g1;
	 public Boolean getRequest() {
		return Request;
	}

	public void setRequest(Boolean request) {
		Request = request;
	}


	@EJB 
	TeamLocal local1;
	 
	
	private List<Gamer> gamers = new ArrayList<Gamer>();
	private List<Team> teams = new ArrayList<Team>();

	String role;
	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	private Gamer gamer = new Gamer();

	public List<Gamer> getGamers() {
		return gamers;
	}

	public void setGamers(List<Gamer> gamers) {
		this.gamers = gamers;
	}

	public Gamer getGamer() {
		return gamer;
	}

	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}

	@PostConstruct
	public void init() {
 teams=local1.findAllTeams();
 g1=local.findGamerById(i);
 System.out.println(g1.getEmail());
 byte[] im= g1.getImage();
 System.out.println(im.length);
 InputStream is = new ByteArrayInputStream(im);
 System.err.println(is);
 dbImage = new DefaultStreamedContent(is) {
};

		gamers = local.findAllGamers();
	}

	public String doUpdate() {

		local.updateGamer(gamer);
		return null;
	}

	public String dodelete(Gamer g) {
		local.deleteGamer(g);

		return "/authentification/Login?faces-redirect=true";
	}

	public String doRegister() throws IOException {
		gamer.setAccepted(false);
		if (role.equals("0")) {
			gamer.setRole(Role.Gamer);
		} else if (role.equals("2")) {
			gamer.setRole(Role.TeamLogistics);
		} else if (role.equals("3")) {
			gamer.setRole(Role.TeamMedia);
		} else if (role.equals("4")) {
			gamer.setRole(Role.TeamOrganisation);
		} else if (role.equals("5")) {
			gamer.setRole(Role.TeamSponsor);
		}
		gamer.setImage(file.getContents());
		gamer.setHasvoted(false);

		local.addGamer(gamer);
		return "/authentification/Login?faces-redirect=true";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	public String RTeam(int id,int id1) {
		Team t=local1.findTeamById(id);
		Gamer g=local.findGamerById(id1);
		g.setTeam(t);
		Request=true;
		local.updateGamer(g);
		return "/public/Home?faces-redirect=true";
     }

	public Gamer getG1() {
		return g1;
	}

	public void setG1(Gamer g1) {
		this.g1 = g1;
	}
     
   
}

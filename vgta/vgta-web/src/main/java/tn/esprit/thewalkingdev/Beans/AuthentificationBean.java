package tn.esprit.thewalkingdev.Beans;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import tn.esprit.thewalkingdev.entites.Gamer;
import tn.esprit.thewalkingdev.entites.Role;
import tn.esprit.thewalkingdev.services.contract.GamerLocal;

@SessionScoped
@ManagedBean
public class AuthentificationBean {
	@EJB
	GamerLocal local;
	private String login;
	private String pwd;
	String message = "";

	String role="";
	   public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private UploadedFile file;
	   
	    public UploadedFile getFile() {
	        return file;
	    }
	 
	    public void setFile(UploadedFile file) {
	        this.file = file;
	    }
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	String nav = null;
  public Gamer getG() {
		return g;
	}

	public void setG(Gamer g) {
		this.g = g;
	}

Gamer g;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String dologin() {
		nav = null;
		try {
			g = local.authentifiacation(login, pwd);
			if (g != null) {

				if (g.getRole() == Role.Gamer) {
					nav = "/public/Home?faces-redirect=true";
				}

			}
		} catch (Exception e) {

			message = "Invalid Password or Email";
			return "/authentification/Login?faces-redirect=true";

		}
		return nav;

	}
	public String dologout() {
		FacesContext.getCurrentInstance().getExternalContext()
		.invalidateSession();
		message = "";
		return "/authentification/Login?faces-redirect=true";
 		
	}
	public String doupdate(Gamer g1) throws IOException{
 
		g1.setAccepted(false);
		
if(role.equals("0"))
	{g1.setRole(Role.Gamer);}
else if (role.equals("2")) {
	g1.setRole(Role.TeamLogistics);
}else if (role.equals("3")) {
	g1.setRole(Role.TeamMedia);
}else if (role.equals("4")) {
	g1.setRole(Role.TeamOrganisation);
}
else if (role.equals("5")) {
	g1.setRole(Role.TeamSponsor);
}

// g.setImage(file.getContents());
		g1.setHasvoted(false);
		local.updateGamer(g1);
		return "/public/Home?faces-redirect=true";
}
}

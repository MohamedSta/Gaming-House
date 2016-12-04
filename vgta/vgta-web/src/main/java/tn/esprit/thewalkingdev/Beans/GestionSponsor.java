package tn.esprit.thewalkingdev.Beans;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.validator.ValidatorException;


import tn.esprit.thewalkingdev.Mail.SendMail;
import tn.esprit.thewalkingdev.entites.Sponsor;
import tn.esprit.thewalkingdev.services.contract.SponsorLocal;

@RequestScoped
@ManagedBean
public class GestionSponsor {

	
	public String Content;
	public String Cont;
	public String Mail;
	private boolean formDisplyed = false;
	private boolean formMailDisplyed = false;
	
	public String getCont() {
		return Cont;
	}


	public void setCont(String cont) {
		Cont = cont;
	}


	public String getMail() {
		return Mail;
	}


	public void setMail(String mail) {
		Mail = mail;
	}


	public boolean isFormMailDisplyed() {
		return formMailDisplyed;
	}


	public void setFormMailDisplyed(boolean formMailDisplyed) {
		this.formMailDisplyed = formMailDisplyed;
	}


	public boolean isFormDisplyed() {
		return formDisplyed;
	}


	public void setFormDisplyed(boolean formDisplyed) {
		this.formDisplyed = formDisplyed;
	}


	public String getContent() {
		return Content;
	}


	public void setContent(String content) {
		Content = content;
	}
	@EJB
	SponsorLocal sponsorlocal;
	private HtmlDataTable datatable;	
	private List<Sponsor> Sponsors;
    private Sponsor sponsor =new Sponsor();
	public void setDatatable(HtmlDataTable datatable) {
		this.datatable = datatable;
	}


	public List<Sponsor> getSponsors() {
		return Sponsors;
	}


	public void setSponsors(List<Sponsor> sponsors) {
		Sponsors = sponsors;
	}


	public Sponsor getSponsor() {
		return sponsor;
	}


	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

	

	public HtmlDataTable getDatatable() {
		return datatable;
	}
	
	@PostConstruct
	private void init() {
		// sponsor =new Sponsor();
		Sponsors = sponsorlocal.findAllSponsors();
	}
public String doAddSponsor()
{
	
    
	sponsorlocal.addSponsor(sponsor);
	return"ListSponsor?faces-redirect=true"; 
}
	
	public String doDeleteSponsor() {
	
		Sponsor sponS =(Sponsor)datatable.getRowData();
			sponsorlocal.deleteSponsor(sponS);
			init();
		return"ListSponsor?faces-redirect=true";
	}
	public String doCallAddSponsor()
	{
		
		return "AddSponsor?faces-redirect=true";
	}
public String doUpdate()
{

	sponsorlocal.updateSponsor(sponsor);
	init();
	return"ListSponsor?faces-redirect=true";
}

	public String doSendMail()
	{Sponsor sponS =(Sponsor)datatable.getRowData();
		String mailuser = sponS.getEmail();
		String nomUser = "Anes";
		String Dest,subject,contenu;
		Dest=mailuser;
		subject="Freelance Transaction !!!";
		contenu="Miss or Mrs  " +nomUser+" your account was decremented by " ;
		SendMail sendMail=new SendMail();
        sendMail.sendMessage(subject,contenu,Dest,"anesmazouni@gmail.com");
        return"ListSponsor?faces-redirect=true";
	}
	public String doSendMailDynamic(String Content,String Cont)
	{String mailuser =sponsor.getEmail();
	

	String Dest,subject,contenu;
	Dest=mailuser;
	subject=Cont;
	contenu="Miss or Mrs  "+Content ;
	SendMail sendMail=new SendMail();
    sendMail.sendMessage(subject,contenu,Dest,"anesmazouni@gmail.com");
    return"ListSponsor?faces-redirect=true";	
	}
	public String doShowForm() {
		
		formDisplyed = formDisplyed ? false : true;
		return null;
	}
	public String doShowFormMail() {
		
		formMailDisplyed = formMailDisplyed ? false : true;
		return null;
	}


	public String validate()  {
		 String name = (String) sponsor.getEmail();
         
		 if(name==null){
	           ;
	            String expression="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	            CharSequence inputStr=name;
	            Pattern pattern=Pattern.compile(expression);
	            Matcher matcher=pattern.matcher(inputStr);
	            String msg="Email is not in Proper Format";
	            if(matcher.matches()){
	               
	            }
	            else{
	                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null));
	            }
	            
		
	}return null;
		 }
	}


	
	


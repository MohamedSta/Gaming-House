package tn.esprit.thewalkingdev.Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.thewalkingdev.Mail.SendMail;

@RequestScoped
@ManagedBean


public class MailBean {
	public String Content;
	public String Cont;
	public String Mail;

	public String getMail() {
		return Mail;
	}

	public void setMail(String mail) {
		Mail = mail;
	}

	public String getCont() {
		return Cont;
	}

	public void setCont(String cont) {
		Cont = cont;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	public String doSendMailDynamic(String Content,String Cont,String Mail)
	{String mailuser =Mail;
	

	String Dest,subject,contenu;
	Dest=mailuser;
	subject=Cont;
	contenu="Miss or Mrs  "+Content ;
	SendMail sendMail=new SendMail();
    sendMail.sendMessage(subject,contenu,Dest,"anesmazouni@gmail.com");
    return"ListSponsor?faces-redirect=true";	
	}
	
}

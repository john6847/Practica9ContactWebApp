package edu.pucmm.pwa.jsf.mbean;

import com.sun.faces.context.flash.ELFlash;
import org.hibernate.validator.constraints.NotBlank;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;


@Named("miFormulario")
//@ManagedBean("miFormulario") //Si no tenemos CDI debemos utiliar la clase javax.faces.bean.ManagedBean
@SessionScoped
public class FormBasico implements Serializable {

    private ArrayList<Contacto> contactos = new ArrayList<>();
    private Contacto selectedContact;

    public Contacto getSelectedContact() {

        return selectedContact;
    }

    public void setSelectedContact(Contacto selectedContact) {
        this.selectedContact = selectedContact;
    }

    public String mandarAlaTabla(){

        return  "formularioContacto?faces-redirect=true";
    }

    public String irAIndex(){

        return  "index?faces-redirect=true";
    }


    private  long id;
    @Size(min = 2, max = 10)
    @NotBlank
    private String nombre;
    @Size(min = 2, max = 10)
    @NotBlank
    private String apellido;

    private String direccion;

    private String telefono;

    private String email;



    public String procesarFormularioMetodoPost() {

        Contacto contacto = new Contacto(id,nombre, apellido,direccion, telefono, email);

        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        if(sessionMap.get("contactos")!=null){
            contactos= (ArrayList<Contacto>) sessionMap.get("contactos");
        }

        contacto.setId(new Random().nextInt(500));
        contactos.add(contacto);

        sessionMap.put("contactos", contactos);


        limpiarDatos();

        return  "tablaContacto?param1=valor&param2=valor2";
    }

    public String procesarFormularioModficada() {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        ArrayList<Contacto> contactoList= (ArrayList<Contacto>) sessionMap.get("contactos");
        for(int i=0;i<contactoList.size();i++){
            if (contactoList.get(i).getId()==selectedContact.getId()) {
                contactoList.get(i).setNombre(selectedContact.getNombre());
                contactoList.get(i).setApellido(selectedContact.getApellido());
                contactoList.get(i).setDireccion(selectedContact.getDireccion());
                contactoList.get(i).setTelefono(selectedContact.getTelefono());
            }
        }
        sessionMap.put("contactos",contactoList);
        return  "tablaContacto";
    }

    public String eliminarContacto() {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        ArrayList<Contacto> contactoList= (ArrayList<Contacto>) sessionMap.get("contactos");

        for(int i=0;i<contactoList.size();i++){
            if (contactoList.get(i).getId()==selectedContact.getId()) {
                contactoList.remove(contactoList.get(i));
            }
        }
        sessionMap.put("contactos",contactoList);
        return  "tablaContacto?faces-redirect=true";
    }


    /**
     * Limpiando las variables.
     * @return
     */
    public String limpiarDatos() {
        nombre = "";
        apellido = "";
        direccion ="";
        telefono="";
        email ="";
        return "";
    }





    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the direction
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * @param direccion the direction to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public  ArrayList<Contacto> getContactos() {

        return contactos;

    }

}

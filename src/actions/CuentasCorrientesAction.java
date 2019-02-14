package actions;

import bo.impl.CuentaCorrienteBOImpl;
import bo.impl.LocalidadBOImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import entities.CuentaCorriente;
import entities.Localidad;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CuentasCorrientesAction extends ActionSupport implements SessionAware, Action {

	private static final long serialVersionUID = -3392835333205482624L;
	private Map<String, Object> sesion;
    private static Logger log = Logger.getLogger(CuentasCorrientesAction.class);


    // ALTA CUENTA CORRIENTE
    private int documento;
    private String nombre;
    private String apellido;
    private String mail;
    private double saldoOperativo;
    private String calle;
    private String telefono;
    private List<Localidad> listLocalidades = new ArrayList<Localidad>();
    private Integer localidad;
    private static final int CATEGORIA_IVA = 5;

    // Lista Ctas
    private List<CuentaCorriente> listCuentasCorrientes;

    // Id de la cuenta a borrar
    private LocalidadBOImpl localidadBO =  new LocalidadBOImpl();


    private Integer idCtaCorriente;
    private CuentaCorrienteBOImpl cuentaCorrienteBO = new CuentaCorrienteBOImpl();

    public String input(){

        cargarLocalidades();
        return SUCCESS;
    }

    private void cargarLocalidades(){
        this.listLocalidades = localidadBO.listarLocalidadeds();
    }

    public String guardarCtaCorriente(){
       try {
           CuentaCorriente ct = new CuentaCorriente();

           ct.setDocumento(this.documento);
           ct.setNombre(this.nombre);
           ct.setApellido(this.apellido);
           ct.setBaja(false);
           ct.setCalle(this.calle);
           ct.setIdCatIva(CATEGORIA_IVA);
           ct.setMail(this.mail);
           ct.setTelefono(this.telefono);
           ct.setSaldoOperativo(this.saldoOperativo);
           ct.setIdLocalidad(this.localidad);

           cuentaCorrienteBO.guardarCuentaCorriente(ct);

           return SUCCESS;

       }catch (Exception e){

           log.error( e.getMessage() );
           return ERROR;
       }
    }

    public String listaCtaCorrientes(){

        this.listCuentasCorrientes =  this.cuentaCorrienteBO.listarCuentasCorrientes();
        sesion.put("cuentas", this.listCuentasCorrientes);

        return SUCCESS;
    }

    public String borrarCtaCorriente(){
        this.cuentaCorrienteBO.borrarCuentaCorriente(this.idCtaCorriente);
        return SUCCESS;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSaldoOperativo(double saldoOperativo) {
        this.saldoOperativo = saldoOperativo;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setCuentaCorrienteBO(CuentaCorrienteBOImpl cuentaCorrienteBO) {
        this.cuentaCorrienteBO = cuentaCorrienteBO;
    }

    public List<Localidad> getListLocalidades() {
        return listLocalidades;
    }

    public void setListLocalidades(List<Localidad> listLocalidades) {
        this.listLocalidades = listLocalidades;
    }

    public Integer getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Integer localidad) {
        this.localidad = localidad;
    }

    public List<CuentaCorriente> getListCuentasCorrientes() {
        return listCuentasCorrientes;
    }

    public void setListCuentasCorrientes(List<CuentaCorriente> listCuentasCorrientes) {
        this.listCuentasCorrientes = listCuentasCorrientes;
    }

    public Integer getIdCtaCorriente() {
        return idCtaCorriente;
    }

    public void setIdCtaCorriente(Integer idCtaCorriente) {
        this.idCtaCorriente = idCtaCorriente;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sesion = map;
    }
}

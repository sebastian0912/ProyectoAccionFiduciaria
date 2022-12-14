package com.Model;

public class Datos {
    
    private String fecha;
    private Long Cuenta_Contable;
    private Long cod_1;
    private Long cod_2;
    private Long cod_4;
    private Long cod_6;
    private Long cod_8;
    private Long cod_11;    
    private String Nombre_Cuenta; 
    private String Cuenta_1;
    private String Cuenta_2; 
    private String Cuenta_4;
    private String Cuenta_6;
    private String Cuenta_8;
    private String Cuenta_11;
    private String Fecha_Combrobante; 
    private Long Numero_Comprobante;
    private int Tipo_Comprobante;  
    private String Nombre_Comprobante;
    private double Debito;
    private double Credito;
    private Long NIT_Tercero;
    private String Nombre_Comun;
    private String Tipo_Persona;
    private String Descripcion;
    private String Usuario;



    public Datos(String fecha, Long cuenta_Contable, Long cod_1, Long cod_2, Long cod_4, Long cod_6, Long cod_8,
            Long cod_11, String nombre_Cuenta, String cuenta_1, String cuenta_2, String cuenta_4, String cuenta_6,
            String cuenta_8, String cuenta_11, String fecha_Combrobante, Long numero_Comprobante, int tipo_Comprobante,
            String nombre_Comprobante, double debito, double credito, Long nIT_Tercero, String nombre_Comun,
            String tipo_Persona, String descripcion, String usuario) {
        this.fecha = fecha;
        Cuenta_Contable = cuenta_Contable;
        this.cod_1 = cod_1;
        this.cod_2 = cod_2;
        this.cod_4 = cod_4;
        this.cod_6 = cod_6;
        this.cod_8 = cod_8;
        this.cod_11 = cod_11;
        Nombre_Cuenta = nombre_Cuenta;
        Cuenta_1 = cuenta_1;
        Cuenta_2 = cuenta_2;
        Cuenta_4 = cuenta_4;
        Cuenta_6 = cuenta_6;
        Cuenta_8 = cuenta_8;
        Cuenta_11 = cuenta_11;
        Fecha_Combrobante = fecha_Combrobante;
        Numero_Comprobante = numero_Comprobante;
        Tipo_Comprobante = tipo_Comprobante;
        Nombre_Comprobante = nombre_Comprobante;
        Debito = debito;
        Credito = credito;
        NIT_Tercero = nIT_Tercero;
        Nombre_Comun = nombre_Comun;
        Tipo_Persona = tipo_Persona;
        Descripcion = descripcion;
        Usuario = usuario;
    }



    public String getFecha() {
        return fecha;
    }



    public void setFecha(String fecha) {
        this.fecha = fecha;
    }



    public Long getCuenta_Contable() {
        return Cuenta_Contable;
    }



    public void setCuenta_Contable(Long cuenta_Contable) {
        Cuenta_Contable = cuenta_Contable;
    }



    public Long getCod_1() {
        return cod_1;
    }



    public void setCod_1(Long cod_1) {
        this.cod_1 = cod_1;
    }



    public Long getCod_2() {
        return cod_2;
    }



    public void setCod_2(Long cod_2) {
        this.cod_2 = cod_2;
    }



    public Long getCod_4() {
        return cod_4;
    }



    public void setCod_4(Long cod_4) {
        this.cod_4 = cod_4;
    }



    public Long getCod_6() {
        return cod_6;
    }



    public void setCod_6(Long cod_6) {
        this.cod_6 = cod_6;
    }



    public Long getCod_8() {
        return cod_8;
    }



    public void setCod_8(Long cod_8) {
        this.cod_8 = cod_8;
    }



    public Long getCod_11() {
        return cod_11;
    }



    public void setCod_11(Long cod_11) {
        this.cod_11 = cod_11;
    }



    public String getNombre_Cuenta() {
        return Nombre_Cuenta;
    }



    public void setNombre_Cuenta(String nombre_Cuenta) {
        Nombre_Cuenta = nombre_Cuenta;
    }



    public String getCuenta_1() {
        return Cuenta_1;
    }



    public void setCuenta_1(String cuenta_1) {
        Cuenta_1 = cuenta_1;
    }



    public String getCuenta_2() {
        return Cuenta_2;
    }



    public void setCuenta_2(String cuenta_2) {
        Cuenta_2 = cuenta_2;
    }



    public String getCuenta_4() {
        return Cuenta_4;
    }



    public void setCuenta_4(String cuenta_4) {
        Cuenta_4 = cuenta_4;
    }



    public String getCuenta_6() {
        return Cuenta_6;
    }



    public void setCuenta_6(String cuenta_6) {
        Cuenta_6 = cuenta_6;
    }



    public String getCuenta_8() {
        return Cuenta_8;
    }



    public void setCuenta_8(String cuenta_8) {
        Cuenta_8 = cuenta_8;
    }



    public String getCuenta_11() {
        return Cuenta_11;
    }



    public void setCuenta_11(String cuenta_11) {
        Cuenta_11 = cuenta_11;
    }



    public String getFecha_Combrobante() {
        return Fecha_Combrobante;
    }



    public void setFecha_Combrobante(String fecha_Combrobante) {
        Fecha_Combrobante = fecha_Combrobante;
    }



    public Long getNumero_Comprobante() {
        return Numero_Comprobante;
    }



    public void setNumero_Comprobante(Long numero_Comprobante) {
        Numero_Comprobante = numero_Comprobante;
    }



    public int getTipo_Comprobante() {
        return Tipo_Comprobante;
    }



    public void setTipo_Comprobante(int tipo_Comprobante) {
        Tipo_Comprobante = tipo_Comprobante;
    }



    public String getNombre_Comprobante() {
        return Nombre_Comprobante;
    }



    public void setNombre_Comprobante(String nombre_Comprobante) {
        Nombre_Comprobante = nombre_Comprobante;
    }



    public double getDebito() {
        return Debito;
    }



    public void setDebito(double debito) {
        Debito = debito;
    }



    public double getCredito() {
        return Credito;
    }



    public void setCredito(double credito) {
        Credito = credito;
    }



    public Long getNIT_Tercero() {
        return NIT_Tercero;
    }



    public void setNIT_Tercero(Long nIT_Tercero) {
        NIT_Tercero = nIT_Tercero;
    }



    public String getNombre_Comun() {
        return Nombre_Comun;
    }



    public void setNombre_Comun(String nombre_Comun) {
        Nombre_Comun = nombre_Comun;
    }



    public String getTipo_Persona() {
        return Tipo_Persona;
    }



    public void setTipo_Persona(String tipo_Persona) {
        Tipo_Persona = tipo_Persona;
    }



    public String getDescripcion() {
        return Descripcion;
    }



    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }



    public String getUsuario() {
        return Usuario;
    }



    public void setUsuario(String usuario) {
        Usuario = usuario;
    }



    public Datos() {
    }


    

}

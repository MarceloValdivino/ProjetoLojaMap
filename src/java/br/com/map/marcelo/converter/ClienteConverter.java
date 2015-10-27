/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.converter;

import br.com.map.marcelo.entidades.Cliente;
import br.com.map.marcelo.facade.Facade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Marcelo
 */
@FacesConverter(forClass = Cliente.class, value = "ClienteConverter")
public class ClienteConverter implements Converter {

    private Facade facade;
    
    public ClienteConverter() {
        facade = Facade.getInstance();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return facade.buscarClientePeloId(Long.parseLong(value));
        } catch (Exception e) {
            throw new ConverterException(e.getMessage());
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Cliente cliente = (Cliente) value;
            return String.valueOf(cliente.getId());
        }
        return "";
    }
    
}

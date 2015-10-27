/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.converter;

import br.com.map.marcelo.entidades.ItemProduto;
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
@FacesConverter(forClass = ItemProduto.class, value = "ItemProdutoConverter")
public class ItemProdutoConverter implements Converter {

    private Facade facade;
    
    public ItemProdutoConverter() {
        facade = Facade.getInstance();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return facade.buscarItemProdutoPeloId(Long.parseLong(value));
        } catch (Exception e) {
            throw new ConverterException(e.getMessage());
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            ItemProduto itemProduto = (ItemProduto) value;
            return String.valueOf(itemProduto.getId());
        }
        return "";
    }
    
}

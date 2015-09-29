/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.validation;

import br.com.map.marcelo.commom.exception.ValidationException;
import br.com.map.marcelo.entidades.Cliente;

/**
 *
 * @author Marcelo
 */
public class Validation {

    public static void validarCliente(Cliente cliente) throws ValidationException{
        if(cliente.getNome().split(" ").length<=1){
            throw new ValidationException("O Cliente deve conter ao menos 2 nomes.");
        }
        
        //if(cliente.getContatos().size() == 0){
        //    
        //}
        
        // TODO validar CPF
        // TODO validar outras coisas
    }
}

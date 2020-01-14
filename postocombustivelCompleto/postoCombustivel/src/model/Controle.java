/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static model.EnumPrecoCombustivel.ALCOOL;
import static model.EnumPrecoCombustivel.GAS_ADITIVADA;
import static model.EnumPrecoCombustivel.GAS_COMUM;
import static model.EnumPrecoCombustivel.OLEO_DIESEL;


/**
 *
 * @author Aluno
 */
public class Controle {
    public static Reservatorio resDiesel = new Reservatorio(OLEO_DIESEL);
    public static Reservatorio resComum = new Reservatorio(GAS_COMUM);
    public static Reservatorio resAditivada = new Reservatorio(GAS_ADITIVADA);
    public static Reservatorio resAlcool = new Reservatorio(ALCOOL);
    
    
}

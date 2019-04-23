/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentaionLayer;

import FunctionLayer.FunctionManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sofieamalielandt
 */
public interface Command
{
    String execute(HttpServletRequest request, HttpServletResponse response, FunctionManager manager) throws CommandException, DataLayer.DataException;

}
